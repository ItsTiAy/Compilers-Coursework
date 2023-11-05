import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Task3
{
    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        CharStream input = CharStreams.fromStream(System.in);

        // create a lexer that feeds off of input CharStream
        GrammarLexer lexer = new GrammarLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        GrammarParser parser = new GrammarParser(tokens);
        ParseTree tree = parser.prog(); // begin parsing at prog rule

        Converter converter = new Converter();
        String code = (converter.visit(tree));

        StringBuilder macros = new StringBuilder();

        // adds all macros in the hashmap into a string
        for(String key: converter.allMacros.keySet())
        {
            macros.append(key);
        }

        System.out.println(macros + "\t.text\n" + code);
    }
}