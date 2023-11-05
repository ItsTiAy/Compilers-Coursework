// Generated from C:/Users/thoma/OneDrive - University of Sussex/Year 2/Autumn Semester/Compilers and Computer Architecture/Assignment/task3/main\Grammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(GrammarParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(GrammarParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#typed_idfr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyped_idfr(GrammarParser.Typed_idfrContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(GrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(GrammarParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpr(GrammarParser.IfExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinExpr(GrammarParser.BinExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileExpr(GrammarParser.WhileExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RepeatExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatExpr(GrammarParser.RepeatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AsgmtExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsgmtExpr(GrammarParser.AsgmtExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunInvocExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunInvocExpr(GrammarParser.FunInvocExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockExpr(GrammarParser.BlockExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(GrammarParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(GrammarParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SkipExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipExpr(GrammarParser.SkipExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(GrammarParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(GrammarParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinop(GrammarParser.BinopContext ctx);
}