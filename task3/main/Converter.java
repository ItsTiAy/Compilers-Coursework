import java.util.HashMap;
import java.util.Map;

public class Converter extends GrammarBaseVisitor<String>
{
    private Map <String, String> idAddress = new HashMap<>();
    Map <String, String> allMacros = new HashMap<>();
    GrammarParser.DecContext current_dec = null;

    int labelNo = 0;

    @Override public String visitProg(GrammarParser.ProgContext ctx)
    {
        StringBuilder out = new StringBuilder();
        allMacros.put(macros.pushImm(), "pushImm");
        allMacros.put(macros.push(), "push");

        //sets main function to be at the beginning
        int index_main = 0;
        for (int i = 0; i < ctx.decs.size(); i++)
        {
            GrammarParser.DecContext dec = ctx.decs.get(i);
            if (dec.identifier().Idfr().getText().equals("main"))
            {
                index_main = i;
            }
        }

        GrammarParser.DecContext main = ctx.decs.get(index_main);
        ctx.decs.set(index_main, ctx.decs.get(0));
        ctx.decs.set(0, main);


        //adds all functions to a hashmap to be accessed when invoking a function
        for (int i = 0; i < ctx.decs.size(); i++)
        {
            for (int j = 0; j < ctx.dec(i).params.size(); j++)
            {
                String currentDecName = ctx.dec(i).identifier().getText();
                String id = ctx.dec(i).typed_idfr(j).identifier().getText();
                // key for idAddress is combination of the function name and the identifier name as this always creates a unique key
                idAddress.put(currentDecName + id, ((j * -4) - 4) + "(fp)");
            }
            //global_funcs.put(ctx.dec(i).identifier().Idfr().getText(), ctx.dec(i));
        }

        // visits each function
        for (int i = 0; i < ctx.decs.size(); i++)
        {
            current_dec = ctx.decs.get(i);
            out.append(visit(ctx.decs.get(i)));
        }

        out.append("end:\nlw\t\ta0, 4(sp)\n");
        out.append("li\t\ta7, 10\n");
        out.append("ecall");

        return out.toString();
    }

    @Override public String visitDec(GrammarParser.DecContext ctx)
    {
        String out = ctx.identifier().Idfr().getText() + ":\n" + visit(ctx.block());

        if(ctx.identifier().Idfr().getText().equals("main"))
        {
            // adds "b  end" to end of the main function to branch to end when finished
            out += "b\t\tend\n";
        }
        else
        {
            //if not the main function, loads a0 with return value that should be on the top of the stack
            out += "lw\t\ta0, 4(sp)\n";
            out += "ret\n";
        }

        return out;
    }

    @Override public String visitBlock(GrammarParser.BlockContext ctx)
    {
        StringBuilder out = new StringBuilder();

        // visits all expressions in a block
        for (int i = 0; i < ctx.exprs.size(); i++)
        {
            out.append(visit(ctx.expr(i)));
        }
        return out.toString();
    }

    @Override public String visitIfExpr(GrammarParser.IfExprContext ctx)
    {
        String out;
        //generates new labels
        String elseLabel = newLabel();
        String endIfLabel = newLabel();

        //stores result of expression on the top of the stack
        //this will be either 1 or 0 for true and false respectively
        out = visit(ctx.expr());

        //loads t1 with the result on the top of the stack
        out += "lw \t\tt1, 4(sp)\n";
        out += "addi\tsp, sp, 4\n";

        //branches to elseLabel if 0 (false)
        out += "beqz\tt1, " + elseLabel + "\n";

        //code for if the statement is true
        out += visit(ctx.block(0));

        out += "b\t\t" + endIfLabel + "\n";
        out += elseLabel + ":\n";

        //code for if the statement is false
        out += visit(ctx.block(1));

        out += endIfLabel + ":\n";

        return out;
    }

    @Override public String visitBinExpr(GrammarParser.BinExprContext ctx)
    {
        //does operation and stores result at the top of the stack
        String out = visit(ctx.expr(1)) + visit(ctx.expr(0)) + ctx.binop().getText();

        switch (ctx.binop().getText())
        {
            //adds the macro for the operation to the map of macros
            case "Eq" ->        allMacros.put(macros.eq(), "Eq");
            case "Less" ->      allMacros.put(macros.less(), "Less");
            case "Gtr" ->       allMacros.put(macros.gtr(), "Gtr");
            case "LessEq" ->    allMacros.put(macros.lessEq(), "LessEq");
            case "GtrEq" ->     allMacros.put(macros.gtrEq(), "GtrEq");
            case "Plus" ->      allMacros.put(macros.plus(), "Plus");
            case "Times" ->     allMacros.put(macros.times(), "Times");
            case "Minus" ->     allMacros.put(macros.minus(), "Minus");

            // adds "ide" to the end of "Div" to make it "Divide" as you can't have div as a macro name
            case "Div" ->       {
                allMacros.put(macros.divide(), "Div");
                out += "ide";
            }
            // adds "Mac" to the end of these as you can't have them as macro names on their own
            case "And" ->       {
                allMacros.put(macros.and(), "And");
                out += "Mac";
            }
            case "Or" ->        {
                allMacros.put(macros.or(), "Or");
                out += "Mac";
            }
            case "Xor" ->       {
                allMacros.put(macros.xor(), "Xor");
                out += "Mac";
            }
            default -> out = "Something's gone wrong";
        }
        out += "\n";
        return out;
    }

