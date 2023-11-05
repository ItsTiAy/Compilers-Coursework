import java.util.ArrayList;

public class Converter extends LanguageBaseVisitor<String>
{

    @Override public String visitProg(LanguageParser.ProgContext ctx)
    {
        // Recursively loops through this method for each function declaration, visiting each one until all
        // the functions have been visited. They are then concatenated to one string which is returned
        if (ctx.prog().getChildCount() == 0)
        {
            return visit(ctx.dec()); // The function declaration
        }
        else
        {
            return visit(ctx.dec()) + ", " + visit(ctx.prog());
        }
    }

    @Override
    public String visitFunDecl(LanguageParser.FunDeclContext ctx)
    {
        ArrayList<String> FunDecl = new ArrayList<>();

        FunDecl.add("FunDecl");

        // Visits each part of the function declaration which return their corresponding strings that can be added to
        // the function declaration list
        FunDecl.add(visit(ctx.idfr())); // The identifier
        FunDecl.add(visit(ctx.type())); // The functions type
        FunDecl.add("[" + visit(ctx.vardec()) + "]"); // The variable declarations
        FunDecl.add(visit(ctx.block())); // The code in the function

        return FunDecl.toString();
    }

    @Override public String visitBlock(LanguageParser.BlockContext ctx)
    {
        ArrayList<String> Block = new ArrayList<>();

        // Visits ene where expressions are added
        Block.add(visit(ctx.ene())); // Group of expressions

        return Block.toString();
    }

    @Override public String visitEne(LanguageParser.EneContext ctx)
    {
        // Recursively loops through this method for each expression, visiting each one until all the expressions
        // have been visited. They are then concatenated to one string which is returned
        if (ctx.getChildCount() == 1)
        {
            return visit(ctx.exp()); // An Expression
        }
        else
        {
            return visit(ctx.exp()) + ", " + visit(ctx.ene());
        }
    }

    @Override
    public String visitAsgmt(LanguageParser.AsgmtContext ctx)
    {
        ArrayList<String> Asgmt = new ArrayList<>();

        // Visits each part of the assignment which return their corresponding strings that can be added to the list
        // which is then returned as a string
        Asgmt.add("Asgmt");
        Asgmt.add(visit(ctx.idfr())); // The identifier
        Asgmt.add(visit(ctx.exp())); // An expression

        return Asgmt.toString();
    }

    @Override
    public String visitBinOpExpr(LanguageParser.BinOpExprContext ctx)
    {
        ArrayList<String> BinOpExpr = new ArrayList<>();

        // Visits each part of the Binary Operation Expression which return their corresponding strings that
        // can be added to the list which is then returned as a string
        BinOpExpr.add("BinOpExpr");
        BinOpExpr.add(visit(ctx.binop())); // The operator e.g. +, -, *
        BinOpExpr.add(visit(ctx.exp(0))); // The first expression
        BinOpExpr.add(visit(ctx.exp(1))); // The second expression

        return BinOpExpr.toString();
    }

    @Override
    public String visitFunInvoc(LanguageParser.FunInvocContext ctx)
    {
        ArrayList<String> FunInvoc = new ArrayList<>();

        // Visits each part of the Function Invocation which return their corresponding strings that can be added
        // to the list which is then returned as a string
        FunInvoc.add("FunInvoc");
        FunInvoc.add(visit(ctx.idfr())); // The function's identifier
        FunInvoc.add("[" + visit(ctx.args()) + "]"); // The function's arguments

        return FunInvoc.toString();
    }

    @Override
    public String visitIfstmt(LanguageParser.IfstmtContext ctx)
    {
        ArrayList<String> Ifstmt = new ArrayList<>();

        // Visits each part of the If Statement which return their corresponding strings that can be added to the
        // list which is then returned as a string
        Ifstmt.add("IfStmt");
        Ifstmt.add(visit(ctx.exp())); // The expression (returns a boolean value)
        Ifstmt.add(visit(ctx.block(0))); // Code for if true
        Ifstmt.add(visit(ctx.block(1))); // Code for if false

        return Ifstmt.toString();
    }

