import com.sun.source.tree.IdentifierTree;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Task1
{
    public static void main(String[] args) throws Exception
    {
        CharStream input = CharStreams.fromStream(System.in);

        LanguageLexer lexer = new LanguageLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        LanguageParser parser = new LanguageParser(tokens);

        ParseTree tree = parser.prog();

        Converter converter = new Converter();
        System.out.println("[" + converter.visit(tree) + "]");
    }
}