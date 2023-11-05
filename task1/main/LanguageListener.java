// Generated from C:/Users/thoma/OneDrive - University of Sussex/Year 2/Autumn Semester/Compilers and Computer Architecture/Assignment/task1/main\Language.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParser}.
 */
public interface LanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LanguageParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LanguageParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunDecl}
	 * labeled alternative in {@link LanguageParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterFunDecl(LanguageParser.FunDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunDecl}
	 * labeled alternative in {@link LanguageParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitFunDecl(LanguageParser.FunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#vardec}.
	 * @param ctx the parse tree
	 */
	void enterVardec(LanguageParser.VardecContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#vardec}.
	 * @param ctx the parse tree
	 */
	void exitVardec(LanguageParser.VardecContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#vardecne}.
	 * @param ctx the parse tree
	 */
	void enterVardecne(LanguageParser.VardecneContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#vardecne}.
	 * @param ctx the parse tree
	 */
	void exitVardecne(LanguageParser.VardecneContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LanguageParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LanguageParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#ene}.
	 * @param ctx the parse tree
	 */
	void enterEne(LanguageParser.EneContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#ene}.
	 * @param ctx the parse tree
	 */
	void exitEne(LanguageParser.EneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Id}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterId(LanguageParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitId(LanguageParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterInt(LanguageParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitInt(LanguageParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Asgmt}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAsgmt(LanguageParser.AsgmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Asgmt}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAsgmt(LanguageParser.AsgmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinOpExpr}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBinOpExpr(LanguageParser.BinOpExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinOpExpr}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBinOpExpr(LanguageParser.BinOpExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunInvoc}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterFunInvoc(LanguageParser.FunInvocContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunInvoc}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitFunInvoc(LanguageParser.FunInvocContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Blk}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBlk(LanguageParser.BlkContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Blk}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBlk(LanguageParser.BlkContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Ifstmt}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(LanguageParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Ifstmt}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(LanguageParser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(LanguageParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(LanguageParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RepeatLoop}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterRepeatLoop(LanguageParser.RepeatLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RepeatLoop}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitRepeatLoop(LanguageParser.RepeatLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Skip}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSkip(LanguageParser.SkipContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Skip}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSkip(LanguageParser.SkipContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(LanguageParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(LanguageParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#argsne}.
	 * @param ctx the parse tree
	 */
	void enterArgsne(LanguageParser.ArgsneContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#argsne}.
	 * @param ctx the parse tree
	 */
	void exitArgsne(LanguageParser.ArgsneContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterBinop(LanguageParser.BinopContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitBinop(LanguageParser.BinopContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LanguageParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LanguageParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#idfr}.
	 * @param ctx the parse tree
	 */
	void enterIdfr(LanguageParser.IdfrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#idfr}.
	 * @param ctx the parse tree
	 */
	void exitIdfr(LanguageParser.IdfrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#intlit}.
	 * @param ctx the parse tree
	 */
	void enterIntlit(LanguageParser.IntlitContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#intlit}.
	 * @param ctx the parse tree
	 */
	void exitIntlit(LanguageParser.IntlitContext ctx);
}