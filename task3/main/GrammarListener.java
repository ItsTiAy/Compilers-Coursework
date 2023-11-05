// Generated from C:/Users/thoma/OneDrive - University of Sussex/Year 2/Autumn Semester/Compilers and Computer Architecture/Assignment/task3/main\Grammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(GrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(GrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterDec(GrammarParser.DecContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitDec(GrammarParser.DecContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#typed_idfr}.
	 * @param ctx the parse tree
	 */
	void enterTyped_idfr(GrammarParser.Typed_idfrContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#typed_idfr}.
	 * @param ctx the parse tree
	 */
	void exitTyped_idfr(GrammarParser.Typed_idfrContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(GrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(GrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIfExpr(GrammarParser.IfExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIfExpr(GrammarParser.IfExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinExpr(GrammarParser.BinExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinExpr(GrammarParser.BinExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterWhileExpr(GrammarParser.WhileExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitWhileExpr(GrammarParser.WhileExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RepeatExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRepeatExpr(GrammarParser.RepeatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RepeatExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRepeatExpr(GrammarParser.RepeatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AsgmtExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAsgmtExpr(GrammarParser.AsgmtExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AsgmtExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAsgmtExpr(GrammarParser.AsgmtExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunInvocExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunInvocExpr(GrammarParser.FunInvocExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunInvocExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunInvocExpr(GrammarParser.FunInvocExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBlockExpr(GrammarParser.BlockExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBlockExpr(GrammarParser.BlockExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(GrammarParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(GrammarParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(GrammarParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(GrammarParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SkipExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSkipExpr(GrammarParser.SkipExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SkipExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSkipExpr(GrammarParser.SkipExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(GrammarParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(GrammarParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(GrammarParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(GrammarParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterBinop(GrammarParser.BinopContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitBinop(GrammarParser.BinopContext ctx);
}