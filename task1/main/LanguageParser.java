// Generated from C:/Users/thoma/OneDrive - University of Sussex/Year 2/Autumn Semester/Compilers and Computer Architecture/Assignment/task1/main\Language.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Assign=1, Less=2, LessEq=3, Plus=4, Minus=5, And=6, Xor=7, Eq=8, Gtr=9, 
		GtrEq=10, Times=11, Div=12, Or=13, LParen=14, Comma=15, RParen=16, LBrace=17, 
		Semicolon=18, RBrace=19, IntType=20, BoolType=21, UnitType=22, While=23, 
		Do=24, Repeat=25, Until=26, If=27, Then=28, Else=29, Skip=30, Idfr=31, 
		IntLit=32, WS=33;
	public static final int
		RULE_prog = 0, RULE_dec = 1, RULE_vardec = 2, RULE_vardecne = 3, RULE_block = 4, 
		RULE_ene = 5, RULE_exp = 6, RULE_args = 7, RULE_argsne = 8, RULE_binop = 9, 
		RULE_type = 10, RULE_idfr = 11, RULE_intlit = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dec", "vardec", "vardecne", "block", "ene", "exp", "args", "argsne", 
			"binop", "type", "idfr", "intlit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':='", "'<'", "'<='", "'+'", "'-'", "'&&'", "'^^'", "'=='", "'>'", 
			"'>='", "'*'", "'/'", "'||'", "'('", "','", "')'", "'{'", "';'", "'}'", 
			"'int'", "'bool'", "'unit'", "'while'", "'do'", "'repeat'", "'until'", 
			"'if'", "'then'", "'else'", "'skip'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Assign", "Less", "LessEq", "Plus", "Minus", "And", "Xor", "Eq", 
			"Gtr", "GtrEq", "Times", "Div", "Or", "LParen", "Comma", "RParen", "LBrace", 
			"Semicolon", "RBrace", "IntType", "BoolType", "UnitType", "While", "Do", 
			"Repeat", "Until", "If", "Then", "Else", "Skip", "Idfr", "IntLit", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public DecContext dec() {
			return getRuleContext(DecContext.class,0);
		}
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				dec();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				dec();
				setState(28);
				prog();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecContext extends ParserRuleContext {
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
	 
		public DecContext() { }
		public void copyFrom(DecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunDeclContext extends DecContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdfrContext idfr() {
			return getRuleContext(IdfrContext.class,0);
		}
		public TerminalNode LParen() { return getToken(LanguageParser.LParen, 0); }
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public TerminalNode RParen() { return getToken(LanguageParser.RParen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunDeclContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFunDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFunDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFunDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dec);
		try {
			_localctx = new FunDeclContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			type();
			setState(33);
			idfr();
			setState(34);
			match(LParen);
			setState(35);
			vardec();
			setState(36);
			match(RParen);
			setState(37);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardecContext extends ParserRuleContext {
		public VardecneContext vardecne() {
			return getRuleContext(VardecneContext.class,0);
		}
		public VardecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterVardec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitVardec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitVardec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecContext vardec() throws RecognitionException {
		VardecContext _localctx = new VardecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vardec);
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RParen:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case IntType:
			case BoolType:
			case UnitType:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				vardecne(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardecneContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdfrContext idfr() {
			return getRuleContext(IdfrContext.class,0);
		}
		public VardecneContext vardecne() {
			return getRuleContext(VardecneContext.class,0);
		}
		public TerminalNode Comma() { return getToken(LanguageParser.Comma, 0); }
		public VardecneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterVardecne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitVardecne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitVardecne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecneContext vardecne() throws RecognitionException {
		return vardecne(0);
	}

	private VardecneContext vardecne(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VardecneContext _localctx = new VardecneContext(_ctx, _parentState);
		VardecneContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_vardecne, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(44);
			type();
			setState(45);
			idfr();
			}
			_ctx.stop = _input.LT(-1);
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VardecneContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_vardecne);
					setState(47);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(48);
					match(Comma);
					setState(49);
					type();
					setState(50);
					idfr();
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(LanguageParser.LBrace, 0); }
		public EneContext ene() {
			return getRuleContext(EneContext.class,0);
		}
		public TerminalNode RBrace() { return getToken(LanguageParser.RBrace, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(LBrace);
			setState(58);
			ene();
			setState(59);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EneContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(LanguageParser.Semicolon, 0); }
		public EneContext ene() {
			return getRuleContext(EneContext.class,0);
		}
		public EneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ene; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterEne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitEne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitEne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EneContext ene() throws RecognitionException {
		EneContext _localctx = new EneContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ene);
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				exp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				exp();
				setState(63);
				match(Semicolon);
				setState(64);
				ene();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BlkContext extends ExpContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlkContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterBlk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitBlk(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitBlk(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfstmtContext extends ExpContext {
		public TerminalNode If() { return getToken(LanguageParser.If, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Then() { return getToken(LanguageParser.Then, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode Else() { return getToken(LanguageParser.Else, 0); }
		public IfstmtContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIfstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIfstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitIfstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RepeatLoopContext extends ExpContext {
		public TerminalNode Repeat() { return getToken(LanguageParser.Repeat, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Until() { return getToken(LanguageParser.Until, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public RepeatLoopContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterRepeatLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitRepeatLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitRepeatLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsgmtContext extends ExpContext {
		public IdfrContext idfr() {
			return getRuleContext(IdfrContext.class,0);
		}
		public TerminalNode Assign() { return getToken(LanguageParser.Assign, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AsgmtContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterAsgmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitAsgmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitAsgmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipContext extends ExpContext {
		public TerminalNode Skip() { return getToken(LanguageParser.Skip, 0); }
		public SkipContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterSkip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitSkip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitSkip(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinOpExprContext extends ExpContext {
		public TerminalNode LParen() { return getToken(LanguageParser.LParen, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public BinopContext binop() {
			return getRuleContext(BinopContext.class,0);
		}
		public TerminalNode RParen() { return getToken(LanguageParser.RParen, 0); }
		public BinOpExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterBinOpExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitBinOpExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitBinOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExpContext {
		public IdfrContext idfr() {
			return getRuleContext(IdfrContext.class,0);
		}
		public IdContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileLoopContext extends ExpContext {
		public TerminalNode While() { return getToken(LanguageParser.While, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Do() { return getToken(LanguageParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileLoopContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExpContext {
		public IntlitContext intlit() {
			return getRuleContext(IntlitContext.class,0);
		}
		public IntContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunInvocContext extends ExpContext {
		public IdfrContext idfr() {
			return getRuleContext(IdfrContext.class,0);
		}
		public TerminalNode LParen() { return getToken(LanguageParser.LParen, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode RParen() { return getToken(LanguageParser.RParen, 0); }
		public FunInvocContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFunInvoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFunInvoc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFunInvoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_exp);
		try {
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new IdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				idfr();
				}
				break;
			case 2:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				intlit();
				}
				break;
			case 3:
				_localctx = new AsgmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				idfr();
				setState(71);
				match(Assign);
				setState(72);
				exp();
				}
				break;
			case 4:
				_localctx = new BinOpExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				match(LParen);
				setState(75);
				exp();
				setState(76);
				binop();
				setState(77);
				exp();
				setState(78);
				match(RParen);
				}
				break;
			case 5:
				_localctx = new FunInvocContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				idfr();
				setState(81);
				match(LParen);
				setState(82);
				args();
				setState(83);
				match(RParen);
				}
				break;
			case 6:
				_localctx = new BlkContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(85);
				block();
				}
				break;
			case 7:
				_localctx = new IfstmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(86);
				match(If);
				setState(87);
				exp();
				setState(88);
				match(Then);
				setState(89);
				block();
				setState(90);
				match(Else);
				setState(91);
				block();
				}
				break;
			case 8:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(93);
				match(While);
				setState(94);
				exp();
				setState(95);
				match(Do);
				setState(96);
				block();
				}
				break;
			case 9:
				_localctx = new RepeatLoopContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(98);
				match(Repeat);
				setState(99);
				block();
				setState(100);
				match(Until);
				setState(101);
				exp();
				}
				break;
			case 10:
				_localctx = new SkipContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(103);
				match(Skip);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public ArgsneContext argsne() {
			return getRuleContext(ArgsneContext.class,0);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_args);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RParen:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case LParen:
			case LBrace:
			case While:
			case Repeat:
			case If:
			case Skip:
			case Idfr:
			case IntLit:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				argsne(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsneContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ArgsneContext argsne() {
			return getRuleContext(ArgsneContext.class,0);
		}
		public TerminalNode Comma() { return getToken(LanguageParser.Comma, 0); }
		public ArgsneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argsne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterArgsne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitArgsne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitArgsne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsneContext argsne() throws RecognitionException {
		return argsne(0);
	}

	private ArgsneContext argsne(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgsneContext _localctx = new ArgsneContext(_ctx, _parentState);
		ArgsneContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_argsne, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(111);
			exp();
			}
			_ctx.stop = _input.LT(-1);
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgsneContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_argsne);
					setState(113);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(114);
					match(Comma);
					setState(115);
					exp();
					}
					} 
				}
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BinopContext extends ParserRuleContext {
		public TerminalNode Eq() { return getToken(LanguageParser.Eq, 0); }
		public TerminalNode Less() { return getToken(LanguageParser.Less, 0); }
		public TerminalNode Gtr() { return getToken(LanguageParser.Gtr, 0); }
		public TerminalNode LessEq() { return getToken(LanguageParser.LessEq, 0); }
		public TerminalNode GtrEq() { return getToken(LanguageParser.GtrEq, 0); }
		public TerminalNode Plus() { return getToken(LanguageParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(LanguageParser.Minus, 0); }
		public TerminalNode Times() { return getToken(LanguageParser.Times, 0); }
		public TerminalNode Div() { return getToken(LanguageParser.Div, 0); }
		public TerminalNode And() { return getToken(LanguageParser.And, 0); }
		public TerminalNode Or() { return getToken(LanguageParser.Or, 0); }
		public TerminalNode Xor() { return getToken(LanguageParser.Xor, 0); }
		public BinopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitBinop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinopContext binop() throws RecognitionException {
		BinopContext _localctx = new BinopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_binop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Less) | (1L << LessEq) | (1L << Plus) | (1L << Minus) | (1L << And) | (1L << Xor) | (1L << Eq) | (1L << Gtr) | (1L << GtrEq) | (1L << Times) | (1L << Div) | (1L << Or))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode IntType() { return getToken(LanguageParser.IntType, 0); }
		public TerminalNode BoolType() { return getToken(LanguageParser.BoolType, 0); }
		public TerminalNode UnitType() { return getToken(LanguageParser.UnitType, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << UnitType))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdfrContext extends ParserRuleContext {
		public TerminalNode Idfr() { return getToken(LanguageParser.Idfr, 0); }
		public IdfrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idfr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIdfr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIdfr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitIdfr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdfrContext idfr() throws RecognitionException {
		IdfrContext _localctx = new IdfrContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_idfr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(Idfr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntlitContext extends ParserRuleContext {
		public TerminalNode IntLit() { return getToken(LanguageParser.IntLit, 0); }
		public IntlitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intlit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIntlit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIntlit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitIntlit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntlitContext intlit() throws RecognitionException {
		IntlitContext _localctx = new IntlitContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_intlit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(IntLit);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return vardecne_sempred((VardecneContext)_localctx, predIndex);
		case 8:
			return argsne_sempred((ArgsneContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean vardecne_sempred(VardecneContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean argsne_sempred(ArgsneContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u0084\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\5\2!\n\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\5\4,\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5"+
		"\67\n\5\f\5\16\5:\13\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7E\n\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\bk\n\b\3\t\3\t\5\to\n\t\3\n\3\n\3\n\3\n\3\n\3\n\7\nw\n\n\f\n\16\n"+
		"z\13\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\2\4\b\22\17\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\2\4\3\2\4\17\3\2\26\30\2\u0085\2 \3\2\2\2\4\""+
		"\3\2\2\2\6+\3\2\2\2\b-\3\2\2\2\n;\3\2\2\2\fD\3\2\2\2\16j\3\2\2\2\20n\3"+
		"\2\2\2\22p\3\2\2\2\24{\3\2\2\2\26}\3\2\2\2\30\177\3\2\2\2\32\u0081\3\2"+
		"\2\2\34!\5\4\3\2\35\36\5\4\3\2\36\37\5\2\2\2\37!\3\2\2\2 \34\3\2\2\2 "+
		"\35\3\2\2\2!\3\3\2\2\2\"#\5\26\f\2#$\5\30\r\2$%\7\20\2\2%&\5\6\4\2&\'"+
		"\7\22\2\2\'(\5\n\6\2(\5\3\2\2\2),\3\2\2\2*,\5\b\5\2+)\3\2\2\2+*\3\2\2"+
		"\2,\7\3\2\2\2-.\b\5\1\2./\5\26\f\2/\60\5\30\r\2\608\3\2\2\2\61\62\f\3"+
		"\2\2\62\63\7\21\2\2\63\64\5\26\f\2\64\65\5\30\r\2\65\67\3\2\2\2\66\61"+
		"\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\t\3\2\2\2:8\3\2\2\2;<\7\23"+
		"\2\2<=\5\f\7\2=>\7\25\2\2>\13\3\2\2\2?E\5\16\b\2@A\5\16\b\2AB\7\24\2\2"+
		"BC\5\f\7\2CE\3\2\2\2D?\3\2\2\2D@\3\2\2\2E\r\3\2\2\2Fk\5\30\r\2Gk\5\32"+
		"\16\2HI\5\30\r\2IJ\7\3\2\2JK\5\16\b\2Kk\3\2\2\2LM\7\20\2\2MN\5\16\b\2"+
		"NO\5\24\13\2OP\5\16\b\2PQ\7\22\2\2Qk\3\2\2\2RS\5\30\r\2ST\7\20\2\2TU\5"+
		"\20\t\2UV\7\22\2\2Vk\3\2\2\2Wk\5\n\6\2XY\7\35\2\2YZ\5\16\b\2Z[\7\36\2"+
		"\2[\\\5\n\6\2\\]\7\37\2\2]^\5\n\6\2^k\3\2\2\2_`\7\31\2\2`a\5\16\b\2ab"+
		"\7\32\2\2bc\5\n\6\2ck\3\2\2\2de\7\33\2\2ef\5\n\6\2fg\7\34\2\2gh\5\16\b"+
		"\2hk\3\2\2\2ik\7 \2\2jF\3\2\2\2jG\3\2\2\2jH\3\2\2\2jL\3\2\2\2jR\3\2\2"+
		"\2jW\3\2\2\2jX\3\2\2\2j_\3\2\2\2jd\3\2\2\2ji\3\2\2\2k\17\3\2\2\2lo\3\2"+
		"\2\2mo\5\22\n\2nl\3\2\2\2nm\3\2\2\2o\21\3\2\2\2pq\b\n\1\2qr\5\16\b\2r"+
		"x\3\2\2\2st\f\3\2\2tu\7\21\2\2uw\5\16\b\2vs\3\2\2\2wz\3\2\2\2xv\3\2\2"+
		"\2xy\3\2\2\2y\23\3\2\2\2zx\3\2\2\2{|\t\2\2\2|\25\3\2\2\2}~\t\3\2\2~\27"+
		"\3\2\2\2\177\u0080\7!\2\2\u0080\31\3\2\2\2\u0081\u0082\7\"\2\2\u0082\33"+
		"\3\2\2\2\t +8Djnx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}