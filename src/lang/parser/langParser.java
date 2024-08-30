// Generated from src/lang/parser/lang.g4 by ANTLR 4.8

package lang.parser;

import lang.ast.*;
import lang.ast.nodes.*;
import lang.ast.nodes.base.Node;
import lang.ast.nodes.definitions.*;
import lang.ast.nodes.definitions.base.Definition;
import lang.ast.nodes.expressions.*;
import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.expressions.binaryOperators.*;
import lang.ast.nodes.expressions.binaryOperators.base.BinaryOperator;
import lang.ast.nodes.expressions.literals.*;
import lang.ast.nodes.expressions.variables.*;
import lang.ast.nodes.expressions.variables.base.Variable;
import lang.ast.nodes.types.*;
import lang.ast.nodes.types.base.Type;
import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class langParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

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


	HashMap<String, Character> specialCharacters = new HashMap<String, Character>() {{
	  put("\\n", '\n');
	  put("\\r", '\r');
	  put("\\t", '\t');
	  put("\\b", '\b');
	  put("\\\\", '\\');
	  put("\\'", '\'');
	}};

	int count = 0;

	public langParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public Program ast;
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<Definition> definitions = new ArrayList<Definition>(); 
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DATA || _la==ID) {
				{
				{
				setState(25);
				((ProgContext)_localctx).def = def();
				 definitions.add(((ProgContext)_localctx).def.ast); 
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			      Definition[] definitionsArray = new Definition[definitions.size()];
			      definitionsArray = definitions.toArray(definitionsArray);

			      Definition definition = definitionsArray[0];
			      int line = definition != null ? definition.getLine() : 0;
			      int column = definition != null ? definition.getColumn() : 0;

			      ((ProgContext)_localctx).ast =  new Program(definitionsArray, line, column);
			    
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitDef(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_def);
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATA:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				((DefContext)_localctx).data = data();
				 ((DefContext)_localctx).ast =  ((DefContext)_localctx).data.ast; 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitData(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(DATA);
			setState(44);
			((DataContext)_localctx).TYPE_NAME = match(TYPE_NAME);
			setState(45);
			match(OPEN_CURLY_BRACE);
			 List<Declaration> declarations = new ArrayList<Declaration>(); 
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(47);
				((DataContext)_localctx).decl = decl();
				 declarations.add(((DataContext)_localctx).decl.ast); 
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(CLOSE_CURLY_BRACE);

			        Declaration[] declarationsArray = new Declaration[declarations.size()];
			        declarationsArray = declarations.toArray(declarationsArray);

			        ((DataContext)_localctx).ast =  new DataRegister((((DataContext)_localctx).TYPE_NAME!=null?((DataContext)_localctx).TYPE_NAME.getText():null), declarationsArray, (((DataContext)_localctx).TYPE_NAME!=null?((DataContext)_localctx).TYPE_NAME.getLine():0), (((DataContext)_localctx).TYPE_NAME!=null?((DataContext)_localctx).TYPE_NAME.getCharPositionInLine():0));
			      
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			((DeclContext)_localctx).ID = match(ID);
			setState(59);
			match(DOUBLE_COLON);
			setState(60);
			((DeclContext)_localctx).type = type(0);
			setState(61);
			match(SEMICOLON);
			 ((DeclContext)_localctx).ast =  new Declaration((((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getText():null), ((DeclContext)_localctx).type.ast, (((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getLine():0), (((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getCharPositionInLine():0)); 
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

	public static class FunContext extends ParserRuleContext {
		public Function ast;
		public Token ID;
		public ParamsContext params;
		public TypeContext type1;
		public TypeContext type2;
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitFun(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			((FunContext)_localctx).ID = match(ID);
			setState(65);
			match(OPEN_PARENTHESIS);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(66);
				((FunContext)_localctx).params = params();
				}
			}

			setState(69);
			match(CLOSE_PARENTHESIS);
			 List<Type> returnTypes = new ArrayList<Type>(); 
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(71);
				match(COLON);
				setState(72);
				((FunContext)_localctx).type1 = type(0);
				 returnTypes.add(((FunContext)_localctx).type1.ast); 
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(74);
					match(COMMA);
					setState(75);
					((FunContext)_localctx).type2 = type(0);
					 returnTypes.add(((FunContext)_localctx).type2.ast); 
					}
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(85);
			match(OPEN_CURLY_BRACE);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << ITERATE) | (1L << RETURN) | (1L << PRINT) | (1L << READ) | (1L << ID) | (1L << OPEN_CURLY_BRACE))) != 0)) {
				{
				{
				setState(86);
				((FunContext)_localctx).cmd = cmd();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			match(CLOSE_CURLY_BRACE);

			      Type[] typesArray = new Type[returnTypes.size()];
			      typesArray = returnTypes.toArray(typesArray);

			      ((FunContext)_localctx).ast =  new Function((((FunContext)_localctx).ID!=null?((FunContext)_localctx).ID.getText():null), ((FunContext)_localctx).params.ast, typesArray, ((FunContext)_localctx).cmd.ast, (((FunContext)_localctx).ID!=null?((FunContext)_localctx).ID.getLine():0), (((FunContext)_localctx).ID!=null?((FunContext)_localctx).ID.getCharPositionInLine():0));
			    
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

	public static class ParamsContext extends ParserRuleContext {
		public Parameter[] ast;
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			((ParamsContext)_localctx).id1 = match(ID);
			setState(96);
			match(DOUBLE_COLON);
			 List<Parameter> parameters = new ArrayList<Parameter>(); 
			setState(98);
			((ParamsContext)_localctx).type1 = type(0);
			 parameters.add(new Parameter((((ParamsContext)_localctx).id1!=null?((ParamsContext)_localctx).id1.getText():null), ((ParamsContext)_localctx).type1.ast, (((ParamsContext)_localctx).id1!=null?((ParamsContext)_localctx).id1.getLine():0), (((ParamsContext)_localctx).id1!=null?((ParamsContext)_localctx).id1.getCharPositionInLine():0))); 
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(100);
				match(COMMA);
				setState(101);
				((ParamsContext)_localctx).id2 = match(ID);
				setState(102);
				match(DOUBLE_COLON);
				setState(103);
				((ParamsContext)_localctx).type2 = type(0);
				 parameters.add(new Parameter((((ParamsContext)_localctx).id2!=null?((ParamsContext)_localctx).id2.getText():null), ((ParamsContext)_localctx).type2.ast, (((ParamsContext)_localctx).id2!=null?((ParamsContext)_localctx).id2.getLine():0), (((ParamsContext)_localctx).id2!=null?((ParamsContext)_localctx).id2.getCharPositionInLine():0))); 
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			      Parameter[] parametersArray = new Parameter[parameters.size()];
			      parametersArray = parameters.toArray(parametersArray);

			      ((ParamsContext)_localctx).ast =  parametersArray;
			    
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
		public Type ast;
		public BTypeContext bType;
		public Token OPEN_BRACKET;
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitType(this);
		}
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
			setState(114);
			((TypeContext)_localctx).bType = bType();
			 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).bType.ast; 
			}
			_ctx.stop = _input.LT(-1);
			setState(123);
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
					setState(117);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(118);
					((TypeContext)_localctx).OPEN_BRACKET = match(OPEN_BRACKET);
					setState(119);
					match(CLOSE_BRACKET);
					 ((TypeContext)_localctx).ast =  new ArrayType(((TypeContext)_localctx).bType.ast, (((TypeContext)_localctx).OPEN_BRACKET!=null?((TypeContext)_localctx).OPEN_BRACKET.getLine():0), (((TypeContext)_localctx).OPEN_BRACKET!=null?((TypeContext)_localctx).OPEN_BRACKET.getCharPositionInLine():0)); 
					}
					} 
				}
				setState(125);
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

	public static class BTypeContext extends ParserRuleContext {
		public Type ast;
		public Token TYPE_INT;
		public Token TYPE_CHAR;
		public Token TYPE_BOOL;
		public Token TYPE_FLOAT;
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterBType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitBType(this);
		}
	}

	public final BTypeContext bType() throws RecognitionException {
		BTypeContext _localctx = new BTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bType);
		try {
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				((BTypeContext)_localctx).TYPE_INT = match(TYPE_INT);
				 ((BTypeContext)_localctx).ast =  new IntType((((BTypeContext)_localctx).TYPE_INT!=null?((BTypeContext)_localctx).TYPE_INT.getLine():0), (((BTypeContext)_localctx).TYPE_INT!=null?((BTypeContext)_localctx).TYPE_INT.getCharPositionInLine():0)); 
				}
				break;
			case TYPE_CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				((BTypeContext)_localctx).TYPE_CHAR = match(TYPE_CHAR);
				 ((BTypeContext)_localctx).ast =  new CharType((((BTypeContext)_localctx).TYPE_CHAR!=null?((BTypeContext)_localctx).TYPE_CHAR.getLine():0), (((BTypeContext)_localctx).TYPE_CHAR!=null?((BTypeContext)_localctx).TYPE_CHAR.getCharPositionInLine():0)); 
				}
				break;
			case TYPE_BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				((BTypeContext)_localctx).TYPE_BOOL = match(TYPE_BOOL);
				 ((BTypeContext)_localctx).ast =  new BoolType((((BTypeContext)_localctx).TYPE_BOOL!=null?((BTypeContext)_localctx).TYPE_BOOL.getLine():0), (((BTypeContext)_localctx).TYPE_BOOL!=null?((BTypeContext)_localctx).TYPE_BOOL.getCharPositionInLine():0)); 
				}
				break;
			case TYPE_FLOAT:
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				((BTypeContext)_localctx).TYPE_FLOAT = match(TYPE_FLOAT);
				 ((BTypeContext)_localctx).ast =  new FloatType((((BTypeContext)_localctx).TYPE_FLOAT!=null?((BTypeContext)_localctx).TYPE_FLOAT.getLine():0), (((BTypeContext)_localctx).TYPE_FLOAT!=null?((BTypeContext)_localctx).TYPE_FLOAT.getCharPositionInLine():0)); 
				}
				break;
			case TYPE_NAME:
				enterOuterAlt(_localctx, 5);
				{
				setState(134);
				((BTypeContext)_localctx).TYPE_NAME = match(TYPE_NAME);
				 ((BTypeContext)_localctx).ast =  new DataType((((BTypeContext)_localctx).TYPE_NAME!=null?((BTypeContext)_localctx).TYPE_NAME.getText():null), (((BTypeContext)_localctx).TYPE_NAME!=null?((BTypeContext)_localctx).TYPE_NAME.getLine():0), (((BTypeContext)_localctx).TYPE_NAME!=null?((BTypeContext)_localctx).TYPE_NAME.getCharPositionInLine():0)); 
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

	public static class CmdContext extends ParserRuleContext {
		public Node ast;
		public Token OPEN_CURLY_BRACE;
		public CmdContext cmd;
		public Token IF;
		public ExpContext condition;
		public CmdContext then;
		public ExpContext exp;
		public CmdContext elseCmd;
		public Token ITERATE;
		public CmdContext body;
		public Token READ;
		public LvalueContext lvalue;
		public Token PRINT;
		public Token RETURN;
		public ExpContext exp1;
		public ExpContext exp2;
		public Token EQUAL;
		public Token ID;
		public ExpsContext arguments;
		public LvalueContext lvalue1;
		public LvalueContext lvalue2;
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmd);
		int _la;
		try {
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				((CmdContext)_localctx).OPEN_CURLY_BRACE = match(OPEN_CURLY_BRACE);
				 List<Node> commands = new ArrayList<Node>(); 
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << ITERATE) | (1L << RETURN) | (1L << PRINT) | (1L << READ) | (1L << ID) | (1L << OPEN_CURLY_BRACE))) != 0)) {
					{
					{
					setState(140);
					((CmdContext)_localctx).cmd = cmd();
					 commands.add(((CmdContext)_localctx).cmd.ast); 
					}
					}
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(148);
				match(CLOSE_CURLY_BRACE);

				      Node[] commandsArray = new Node[commands.size()];
				      commandsArray = commands.toArray(commandsArray);

				      ((CmdContext)_localctx).ast =  new Block(commandsArray, (((CmdContext)_localctx).OPEN_CURLY_BRACE!=null?((CmdContext)_localctx).OPEN_CURLY_BRACE.getLine():0), (((CmdContext)_localctx).OPEN_CURLY_BRACE!=null?((CmdContext)_localctx).OPEN_CURLY_BRACE.getCharPositionInLine():0));
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				((CmdContext)_localctx).IF = match(IF);
				setState(151);
				match(OPEN_PARENTHESIS);
				setState(152);
				((CmdContext)_localctx).condition = exp(0);
				setState(153);
				match(CLOSE_PARENTHESIS);
				setState(154);
				((CmdContext)_localctx).then = cmd();
				 ((CmdContext)_localctx).ast =  new If(((CmdContext)_localctx).condition.ast, ((CmdContext)_localctx).then.ast, (((CmdContext)_localctx).IF!=null?((CmdContext)_localctx).IF.getLine():0), (((CmdContext)_localctx).IF!=null?((CmdContext)_localctx).IF.getCharPositionInLine():0)); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				((CmdContext)_localctx).IF = match(IF);
				setState(158);
				match(OPEN_PARENTHESIS);
				setState(159);
				((CmdContext)_localctx).condition = ((CmdContext)_localctx).exp = exp(0);
				setState(160);
				match(CLOSE_PARENTHESIS);
				setState(161);
				((CmdContext)_localctx).then = cmd();
				setState(162);
				match(ELSE);
				setState(163);
				((CmdContext)_localctx).elseCmd = cmd();
				 ((CmdContext)_localctx).ast =  new If(((CmdContext)_localctx).exp.ast, ((CmdContext)_localctx).then.ast, ((CmdContext)_localctx).elseCmd.ast, (((CmdContext)_localctx).IF!=null?((CmdContext)_localctx).IF.getLine():0), (((CmdContext)_localctx).IF!=null?((CmdContext)_localctx).IF.getCharPositionInLine():0)); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(166);
				((CmdContext)_localctx).ITERATE = match(ITERATE);
				setState(167);
				match(OPEN_PARENTHESIS);
				setState(168);
				((CmdContext)_localctx).condition = exp(0);
				setState(169);
				match(CLOSE_PARENTHESIS);
				setState(170);
				((CmdContext)_localctx).body = cmd();
				 ((CmdContext)_localctx).ast =  new Iterate(((CmdContext)_localctx).condition.ast, ((CmdContext)_localctx).body.ast, (((CmdContext)_localctx).ITERATE!=null?((CmdContext)_localctx).ITERATE.getLine():0), (((CmdContext)_localctx).ITERATE!=null?((CmdContext)_localctx).ITERATE.getCharPositionInLine():0)); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
				((CmdContext)_localctx).READ = match(READ);
				setState(174);
				((CmdContext)_localctx).lvalue = lvalue(0);
				setState(175);
				match(SEMICOLON);
				 ((CmdContext)_localctx).ast =  new Read(((CmdContext)_localctx).lvalue.ast, (((CmdContext)_localctx).READ!=null?((CmdContext)_localctx).READ.getLine():0), (((CmdContext)_localctx).READ!=null?((CmdContext)_localctx).READ.getCharPositionInLine():0)); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(178);
				((CmdContext)_localctx).PRINT = match(PRINT);
				setState(179);
				((CmdContext)_localctx).exp = exp(0);
				setState(180);
				match(SEMICOLON);
				 ((CmdContext)_localctx).ast =  new Print(((CmdContext)_localctx).exp.ast, (((CmdContext)_localctx).PRINT!=null?((CmdContext)_localctx).PRINT.getLine():0), (((CmdContext)_localctx).PRINT!=null?((CmdContext)_localctx).PRINT.getCharPositionInLine():0)); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(183);
				((CmdContext)_localctx).RETURN = match(RETURN);
				 List<Expression> expList = new ArrayList<Expression>(); 
				setState(185);
				((CmdContext)_localctx).exp1 = exp(0);
				 expList.add(((CmdContext)_localctx).exp1.ast); 
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(187);
					match(COMMA);
					setState(188);
					((CmdContext)_localctx).exp2 = exp(0);
					 expList.add(((CmdContext)_localctx).exp2.ast); 
					}
					}
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(196);
				match(SEMICOLON);

				      Expression[] expressionsArray = new Expression[expList.size()];
				      expressionsArray = expList.toArray(expressionsArray);

				      ((CmdContext)_localctx).ast =  new Return(expressionsArray, (((CmdContext)_localctx).RETURN!=null?((CmdContext)_localctx).RETURN.getLine():0), (((CmdContext)_localctx).RETURN!=null?((CmdContext)_localctx).RETURN.getCharPositionInLine():0));
				    
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(199);
				((CmdContext)_localctx).lvalue = lvalue(0);
				setState(200);
				((CmdContext)_localctx).EQUAL = match(EQUAL);
				setState(201);
				((CmdContext)_localctx).exp = exp(0);
				setState(202);
				match(SEMICOLON);
				 ((CmdContext)_localctx).ast =  new Assignment(((CmdContext)_localctx).lvalue.ast, ((CmdContext)_localctx).exp.ast, (((CmdContext)_localctx).EQUAL!=null?((CmdContext)_localctx).EQUAL.getLine():0), (((CmdContext)_localctx).EQUAL!=null?((CmdContext)_localctx).EQUAL.getCharPositionInLine():0)); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(205);
				((CmdContext)_localctx).ID = match(ID);
				setState(206);
				match(OPEN_PARENTHESIS);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FLOAT) | (1L << INT) | (1L << FALSE) | (1L << TRUE) | (1L << NULL) | (1L << NEW) | (1L << ID) | (1L << CHAR) | (1L << OPEN_PARENTHESIS) | (1L << MINUS) | (1L << NOT))) != 0)) {
					{
					setState(207);
					((CmdContext)_localctx).arguments = exps();
					}
				}

				setState(210);
				match(CLOSE_PARENTHESIS);
				 List<Variable> returnVariables = new ArrayList<Variable>(); 
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LESS_THAN) {
					{
					setState(212);
					match(LESS_THAN);
					setState(213);
					((CmdContext)_localctx).lvalue1 = lvalue(0);
					 returnVariables.add(((CmdContext)_localctx).lvalue1.ast); 
					setState(221);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(215);
						match(COMMA);
						setState(216);
						((CmdContext)_localctx).lvalue2 = lvalue(0);
						 returnVariables.add(((CmdContext)_localctx).lvalue2.ast); 
						}
						}
						setState(223);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(224);
					match(GREATER_THAN);
					}
				}

				setState(228);
				match(SEMICOLON);

				      Variable[] variablesArray = new Variable[returnVariables.size()];
				      variablesArray = returnVariables.toArray(variablesArray);

				      ((CmdContext)_localctx).ast =  new Call((((CmdContext)_localctx).ID!=null?((CmdContext)_localctx).ID.getText():null), ((CmdContext)_localctx).arguments.ast, variablesArray, (((CmdContext)_localctx).ID!=null?((CmdContext)_localctx).ID.getLine():0), (((CmdContext)_localctx).ID!=null?((CmdContext)_localctx).ID.getCharPositionInLine():0));
				    
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
		public Expression ast;
		public ExpContext expLeft;
		public LvalueContext lvalue;
		public ExpContext exp;
		public Token NOT;
		public Token MINUS;
		public Token FALSE;
		public Token TRUE;
		public Token NULL;
		public Token INT;
		public Token FLOAT;
		public Token CHAR;
		public Token NEW;
		public TypeContext type;
		public Token ID;
		public ExpsContext arguments;
		public ExpContext returnIndex;
		public Token TIMES;
		public ExpContext expRight;
		public Token DIVISION;
		public Token MODULUS;
		public Token PLUS;
		public Token LESS_THAN;
		public Token COMPARISON;
		public Token NOT_EQUAL;
		public Token AND;
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode OPEN_PARENTHESIS() { return getToken(langParser.OPEN_PARENTHESIS, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(langParser.CLOSE_PARENTHESIS, 0); }
		public TerminalNode NOT() { return getToken(langParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(langParser.MINUS, 0); }
		public TerminalNode FALSE() { return getToken(langParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(langParser.TRUE, 0); }
		public TerminalNode NULL() { return getToken(langParser.NULL, 0); }
		public TerminalNode INT() { return getToken(langParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(langParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(langParser.CHAR, 0); }
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
		public TerminalNode TIMES() { return getToken(langParser.TIMES, 0); }
		public TerminalNode DIVISION() { return getToken(langParser.DIVISION, 0); }
		public TerminalNode MODULUS() { return getToken(langParser.MODULUS, 0); }
		public TerminalNode PLUS() { return getToken(langParser.PLUS, 0); }
		public TerminalNode LESS_THAN() { return getToken(langParser.LESS_THAN, 0); }
		public TerminalNode COMPARISON() { return getToken(langParser.COMPARISON, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(langParser.NOT_EQUAL, 0); }
		public TerminalNode AND() { return getToken(langParser.AND, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitExp(this);
		}
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
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(233);
				((ExpContext)_localctx).lvalue = lvalue(0);
				 ((ExpContext)_localctx).ast =  ((ExpContext)_localctx).lvalue.ast; 
				}
				break;
			case 2:
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
			case 3:
				{
				setState(241);
				((ExpContext)_localctx).NOT = match(NOT);
				setState(242);
				((ExpContext)_localctx).exp = exp(19);
				 ((ExpContext)_localctx).ast =  new Not(((ExpContext)_localctx).exp.ast, (((ExpContext)_localctx).NOT!=null?((ExpContext)_localctx).NOT.getLine():0), (((ExpContext)_localctx).NOT!=null?((ExpContext)_localctx).NOT.getCharPositionInLine():0)); 
				}
				break;
			case 4:
				{
				setState(245);
				((ExpContext)_localctx).MINUS = match(MINUS);
				setState(246);
				((ExpContext)_localctx).exp = exp(18);
				 ((ExpContext)_localctx).ast =  new UnaryMinus(((ExpContext)_localctx).exp.ast, (((ExpContext)_localctx).MINUS!=null?((ExpContext)_localctx).MINUS.getLine():0), (((ExpContext)_localctx).MINUS!=null?((ExpContext)_localctx).MINUS.getCharPositionInLine():0)); 
				}
				break;
			case 5:
				{
				setState(249);
				((ExpContext)_localctx).FALSE = match(FALSE);
				 ((ExpContext)_localctx).ast =  new False((((ExpContext)_localctx).FALSE!=null?((ExpContext)_localctx).FALSE.getLine():0), (((ExpContext)_localctx).FALSE!=null?((ExpContext)_localctx).FALSE.getCharPositionInLine():0)); 
				}
				break;
			case 6:
				{
				setState(251);
				((ExpContext)_localctx).TRUE = match(TRUE);
				 ((ExpContext)_localctx).ast =  new True((((ExpContext)_localctx).TRUE!=null?((ExpContext)_localctx).TRUE.getLine():0), (((ExpContext)_localctx).TRUE!=null?((ExpContext)_localctx).TRUE.getCharPositionInLine():0)); 
				}
				break;
			case 7:
				{
				setState(253);
				((ExpContext)_localctx).NULL = match(NULL);
				 ((ExpContext)_localctx).ast =  new Null((((ExpContext)_localctx).NULL!=null?((ExpContext)_localctx).NULL.getLine():0), (((ExpContext)_localctx).NULL!=null?((ExpContext)_localctx).NULL.getCharPositionInLine():0)); 
				}
				break;
			case 8:
				{
				setState(255);
				((ExpContext)_localctx).INT = match(INT);
				 ((ExpContext)_localctx).ast =  new LiteralInt(Integer.parseInt((((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getText():null)), (((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getLine():0), (((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getCharPositionInLine():0)); 
				}
				break;
			case 9:
				{
				setState(257);
				((ExpContext)_localctx).FLOAT = match(FLOAT);
				 ((ExpContext)_localctx).ast =  new LiteralFloat(Float.parseFloat((((ExpContext)_localctx).FLOAT!=null?((ExpContext)_localctx).FLOAT.getText():null)), (((ExpContext)_localctx).FLOAT!=null?((ExpContext)_localctx).FLOAT.getLine():0), (((ExpContext)_localctx).FLOAT!=null?((ExpContext)_localctx).FLOAT.getCharPositionInLine():0)); 
				}
				break;
			case 10:
				{
				setState(259);
				((ExpContext)_localctx).CHAR = match(CHAR);

				      String text = (((ExpContext)_localctx).CHAR!=null?((ExpContext)_localctx).CHAR.getText():null);
				      String value = text.substring(1);
				      value = value.substring(0, value.length() - 1);

				      if (value.length() == 1) {
				        ((ExpContext)_localctx).ast =  new LiteralChar(value.toCharArray()[0], (((ExpContext)_localctx).CHAR!=null?((ExpContext)_localctx).CHAR.getLine():0), (((ExpContext)_localctx).CHAR!=null?((ExpContext)_localctx).CHAR.getCharPositionInLine():0));
				      } else if (this.specialCharacters.containsKey(value)) {
				        ((ExpContext)_localctx).ast =  new LiteralChar(this.specialCharacters.get(value), (((ExpContext)_localctx).CHAR!=null?((ExpContext)_localctx).CHAR.getLine():0), (((ExpContext)_localctx).CHAR!=null?((ExpContext)_localctx).CHAR.getCharPositionInLine():0));
				      }
				    
				}
				break;
			case 11:
				{
				setState(261);
				((ExpContext)_localctx).NEW = match(NEW);
				setState(262);
				((ExpContext)_localctx).type = type(0);
				setState(267);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(263);
					match(OPEN_BRACKET);
					setState(264);
					((ExpContext)_localctx).exp = exp(0);
					setState(265);
					match(CLOSE_BRACKET);
					}
					break;
				}
				 ((ExpContext)_localctx).ast =  new VariableDeclaration(((ExpContext)_localctx).type.ast, ((ExpContext)_localctx).exp.ast, (((ExpContext)_localctx).NEW!=null?((ExpContext)_localctx).NEW.getLine():0), (((ExpContext)_localctx).NEW!=null?((ExpContext)_localctx).NEW.getCharPositionInLine():0)); 
				}
				break;
			case 12:
				{
				setState(271);
				((ExpContext)_localctx).ID = match(ID);
				setState(272);
				match(OPEN_PARENTHESIS);
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FLOAT) | (1L << INT) | (1L << FALSE) | (1L << TRUE) | (1L << NULL) | (1L << NEW) | (1L << ID) | (1L << CHAR) | (1L << OPEN_PARENTHESIS) | (1L << MINUS) | (1L << NOT))) != 0)) {
					{
					setState(273);
					((ExpContext)_localctx).arguments = exps();
					}
				}

				setState(276);
				match(CLOSE_PARENTHESIS);
				setState(277);
				match(OPEN_BRACKET);
				setState(278);
				((ExpContext)_localctx).returnIndex = ((ExpContext)_localctx).exp = exp(0);
				setState(279);
				match(CLOSE_BRACKET);
				 ((ExpContext)_localctx).ast =  new Call((((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null), ((ExpContext)_localctx).arguments.ast, ((ExpContext)_localctx).returnIndex.ast, (((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getLine():0), (((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getCharPositionInLine():0)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(331);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(329);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(284);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(285);
						((ExpContext)_localctx).TIMES = match(TIMES);
						setState(286);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(18);
						 ((ExpContext)_localctx).ast =  new Multiplication(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast, (((ExpContext)_localctx).TIMES!=null?((ExpContext)_localctx).TIMES.getLine():0), (((ExpContext)_localctx).TIMES!=null?((ExpContext)_localctx).TIMES.getCharPositionInLine():0)); 
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(289);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(290);
						((ExpContext)_localctx).DIVISION = match(DIVISION);
						setState(291);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(17);
						 ((ExpContext)_localctx).ast =  new Division(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast, (((ExpContext)_localctx).DIVISION!=null?((ExpContext)_localctx).DIVISION.getLine():0), (((ExpContext)_localctx).DIVISION!=null?((ExpContext)_localctx).DIVISION.getCharPositionInLine():0)); 
						}
						break;
					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(294);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(295);
						((ExpContext)_localctx).MODULUS = match(MODULUS);
						setState(296);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(16);
						 ((ExpContext)_localctx).ast =  new Modulus(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast, (((ExpContext)_localctx).MODULUS!=null?((ExpContext)_localctx).MODULUS.getLine():0), (((ExpContext)_localctx).MODULUS!=null?((ExpContext)_localctx).MODULUS.getCharPositionInLine():0)); 
						}
						break;
					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(299);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(300);
						((ExpContext)_localctx).PLUS = match(PLUS);
						setState(301);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(15);
						 ((ExpContext)_localctx).ast =  new Add(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast, (((ExpContext)_localctx).PLUS!=null?((ExpContext)_localctx).PLUS.getLine():0), (((ExpContext)_localctx).PLUS!=null?((ExpContext)_localctx).PLUS.getCharPositionInLine():0)); 
						}
						break;
					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(304);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(305);
						((ExpContext)_localctx).MINUS = match(MINUS);
						setState(306);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(14);
						 ((ExpContext)_localctx).ast =  new Subtraction(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast, (((ExpContext)_localctx).MINUS!=null?((ExpContext)_localctx).MINUS.getLine():0), (((ExpContext)_localctx).MINUS!=null?((ExpContext)_localctx).MINUS.getCharPositionInLine():0)); 
						}
						break;
					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(309);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(310);
						((ExpContext)_localctx).LESS_THAN = match(LESS_THAN);
						setState(311);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(13);
						 ((ExpContext)_localctx).ast =  new LessThan(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast, (((ExpContext)_localctx).LESS_THAN!=null?((ExpContext)_localctx).LESS_THAN.getLine():0), (((ExpContext)_localctx).LESS_THAN!=null?((ExpContext)_localctx).LESS_THAN.getCharPositionInLine():0)); 
						}
						break;
					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(314);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(315);
						((ExpContext)_localctx).COMPARISON = match(COMPARISON);
						setState(316);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(12);
						 ((ExpContext)_localctx).ast =  new Equals(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast, (((ExpContext)_localctx).COMPARISON!=null?((ExpContext)_localctx).COMPARISON.getLine():0), (((ExpContext)_localctx).COMPARISON!=null?((ExpContext)_localctx).COMPARISON.getCharPositionInLine():0)); 
						}
						break;
					case 8:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(319);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(320);
						((ExpContext)_localctx).NOT_EQUAL = match(NOT_EQUAL);
						setState(321);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(11);
						 ((ExpContext)_localctx).ast =  new NotEquals(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast, (((ExpContext)_localctx).NOT_EQUAL!=null?((ExpContext)_localctx).NOT_EQUAL.getLine():0), (((ExpContext)_localctx).NOT_EQUAL!=null?((ExpContext)_localctx).NOT_EQUAL.getCharPositionInLine():0)); 
						}
						break;
					case 9:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(324);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(325);
						((ExpContext)_localctx).AND = match(AND);
						setState(326);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(10);
						 ((ExpContext)_localctx).ast =  new And(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast, (((ExpContext)_localctx).AND!=null?((ExpContext)_localctx).AND.getLine():0), (((ExpContext)_localctx).AND!=null?((ExpContext)_localctx).AND.getCharPositionInLine():0)); 
						}
						break;
					}
					} 
				}
				setState(333);
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

	public static class LvalueContext extends ParserRuleContext {
		public Variable ast;
		public LvalueContext lvalue1;
		public LvalueContext lvalue2;
		public Token ID;
		public Token OPEN_BRACKET;
		public ExpContext exp;
		public Token DOT;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(langParser.OPEN_BRACKET, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode CLOSE_BRACKET() { return getToken(langParser.CLOSE_BRACKET, 0); }
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode DOT() { return getToken(langParser.DOT, 0); }
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterLvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitLvalue(this);
		}
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
			setState(335);
			((LvalueContext)_localctx).ID = match(ID);
			 ((LvalueContext)_localctx).ast =  new SimpleVariable((((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getText():null), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getLine():0), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getCharPositionInLine():0)); 
			}
			_ctx.stop = _input.LT(-1);
			setState(350);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(348);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						_localctx.lvalue1 = _prevctx;
						_localctx.lvalue1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(338);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(339);
						((LvalueContext)_localctx).OPEN_BRACKET = match(OPEN_BRACKET);
						setState(340);
						((LvalueContext)_localctx).exp = exp(0);
						setState(341);
						match(CLOSE_BRACKET);
						 ((LvalueContext)_localctx).ast =  new ArrayAccess(((LvalueContext)_localctx).lvalue1.ast, ((LvalueContext)_localctx).exp.ast, (((LvalueContext)_localctx).OPEN_BRACKET!=null?((LvalueContext)_localctx).OPEN_BRACKET.getLine():0), (((LvalueContext)_localctx).OPEN_BRACKET!=null?((LvalueContext)_localctx).OPEN_BRACKET.getCharPositionInLine():0)); 
						}
						break;
					case 2:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						_localctx.lvalue2 = _prevctx;
						_localctx.lvalue2 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(344);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(345);
						((LvalueContext)_localctx).DOT = match(DOT);
						setState(346);
						((LvalueContext)_localctx).ID = match(ID);
						 ((LvalueContext)_localctx).ast =  new FieldAccess(((LvalueContext)_localctx).lvalue2.ast, (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getText():null), (((LvalueContext)_localctx).DOT!=null?((LvalueContext)_localctx).DOT.getLine():0), (((LvalueContext)_localctx).DOT!=null?((LvalueContext)_localctx).DOT.getCharPositionInLine():0)); 
						}
						break;
					}
					} 
				}
				setState(352);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterExps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitExps(this);
		}
	}

	public final ExpsContext exps() throws RecognitionException {
		ExpsContext _localctx = new ExpsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<Expression> expList = new ArrayList<Expression>(); 
			setState(354);
			((ExpsContext)_localctx).exp1 = exp(0);
			 expList.add(((ExpsContext)_localctx).exp1.ast); 
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(356);
				match(COMMA);
				setState(357);
				((ExpsContext)_localctx).exp2 = exp(0);
				 expList.add(((ExpsContext)_localctx).exp2.ast); 
				}
				}
				setState(364);
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
			return precpred(_ctx, 17);
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 15);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 11);
		case 8:
			return precpred(_ctx, 10);
		case 9:
			return precpred(_ctx, 9);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u0172\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\7\2\37\n\2\f\2\16\2\"\13\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3,\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\65"+
		"\n\4\f\4\16\48\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5"+
		"\6F\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6Q\n\6\f\6\16\6T\13\6\5"+
		"\6V\n\6\3\6\3\6\7\6Z\n\6\f\6\16\6]\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7m\n\7\f\7\16\7p\13\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\7\b|\n\b\f\b\16\b\177\13\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u008b\n\t\3\n\3\n\3\n\3\n\3\n\7\n\u0092\n\n\f\n"+
		"\16\n\u0095\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00c2\n\n\f\n\16"+
		"\n\u00c5\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00d3"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00de\n\n\f\n\16\n\u00e1"+
		"\13\n\3\n\3\n\5\n\u00e5\n\n\3\n\3\n\5\n\u00e9\n\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u010e\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0115\n"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u011d\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u014c\n\13\f\13\16\13\u014f\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\7\f\u015f\n\f\f\f\16\f\u0162\13\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\7\r\u016b\n\r\f\r\16\r\u016e\13\r\3\r\3\r\3\r\2\5\16\24\26"+
		"\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\2\u0198\2\32\3\2\2\2\4+\3\2\2\2"+
		"\6-\3\2\2\2\b<\3\2\2\2\nB\3\2\2\2\fa\3\2\2\2\16s\3\2\2\2\20\u008a\3\2"+
		"\2\2\22\u00e8\3\2\2\2\24\u011c\3\2\2\2\26\u0150\3\2\2\2\30\u0163\3\2\2"+
		"\2\32 \b\2\1\2\33\34\5\4\3\2\34\35\b\2\1\2\35\37\3\2\2\2\36\33\3\2\2\2"+
		"\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!#\3\2\2\2\" \3\2\2\2#$\b\2\1\2$\3"+
		"\3\2\2\2%&\5\6\4\2&\'\b\3\1\2\',\3\2\2\2()\5\n\6\2)*\b\3\1\2*,\3\2\2\2"+
		"+%\3\2\2\2+(\3\2\2\2,\5\3\2\2\2-.\7\n\2\2./\7\25\2\2/\60\7\33\2\2\60\66"+
		"\b\4\1\2\61\62\5\b\5\2\62\63\b\4\1\2\63\65\3\2\2\2\64\61\3\2\2\2\658\3"+
		"\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3\2\2\29:\7\34\2\2"+
		":;\b\4\1\2;\7\3\2\2\2<=\7\20\2\2=>\7 \2\2>?\5\16\b\2?@\7\37\2\2@A\b\5"+
		"\1\2A\t\3\2\2\2BC\7\20\2\2CE\7\27\2\2DF\5\f\7\2ED\3\2\2\2EF\3\2\2\2FG"+
		"\3\2\2\2GH\7\30\2\2HU\b\6\1\2IJ\7!\2\2JK\5\16\b\2KR\b\6\1\2LM\7#\2\2M"+
		"N\5\16\b\2NO\b\6\1\2OQ\3\2\2\2PL\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2"+
		"SV\3\2\2\2TR\3\2\2\2UI\3\2\2\2UV\3\2\2\2VW\3\2\2\2W[\7\33\2\2XZ\5\22\n"+
		"\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2][\3\2\2\2^_\7\34"+
		"\2\2_`\b\6\1\2`\13\3\2\2\2ab\7\20\2\2bc\7 \2\2cd\b\7\1\2de\5\16\b\2en"+
		"\b\7\1\2fg\7#\2\2gh\7\20\2\2hi\7 \2\2ij\5\16\b\2jk\b\7\1\2km\3\2\2\2l"+
		"f\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\b\7\1\2"+
		"r\r\3\2\2\2st\b\b\1\2tu\5\20\t\2uv\b\b\1\2v}\3\2\2\2wx\f\4\2\2xy\7\31"+
		"\2\2yz\7\32\2\2z|\b\b\1\2{w\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~"+
		"\17\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\21\2\2\u0081\u008b\b\t\1\2\u0082"+
		"\u0083\7\24\2\2\u0083\u008b\b\t\1\2\u0084\u0085\7\23\2\2\u0085\u008b\b"+
		"\t\1\2\u0086\u0087\7\22\2\2\u0087\u008b\b\t\1\2\u0088\u0089\7\25\2\2\u0089"+
		"\u008b\b\t\1\2\u008a\u0080\3\2\2\2\u008a\u0082\3\2\2\2\u008a\u0084\3\2"+
		"\2\2\u008a\u0086\3\2\2\2\u008a\u0088\3\2\2\2\u008b\21\3\2\2\2\u008c\u008d"+
		"\7\33\2\2\u008d\u0093\b\n\1\2\u008e\u008f\5\22\n\2\u008f\u0090\b\n\1\2"+
		"\u0090\u0092\3\2\2\2\u0091\u008e\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091"+
		"\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096"+
		"\u0097\7\34\2\2\u0097\u00e9\b\n\1\2\u0098\u0099\7\b\2\2\u0099\u009a\7"+
		"\27\2\2\u009a\u009b\5\24\13\2\u009b\u009c\7\30\2\2\u009c\u009d\5\22\n"+
		"\2\u009d\u009e\b\n\1\2\u009e\u00e9\3\2\2\2\u009f\u00a0\7\b\2\2\u00a0\u00a1"+
		"\7\27\2\2\u00a1\u00a2\5\24\13\2\u00a2\u00a3\7\30\2\2\u00a3\u00a4\5\22"+
		"\n\2\u00a4\u00a5\7\t\2\2\u00a5\u00a6\5\22\n\2\u00a6\u00a7\b\n\1\2\u00a7"+
		"\u00e9\3\2\2\2\u00a8\u00a9\7\13\2\2\u00a9\u00aa\7\27\2\2\u00aa\u00ab\5"+
		"\24\13\2\u00ab\u00ac\7\30\2\2\u00ac\u00ad\5\22\n\2\u00ad\u00ae\b\n\1\2"+
		"\u00ae\u00e9\3\2\2\2\u00af\u00b0\7\16\2\2\u00b0\u00b1\5\26\f\2\u00b1\u00b2"+
		"\7\37\2\2\u00b2\u00b3\b\n\1\2\u00b3\u00e9\3\2\2\2\u00b4\u00b5\7\r\2\2"+
		"\u00b5\u00b6\5\24\13\2\u00b6\u00b7\7\37\2\2\u00b7\u00b8\b\n\1\2\u00b8"+
		"\u00e9\3\2\2\2\u00b9\u00ba\7\f\2\2\u00ba\u00bb\b\n\1\2\u00bb\u00bc\5\24"+
		"\13\2\u00bc\u00c3\b\n\1\2\u00bd\u00be\7#\2\2\u00be\u00bf\5\24\13\2\u00bf"+
		"\u00c0\b\n\1\2\u00c0\u00c2\3\2\2\2\u00c1\u00bd\3\2\2\2\u00c2\u00c5\3\2"+
		"\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c6\u00c7\7\37\2\2\u00c7\u00c8\b\n\1\2\u00c8\u00e9\3"+
		"\2\2\2\u00c9\u00ca\5\26\f\2\u00ca\u00cb\7%\2\2\u00cb\u00cc\5\24\13\2\u00cc"+
		"\u00cd\7\37\2\2\u00cd\u00ce\b\n\1\2\u00ce\u00e9\3\2\2\2\u00cf\u00d0\7"+
		"\20\2\2\u00d0\u00d2\7\27\2\2\u00d1\u00d3\5\30\r\2\u00d2\u00d1\3\2\2\2"+
		"\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\7\30\2\2\u00d5\u00e4"+
		"\b\n\1\2\u00d6\u00d7\7\36\2\2\u00d7\u00d8\5\26\f\2\u00d8\u00df\b\n\1\2"+
		"\u00d9\u00da\7#\2\2\u00da\u00db\5\26\f\2\u00db\u00dc\b\n\1\2\u00dc\u00de"+
		"\3\2\2\2\u00dd\u00d9\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\7\35"+
		"\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00d6\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6\u00e7\7\37\2\2\u00e7\u00e9\b\n\1\2\u00e8\u008c\3"+
		"\2\2\2\u00e8\u0098\3\2\2\2\u00e8\u009f\3\2\2\2\u00e8\u00a8\3\2\2\2\u00e8"+
		"\u00af\3\2\2\2\u00e8\u00b4\3\2\2\2\u00e8\u00b9\3\2\2\2\u00e8\u00c9\3\2"+
		"\2\2\u00e8\u00cf\3\2\2\2\u00e9\23\3\2\2\2\u00ea\u00eb\b\13\1\2\u00eb\u00ec"+
		"\5\26\f\2\u00ec\u00ed\b\13\1\2\u00ed\u011d\3\2\2\2\u00ee\u00ef\7\27\2"+
		"\2\u00ef\u00f0\5\24\13\2\u00f0\u00f1\7\30\2\2\u00f1\u00f2\b\13\1\2\u00f2"+
		"\u011d\3\2\2\2\u00f3\u00f4\7-\2\2\u00f4\u00f5\5\24\13\25\u00f5\u00f6\b"+
		"\13\1\2\u00f6\u011d\3\2\2\2\u00f7\u00f8\7(\2\2\u00f8\u00f9\5\24\13\24"+
		"\u00f9\u00fa\b\13\1\2\u00fa\u011d\3\2\2\2\u00fb\u00fc\7\5\2\2\u00fc\u011d"+
		"\b\13\1\2\u00fd\u00fe\7\6\2\2\u00fe\u011d\b\13\1\2\u00ff\u0100\7\7\2\2"+
		"\u0100\u011d\b\13\1\2\u0101\u0102\7\4\2\2\u0102\u011d\b\13\1\2\u0103\u0104"+
		"\7\3\2\2\u0104\u011d\b\13\1\2\u0105\u0106\7\26\2\2\u0106\u011d\b\13\1"+
		"\2\u0107\u0108\7\17\2\2\u0108\u010d\5\16\b\2\u0109\u010a\7\31\2\2\u010a"+
		"\u010b\5\24\13\2\u010b\u010c\7\32\2\2\u010c\u010e\3\2\2\2\u010d\u0109"+
		"\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\b\13\1\2"+
		"\u0110\u011d\3\2\2\2\u0111\u0112\7\20\2\2\u0112\u0114\7\27\2\2\u0113\u0115"+
		"\5\30\r\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2"+
		"\u0116\u0117\7\30\2\2\u0117\u0118\7\31\2\2\u0118\u0119\5\24\13\2\u0119"+
		"\u011a\7\32\2\2\u011a\u011b\b\13\1\2\u011b\u011d\3\2\2\2\u011c\u00ea\3"+
		"\2\2\2\u011c\u00ee\3\2\2\2\u011c\u00f3\3\2\2\2\u011c\u00f7\3\2\2\2\u011c"+
		"\u00fb\3\2\2\2\u011c\u00fd\3\2\2\2\u011c\u00ff\3\2\2\2\u011c\u0101\3\2"+
		"\2\2\u011c\u0103\3\2\2\2\u011c\u0105\3\2\2\2\u011c\u0107\3\2\2\2\u011c"+
		"\u0111\3\2\2\2\u011d\u014d\3\2\2\2\u011e\u011f\f\23\2\2\u011f\u0120\7"+
		")\2\2\u0120\u0121\5\24\13\24\u0121\u0122\b\13\1\2\u0122\u014c\3\2\2\2"+
		"\u0123\u0124\f\22\2\2\u0124\u0125\7*\2\2\u0125\u0126\5\24\13\23\u0126"+
		"\u0127\b\13\1\2\u0127\u014c\3\2\2\2\u0128\u0129\f\21\2\2\u0129\u012a\7"+
		"+\2\2\u012a\u012b\5\24\13\22\u012b\u012c\b\13\1\2\u012c\u014c\3\2\2\2"+
		"\u012d\u012e\f\20\2\2\u012e\u012f\7\'\2\2\u012f\u0130\5\24\13\21\u0130"+
		"\u0131\b\13\1\2\u0131\u014c\3\2\2\2\u0132\u0133\f\17\2\2\u0133\u0134\7"+
		"(\2\2\u0134\u0135\5\24\13\20\u0135\u0136\b\13\1\2\u0136\u014c\3\2\2\2"+
		"\u0137\u0138\f\16\2\2\u0138\u0139\7\36\2\2\u0139\u013a\5\24\13\17\u013a"+
		"\u013b\b\13\1\2\u013b\u014c\3\2\2\2\u013c\u013d\f\r\2\2\u013d\u013e\7"+
		"$\2\2\u013e\u013f\5\24\13\16\u013f\u0140\b\13\1\2\u0140\u014c\3\2\2\2"+
		"\u0141\u0142\f\f\2\2\u0142\u0143\7&\2\2\u0143\u0144\5\24\13\r\u0144\u0145"+
		"\b\13\1\2\u0145\u014c\3\2\2\2\u0146\u0147\f\13\2\2\u0147\u0148\7,\2\2"+
		"\u0148\u0149\5\24\13\f\u0149\u014a\b\13\1\2\u014a\u014c\3\2\2\2\u014b"+
		"\u011e\3\2\2\2\u014b\u0123\3\2\2\2\u014b\u0128\3\2\2\2\u014b\u012d\3\2"+
		"\2\2\u014b\u0132\3\2\2\2\u014b\u0137\3\2\2\2\u014b\u013c\3\2\2\2\u014b"+
		"\u0141\3\2\2\2\u014b\u0146\3\2\2\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2"+
		"\2\2\u014d\u014e\3\2\2\2\u014e\25\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0151"+
		"\b\f\1\2\u0151\u0152\7\20\2\2\u0152\u0153\b\f\1\2\u0153\u0160\3\2\2\2"+
		"\u0154\u0155\f\4\2\2\u0155\u0156\7\31\2\2\u0156\u0157\5\24\13\2\u0157"+
		"\u0158\7\32\2\2\u0158\u0159\b\f\1\2\u0159\u015f\3\2\2\2\u015a\u015b\f"+
		"\3\2\2\u015b\u015c\7\"\2\2\u015c\u015d\7\20\2\2\u015d\u015f\b\f\1\2\u015e"+
		"\u0154\3\2\2\2\u015e\u015a\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2"+
		"\2\2\u0160\u0161\3\2\2\2\u0161\27\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0164"+
		"\b\r\1\2\u0164\u0165\5\24\13\2\u0165\u016c\b\r\1\2\u0166\u0167\7#\2\2"+
		"\u0167\u0168\5\24\13\2\u0168\u0169\b\r\1\2\u0169\u016b\3\2\2\2\u016a\u0166"+
		"\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d"+
		"\u016f\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0170\b\r\1\2\u0170\31\3\2\2"+
		"\2\32 +\66ERU[n}\u008a\u0093\u00c3\u00d2\u00df\u00e4\u00e8\u010d\u0114"+
		"\u011c\u014b\u014d\u015e\u0160\u016c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}