    @Override
    public String visitWhileLoop(LanguageParser.WhileLoopContext ctx)
    {
        ArrayList<String> WhileLoop = new ArrayList<>();

        // Visits each part of the While Loop which return their corresponding strings that can be added to the
        // list which is then returned as a string
        WhileLoop.add("WhileLoop");
        WhileLoop.add(visit(ctx.exp())); // The expression (returns a boolean value)
        WhileLoop.add(visit(ctx.block())); // The code for while true

        return WhileLoop.toString();
    }

    @Override
    public String visitRepeatLoop(LanguageParser.RepeatLoopContext ctx)
    {
        ArrayList<String> RepeatLoop = new ArrayList<>();

        // Visits each part of the Repeat Loop which return their corresponding strings that can be added to the
        // list which is then returned as a string
        RepeatLoop.add("RepeatLoop");
        RepeatLoop.add(visit(ctx.exp())); // The expression (returns a boolean value)
        RepeatLoop.add(visit(ctx.block())); // The code for while the repeat is true

        return RepeatLoop.toString();
    }

    @Override public String visitArgs(LanguageParser.ArgsContext ctx)
    {
        // If there are no arguments, returns an empty string. Otherwise, visits the arguments' method which returns
        // the arguments
        if (ctx.getChildCount() == 0)
        {
            return "";
        }
        else
        {
            return visit(ctx.argsne());
        }
    }


    @Override public String visitArgsne(LanguageParser.ArgsneContext ctx)
    {
        // Recursively loops through this method for each argument, visiting each one until all the arguments
        // have been visited. They are then concatenated to one string which is returned
        if (ctx.getChildCount() == 1)
        {
            return visit(ctx.exp()); // The expression to be used as an argument
        }
        else
        {
            return visit(ctx.argsne()) + ", " + visit(ctx.exp());
        }
    }

    @Override public String visitVardec(LanguageParser.VardecContext ctx)
    {
        // If there are variables, returns an empty string. Otherwise, visits the variable declaration method
        // which returns the variables and their type
        if (ctx.getChildCount() == 0)
        {
            return " ";
        }
        else
        {
            return visit(ctx.vardecne());
        }
    }

    @Override public String visitVardecne(LanguageParser.VardecneContext ctx)
    {
        // Recursively loops through this method for each identifier and type, visiting each one until they have
        // all been visited. They are then concatenated into one string which is returned
        if (ctx.getChildCount() == 2)
        {
            return "[" + visit(ctx.idfr()) + ", " + visit(ctx.type()) + "]";
        }
        else
        {
            return visit(ctx.vardecne()) + ", [" + visit(ctx.idfr()) + ", " + visit(ctx.type()) + "]";
        }
    }

    @Override public String visitType(LanguageParser.TypeContext ctx)
    {
        // Returns the word for the type for each of the three types
        return switch (ctx.getText())
                {
                    case "int" -> "IntType";
                    case "bool" -> "BoolType";
                    case "unit" -> "UnitType";
                    default -> "";
                };
    }

    @Override public String visitIdfr(LanguageParser.IdfrContext ctx)
    {
        // Returns the name of the identifier encased in brackets and "Idfr" at the beginning
        return "Idfr(\"" + ctx.getText() + "\")";
    }

    @Override public String visitIntlit(LanguageParser.IntlitContext ctx)
    {
        // Returns the integer encased in brackets and "IntLit" at the beginning
        return "IntLit(" + ctx.getText() + ")";
    }

    @Override public String visitBinop(LanguageParser.BinopContext ctx)
    {
        // Returns the name associated with the Binary operation symbol
        return switch (ctx.getText())
                {
                    case ":=" -> "Assign";
                    case "<" -> "Less";
                    case "<=" -> "LessEq";
                    case "+" -> "Plus";
                    case "-" -> "Minus";
                    case "&&" -> "And";
                    case "^^" -> "Xor";
                    case "==" -> "Eq";
                    case ">" -> "Gtr";
                    case ">=" -> "GtrEq";
                    case "*" -> "Times";
                    case "/" -> "Div";
                    case "||" -> "Or";
                    default -> "";
                };
    }

    @Override public String visitId(LanguageParser.IdContext ctx)
    {
        // Visits the identifier method
        return visit(ctx.idfr());
    }

    @Override public String visitSkip(LanguageParser.SkipContext ctx)
    {
        // Simply returns the word "Skip"
        return "Skip";
    }
}
