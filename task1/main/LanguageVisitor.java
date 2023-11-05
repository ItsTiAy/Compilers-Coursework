// Generated from C:/Users/thoma/OneDrive - University of Sussex/Year 2/Autumn Semester/Compilers and Computer Architecture/Assignment/task1/main\Language.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(LanguageParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunDecl}
	 * labeled alternative in {@link LanguageParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDecl(LanguageParser.FunDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#vardec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardec(LanguageParser.VardecContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#vardecne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardecne(LanguageParser.VardecneContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LanguageParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#ene}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEne(LanguageParser.EneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(LanguageParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(LanguageParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Asgmt}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsgmt(LanguageParser.AsgmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinOpExpr}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinOpExpr(LanguageParser.BinOpExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunInvoc}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunInvoc(LanguageParser.FunInvocContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Blk}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlk(LanguageParser.BlkContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Ifstmt}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(LanguageParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(LanguageParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RepeatLoop}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatLoop(LanguageParser.RepeatLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Skip}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip(LanguageParser.SkipContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(LanguageParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#argsne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgsne(LanguageParser.ArgsneContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinop(LanguageParser.BinopContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LanguageParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#idfr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdfr(LanguageParser.IdfrContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#intlit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntlit(LanguageParser.IntlitContext ctx);
}