    @Override public String visitWhileExpr(GrammarParser.WhileExprContext ctx)
    {
        String out = "";

        //creates new labels
        String startLabel = newLabel();
        String endWhileLabel = newLabel();

        out += startLabel + ":\n";

        //stores result of expression on the top of the stack
        //this will be either 1 or 0 for true and false respectively
        out += visit(ctx.expr());

        out += "lw \t\tt1, 4(sp)\n";
        out += "addi\tsp, sp, 4\n";

        //branch if the expression is no longer true
        out += "beqz\tt1, " + endWhileLabel + "\n";

        //generates code for the loop body
        out += visit(ctx.block());

        out += "b\t\t" + startLabel + "\n";
        out += endWhileLabel + ":\n";

        return out;
    }

    @Override public String visitRepeatExpr(GrammarParser.RepeatExprContext ctx)
    {
        String out = "";

        //creates new labels
        String startLabel = newLabel();
        String endRepeatLabel = newLabel();

        out += startLabel + ":\n";

        //generates code for the loop body
        out += visit(ctx.block());

        //stores result of expression on the top of the stack
        //this will be either 1 or 0 for true and false respectively
        out += visit(ctx.expr());

        out += "lw \t\tt1, 4(sp)\n";
        out += "addi\tsp, sp, 4\n";

        //branch if the expression has become true
        out += "bnez\tt1, " + endRepeatLabel + "\n";

        out += "b\t\t" + startLabel + "\n";

        out += endRepeatLabel + ":\n";

        return out;
    }

    @Override public String visitAsgmtExpr(GrammarParser.AsgmtExprContext ctx)
    {
        String out = "";

        //returns a value that you want to assign to the identifier
        out += visit(ctx.expr());

        //loads value of top of stack into t1
        out += "lw\t\tt1 4(sp)\n";

        //stores value in t1 onto the address of the identifier
        out += "sw\t\tt1 " + getIdAddress(ctx.identifier().getText()) + "\n";

        return out;
    }

    @Override public String visitFunInvocExpr(GrammarParser.FunInvocExprContext ctx)
    {
        // Push the arguments onto the top of the stack in reverse order and then call the function
        StringBuilder function = new StringBuilder();

        //adds the SavePointers and RestorePointers macros to the macros map
        allMacros.put(macros.savePointers(), "SavePointers");
        allMacros.put(macros.restorePointers(), "RestorePointers");

        //stores old fp address into a1
        function.append("mv\t\ta1 fp\n");
        function.append("SavePointers\n");

        // temp sets all parameters to use previous frame pointer as it has just been moved
        // this allows arguments in the current function to work correctly
        for (int i = 0; i < current_dec.params.size(); i++)
        {
            String id = current_dec.typed_idfr(i).identifier().getText();
            idAddress.replace(current_dec.identifier().getText() + id, ((i * -4) - 4) + "(a1)");
        }

        // pushes parameters onto stack
        for (int i = 0; i < ctx.block().exprs.size(); i++)
        {
            function.append(visit(ctx.block().expr(i)));
        }

        // changes arguments to use the normal frame pointer again
        for (int i = 0; i < current_dec.params.size(); i++)
        {
            String id = current_dec.typed_idfr(i).identifier().getText();
            idAddress.replace(current_dec.identifier().getText() + id, ((i * -4) - 4) + "(fp)");
        }

        function.append("jal\t\t").append((ctx.identifier().Idfr().getText())).append("\n");

        function.append("RestorePointers\n");

        // Stores what was returned from the function (in a0) onto the top of the stack and then moves the stack down
        function.append("sw\t\ta0, (sp)\naddi\tsp, sp, -4\n");

        return function.toString();
    }

    @Override public String visitBlockExpr(GrammarParser.BlockExprContext ctx)
    {
        return visit(ctx.block());
    }

    @Override public String visitIdExpr(GrammarParser.IdExprContext ctx)
    {
        return visit(ctx.identifier());
    }

    @Override public String visitIntExpr(GrammarParser.IntExprContext ctx)
    {
        return visit(ctx.integer());
    }

    @Override public String visitSkipExpr(GrammarParser.SkipExprContext ctx)
    {
        // Skip keyword does not do anything so just returns an empty string
        return "";
    }

    @Override public String visitIdentifier(GrammarParser.IdentifierContext ctx)
    {
        String address = getIdAddress(ctx.getText());
        // address will be null if the function is never invoked, so if it is null the identifiers address is set to "(zero)"
        // Will not have any effect on program as the function isn't used
        // Might no longer be needed now
        if(address == null)
        {
            address = "(zero)";
        }
        // should push value on stack from address of the variable
        String out = "lw\t\tt1, " + address + "\n";
        out += "Push\n";

        return out;
    }

    @Override public String visitInteger(GrammarParser.IntegerContext ctx)
    {
        // Pushes the number onto the stack
        return "PushImm\t" + (ctx.IntLit()) + "\n";
    }

    @Override public String visitBinop(GrammarParser.BinopContext ctx) { return visitChildren(ctx); }

    public String newLabel()
    {
        // increases label number by 1 each time so each label is unique
        labelNo++;
        return "label" + labelNo;
    }

    public String getIdAddress(String identifier)
    {
        // returns the frame pointer address for the identifier in the current function
        return idAddress.get(current_dec.identifier().getText() + identifier);
    }
}

