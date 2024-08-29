// Generated from /home/gfrasson/projects/ufjf/08periodo/compiladores/lang-compiler/src/lang/parser/lang.g4 by ANTLR 4.13.1

  package lang.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class langParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FLOAT=1, INT=2, FALSE=3, TRUE=4, NULL=5, IF=6, ELSE=7, DATA=8, ITERATE=9, 
		RETURN=10, PRINT=11, READ=12, NEW=13, ID=14, TYPE_INT=15, TYPE_FLOAT=16, 
		TYPE_BOOL=17, TYPE_CHAR=18, TYPE_NAME=19, CHAR=20, OPEN_PARENTHESIS=21, 
		CLOSE_PARENTHESIS=22, OPEN_BRACKET=23, CLOSE_BRACKET=24, OPEN_CURLY_BRACE=25, 
		CLOSE_CURLY_BRACE=26, GREATER_THAN=27, LESS_THAN=28, SEMICOLON=29, DOUBLE_COLON=30, 
		COLON=31, DOT=32, COMMA=33, COMPARISON=34, EQUAL=35, NOT_EQUAL=36, PLUS=37, 
		MINUS=38, TIMES=39, DIVISION=40, MODULUS=41, AND=42, NOT=43, NEWLINE=44, 
		WHITESPACE=45, LINE_COMMENT=46, COMMENT=47;
	public static final int
		RULE_prog = 0, RULE_def = 1, RULE_data = 2, RULE_decl = 3, RULE_fun = 4, 
		RULE_params = 5, RULE_type = 6, RULE_bType = 7, RULE_cmd = 8, RULE_exp = 9, 
		RULE_lvalue = 10, RULE_exps = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "def", "data", "decl", "fun", "params", "type", "bType", "cmd", 
			"exp", "lvalue", "exps"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'false'", "'true'", "'null'", "'if'", "'else'", "'data'", 
			"'iterate'", "'return'", "'print'", "'read'", "'new'", null, "'Int'", 
			"'Float'", "'Bool'", "'Char'", null, null, "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "'>'", "'<'", "';'", "'::'", "':'", "'.'", "','", "'=='", 
			"'='", "'!='", "'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FLOAT", "INT", "FALSE", "TRUE", "NULL", "IF", "ELSE", "DATA", 
			"ITERATE", "RETURN", "PRINT", "READ", "NEW", "ID", "TYPE_INT", "TYPE_FLOAT", 
			"TYPE_BOOL", "TYPE_CHAR", "TYPE_NAME", "CHAR", "OPEN_PARENTHESIS", "CLOSE_PARENTHESIS", 
			"OPEN_BRACKET", "CLOSE_BRACKET", "OPEN_CURLY_BRACE", "CLOSE_CURLY_BRACE", 
			"GREATER_THAN", "LESS_THAN", "SEMICOLON", "DOUBLE_COLON", "COLON", "DOT", 
			"COMMA", "COMPARISON", "EQUAL", "NOT_EQUAL", "PLUS", "MINUS", "TIMES", 
			"DIVISION", "MODULUS", "AND", "NOT", "NEWLINE", "WHITESPACE", "LINE_COMMENT", 
			"COMMENT"
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
	public String getGrammarFileName() { return "lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public langParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public Definition ast;
		public DefContext def;
		public List<DefContext> def() {
			return getRuleContexts(DefContext.class);
		}
		public DefContext def(int i) {
			return getRuleContext(DefContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DATA || _la==ID) {
				{
				{
				setState(24);
				((ProgContext)_localctx).def = def();
				 ((ProgContext)_localctx).ast =  ((ProgContext)_localctx).def.ast; 
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefContext extends ParserRuleContext {
		public Definition ast;
		public DataContext data;
		public FunContext fun;
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_def);
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATA:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				((DefContext)_localctx).data = data();
				 ((DefContext)_localctx).ast =  ((DefContext)_localctx).data.ast; 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				((DefContext)_localctx).fun = fun();
				 ((DefContext)_localctx).ast =  ((DefContext)_localctx).fun.ast; 
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

	@SuppressWarnings("CheckReturnValue")
	public static class DataContext extends ParserRuleContext {
		public DataRegister ast;
		public Token TYPE_NAME;
		public DeclContext decl;
		public TerminalNode DATA() { return getToken(langParser.DATA, 0); }
		public TerminalNode TYPE_NAME() { return getToken(langParser.TYPE_NAME, 0); }
		public TerminalNode OPEN_CURLY_BRACE() { return getToken(langParser.OPEN_CURLY_BRACE, 0); }
		public TerminalNode CLOSE_CURLY_BRACE() { return getToken(langParser.CLOSE_CURLY_BRACE, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(DATA);
			setState(41);
			((DataContext)_localctx).TYPE_NAME = match(TYPE_NAME);
			setState(42);
			match(OPEN_CURLY_BRACE);
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(43);
				((DataContext)_localctx).decl = decl();
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
			match(CLOSE_CURLY_BRACE);
			 ((DataContext)_localctx).ast =  new DataRegister(((DataContext)_localctx).TYPE_NAME, ((DataContext)_localctx).decl.ast); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public Declaration ast;
		public Token ID;
		public TypeContext type;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TerminalNode DOUBLE_COLON() { return getToken(langParser.DOUBLE_COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(langParser.SEMICOLON, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			((DeclContext)_localctx).ID = match(ID);
			setState(53);
			match(DOUBLE_COLON);
			setState(54);
			((DeclContext)_localctx).type = type(0);
			setState(55);
			match(SEMICOLON);
			 ((DeclContext)_localctx).ast =  new Declaration(((DeclContext)_localctx).ID, ((DeclContext)_localctx).type.ast); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunContext extends ParserRuleContext {
		public Function ast;
		public Token ID;
		public ParamsContext params;
		public TypeContext type1;
		public TypeContext typeList;
		public CmdContext cmd;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TerminalNode OPEN_PARENTHESIS() { return getToken(langParser.OPEN_PARENTHESIS, 0); }
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(langParser.CLOSE_PARENTHESIS, 0); }
		public TerminalNode OPEN_CURLY_BRACE() { return getToken(langParser.OPEN_CURLY_BRACE, 0); }
		public TerminalNode CLOSE_CURLY_BRACE() { return getToken(langParser.CLOSE_CURLY_BRACE, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(langParser.COLON, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(langParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(langParser.COMMA, i);
		}
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			((FunContext)_localctx).ID = match(ID);
			setState(59);
			match(OPEN_PARENTHESIS);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(60);
				((FunContext)_localctx).params = params();
				}
			}

			setState(63);
			match(CLOSE_PARENTHESIS);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(64);
				match(COLON);
				setState(65);
				((FunContext)_localctx).type1 = type(0);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(66);
					match(COMMA);
					setState(67);
					((FunContext)_localctx).typeList = type(0);
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(75);
			match(OPEN_CURLY_BRACE);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33578560L) != 0)) {
				{
				{
				setState(76);
				((FunContext)_localctx).cmd = cmd();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			match(CLOSE_CURLY_BRACE);

			      List<Type> returnTypes = new ArrayList();
			      if (((FunContext)_localctx).type1.ast != null) {
			        returnTypes.add(((FunContext)_localctx).type1.ast);

			        for (Type currentType : ((FunContext)_localctx).typeList.ast) {
			          returnTypes.add(currentType.ast);
			        }
			      }

			      ((FunContext)_localctx).ast =  new Function(((FunContext)_localctx).ID, ((FunContext)_localctx).params.ast, returnTypes, ((FunContext)_localctx).cmd.ast);
			    
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public Parameter ast;
		public Token id1;
		public TypeContext type1;
		public Token id2;
		public TypeContext type2;
		public List<TerminalNode> DOUBLE_COLON() { return getTokens(langParser.DOUBLE_COLON); }
		public TerminalNode DOUBLE_COLON(int i) {
			return getToken(langParser.DOUBLE_COLON, i);
		}
		public List<TerminalNode> ID() { return getTokens(langParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(langParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(langParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(langParser.COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			((ParamsContext)_localctx).id1 = match(ID);
			setState(86);
			match(DOUBLE_COLON);
			setState(87);
			((ParamsContext)_localctx).type1 = type(0);
			 _localctx.ast = new Parameter(((ParamsContext)_localctx).id1, ((ParamsContext)_localctx).type1.ast) 
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(89);
				match(COMMA);
				setState(90);
				((ParamsContext)_localctx).id2 = match(ID);
				setState(91);
				match(DOUBLE_COLON);
				setState(92);
				((ParamsContext)_localctx).type2 = type(0);
				 _localctx.ast = new Parameter(((ParamsContext)_localctx).id2, ((ParamsContext)_localctx).type2.ast) 
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public BTypeContext bType;
		public BTypeContext bType() {
			return getRuleContext(BTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode OPEN_BRACKET() { return getToken(langParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(langParser.CLOSE_BRACKET, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(101);
			((TypeContext)_localctx).bType = bType();
			 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).bType.ast; 
			}
			_ctx.stop = _input.LT(-1);
			setState(110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(104);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(105);
					match(OPEN_BRACKET);
					setState(106);
					match(CLOSE_BRACKET);
					 ((TypeContext)_localctx).ast =  new ArrayType(((TypeContext)_localctx).bType.ast); 
					}
					} 
				}
				setState(112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BTypeContext extends ParserRuleContext {
		public Type ast;
		public Token TYPE_NAME;
		public TerminalNode TYPE_INT() { return getToken(langParser.TYPE_INT, 0); }
		public TerminalNode TYPE_CHAR() { return getToken(langParser.TYPE_CHAR, 0); }
		public TerminalNode TYPE_BOOL() { return getToken(langParser.TYPE_BOOL, 0); }
		public TerminalNode TYPE_FLOAT() { return getToken(langParser.TYPE_FLOAT, 0); }
		public TerminalNode TYPE_NAME() { return getToken(langParser.TYPE_NAME, 0); }
		public BTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bType; }
	}

	public final BTypeContext bType() throws RecognitionException {
		BTypeContext _localctx = new BTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bType);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				match(TYPE_INT);
				 ((BTypeContext)_localctx).ast =  new IntType(); 
				}
				break;
			case TYPE_CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				match(TYPE_CHAR);
				 ((BTypeContext)_localctx).ast =  new CharType(); 
				}
				break;
			case TYPE_BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				match(TYPE_BOOL);
				 ((BTypeContext)_localctx).ast =  new BoolType(); 
				}
				break;
			case TYPE_FLOAT:
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				match(TYPE_FLOAT);
				 ((BTypeContext)_localctx).ast =  new FloatType(); 
				}
				break;
			case TYPE_NAME:
				enterOuterAlt(_localctx, 5);
				{
				setState(121);
				((BTypeContext)_localctx).TYPE_NAME = match(TYPE_NAME);
				 ((BTypeContext)_localctx).ast =  new DataType(((BTypeContext)_localctx).TYPE_NAME); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public Node ast;
		public CmdContext cmd;
		public ExpContext condition;
		public CmdContext then;
		public ExpContext exp;
		public CmdContext else_;
		public CmdContext body;
		public LvalueContext lvalue;
		public ExpContext exp1;
		public ExpContext exp2;
		public ExpsContext parameters;
		public TerminalNode OPEN_CURLY_BRACE() { return getToken(langParser.OPEN_CURLY_BRACE, 0); }
		public TerminalNode CLOSE_CURLY_BRACE() { return getToken(langParser.CLOSE_CURLY_BRACE, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode IF() { return getToken(langParser.IF, 0); }
		public TerminalNode OPEN_PARENTHESIS() { return getToken(langParser.OPEN_PARENTHESIS, 0); }
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(langParser.CLOSE_PARENTHESIS, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(langParser.ELSE, 0); }
		public TerminalNode ITERATE() { return getToken(langParser.ITERATE, 0); }
		public TerminalNode READ() { return getToken(langParser.READ, 0); }
		public List<LvalueContext> lvalue() {
			return getRuleContexts(LvalueContext.class);
		}
		public LvalueContext lvalue(int i) {
			return getRuleContext(LvalueContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(langParser.SEMICOLON, 0); }
		public TerminalNode PRINT() { return getToken(langParser.PRINT, 0); }
		public TerminalNode RETURN() { return getToken(langParser.RETURN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(langParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(langParser.COMMA, i);
		}
		public TerminalNode EQUAL() { return getToken(langParser.EQUAL, 0); }
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TerminalNode LESS_THAN() { return getToken(langParser.LESS_THAN, 0); }
		public TerminalNode GREATER_THAN() { return getToken(langParser.GREATER_THAN, 0); }
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmd);
		int _la;
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(OPEN_CURLY_BRACE);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33578560L) != 0)) {
					{
					{
					setState(126);
					((CmdContext)_localctx).cmd = cmd();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(132);
				match(CLOSE_CURLY_BRACE);
				 ((CmdContext)_localctx).ast =  ((CmdContext)_localctx).cmd.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				match(IF);
				setState(135);
				match(OPEN_PARENTHESIS);
				setState(136);
				((CmdContext)_localctx).condition = exp(0);
				setState(137);
				match(CLOSE_PARENTHESIS);
				setState(138);
				((CmdContext)_localctx).then = cmd();
				 ((CmdContext)_localctx).ast =  new If(((CmdContext)_localctx).condition.ast, ((CmdContext)_localctx).then.ast); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				match(IF);
				setState(142);
				match(OPEN_PARENTHESIS);
				setState(143);
				((CmdContext)_localctx).condition = ((CmdContext)_localctx).exp = exp(0);
				setState(144);
				match(CLOSE_PARENTHESIS);
				setState(145);
				((CmdContext)_localctx).then = cmd();
				setState(146);
				match(ELSE);
				setState(147);
				((CmdContext)_localctx).else_ = cmd();
				 ((CmdContext)_localctx).ast =  new If(((CmdContext)_localctx).exp.ast, ((CmdContext)_localctx).then.ast, ((CmdContext)_localctx).else.ast); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(150);
				match(ITERATE);
				setState(151);
				match(OPEN_PARENTHESIS);
				setState(152);
				((CmdContext)_localctx).condition = exp(0);
				setState(153);
				match(CLOSE_PARENTHESIS);
				setState(154);
				((CmdContext)_localctx).body = cmd();
				 ((CmdContext)_localctx).ast =  new Iterate(((CmdContext)_localctx).condition.ast, ((CmdContext)_localctx).body.ast); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(157);
				match(READ);
				setState(158);
				((CmdContext)_localctx).lvalue = lvalue(0);
				setState(159);
				match(SEMICOLON);
				 ((CmdContext)_localctx).ast =  new Read(((CmdContext)_localctx).lvalue.ast); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(162);
				match(PRINT);
				setState(163);
				((CmdContext)_localctx).exp = exp(0);
				setState(164);
				match(SEMICOLON);
				 ((CmdContext)_localctx).ast =  new Print(((CmdContext)_localctx).exp.ast); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(167);
				match(RETURN);
				 expList = new ArrayList<Expression>(); 
				setState(169);
				((CmdContext)_localctx).exp1 = exp(0);
				 expList.add(((CmdContext)_localctx).exp1.ast); 
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(171);
					match(COMMA);
					setState(172);
					((CmdContext)_localctx).exp2 = exp(0);
					 expList.add(((CmdContext)_localctx).exp2.ast); 
					}
					}
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(180);
				match(SEMICOLON);

				      Expression[] expressionsArray = new Expression[expList.size()];
				      expressionsArray = expList.toArray(expressionsArray);

				      ((CmdContext)_localctx).ast =  new Return(expressionsArray);
				    
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(183);
				((CmdContext)_localctx).lvalue = lvalue(0);
				setState(184);
				match(EQUAL);
				setState(185);
				((CmdContext)_localctx).exp = exp(0);
				setState(186);
				match(SEMICOLON);
				 ((CmdContext)_localctx).ast =  new Assignment(((CmdContext)_localctx).lvalue.ast, ((CmdContext)_localctx).exp.ast); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(189);
				match(ID);
				setState(190);
				match(OPEN_PARENTHESIS);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9070974099518L) != 0)) {
					{
					setState(191);
					((CmdContext)_localctx).parameters = exps();
					}
				}

				setState(194);
				match(CLOSE_PARENTHESIS);
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LESS_THAN) {
					{
					setState(195);
					match(LESS_THAN);
					setState(196);
					lvalue(0);
					setState(201);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(197);
						match(COMMA);
						setState(198);
						lvalue(0);
						}
						}
						setState(203);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(204);
					match(GREATER_THAN);
					}
				}

				setState(208);
				match(SEMICOLON);
				 ((CmdContext)_localctx).ast =  new Call(); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public Expression ast;
		public ExpContext expLeft;
		public ExpContext exp;
		public Token INT;
		public Token FLOAT;
		public Token CHAR;
		public LvalueContext lvalue;
		public Token ID;
		public ExpsContext arguments;
		public ExpContext returnIndex;
		public ExpContext expRight;
		public TerminalNode NOT() { return getToken(langParser.NOT, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(langParser.MINUS, 0); }
		public TerminalNode FALSE() { return getToken(langParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(langParser.TRUE, 0); }
		public TerminalNode NULL() { return getToken(langParser.NULL, 0); }
		public TerminalNode INT() { return getToken(langParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(langParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(langParser.CHAR, 0); }
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode OPEN_PARENTHESIS() { return getToken(langParser.OPEN_PARENTHESIS, 0); }
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(langParser.CLOSE_PARENTHESIS, 0); }
		public TerminalNode NEW() { return getToken(langParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode OPEN_BRACKET() { return getToken(langParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(langParser.CLOSE_BRACKET, 0); }
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public TerminalNode AND() { return getToken(langParser.AND, 0); }
		public TerminalNode COMPARISON() { return getToken(langParser.COMPARISON, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(langParser.NOT_EQUAL, 0); }
		public TerminalNode LESS_THAN() { return getToken(langParser.LESS_THAN, 0); }
		public TerminalNode PLUS() { return getToken(langParser.PLUS, 0); }
		public TerminalNode TIMES() { return getToken(langParser.TIMES, 0); }
		public TerminalNode DIVISION() { return getToken(langParser.DIVISION, 0); }
		public TerminalNode MODULUS() { return getToken(langParser.MODULUS, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(213);
				match(NOT);
				setState(214);
				((ExpContext)_localctx).exp = exp(12);
				 ((ExpContext)_localctx).ast =  new Not(((ExpContext)_localctx).exp.ast); 
				}
				break;
			case 2:
				{
				setState(217);
				match(MINUS);
				setState(218);
				((ExpContext)_localctx).exp = exp(11);
				 ((ExpContext)_localctx).ast =  new UnaryMinus(((ExpContext)_localctx).exp.ast); 
				}
				break;
			case 3:
				{
				setState(221);
				match(FALSE);
				 ((ExpContext)_localctx).ast =  new False(); 
				}
				break;
			case 4:
				{
				setState(223);
				match(TRUE);
				 ((ExpContext)_localctx).ast =  new True(); 
				}
				break;
			case 5:
				{
				setState(225);
				match(NULL);
				 ((ExpContext)_localctx).ast =  new Null(); 
				}
				break;
			case 6:
				{
				setState(227);
				((ExpContext)_localctx).INT = match(INT);
				 ((ExpContext)_localctx).ast =  new LiteralInt(Integer.parseInt(((ExpContext)_localctx).INT)); 
				}
				break;
			case 7:
				{
				setState(229);
				((ExpContext)_localctx).FLOAT = match(FLOAT);
				 ((ExpContext)_localctx).ast =  new LiteralFloat(Float.parseFloat(((ExpContext)_localctx).FLOAT)); 
				}
				break;
			case 8:
				{
				setState(231);
				((ExpContext)_localctx).CHAR = match(CHAR);
				 ((ExpContext)_localctx).ast =  new LiteralChar(((ExpContext)_localctx).CHAR); 
				}
				break;
			case 9:
				{
				setState(233);
				((ExpContext)_localctx).lvalue = lvalue(0);
				 ((ExpContext)_localctx).ast =  ((ExpContext)_localctx).lvalue.ast; 
				}
				break;
			case 10:
				{
				setState(236);
				match(OPEN_PARENTHESIS);
				setState(237);
				((ExpContext)_localctx).exp = exp(0);
				setState(238);
				match(CLOSE_PARENTHESIS);
				 ((ExpContext)_localctx).ast =  ((ExpContext)_localctx).exp.ast; 
				}
				break;
			case 11:
				{
				setState(241);
				match(NEW);
				setState(242);
				type(0);
				setState(247);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(243);
					match(OPEN_BRACKET);
					setState(244);
					((ExpContext)_localctx).exp = exp(0);
					setState(245);
					match(CLOSE_BRACKET);
					}
					break;
				}
				 ((ExpContext)_localctx).ast =  ; 
				}
				break;
			case 12:
				{
				setState(251);
				((ExpContext)_localctx).ID = match(ID);
				setState(252);
				match(OPEN_PARENTHESIS);
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9070974099518L) != 0)) {
					{
					setState(253);
					((ExpContext)_localctx).arguments = exps();
					}
				}

				setState(256);
				match(CLOSE_PARENTHESIS);
				setState(257);
				match(OPEN_BRACKET);
				setState(258);
				((ExpContext)_localctx).returnIndex = ((ExpContext)_localctx).exp = exp(0);
				setState(259);
				match(CLOSE_BRACKET);
				 ((ExpContext)_localctx).ast =  new Call(((ExpContext)_localctx).ID, ((ExpContext)_localctx).arguments.ast, ((ExpContext)_localctx).returnIndex.ast); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(311);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(309);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(264);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(265);
						match(AND);
						setState(266);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(22);
						 ((ExpContext)_localctx).ast =  new And(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast); 
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(269);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(270);
						match(COMPARISON);
						setState(271);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(21);
						 ((ExpContext)_localctx).ast =  new Equals(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast); 
						}
						break;
					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(274);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(275);
						match(NOT_EQUAL);
						setState(276);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(20);
						 ((ExpContext)_localctx).ast =  new NotEqual(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast); 
						}
						break;
					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(279);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(280);
						match(LESS_THAN);
						setState(281);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(19);
						 ((ExpContext)_localctx).ast =  new LessThan(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast); 
						}
						break;
					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(284);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(285);
						match(PLUS);
						setState(286);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(18);
						 ((ExpContext)_localctx).ast =  new Add(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(289);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(290);
						match(MINUS);
						setState(291);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(17);
						 ((ExpContext)_localctx).ast =  new Minus(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast); 
						}
						break;
					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(294);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(295);
						match(TIMES);
						setState(296);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(16);
						 ((ExpContext)_localctx).ast =  new Multiplication(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast); 
						}
						break;
					case 8:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(299);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(300);
						match(DIVISION);
						setState(301);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(15);
						 ((ExpContext)_localctx).ast =  new Division(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast); 
						}
						break;
					case 9:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(304);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(305);
						match(MODULUS);
						setState(306);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(14);
						 ((ExpContext)_localctx).ast =  new Modulus(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast); 
						}
						break;
					}
					} 
				}
				setState(313);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LvalueContext extends ParserRuleContext {
		public Variable ast;
		public Token ID;
		public ExpContext exp;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode OPEN_BRACKET() { return getToken(langParser.OPEN_BRACKET, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode CLOSE_BRACKET() { return getToken(langParser.CLOSE_BRACKET, 0); }
		public TerminalNode DOT() { return getToken(langParser.DOT, 0); }
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
	}

	public final LvalueContext lvalue() throws RecognitionException {
		return lvalue(0);
	}

	private LvalueContext lvalue(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LvalueContext _localctx = new LvalueContext(_ctx, _parentState);
		LvalueContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_lvalue, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(315);
			((LvalueContext)_localctx).ID = match(ID);
			 ((LvalueContext)_localctx).ast =  new Variable(((LvalueContext)_localctx).ID); 
			}
			_ctx.stop = _input.LT(-1);
			setState(330);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(328);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(318);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(319);
						match(OPEN_BRACKET);
						setState(320);
						((LvalueContext)_localctx).exp = exp(0);
						setState(321);
						match(CLOSE_BRACKET);
						 ((LvalueContext)_localctx).ast =  new Variable(((LvalueContext)_localctx).ID, ((LvalueContext)_localctx).exp.ast); 
						}
						break;
					case 2:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(324);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(325);
						match(DOT);
						setState(326);
						((LvalueContext)_localctx).ID = match(ID);
						 ((LvalueContext)_localctx).ast =  ; 
						}
						break;
					}
					} 
				}
				setState(332);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpsContext extends ParserRuleContext {
		public Expression[] ast;
		public ExpContext exp1;
		public ExpContext exp2;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(langParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(langParser.COMMA, i);
		}
		public ExpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exps; }
	}

	public final ExpsContext exps() throws RecognitionException {
		ExpsContext _localctx = new ExpsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 expList = new ArrayList<Expression>(); 
			setState(334);
			((ExpsContext)_localctx).exp1 = exp(0);
			 expList.add(((ExpsContext)_localctx).exp1.ast); 
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(336);
				match(COMMA);
				setState(337);
				((ExpsContext)_localctx).exp2 = exp(0);
				 expList.add(((ExpsContext)_localctx).exp2.ast); 
				}
				}
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			      Expression[] expressionsArray = new Expression[expList.size()];
			      expressionsArray = expList.toArray(expressionsArray);

			      ((ExpsContext)_localctx).ast =  expressionsArray;
			    
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
		case 6:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 9:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 10:
			return lvalue_sempred((LvalueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 21);
		case 2:
			return precpred(_ctx, 20);
		case 3:
			return precpred(_ctx, 19);
		case 4:
			return precpred(_ctx, 18);
		case 5:
			return precpred(_ctx, 17);
		case 6:
			return precpred(_ctx, 16);
		case 7:
			return precpred(_ctx, 15);
		case 8:
			return precpred(_ctx, 14);
		case 9:
			return precpred(_ctx, 13);
		}
		return true;
	}
	private boolean lvalue_sempred(LvalueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u015c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u001c\b\u0000\n\u0000\f\u0000"+
		"\u001f\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\'\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002-\b\u0002\n\u0002\f\u00020\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		">\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004E\b\u0004\n\u0004\f\u0004H\t\u0004\u0003\u0004J\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004N\b\u0004\n\u0004\f\u0004Q\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005`\b\u0005\n\u0005\f\u0005c\t\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006m\b\u0006\n\u0006\f\u0006p\t\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007|\b\u0007\u0001\b\u0001\b\u0005"+
		"\b\u0080\b\b\n\b\f\b\u0083\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0005\b\u00b0\b\b\n\b\f\b\u00b3\t\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00c1\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005"+
		"\b\u00c8\b\b\n\b\f\b\u00cb\t\b\u0001\b\u0001\b\u0003\b\u00cf\b\b\u0001"+
		"\b\u0001\b\u0003\b\u00d3\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u00f8\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00ff\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u0107\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u0136\b\t\n\t\f\t\u0139\t\t\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u0149\b\n\n\n\f\n\u014c\t\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u0155\b\u000b\n\u000b\f\u000b\u0158\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0000\u0003\f\u0012\u0014\f\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0014\u0016\u0000\u0000\u0182\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0002&\u0001\u0000\u0000\u0000\u0004(\u0001\u0000\u0000\u0000"+
		"\u00064\u0001\u0000\u0000\u0000\b:\u0001\u0000\u0000\u0000\nU\u0001\u0000"+
		"\u0000\u0000\fd\u0001\u0000\u0000\u0000\u000e{\u0001\u0000\u0000\u0000"+
		"\u0010\u00d2\u0001\u0000\u0000\u0000\u0012\u0106\u0001\u0000\u0000\u0000"+
		"\u0014\u013a\u0001\u0000\u0000\u0000\u0016\u014d\u0001\u0000\u0000\u0000"+
		"\u0018\u0019\u0003\u0002\u0001\u0000\u0019\u001a\u0006\u0000\uffff\uffff"+
		"\u0000\u001a\u001c\u0001\u0000\u0000\u0000\u001b\u0018\u0001\u0000\u0000"+
		"\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000"+
		"\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u0001\u0001\u0000\u0000"+
		"\u0000\u001f\u001d\u0001\u0000\u0000\u0000 !\u0003\u0004\u0002\u0000!"+
		"\"\u0006\u0001\uffff\uffff\u0000\"\'\u0001\u0000\u0000\u0000#$\u0003\b"+
		"\u0004\u0000$%\u0006\u0001\uffff\uffff\u0000%\'\u0001\u0000\u0000\u0000"+
		"& \u0001\u0000\u0000\u0000&#\u0001\u0000\u0000\u0000\'\u0003\u0001\u0000"+
		"\u0000\u0000()\u0005\b\u0000\u0000)*\u0005\u0013\u0000\u0000*.\u0005\u0019"+
		"\u0000\u0000+-\u0003\u0006\u0003\u0000,+\u0001\u0000\u0000\u0000-0\u0001"+
		"\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000"+
		"/1\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u000012\u0005\u001a\u0000"+
		"\u000023\u0006\u0002\uffff\uffff\u00003\u0005\u0001\u0000\u0000\u0000"+
		"45\u0005\u000e\u0000\u000056\u0005\u001e\u0000\u000067\u0003\f\u0006\u0000"+
		"78\u0005\u001d\u0000\u000089\u0006\u0003\uffff\uffff\u00009\u0007\u0001"+
		"\u0000\u0000\u0000:;\u0005\u000e\u0000\u0000;=\u0005\u0015\u0000\u0000"+
		"<>\u0003\n\u0005\u0000=<\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000"+
		">?\u0001\u0000\u0000\u0000?I\u0005\u0016\u0000\u0000@A\u0005\u001f\u0000"+
		"\u0000AF\u0003\f\u0006\u0000BC\u0005!\u0000\u0000CE\u0003\f\u0006\u0000"+
		"DB\u0001\u0000\u0000\u0000EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000"+
		"\u0000FG\u0001\u0000\u0000\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000"+
		"\u0000\u0000I@\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000KO\u0005\u0019\u0000\u0000LN\u0003\u0010\b\u0000ML\u0001"+
		"\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000"+
		"\u0000RS\u0005\u001a\u0000\u0000ST\u0006\u0004\uffff\uffff\u0000T\t\u0001"+
		"\u0000\u0000\u0000UV\u0005\u000e\u0000\u0000VW\u0005\u001e\u0000\u0000"+
		"WX\u0003\f\u0006\u0000Xa\u0006\u0005\uffff\uffff\u0000YZ\u0005!\u0000"+
		"\u0000Z[\u0005\u000e\u0000\u0000[\\\u0005\u001e\u0000\u0000\\]\u0003\f"+
		"\u0006\u0000]^\u0006\u0005\uffff\uffff\u0000^`\u0001\u0000\u0000\u0000"+
		"_Y\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000"+
		"\u0000ab\u0001\u0000\u0000\u0000b\u000b\u0001\u0000\u0000\u0000ca\u0001"+
		"\u0000\u0000\u0000de\u0006\u0006\uffff\uffff\u0000ef\u0003\u000e\u0007"+
		"\u0000fg\u0006\u0006\uffff\uffff\u0000gn\u0001\u0000\u0000\u0000hi\n\u0002"+
		"\u0000\u0000ij\u0005\u0017\u0000\u0000jk\u0005\u0018\u0000\u0000km\u0006"+
		"\u0006\uffff\uffff\u0000lh\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000"+
		"\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000o\r\u0001\u0000"+
		"\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0005\u000f\u0000\u0000r|\u0006"+
		"\u0007\uffff\uffff\u0000st\u0005\u0012\u0000\u0000t|\u0006\u0007\uffff"+
		"\uffff\u0000uv\u0005\u0011\u0000\u0000v|\u0006\u0007\uffff\uffff\u0000"+
		"wx\u0005\u0010\u0000\u0000x|\u0006\u0007\uffff\uffff\u0000yz\u0005\u0013"+
		"\u0000\u0000z|\u0006\u0007\uffff\uffff\u0000{q\u0001\u0000\u0000\u0000"+
		"{s\u0001\u0000\u0000\u0000{u\u0001\u0000\u0000\u0000{w\u0001\u0000\u0000"+
		"\u0000{y\u0001\u0000\u0000\u0000|\u000f\u0001\u0000\u0000\u0000}\u0081"+
		"\u0005\u0019\u0000\u0000~\u0080\u0003\u0010\b\u0000\u007f~\u0001\u0000"+
		"\u0000\u0000\u0080\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0084\u0001\u0000"+
		"\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0085\u0005\u001a"+
		"\u0000\u0000\u0085\u00d3\u0006\b\uffff\uffff\u0000\u0086\u0087\u0005\u0006"+
		"\u0000\u0000\u0087\u0088\u0005\u0015\u0000\u0000\u0088\u0089\u0003\u0012"+
		"\t\u0000\u0089\u008a\u0005\u0016\u0000\u0000\u008a\u008b\u0003\u0010\b"+
		"\u0000\u008b\u008c\u0006\b\uffff\uffff\u0000\u008c\u00d3\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0005\u0006\u0000\u0000\u008e\u008f\u0005\u0015\u0000"+
		"\u0000\u008f\u0090\u0003\u0012\t\u0000\u0090\u0091\u0005\u0016\u0000\u0000"+
		"\u0091\u0092\u0003\u0010\b\u0000\u0092\u0093\u0005\u0007\u0000\u0000\u0093"+
		"\u0094\u0003\u0010\b\u0000\u0094\u0095\u0006\b\uffff\uffff\u0000\u0095"+
		"\u00d3\u0001\u0000\u0000\u0000\u0096\u0097\u0005\t\u0000\u0000\u0097\u0098"+
		"\u0005\u0015\u0000\u0000\u0098\u0099\u0003\u0012\t\u0000\u0099\u009a\u0005"+
		"\u0016\u0000\u0000\u009a\u009b\u0003\u0010\b\u0000\u009b\u009c\u0006\b"+
		"\uffff\uffff\u0000\u009c\u00d3\u0001\u0000\u0000\u0000\u009d\u009e\u0005"+
		"\f\u0000\u0000\u009e\u009f\u0003\u0014\n\u0000\u009f\u00a0\u0005\u001d"+
		"\u0000\u0000\u00a0\u00a1\u0006\b\uffff\uffff\u0000\u00a1\u00d3\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0005\u000b\u0000\u0000\u00a3\u00a4\u0003\u0012"+
		"\t\u0000\u00a4\u00a5\u0005\u001d\u0000\u0000\u00a5\u00a6\u0006\b\uffff"+
		"\uffff\u0000\u00a6\u00d3\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\n\u0000"+
		"\u0000\u00a8\u00a9\u0006\b\uffff\uffff\u0000\u00a9\u00aa\u0003\u0012\t"+
		"\u0000\u00aa\u00b1\u0006\b\uffff\uffff\u0000\u00ab\u00ac\u0005!\u0000"+
		"\u0000\u00ac\u00ad\u0003\u0012\t\u0000\u00ad\u00ae\u0006\b\uffff\uffff"+
		"\u0000\u00ae\u00b0\u0001\u0000\u0000\u0000\u00af\u00ab\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b3\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005\u001d\u0000"+
		"\u0000\u00b5\u00b6\u0006\b\uffff\uffff\u0000\u00b6\u00d3\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0003\u0014\n\u0000\u00b8\u00b9\u0005#\u0000\u0000"+
		"\u00b9\u00ba\u0003\u0012\t\u0000\u00ba\u00bb\u0005\u001d\u0000\u0000\u00bb"+
		"\u00bc\u0006\b\uffff\uffff\u0000\u00bc\u00d3\u0001\u0000\u0000\u0000\u00bd"+
		"\u00be\u0005\u000e\u0000\u0000\u00be\u00c0\u0005\u0015\u0000\u0000\u00bf"+
		"\u00c1\u0003\u0016\u000b\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2"+
		"\u00ce\u0005\u0016\u0000\u0000\u00c3\u00c4\u0005\u001c\u0000\u0000\u00c4"+
		"\u00c9\u0003\u0014\n\u0000\u00c5\u00c6\u0005!\u0000\u0000\u00c6\u00c8"+
		"\u0003\u0014\n\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00cb\u0001"+
		"\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cc\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001"+
		"\u0000\u0000\u0000\u00cc\u00cd\u0005\u001b\u0000\u0000\u00cd\u00cf\u0001"+
		"\u0000\u0000\u0000\u00ce\u00c3\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005"+
		"\u001d\u0000\u0000\u00d1\u00d3\u0006\b\uffff\uffff\u0000\u00d2}\u0001"+
		"\u0000\u0000\u0000\u00d2\u0086\u0001\u0000\u0000\u0000\u00d2\u008d\u0001"+
		"\u0000\u0000\u0000\u00d2\u0096\u0001\u0000\u0000\u0000\u00d2\u009d\u0001"+
		"\u0000\u0000\u0000\u00d2\u00a2\u0001\u0000\u0000\u0000\u00d2\u00a7\u0001"+
		"\u0000\u0000\u0000\u00d2\u00b7\u0001\u0000\u0000\u0000\u00d2\u00bd\u0001"+
		"\u0000\u0000\u0000\u00d3\u0011\u0001\u0000\u0000\u0000\u00d4\u00d5\u0006"+
		"\t\uffff\uffff\u0000\u00d5\u00d6\u0005+\u0000\u0000\u00d6\u00d7\u0003"+
		"\u0012\t\f\u00d7\u00d8\u0006\t\uffff\uffff\u0000\u00d8\u0107\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0005&\u0000\u0000\u00da\u00db\u0003\u0012\t"+
		"\u000b\u00db\u00dc\u0006\t\uffff\uffff\u0000\u00dc\u0107\u0001\u0000\u0000"+
		"\u0000\u00dd\u00de\u0005\u0003\u0000\u0000\u00de\u0107\u0006\t\uffff\uffff"+
		"\u0000\u00df\u00e0\u0005\u0004\u0000\u0000\u00e0\u0107\u0006\t\uffff\uffff"+
		"\u0000\u00e1\u00e2\u0005\u0005\u0000\u0000\u00e2\u0107\u0006\t\uffff\uffff"+
		"\u0000\u00e3\u00e4\u0005\u0002\u0000\u0000\u00e4\u0107\u0006\t\uffff\uffff"+
		"\u0000\u00e5\u00e6\u0005\u0001\u0000\u0000\u00e6\u0107\u0006\t\uffff\uffff"+
		"\u0000\u00e7\u00e8\u0005\u0014\u0000\u0000\u00e8\u0107\u0006\t\uffff\uffff"+
		"\u0000\u00e9\u00ea\u0003\u0014\n\u0000\u00ea\u00eb\u0006\t\uffff\uffff"+
		"\u0000\u00eb\u0107\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\u0015\u0000"+
		"\u0000\u00ed\u00ee\u0003\u0012\t\u0000\u00ee\u00ef\u0005\u0016\u0000\u0000"+
		"\u00ef\u00f0\u0006\t\uffff\uffff\u0000\u00f0\u0107\u0001\u0000\u0000\u0000"+
		"\u00f1\u00f2\u0005\r\u0000\u0000\u00f2\u00f7\u0003\f\u0006\u0000\u00f3"+
		"\u00f4\u0005\u0017\u0000\u0000\u00f4\u00f5\u0003\u0012\t\u0000\u00f5\u00f6"+
		"\u0005\u0018\u0000\u0000\u00f6\u00f8\u0001\u0000\u0000\u0000\u00f7\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8\u00f9"+
		"\u0001\u0000\u0000\u0000\u00f9\u00fa\u0006\t\uffff\uffff\u0000\u00fa\u0107"+
		"\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005\u000e\u0000\u0000\u00fc\u00fe"+
		"\u0005\u0015\u0000\u0000\u00fd\u00ff\u0003\u0016\u000b\u0000\u00fe\u00fd"+
		"\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0100"+
		"\u0001\u0000\u0000\u0000\u0100\u0101\u0005\u0016\u0000\u0000\u0101\u0102"+
		"\u0005\u0017\u0000\u0000\u0102\u0103\u0003\u0012\t\u0000\u0103\u0104\u0005"+
		"\u0018\u0000\u0000\u0104\u0105\u0006\t\uffff\uffff\u0000\u0105\u0107\u0001"+
		"\u0000\u0000\u0000\u0106\u00d4\u0001\u0000\u0000\u0000\u0106\u00d9\u0001"+
		"\u0000\u0000\u0000\u0106\u00dd\u0001\u0000\u0000\u0000\u0106\u00df\u0001"+
		"\u0000\u0000\u0000\u0106\u00e1\u0001\u0000\u0000\u0000\u0106\u00e3\u0001"+
		"\u0000\u0000\u0000\u0106\u00e5\u0001\u0000\u0000\u0000\u0106\u00e7\u0001"+
		"\u0000\u0000\u0000\u0106\u00e9\u0001\u0000\u0000\u0000\u0106\u00ec\u0001"+
		"\u0000\u0000\u0000\u0106\u00f1\u0001\u0000\u0000\u0000\u0106\u00fb\u0001"+
		"\u0000\u0000\u0000\u0107\u0137\u0001\u0000\u0000\u0000\u0108\u0109\n\u0015"+
		"\u0000\u0000\u0109\u010a\u0005*\u0000\u0000\u010a\u010b\u0003\u0012\t"+
		"\u0016\u010b\u010c\u0006\t\uffff\uffff\u0000\u010c\u0136\u0001\u0000\u0000"+
		"\u0000\u010d\u010e\n\u0014\u0000\u0000\u010e\u010f\u0005\"\u0000\u0000"+
		"\u010f\u0110\u0003\u0012\t\u0015\u0110\u0111\u0006\t\uffff\uffff\u0000"+
		"\u0111\u0136\u0001\u0000\u0000\u0000\u0112\u0113\n\u0013\u0000\u0000\u0113"+
		"\u0114\u0005$\u0000\u0000\u0114\u0115\u0003\u0012\t\u0014\u0115\u0116"+
		"\u0006\t\uffff\uffff\u0000\u0116\u0136\u0001\u0000\u0000\u0000\u0117\u0118"+
		"\n\u0012\u0000\u0000\u0118\u0119\u0005\u001c\u0000\u0000\u0119\u011a\u0003"+
		"\u0012\t\u0013\u011a\u011b\u0006\t\uffff\uffff\u0000\u011b\u0136\u0001"+
		"\u0000\u0000\u0000\u011c\u011d\n\u0011\u0000\u0000\u011d\u011e\u0005%"+
		"\u0000\u0000\u011e\u011f\u0003\u0012\t\u0012\u011f\u0120\u0006\t\uffff"+
		"\uffff\u0000\u0120\u0136\u0001\u0000\u0000\u0000\u0121\u0122\n\u0010\u0000"+
		"\u0000\u0122\u0123\u0005&\u0000\u0000\u0123\u0124\u0003\u0012\t\u0011"+
		"\u0124\u0125\u0006\t\uffff\uffff\u0000\u0125\u0136\u0001\u0000\u0000\u0000"+
		"\u0126\u0127\n\u000f\u0000\u0000\u0127\u0128\u0005\'\u0000\u0000\u0128"+
		"\u0129\u0003\u0012\t\u0010\u0129\u012a\u0006\t\uffff\uffff\u0000\u012a"+
		"\u0136\u0001\u0000\u0000\u0000\u012b\u012c\n\u000e\u0000\u0000\u012c\u012d"+
		"\u0005(\u0000\u0000\u012d\u012e\u0003\u0012\t\u000f\u012e\u012f\u0006"+
		"\t\uffff\uffff\u0000\u012f\u0136\u0001\u0000\u0000\u0000\u0130\u0131\n"+
		"\r\u0000\u0000\u0131\u0132\u0005)\u0000\u0000\u0132\u0133\u0003\u0012"+
		"\t\u000e\u0133\u0134\u0006\t\uffff\uffff\u0000\u0134\u0136\u0001\u0000"+
		"\u0000\u0000\u0135\u0108\u0001\u0000\u0000\u0000\u0135\u010d\u0001\u0000"+
		"\u0000\u0000\u0135\u0112\u0001\u0000\u0000\u0000\u0135\u0117\u0001\u0000"+
		"\u0000\u0000\u0135\u011c\u0001\u0000\u0000\u0000\u0135\u0121\u0001\u0000"+
		"\u0000\u0000\u0135\u0126\u0001\u0000\u0000\u0000\u0135\u012b\u0001\u0000"+
		"\u0000\u0000\u0135\u0130\u0001\u0000\u0000\u0000\u0136\u0139\u0001\u0000"+
		"\u0000\u0000\u0137\u0135\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000"+
		"\u0000\u0000\u0138\u0013\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000"+
		"\u0000\u0000\u013a\u013b\u0006\n\uffff\uffff\u0000\u013b\u013c\u0005\u000e"+
		"\u0000\u0000\u013c\u013d\u0006\n\uffff\uffff\u0000\u013d\u014a\u0001\u0000"+
		"\u0000\u0000\u013e\u013f\n\u0002\u0000\u0000\u013f\u0140\u0005\u0017\u0000"+
		"\u0000\u0140\u0141\u0003\u0012\t\u0000\u0141\u0142\u0005\u0018\u0000\u0000"+
		"\u0142\u0143\u0006\n\uffff\uffff\u0000\u0143\u0149\u0001\u0000\u0000\u0000"+
		"\u0144\u0145\n\u0001\u0000\u0000\u0145\u0146\u0005 \u0000\u0000\u0146"+
		"\u0147\u0005\u000e\u0000\u0000\u0147\u0149\u0006\n\uffff\uffff\u0000\u0148"+
		"\u013e\u0001\u0000\u0000\u0000\u0148\u0144\u0001\u0000\u0000\u0000\u0149"+
		"\u014c\u0001\u0000\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014a"+
		"\u014b\u0001\u0000\u0000\u0000\u014b\u0015\u0001\u0000\u0000\u0000\u014c"+
		"\u014a\u0001\u0000\u0000\u0000\u014d\u014e\u0006\u000b\uffff\uffff\u0000"+
		"\u014e\u014f\u0003\u0012\t\u0000\u014f\u0156\u0006\u000b\uffff\uffff\u0000"+
		"\u0150\u0151\u0005!\u0000\u0000\u0151\u0152\u0003\u0012\t\u0000\u0152"+
		"\u0153\u0006\u000b\uffff\uffff\u0000\u0153\u0155\u0001\u0000\u0000\u0000"+
		"\u0154\u0150\u0001\u0000\u0000\u0000\u0155\u0158\u0001\u0000\u0000\u0000"+
		"\u0156\u0154\u0001\u0000\u0000\u0000\u0156\u0157\u0001\u0000\u0000\u0000"+
		"\u0157\u0159\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000"+
		"\u0159\u015a\u0006\u000b\uffff\uffff\u0000\u015a\u0017\u0001\u0000\u0000"+
		"\u0000\u0018\u001d&.=FIOan{\u0081\u00b1\u00c0\u00c9\u00ce\u00d2\u00f7"+
		"\u00fe\u0106\u0135\u0137\u0148\u014a\u0156";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}