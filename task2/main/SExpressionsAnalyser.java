import org.antlr.v4.runtime.CodePointBuffer;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class SExpressionsAnalyser extends SExpressionsBaseVisitor<Types>
{

    // S expression that don't currently work 14, 15, 18

    private Map<String, SExpressionsParser.DecContext> global_funcs = new HashMap<>();
    private Map<String, Types> local_vars = new HashMap<>();

    private SExpressionsParser.DecContext current_dec = null;
    private final SExpressionsToString toStrConverter = new SExpressionsToString();

    public String visitAndPrint(SExpressionsParser.ProgContext prog)
    {

        visit(prog);    // Discards the dummy return value.

        // At this point, we know for sure that there is at least a 'main' function.

        // sets main function to be at the beginning of the list of function declarations
        int index_main = 0;
        for (int i = 0; i < prog.decs.size(); ++i) {
            SExpressionsParser.DecContext dec = prog.decs.get(i);
            if (dec.identifier().Idfr().getText().equals("main")) {
                index_main = i;
            }
        }

        SExpressionsParser.DecContext main = prog.decs.get(index_main);
        prog.decs.set(index_main, prog.decs.get(0));
        prog.decs.set(0, main);

        return toStrConverter.visitHighlight(prog, prog).replaceAll("\u001B\\[[;\\d]*m", "");   // Removes ANSI colours.

    }

    @Override public Types visitProg(SExpressionsParser.ProgContext ctx)
    {
        // loop through all decs in order to visit each one of them
        for (int i = 0; i < ctx.decs.size(); i++)
        {
            // throws error if function name has been used already
            if(global_funcs.containsKey(ctx.dec(i).identifier().getText()))
            {
                throw new TypeException().duplicatedFuncError(ctx, ctx.dec(i).identifier(), Types.toType(ctx.dec(i).type()));
            }
            visit(ctx.decs.get(i));
        }

        boolean found_main = false;


        for (int i = 0; i < ctx.decs.size(); ++i) {

            SExpressionsParser.DecContext dec = ctx.decs.get(i);
            SExpressionsParser.IdentifierContext id = dec.identifier();
            SExpressionsParser.TypeContext type = dec.type();

            // if the current dec in the loop is the main function, checks the type and parameters
            if (id.Idfr().getText().equals("main"))
            {
                // throws error if main function has any parameters
                if(dec.params.size() > 0)
                {
                    throw new TypeException().mainFuncError(dec, dec.params.get(0), Types.toType(dec.params.get(0).type()));
                }
                // Throws error if main function is not of type INT
                if(Types.toType(type) != Types.INT)
                {
                    throw new TypeException().mainFuncError(ctx, dec, Types.toType(type));
                }
                found_main = true;
            }

            // sets the current dec
            current_dec = ctx.decs.get(i);

            // visits the block of the current dec and checks that it's return type is the same as the dec's
            if(visit(current_dec.block()) != Types.toType(current_dec.type()))
            {
                throw new TypeException().functionBodyError(current_dec, current_dec.block().expr, visit(current_dec.block().expr));
            }
        }

        // throws error if no main function
        if (!found_main)
        {
            throw new TypeException().noMainFuncError();
        }

        return Types.UNKNOWN;   // This is just a dummy return value.

    }

    @Override public Types visitDec(SExpressionsParser.DecContext ctx)
    {
        ArrayList<String> currentVariables = new ArrayList<>();

        for (int i = 0; i < ctx.params.size(); i++)
        {
            // throws error if any parameter is of type unit
            if(Types.toType(ctx.params.get(i).type()) == Types.UNIT)
            {
                throw new TypeException().unitVarError(ctx, ctx.params.get(i).getChild(1), Types.toType(ctx.params.get(i).type()));
            }
            // checks for duplicate variable names
            if(currentVariables.contains(ctx.typed_idfr(i).getChild(1).getText()))
            {
                throw new TypeException().duplicatedVarError(ctx, ctx.typed_idfr(i).identifier(), Types.toType(ctx.typed_idfr(i).type()));
            }

            // adds the variables to a list so that they can be checked for duplicates in the current function
            currentVariables.add(ctx.typed_idfr(i).getChild(1).getText());

            // adds the variables and their type to the symbol table so the type can be checked later on
            local_vars.put(ctx.typed_idfr(i).getChild(1).getText(), Types.toType(ctx.typed_idfr(i).type()));
        }

        // adds the function to the global_funcs hashmap
        global_funcs.put(ctx.identifier().getText(), ctx);

        return Types.toType(ctx.type());
    }

    @Override public Types visitTyped_idfr(SExpressionsParser.Typed_idfrContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitType(SExpressionsParser.TypeContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitBlock(SExpressionsParser.BlockContext ctx)
    {
        // visits all expressions except the last one
        for (int i = 0; i < ctx.exprs.size() - 1; i++)
        {
            visit(ctx.expr(i));
        }

        // returns type of last expression in block
        return visit(ctx.expr(ctx.exprs.size() - 1));
    }

    @Override public Types visitIfExpr(SExpressionsParser.IfExprContext ctx)
    {
        SExpressionsParser.ExprContext operand1 = ctx.expr();
        SExpressionsParser.BlockContext operand2 = ctx.block(0);
        SExpressionsParser.BlockContext operand3 = ctx.block(1);
        // sets the types of the expression and blocks by visiting them
        operand1.t = visit(operand1);
        operand2.t = visit(operand2);
        operand3.t = visit(operand3);

        // throws error if the expression is not of bool type
        if(operand1.t != Types.BOOL)
        {
            throw new TypeException().conditionError(ctx, operand1, operand1.t);
        }
        // throws error if the block's types are not the same
        else if(operand2.t != operand3.t)
        {
            throw new TypeException().branchMismatchError(ctx, operand2.expr, operand2.t, operand3.expr, operand3.t);
        }

        return operand2.t;
    }

    @Override public Types visitBinExpr(SExpressionsParser.BinExprContext ctx)
    {
        SExpressionsParser.ExprContext operand1 = ctx.expr(0);
        SExpressionsParser.ExprContext operand2 = ctx.expr(1);
        // sets the types of the expressions by visiting them
        operand1.t = visit(operand1);
        operand2.t = visit(operand2);

        // finds if binop is a numerical, comparison, or boolean operation
        Types t = switch (((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType()) {

            case SExpressionsParser.Plus, SExpressionsParser.Minus, SExpressionsParser.Times, SExpressionsParser.Div -> {
                // if both expressions in a numerical operation are not of type int, throw error
                if(operand1.t != Types.INT || operand2.t != Types.INT)
                {
                    throw new TypeException().arithmeticError(ctx, operand1, operand1.t, operand2, operand2.t);
                }
                // sets t to type int
                yield Types.INT;
            }
            case SExpressionsParser.Eq, SExpressionsParser.Less, SExpressionsParser.Gtr, SExpressionsParser.LessEq, SExpressionsParser.GtrEq -> {
                // if both expressions in a comparison operation are not of type int, throw error
                if(operand1.t != Types.INT || operand2.t != Types.INT)
                {
                    throw new TypeException().comparisonError(ctx, operand1, operand1.t, operand2, operand2.t);
                }
                // sets t to type bool
                yield Types.BOOL;
            }
            case SExpressionsParser.And, SExpressionsParser.Or, SExpressionsParser.Xor -> {
                // if both expressions in a boolean operation are not of type bool, throw error
                if(operand1.t != Types.BOOL || operand2.t != Types.BOOL)
                {
                    throw new TypeException().logicalError(ctx, operand1, operand1.t, operand2, operand2.t);
                }
                // sets t to type bool
                yield Types.BOOL;
            }
            default -> {
                throw new RuntimeException("Shouldn't be here - wrong binary operator.");
            }
        };
        // returns type of binop expression
        return t;
    }

    @Override public Types visitWhileExpr(SExpressionsParser.WhileExprContext ctx)
    {
        SExpressionsParser.ExprContext operand1 = ctx.expr();
        SExpressionsParser.BlockContext operand2 = ctx.block();
        // sets the types of the expression and block by visiting them
        operand1.t = visit(operand1);
        operand2.t = visit(operand2);

        // if the expression is not of type bool, throws error
        if(operand1.t != Types.BOOL)
        {
            throw new TypeException().conditionError(ctx, operand1, operand1.t);
        }
        // if the block is not of type unit, throws error
        else if(operand2.t != Types.UNIT)
        {
            throw new TypeException().loopBodyError(ctx, operand2.expr, visit(operand2.expr));
        }

        return Types.UNIT;
    }

    @Override public Types visitRepeatExpr(SExpressionsParser.RepeatExprContext ctx)
    {
        SExpressionsParser.ExprContext operand1 = ctx.expr();
        SExpressionsParser.BlockContext operand2 = ctx.block();
        // sets the types of the expression and block by visiting them
        operand1.t = visit(operand1);
        operand2.t = visit(operand2);

        // if the expression is not of type bool, throws error
        if(operand1.t != Types.BOOL)
        {
            throw new TypeException().conditionError(ctx, operand1, operand1.t);
        }
        // if the block is not of type unit, throws error
        else if(operand2.t != Types.UNIT)
        {
            throw new TypeException().loopBodyError(ctx, operand2.expr, visit(operand2.expr));
        }

        return Types.UNIT;
    }

    @Override public Types visitAsgmtExpr(SExpressionsParser.AsgmtExprContext ctx)
    {
        SExpressionsParser.IdentifierContext operand1 = ctx.identifier();
        SExpressionsParser.ExprContext operand2 = ctx.expr();
        // sets default type of identifier to unknown
        Types operand1Type = Types.UNKNOWN;
        // sets type of expression by visiting it
        operand2.t = visit(operand2);

        // loops through all parameters of current function to set the type of the identifier
        for (int i = 0; i < current_dec.params.size(); i++)
        {
            if(current_dec.params.get(i).identifier().getText().equals(operand1.getText()))
            {
                // returns type of identifier stored in the symbol table
                operand1Type = local_vars.get(operand1.getText());
                break;
            }
        }

        // if identifier is not found in previous loop, type remains unknown, therefore throws error as the
        // identifier is not defined anywhere
        if(operand1Type == Types.UNKNOWN)
        {
            throw new TypeException().undeclaredVarError(current_dec, operand1, Types.UNKNOWN);
        }

        // throws error if the identifier and the expression do not have the same type
        if (operand1Type != operand2.t)
        {
            throw new TypeException().assignmentError(ctx, operand1, operand1Type, operand2, operand2.t);
        }

        return Types.UNIT;
    }

    @Override public Types visitFunInvocExpr(SExpressionsParser.FunInvocExprContext ctx)
    {
        SExpressionsParser.DecContext function;
        SExpressionsParser.ExprContext operand1;

        // throws error if the function has not been declared
        if(!global_funcs.containsKey(ctx.identifier().getText()))
        {
            throw new TypeException().undeclaredFuncError(current_dec, ctx.identifier(), Types.UNKNOWN);
        }
        else
        {
            function = global_funcs.get(ctx.identifier().getText());
        }

        // if the number of arguments when invoking the function is not the same as the
        // number of arguments in the function declaration, throws error
        if(function.params.size() != ctx.block().exprs.size())
        {
            throw new TypeException().argumentNumberError(ctx, ctx.block(), Types.UNKNOWN);
        }

        for (int i = 0; i < function.params.size(); i++)
        {
            operand1 = ctx.block().expr(i);
            // sets the type of each parameter by visiting it
            operand1.t = visit(operand1);

            // throws error if parameter has null type meaning it has not been declared
            if(operand1.t == null)
            {
                throw new TypeException().undeclaredVarError(current_dec, operand1, Types.UNKNOWN);
            }

            // throws error if type of parameter does not match that in the function declaration
            if(local_vars.get(function.params.get(i).getChild(1).getText()) != operand1.t)
            {
                throw new TypeException().argumentError(ctx, operand1, operand1.t);
            }
        }

        // returns the functions type
        return Types.toType(function.type());
    }

    @Override public Types visitBlockExpr(SExpressionsParser.BlockExprContext ctx)
    {
        // visits block
        return visit(ctx.block());
    }

    @Override public Types visitIdExpr(SExpressionsParser.IdExprContext ctx)
    {
        //checks if the identifier is in the current dec's scope
        for (int i = 0; i < current_dec.params.size(); i++)
        {
            if(current_dec.params.get(i).identifier().getText().equals(ctx.getText()))
            {
                // returns type of identifier stored in the symbol table
                return local_vars.get(ctx.getText());
            }
        }

        throw new TypeException().undeclaredVarError(current_dec, ctx, Types.UNKNOWN);
    }

    @Override public Types visitIntExpr(SExpressionsParser.IntExprContext ctx)
    {
        // returns int type
        return Types.INT;
    }

    @Override public Types visitSkipExpr(SExpressionsParser.SkipExprContext ctx)
    {
        // returns unit type
        return Types.UNIT;
    }

    @Override public Types visitIdentifier(SExpressionsParser.IdentifierContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitInteger(SExpressionsParser.IntegerContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitBinop(SExpressionsParser.BinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

}
