// Generated from src/lang/parser/lang.g4 by ANTLR 4.8

/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

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
		WHITESPACE=45, LINE_COMMENT=46, COMMENT=47, LEXER_ERROR=48;
	public static final int
		RULE_prog = 0, RULE_def = 1, RULE_data = 2, RULE_decl = 3, RULE_fun = 4, 
		RULE_block = 5, RULE_params = 6, RULE_type = 7, RULE_bType = 8, RULE_cmd = 9, 
		RULE_exp = 10, RULE_lvalue = 11, RULE_exps = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "def", "data", "decl", "fun", "block", "params", "type", "bType", 
			"cmd", "exp", "lvalue", "exps"
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
			"COMMENT", "LEXER_ERROR"
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
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DATA || _la==ID) {
				{
				{
				setState(27);
				((ProgContext)_localctx).def = def();
				 definitions.add(((ProgContext)_localctx).def.ast); 
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			      Definition[] definitionsArray = new Definition[definitions.size()];
			      definitionsArray = definitions.toArray(definitionsArray);

			      int line = definitionsArray.length > 0 ? definitionsArray[0].getLine() : 0;
			      int column = definitionsArray.length > 0 ? definitionsArray[0].getColumn() : 0;

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
			setState(43);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATA:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				((DefContext)_localctx).data = data();
				 ((DefContext)_localctx).ast =  ((DefContext)_localctx).data.ast; 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
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
			setState(45);
			match(DATA);
			setState(46);
			((DataContext)_localctx).TYPE_NAME = match(TYPE_NAME);
			setState(47);
			match(OPEN_CURLY_BRACE);
			 List<Declaration> declarations = new ArrayList<Declaration>(); 
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(49);
				((DataContext)_localctx).decl = decl();
				 declarations.add(((DataContext)_localctx).decl.ast); 
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
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
			setState(60);
			((DeclContext)_localctx).ID = match(ID);
			setState(61);
			match(DOUBLE_COLON);
			setState(62);
			((DeclContext)_localctx).type = type(0);
			setState(63);
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
		public BlockContext block;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TerminalNode OPEN_PARENTHESIS() { return getToken(langParser.OPEN_PARENTHESIS, 0); }
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(langParser.CLOSE_PARENTHESIS, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(langParser.COLON, 0); }
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
			setState(66);
			((FunContext)_localctx).ID = match(ID);
			setState(67);
			match(OPEN_PARENTHESIS);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(68);
				((FunContext)_localctx).params = params();
				}
			}

			setState(71);
			match(CLOSE_PARENTHESIS);
			 List<Type> returnTypes = new ArrayList<Type>(); 
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(73);
				match(COLON);
				setState(74);
				((FunContext)_localctx).type1 = type(0);
				 returnTypes.add(((FunContext)_localctx).type1.ast); 
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(76);
					match(COMMA);
					setState(77);
					((FunContext)_localctx).type2 = type(0);
					 returnTypes.add(((FunContext)_localctx).type2.ast); 
					}
					}
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(87);
			((FunContext)_localctx).block = block();

			      Type[] typesArray = new Type[returnTypes.size()];
			      typesArray = returnTypes.toArray(typesArray);

			      FunContext context = (FunContext)_localctx;
			      Parameter[] parameters = context.params != null ? ((FunContext)_localctx).params.ast : new Parameter[0];

			      ((FunContext)_localctx).ast =  new Function((((FunContext)_localctx).ID!=null?((FunContext)_localctx).ID.getText():null), parameters, typesArray, ((FunContext)_localctx).block.ast, (((FunContext)_localctx).ID!=null?((FunContext)_localctx).ID.getLine():0), (((FunContext)_localctx).ID!=null?((FunContext)_localctx).ID.getCharPositionInLine():0));
			    
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

	public static class BlockContext extends ParserRuleContext {
		public Block ast;
		public Token OPEN_CURLY_BRACE;
		public CmdContext cmd;
		public TerminalNode OPEN_CURLY_BRACE() { return getToken(langParser.OPEN_CURLY_BRACE, 0); }
		public TerminalNode CLOSE_CURLY_BRACE() { return getToken(langParser.CLOSE_CURLY_BRACE, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			((BlockContext)_localctx).OPEN_CURLY_BRACE = match(OPEN_CURLY_BRACE);
			 List<Node> commands = new ArrayList<Node>(); 
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << ITERATE) | (1L << RETURN) | (1L << PRINT) | (1L << READ) | (1L << ID) | (1L << OPEN_CURLY_BRACE))) != 0)) {
				{
				{
				setState(92);
				((BlockContext)_localctx).cmd = cmd();
				 commands.add(((BlockContext)_localctx).cmd.ast); 
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(CLOSE_CURLY_BRACE);

			      Node[] commandsArray = new Node[commands.size()];
			      commandsArray = commands.toArray(commandsArray);

			      ((BlockContext)_localctx).ast =  new Block(commandsArray, (((BlockContext)_localctx).OPEN_CURLY_BRACE!=null?((BlockContext)_localctx).OPEN_CURLY_BRACE.getLine():0), (((BlockContext)_localctx).OPEN_CURLY_BRACE!=null?((BlockContext)_localctx).OPEN_CURLY_BRACE.getCharPositionInLine():0));
			    
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
		enterRule(_localctx, 12, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			((ParamsContext)_localctx).id1 = match(ID);
			setState(104);
			match(DOUBLE_COLON);
			 List<Parameter> parameters = new ArrayList<Parameter>(); 
			setState(106);
			((ParamsContext)_localctx).type1 = type(0);
			 parameters.add(new Parameter((((ParamsContext)_localctx).id1!=null?((ParamsContext)_localctx).id1.getText():null), ((ParamsContext)_localctx).type1.ast, (((ParamsContext)_localctx).id1!=null?((ParamsContext)_localctx).id1.getLine():0), (((ParamsContext)_localctx).id1!=null?((ParamsContext)_localctx).id1.getCharPositionInLine():0))); 
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(108);
				match(COMMA);
				setState(109);
				((ParamsContext)_localctx).id2 = match(ID);
				setState(110);
				match(DOUBLE_COLON);
				setState(111);
				((ParamsContext)_localctx).type2 = type(0);
				 parameters.add(new Parameter((((ParamsContext)_localctx).id2!=null?((ParamsContext)_localctx).id2.getText():null), ((ParamsContext)_localctx).type2.ast, (((ParamsContext)_localctx).id2!=null?((ParamsContext)_localctx).id2.getLine():0), (((ParamsContext)_localctx).id2!=null?((ParamsContext)_localctx).id2.getCharPositionInLine():0))); 
				}
				}
				setState(118);
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
		public TypeContext type1;
		public BTypeContext bType;
		public Token OPEN_BRACKET;
		public BTypeContext bType() {
			return getRuleContext(BTypeContext.class,0);
		}
		public TerminalNode OPEN_BRACKET() { return getToken(langParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(langParser.CLOSE_BRACKET, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(122);
			((TypeContext)_localctx).bType = bType();
			 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).bType.ast; 
			}
			_ctx.stop = _input.LT(-1);
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.type1 = _prevctx;
					_localctx.type1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(125);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(126);
					((TypeContext)_localctx).OPEN_BRACKET = match(OPEN_BRACKET);
					setState(127);
					match(CLOSE_BRACKET);
					 ((TypeContext)_localctx).ast =  new ArrayType(((TypeContext)_localctx).type1.ast, (((TypeContext)_localctx).OPEN_BRACKET!=null?((TypeContext)_localctx).OPEN_BRACKET.getLine():0), (((TypeContext)_localctx).OPEN_BRACKET!=null?((TypeContext)_localctx).OPEN_BRACKET.getCharPositionInLine():0)); 
					}
					} 
				}
				setState(133);
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
		enterRule(_localctx, 16, RULE_bType);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				((BTypeContext)_localctx).TYPE_INT = match(TYPE_INT);
				 ((BTypeContext)_localctx).ast =  new IntType((((BTypeContext)_localctx).TYPE_INT!=null?((BTypeContext)_localctx).TYPE_INT.getLine():0), (((BTypeContext)_localctx).TYPE_INT!=null?((BTypeContext)_localctx).TYPE_INT.getCharPositionInLine():0)); 
				}
				break;
			case TYPE_CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				((BTypeContext)_localctx).TYPE_CHAR = match(TYPE_CHAR);
				 ((BTypeContext)_localctx).ast =  new CharType((((BTypeContext)_localctx).TYPE_CHAR!=null?((BTypeContext)_localctx).TYPE_CHAR.getLine():0), (((BTypeContext)_localctx).TYPE_CHAR!=null?((BTypeContext)_localctx).TYPE_CHAR.getCharPositionInLine():0)); 
				}
				break;
			case TYPE_BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				((BTypeContext)_localctx).TYPE_BOOL = match(TYPE_BOOL);
				 ((BTypeContext)_localctx).ast =  new BoolType((((BTypeContext)_localctx).TYPE_BOOL!=null?((BTypeContext)_localctx).TYPE_BOOL.getLine():0), (((BTypeContext)_localctx).TYPE_BOOL!=null?((BTypeContext)_localctx).TYPE_BOOL.getCharPositionInLine():0)); 
				}
				break;
			case TYPE_FLOAT:
				enterOuterAlt(_localctx, 4);
				{
				setState(140);
				((BTypeContext)_localctx).TYPE_FLOAT = match(TYPE_FLOAT);
				 ((BTypeContext)_localctx).ast =  new FloatType((((BTypeContext)_localctx).TYPE_FLOAT!=null?((BTypeContext)_localctx).TYPE_FLOAT.getLine():0), (((BTypeContext)_localctx).TYPE_FLOAT!=null?((BTypeContext)_localctx).TYPE_FLOAT.getCharPositionInLine():0)); 
				}
				break;
			case TYPE_NAME:
				enterOuterAlt(_localctx, 5);
				{
				setState(142);
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
		public BlockContext block;
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
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
		enterRule(_localctx, 18, RULE_cmd);
		int _la;
		try {
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				((CmdContext)_localctx).block = block();
				 ((CmdContext)_localctx).ast =  ((CmdContext)_localctx).block.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				((CmdContext)_localctx).IF = match(IF);
				setState(150);
				match(OPEN_PARENTHESIS);
				setState(151);
				((CmdContext)_localctx).condition = exp(0);
				setState(152);
				match(CLOSE_PARENTHESIS);
				setState(153);
				((CmdContext)_localctx).then = cmd();
				 ((CmdContext)_localctx).ast =  new If(((CmdContext)_localctx).condition.ast, ((CmdContext)_localctx).then.ast, (((CmdContext)_localctx).IF!=null?((CmdContext)_localctx).IF.getLine():0), (((CmdContext)_localctx).IF!=null?((CmdContext)_localctx).IF.getCharPositionInLine():0)); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				((CmdContext)_localctx).IF = match(IF);
				setState(157);
				match(OPEN_PARENTHESIS);
				setState(158);
				((CmdContext)_localctx).condition = ((CmdContext)_localctx).exp = exp(0);
				setState(159);
				match(CLOSE_PARENTHESIS);
				setState(160);
				((CmdContext)_localctx).then = cmd();
				setState(161);
				match(ELSE);
				setState(162);
				((CmdContext)_localctx).elseCmd = cmd();
				 ((CmdContext)_localctx).ast =  new If(((CmdContext)_localctx).exp.ast, ((CmdContext)_localctx).then.ast, ((CmdContext)_localctx).elseCmd.ast, (((CmdContext)_localctx).IF!=null?((CmdContext)_localctx).IF.getLine():0), (((CmdContext)_localctx).IF!=null?((CmdContext)_localctx).IF.getCharPositionInLine():0)); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				((CmdContext)_localctx).ITERATE = match(ITERATE);
				setState(166);
				match(OPEN_PARENTHESIS);
				setState(167);
				((CmdContext)_localctx).condition = exp(0);
				setState(168);
				match(CLOSE_PARENTHESIS);
				setState(169);
				((CmdContext)_localctx).body = cmd();
				 ((CmdContext)_localctx).ast =  new Iterate(((CmdContext)_localctx).condition.ast, ((CmdContext)_localctx).body.ast, (((CmdContext)_localctx).ITERATE!=null?((CmdContext)_localctx).ITERATE.getLine():0), (((CmdContext)_localctx).ITERATE!=null?((CmdContext)_localctx).ITERATE.getCharPositionInLine():0)); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
				((CmdContext)_localctx).READ = match(READ);
				setState(173);
				((CmdContext)_localctx).lvalue = lvalue(0);
				setState(174);
				match(SEMICOLON);
				 ((CmdContext)_localctx).ast =  new Read(((CmdContext)_localctx).lvalue.ast, (((CmdContext)_localctx).READ!=null?((CmdContext)_localctx).READ.getLine():0), (((CmdContext)_localctx).READ!=null?((CmdContext)_localctx).READ.getCharPositionInLine():0)); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(177);
				((CmdContext)_localctx).PRINT = match(PRINT);
				setState(178);
				((CmdContext)_localctx).exp = exp(0);
				setState(179);
				match(SEMICOLON);
				 ((CmdContext)_localctx).ast =  new Print(((CmdContext)_localctx).exp.ast, (((CmdContext)_localctx).PRINT!=null?((CmdContext)_localctx).PRINT.getLine():0), (((CmdContext)_localctx).PRINT!=null?((CmdContext)_localctx).PRINT.getCharPositionInLine():0)); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(182);
				((CmdContext)_localctx).RETURN = match(RETURN);
				 List<Expression> expList = new ArrayList<Expression>(); 
				setState(184);
				((CmdContext)_localctx).exp1 = exp(0);
				 expList.add(((CmdContext)_localctx).exp1.ast); 
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(186);
					match(COMMA);
					setState(187);
					((CmdContext)_localctx).exp2 = exp(0);
					 expList.add(((CmdContext)_localctx).exp2.ast); 
					}
					}
					setState(194);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(195);
				match(SEMICOLON);

				      Expression[] expressionsArray = new Expression[expList.size()];
				      expressionsArray = expList.toArray(expressionsArray);

				      ((CmdContext)_localctx).ast =  new Return(expressionsArray, (((CmdContext)_localctx).RETURN!=null?((CmdContext)_localctx).RETURN.getLine():0), (((CmdContext)_localctx).RETURN!=null?((CmdContext)_localctx).RETURN.getCharPositionInLine():0));
				    
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(198);
				((CmdContext)_localctx).lvalue = lvalue(0);
				setState(199);
				((CmdContext)_localctx).EQUAL = match(EQUAL);
				setState(200);
				((CmdContext)_localctx).exp = exp(0);
				setState(201);
				match(SEMICOLON);
				 ((CmdContext)_localctx).ast =  new Assignment(((CmdContext)_localctx).lvalue.ast, ((CmdContext)_localctx).exp.ast, (((CmdContext)_localctx).EQUAL!=null?((CmdContext)_localctx).EQUAL.getLine():0), (((CmdContext)_localctx).EQUAL!=null?((CmdContext)_localctx).EQUAL.getCharPositionInLine():0)); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(204);
				((CmdContext)_localctx).ID = match(ID);
				setState(205);
				match(OPEN_PARENTHESIS);
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FLOAT) | (1L << INT) | (1L << FALSE) | (1L << TRUE) | (1L << NULL) | (1L << NEW) | (1L << ID) | (1L << CHAR) | (1L << OPEN_PARENTHESIS) | (1L << MINUS) | (1L << NOT))) != 0)) {
					{
					setState(206);
					((CmdContext)_localctx).arguments = exps();
					}
				}

				setState(209);
				match(CLOSE_PARENTHESIS);
				 List<Variable> returnVariables = new ArrayList<Variable>(); 
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LESS_THAN) {
					{
					setState(211);
					match(LESS_THAN);
					setState(212);
					((CmdContext)_localctx).lvalue1 = lvalue(0);
					 returnVariables.add(((CmdContext)_localctx).lvalue1.ast); 
					setState(220);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(214);
						match(COMMA);
						setState(215);
						((CmdContext)_localctx).lvalue2 = lvalue(0);
						 returnVariables.add(((CmdContext)_localctx).lvalue2.ast); 
						}
						}
						setState(222);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(223);
					match(GREATER_THAN);
					}
				}

				setState(227);
				match(SEMICOLON);

				      Variable[] variablesArray = new Variable[returnVariables.size()];
				      variablesArray = returnVariables.toArray(variablesArray);

				      CmdContext context = (CmdContext)_localctx;
				      Expression[] argumentsArray = context.arguments != null ? ((CmdContext)_localctx).arguments.ast : new Expression[0];

				      ((CmdContext)_localctx).ast =  new Call((((CmdContext)_localctx).ID!=null?((CmdContext)_localctx).ID.getText():null), argumentsArray, variablesArray, (((CmdContext)_localctx).ID!=null?((CmdContext)_localctx).ID.getLine():0), (((CmdContext)_localctx).ID!=null?((CmdContext)_localctx).ID.getCharPositionInLine():0));
				    
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(232);
				((ExpContext)_localctx).lvalue = lvalue(0);
				 ((ExpContext)_localctx).ast =  ((ExpContext)_localctx).lvalue.ast; 
				}
				break;
			case 2:
				{
				setState(235);
				match(OPEN_PARENTHESIS);
				setState(236);
				((ExpContext)_localctx).exp = exp(0);
				setState(237);
				match(CLOSE_PARENTHESIS);
				 ((ExpContext)_localctx).ast =  ((ExpContext)_localctx).exp.ast; 
				}
				break;
			case 3:
				{
				setState(240);
				((ExpContext)_localctx).NOT = match(NOT);
				setState(241);
				((ExpContext)_localctx).exp = exp(19);
				 ((ExpContext)_localctx).ast =  new Not(((ExpContext)_localctx).exp.ast, (((ExpContext)_localctx).NOT!=null?((ExpContext)_localctx).NOT.getLine():0), (((ExpContext)_localctx).NOT!=null?((ExpContext)_localctx).NOT.getCharPositionInLine():0)); 
				}
				break;
			case 4:
				{
				setState(244);
				((ExpContext)_localctx).MINUS = match(MINUS);
				setState(245);
				((ExpContext)_localctx).exp = exp(18);
				 ((ExpContext)_localctx).ast =  new UnaryMinus(((ExpContext)_localctx).exp.ast, (((ExpContext)_localctx).MINUS!=null?((ExpContext)_localctx).MINUS.getLine():0), (((ExpContext)_localctx).MINUS!=null?((ExpContext)_localctx).MINUS.getCharPositionInLine():0)); 
				}
				break;
			case 5:
				{
				setState(248);
				((ExpContext)_localctx).FALSE = match(FALSE);
				 ((ExpContext)_localctx).ast =  new False((((ExpContext)_localctx).FALSE!=null?((ExpContext)_localctx).FALSE.getLine():0), (((ExpContext)_localctx).FALSE!=null?((ExpContext)_localctx).FALSE.getCharPositionInLine():0)); 
				}
				break;
			case 6:
				{
				setState(250);
				((ExpContext)_localctx).TRUE = match(TRUE);
				 ((ExpContext)_localctx).ast =  new True((((ExpContext)_localctx).TRUE!=null?((ExpContext)_localctx).TRUE.getLine():0), (((ExpContext)_localctx).TRUE!=null?((ExpContext)_localctx).TRUE.getCharPositionInLine():0)); 
				}
				break;
			case 7:
				{
				setState(252);
				((ExpContext)_localctx).NULL = match(NULL);
				 ((ExpContext)_localctx).ast =  new Null((((ExpContext)_localctx).NULL!=null?((ExpContext)_localctx).NULL.getLine():0), (((ExpContext)_localctx).NULL!=null?((ExpContext)_localctx).NULL.getCharPositionInLine():0)); 
				}
				break;
			case 8:
				{
				setState(254);
				((ExpContext)_localctx).INT = match(INT);
				 ((ExpContext)_localctx).ast =  new LiteralInt(Integer.parseInt((((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getText():null)), (((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getLine():0), (((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getCharPositionInLine():0)); 
				}
				break;
			case 9:
				{
				setState(256);
				((ExpContext)_localctx).FLOAT = match(FLOAT);
				 ((ExpContext)_localctx).ast =  new LiteralFloat(Float.parseFloat((((ExpContext)_localctx).FLOAT!=null?((ExpContext)_localctx).FLOAT.getText():null)), (((ExpContext)_localctx).FLOAT!=null?((ExpContext)_localctx).FLOAT.getLine():0), (((ExpContext)_localctx).FLOAT!=null?((ExpContext)_localctx).FLOAT.getCharPositionInLine():0)); 
				}
				break;
			case 10:
				{
				setState(258);
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
				setState(260);
				((ExpContext)_localctx).NEW = match(NEW);
				setState(261);
				((ExpContext)_localctx).type = type(0);
				setState(266);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(262);
					match(OPEN_BRACKET);
					setState(263);
					((ExpContext)_localctx).exp = exp(0);
					setState(264);
					match(CLOSE_BRACKET);
					}
					break;
				}

				      ExpContext context = (ExpContext)_localctx;
				      Expression expression = context.exp != null ? ((ExpContext)_localctx).exp.ast : null;

				      ((ExpContext)_localctx).ast =  new Instance(((ExpContext)_localctx).type.ast, expression, (((ExpContext)_localctx).NEW!=null?((ExpContext)_localctx).NEW.getLine():0), (((ExpContext)_localctx).NEW!=null?((ExpContext)_localctx).NEW.getCharPositionInLine():0));
				    
				}
				break;
			case 12:
				{
				setState(270);
				((ExpContext)_localctx).ID = match(ID);
				setState(271);
				match(OPEN_PARENTHESIS);
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FLOAT) | (1L << INT) | (1L << FALSE) | (1L << TRUE) | (1L << NULL) | (1L << NEW) | (1L << ID) | (1L << CHAR) | (1L << OPEN_PARENTHESIS) | (1L << MINUS) | (1L << NOT))) != 0)) {
					{
					setState(272);
					((ExpContext)_localctx).arguments = exps();
					}
				}

				setState(275);
				match(CLOSE_PARENTHESIS);
				setState(276);
				match(OPEN_BRACKET);
				setState(277);
				((ExpContext)_localctx).returnIndex = ((ExpContext)_localctx).exp = exp(0);
				setState(278);
				match(CLOSE_BRACKET);

				      ExpContext context = (ExpContext)_localctx;
				      Expression[] argumentsArray = context.arguments != null ? ((ExpContext)_localctx).arguments.ast : new Expression[0];

				      ((ExpContext)_localctx).ast =  new Call((((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null), argumentsArray, ((ExpContext)_localctx).returnIndex.ast, (((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getLine():0), (((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getCharPositionInLine():0));
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(330);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(328);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.expLeft = _prevctx;
						_localctx.expLeft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(283);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(284);
						((ExpContext)_localctx).TIMES = match(TIMES);
						setState(285);
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
						setState(288);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(289);
						((ExpContext)_localctx).DIVISION = match(DIVISION);
						setState(290);
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
						setState(293);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(294);
						((ExpContext)_localctx).MODULUS = match(MODULUS);
						setState(295);
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
						setState(298);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(299);
						((ExpContext)_localctx).PLUS = match(PLUS);
						setState(300);
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
						setState(303);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(304);
						((ExpContext)_localctx).MINUS = match(MINUS);
						setState(305);
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
						setState(308);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(309);
						((ExpContext)_localctx).LESS_THAN = match(LESS_THAN);
						setState(310);
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
						setState(313);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(314);
						((ExpContext)_localctx).COMPARISON = match(COMPARISON);
						setState(315);
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
						setState(318);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(319);
						((ExpContext)_localctx).NOT_EQUAL = match(NOT_EQUAL);
						setState(320);
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
						setState(323);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(324);
						((ExpContext)_localctx).AND = match(AND);
						setState(325);
						((ExpContext)_localctx).expRight = ((ExpContext)_localctx).exp = exp(10);
						 ((ExpContext)_localctx).ast =  new And(((ExpContext)_localctx).expLeft.ast, ((ExpContext)_localctx).expRight.ast, (((ExpContext)_localctx).AND!=null?((ExpContext)_localctx).AND.getLine():0), (((ExpContext)_localctx).AND!=null?((ExpContext)_localctx).AND.getCharPositionInLine():0)); 
						}
						break;
					}
					} 
				}
				setState(332);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_lvalue, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(334);
			((LvalueContext)_localctx).ID = match(ID);
			 ((LvalueContext)_localctx).ast =  new SimpleVariable((((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getText():null), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getLine():0), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getCharPositionInLine():0)); 
			}
			_ctx.stop = _input.LT(-1);
			setState(349);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(347);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						_localctx.lvalue1 = _prevctx;
						_localctx.lvalue1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(337);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(338);
						((LvalueContext)_localctx).OPEN_BRACKET = match(OPEN_BRACKET);
						setState(339);
						((LvalueContext)_localctx).exp = exp(0);
						setState(340);
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
						setState(343);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(344);
						((LvalueContext)_localctx).DOT = match(DOT);
						setState(345);
						((LvalueContext)_localctx).ID = match(ID);
						 ((LvalueContext)_localctx).ast =  new FieldAccess(((LvalueContext)_localctx).lvalue2.ast, (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getText():null), (((LvalueContext)_localctx).DOT!=null?((LvalueContext)_localctx).DOT.getLine():0), (((LvalueContext)_localctx).DOT!=null?((LvalueContext)_localctx).DOT.getCharPositionInLine():0)); 
						}
						break;
					}
					} 
				}
				setState(351);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		enterRule(_localctx, 24, RULE_exps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<Expression> expList = new ArrayList<Expression>(); 
			setState(353);
			((ExpsContext)_localctx).exp1 = exp(0);
			 expList.add(((ExpsContext)_localctx).exp1.ast); 
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(355);
				match(COMMA);
				setState(356);
				((ExpsContext)_localctx).exp2 = exp(0);
				 expList.add(((ExpsContext)_localctx).exp2.ast); 
				}
				}
				setState(363);
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
		case 7:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 10:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 11:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\62\u0171\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\7\2!\n\2\f\2\16\2$\13"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\7\4\67\n\4\f\4\16\4:\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\5\6H\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6S\n\6\f\6\16\6"+
		"V\13\6\5\6X\n\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7b\n\7\f\7\16\7e\13"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bu\n\b\f"+
		"\b\16\bx\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0084\n\t\f"+
		"\t\16\t\u0087\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0093\n"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\7\13\u00c1\n\13\f\13\16\13\u00c4\13\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00d2\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00dd\n\13\f\13\16\13\u00e0\13"+
		"\13\3\13\3\13\5\13\u00e4\n\13\3\13\3\13\5\13\u00e8\n\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u010d\n\f"+
		"\3\f\3\f\3\f\3\f\3\f\5\f\u0114\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u011c\n"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u014b\n\f\f\f\16\f\u014e"+
		"\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u015e"+
		"\n\r\f\r\16\r\u0161\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u016a"+
		"\n\16\f\16\16\16\u016d\13\16\3\16\3\16\3\16\2\5\20\26\30\17\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\2\2\2\u0195\2\34\3\2\2\2\4-\3\2\2\2\6/\3\2\2\2"+
		"\b>\3\2\2\2\nD\3\2\2\2\f\\\3\2\2\2\16i\3\2\2\2\20{\3\2\2\2\22\u0092\3"+
		"\2\2\2\24\u00e7\3\2\2\2\26\u011b\3\2\2\2\30\u014f\3\2\2\2\32\u0162\3\2"+
		"\2\2\34\"\b\2\1\2\35\36\5\4\3\2\36\37\b\2\1\2\37!\3\2\2\2 \35\3\2\2\2"+
		"!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#%\3\2\2\2$\"\3\2\2\2%&\b\2\1\2&\3\3\2"+
		"\2\2\'(\5\6\4\2()\b\3\1\2).\3\2\2\2*+\5\n\6\2+,\b\3\1\2,.\3\2\2\2-\'\3"+
		"\2\2\2-*\3\2\2\2.\5\3\2\2\2/\60\7\n\2\2\60\61\7\25\2\2\61\62\7\33\2\2"+
		"\628\b\4\1\2\63\64\5\b\5\2\64\65\b\4\1\2\65\67\3\2\2\2\66\63\3\2\2\2\67"+
		":\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7\34\2\2<=\b\4\1"+
		"\2=\7\3\2\2\2>?\7\20\2\2?@\7 \2\2@A\5\20\t\2AB\7\37\2\2BC\b\5\1\2C\t\3"+
		"\2\2\2DE\7\20\2\2EG\7\27\2\2FH\5\16\b\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2"+
		"IJ\7\30\2\2JW\b\6\1\2KL\7!\2\2LM\5\20\t\2MT\b\6\1\2NO\7#\2\2OP\5\20\t"+
		"\2PQ\b\6\1\2QS\3\2\2\2RN\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UX\3\2\2"+
		"\2VT\3\2\2\2WK\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\5\f\7\2Z[\b\6\1\2[\13\3\2"+
		"\2\2\\]\7\33\2\2]c\b\7\1\2^_\5\24\13\2_`\b\7\1\2`b\3\2\2\2a^\3\2\2\2b"+
		"e\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fg\7\34\2\2gh\b\7\1\2"+
		"h\r\3\2\2\2ij\7\20\2\2jk\7 \2\2kl\b\b\1\2lm\5\20\t\2mv\b\b\1\2no\7#\2"+
		"\2op\7\20\2\2pq\7 \2\2qr\5\20\t\2rs\b\b\1\2su\3\2\2\2tn\3\2\2\2ux\3\2"+
		"\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\b\b\1\2z\17\3\2\2\2{|\b"+
		"\t\1\2|}\5\22\n\2}~\b\t\1\2~\u0085\3\2\2\2\177\u0080\f\4\2\2\u0080\u0081"+
		"\7\31\2\2\u0081\u0082\7\32\2\2\u0082\u0084\b\t\1\2\u0083\177\3\2\2\2\u0084"+
		"\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\21\3\2\2"+
		"\2\u0087\u0085\3\2\2\2\u0088\u0089\7\21\2\2\u0089\u0093\b\n\1\2\u008a"+
		"\u008b\7\24\2\2\u008b\u0093\b\n\1\2\u008c\u008d\7\23\2\2\u008d\u0093\b"+
		"\n\1\2\u008e\u008f\7\22\2\2\u008f\u0093\b\n\1\2\u0090\u0091\7\25\2\2\u0091"+
		"\u0093\b\n\1\2\u0092\u0088\3\2\2\2\u0092\u008a\3\2\2\2\u0092\u008c\3\2"+
		"\2\2\u0092\u008e\3\2\2\2\u0092\u0090\3\2\2\2\u0093\23\3\2\2\2\u0094\u0095"+
		"\5\f\7\2\u0095\u0096\b\13\1\2\u0096\u00e8\3\2\2\2\u0097\u0098\7\b\2\2"+
		"\u0098\u0099\7\27\2\2\u0099\u009a\5\26\f\2\u009a\u009b\7\30\2\2\u009b"+
		"\u009c\5\24\13\2\u009c\u009d\b\13\1\2\u009d\u00e8\3\2\2\2\u009e\u009f"+
		"\7\b\2\2\u009f\u00a0\7\27\2\2\u00a0\u00a1\5\26\f\2\u00a1\u00a2\7\30\2"+
		"\2\u00a2\u00a3\5\24\13\2\u00a3\u00a4\7\t\2\2\u00a4\u00a5\5\24\13\2\u00a5"+
		"\u00a6\b\13\1\2\u00a6\u00e8\3\2\2\2\u00a7\u00a8\7\13\2\2\u00a8\u00a9\7"+
		"\27\2\2\u00a9\u00aa\5\26\f\2\u00aa\u00ab\7\30\2\2\u00ab\u00ac\5\24\13"+
		"\2\u00ac\u00ad\b\13\1\2\u00ad\u00e8\3\2\2\2\u00ae\u00af\7\16\2\2\u00af"+
		"\u00b0\5\30\r\2\u00b0\u00b1\7\37\2\2\u00b1\u00b2\b\13\1\2\u00b2\u00e8"+
		"\3\2\2\2\u00b3\u00b4\7\r\2\2\u00b4\u00b5\5\26\f\2\u00b5\u00b6\7\37\2\2"+
		"\u00b6\u00b7\b\13\1\2\u00b7\u00e8\3\2\2\2\u00b8\u00b9\7\f\2\2\u00b9\u00ba"+
		"\b\13\1\2\u00ba\u00bb\5\26\f\2\u00bb\u00c2\b\13\1\2\u00bc\u00bd\7#\2\2"+
		"\u00bd\u00be\5\26\f\2\u00be\u00bf\b\13\1\2\u00bf\u00c1\3\2\2\2\u00c0\u00bc"+
		"\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c5\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c6\7\37\2\2\u00c6\u00c7\b"+
		"\13\1\2\u00c7\u00e8\3\2\2\2\u00c8\u00c9\5\30\r\2\u00c9\u00ca\7%\2\2\u00ca"+
		"\u00cb\5\26\f\2\u00cb\u00cc\7\37\2\2\u00cc\u00cd\b\13\1\2\u00cd\u00e8"+
		"\3\2\2\2\u00ce\u00cf\7\20\2\2\u00cf\u00d1\7\27\2\2\u00d0\u00d2\5\32\16"+
		"\2\u00d1\u00d0\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4"+
		"\7\30\2\2\u00d4\u00e3\b\13\1\2\u00d5\u00d6\7\36\2\2\u00d6\u00d7\5\30\r"+
		"\2\u00d7\u00de\b\13\1\2\u00d8\u00d9\7#\2\2\u00d9\u00da\5\30\r\2\u00da"+
		"\u00db\b\13\1\2\u00db\u00dd\3\2\2\2\u00dc\u00d8\3\2\2\2\u00dd\u00e0\3"+
		"\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e1\u00e2\7\35\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00d5\3"+
		"\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\7\37\2\2\u00e6"+
		"\u00e8\b\13\1\2\u00e7\u0094\3\2\2\2\u00e7\u0097\3\2\2\2\u00e7\u009e\3"+
		"\2\2\2\u00e7\u00a7\3\2\2\2\u00e7\u00ae\3\2\2\2\u00e7\u00b3\3\2\2\2\u00e7"+
		"\u00b8\3\2\2\2\u00e7\u00c8\3\2\2\2\u00e7\u00ce\3\2\2\2\u00e8\25\3\2\2"+
		"\2\u00e9\u00ea\b\f\1\2\u00ea\u00eb\5\30\r\2\u00eb\u00ec\b\f\1\2\u00ec"+
		"\u011c\3\2\2\2\u00ed\u00ee\7\27\2\2\u00ee\u00ef\5\26\f\2\u00ef\u00f0\7"+
		"\30\2\2\u00f0\u00f1\b\f\1\2\u00f1\u011c\3\2\2\2\u00f2\u00f3\7-\2\2\u00f3"+
		"\u00f4\5\26\f\25\u00f4\u00f5\b\f\1\2\u00f5\u011c\3\2\2\2\u00f6\u00f7\7"+
		"(\2\2\u00f7\u00f8\5\26\f\24\u00f8\u00f9\b\f\1\2\u00f9\u011c\3\2\2\2\u00fa"+
		"\u00fb\7\5\2\2\u00fb\u011c\b\f\1\2\u00fc\u00fd\7\6\2\2\u00fd\u011c\b\f"+
		"\1\2\u00fe\u00ff\7\7\2\2\u00ff\u011c\b\f\1\2\u0100\u0101\7\4\2\2\u0101"+
		"\u011c\b\f\1\2\u0102\u0103\7\3\2\2\u0103\u011c\b\f\1\2\u0104\u0105\7\26"+
		"\2\2\u0105\u011c\b\f\1\2\u0106\u0107\7\17\2\2\u0107\u010c\5\20\t\2\u0108"+
		"\u0109\7\31\2\2\u0109\u010a\5\26\f\2\u010a\u010b\7\32\2\2\u010b\u010d"+
		"\3\2\2\2\u010c\u0108\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u010f\b\f\1\2\u010f\u011c\3\2\2\2\u0110\u0111\7\20\2\2\u0111\u0113\7"+
		"\27\2\2\u0112\u0114\5\32\16\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2"+
		"\u0114\u0115\3\2\2\2\u0115\u0116\7\30\2\2\u0116\u0117\7\31\2\2\u0117\u0118"+
		"\5\26\f\2\u0118\u0119\7\32\2\2\u0119\u011a\b\f\1\2\u011a\u011c\3\2\2\2"+
		"\u011b\u00e9\3\2\2\2\u011b\u00ed\3\2\2\2\u011b\u00f2\3\2\2\2\u011b\u00f6"+
		"\3\2\2\2\u011b\u00fa\3\2\2\2\u011b\u00fc\3\2\2\2\u011b\u00fe\3\2\2\2\u011b"+
		"\u0100\3\2\2\2\u011b\u0102\3\2\2\2\u011b\u0104\3\2\2\2\u011b\u0106\3\2"+
		"\2\2\u011b\u0110\3\2\2\2\u011c\u014c\3\2\2\2\u011d\u011e\f\23\2\2\u011e"+
		"\u011f\7)\2\2\u011f\u0120\5\26\f\24\u0120\u0121\b\f\1\2\u0121\u014b\3"+
		"\2\2\2\u0122\u0123\f\22\2\2\u0123\u0124\7*\2\2\u0124\u0125\5\26\f\23\u0125"+
		"\u0126\b\f\1\2\u0126\u014b\3\2\2\2\u0127\u0128\f\21\2\2\u0128\u0129\7"+
		"+\2\2\u0129\u012a\5\26\f\22\u012a\u012b\b\f\1\2\u012b\u014b\3\2\2\2\u012c"+
		"\u012d\f\20\2\2\u012d\u012e\7\'\2\2\u012e\u012f\5\26\f\21\u012f\u0130"+
		"\b\f\1\2\u0130\u014b\3\2\2\2\u0131\u0132\f\17\2\2\u0132\u0133\7(\2\2\u0133"+
		"\u0134\5\26\f\20\u0134\u0135\b\f\1\2\u0135\u014b\3\2\2\2\u0136\u0137\f"+
		"\16\2\2\u0137\u0138\7\36\2\2\u0138\u0139\5\26\f\17\u0139\u013a\b\f\1\2"+
		"\u013a\u014b\3\2\2\2\u013b\u013c\f\r\2\2\u013c\u013d\7$\2\2\u013d\u013e"+
		"\5\26\f\16\u013e\u013f\b\f\1\2\u013f\u014b\3\2\2\2\u0140\u0141\f\f\2\2"+
		"\u0141\u0142\7&\2\2\u0142\u0143\5\26\f\r\u0143\u0144\b\f\1\2\u0144\u014b"+
		"\3\2\2\2\u0145\u0146\f\13\2\2\u0146\u0147\7,\2\2\u0147\u0148\5\26\f\f"+
		"\u0148\u0149\b\f\1\2\u0149\u014b\3\2\2\2\u014a\u011d\3\2\2\2\u014a\u0122"+
		"\3\2\2\2\u014a\u0127\3\2\2\2\u014a\u012c\3\2\2\2\u014a\u0131\3\2\2\2\u014a"+
		"\u0136\3\2\2\2\u014a\u013b\3\2\2\2\u014a\u0140\3\2\2\2\u014a\u0145\3\2"+
		"\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d"+
		"\27\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150\b\r\1\2\u0150\u0151\7\20\2"+
		"\2\u0151\u0152\b\r\1\2\u0152\u015f\3\2\2\2\u0153\u0154\f\4\2\2\u0154\u0155"+
		"\7\31\2\2\u0155\u0156\5\26\f\2\u0156\u0157\7\32\2\2\u0157\u0158\b\r\1"+
		"\2\u0158\u015e\3\2\2\2\u0159\u015a\f\3\2\2\u015a\u015b\7\"\2\2\u015b\u015c"+
		"\7\20\2\2\u015c\u015e\b\r\1\2\u015d\u0153\3\2\2\2\u015d\u0159\3\2\2\2"+
		"\u015e\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\31"+
		"\3\2\2\2\u0161\u015f\3\2\2\2\u0162\u0163\b\16\1\2\u0163\u0164\5\26\f\2"+
		"\u0164\u016b\b\16\1\2\u0165\u0166\7#\2\2\u0166\u0167\5\26\f\2\u0167\u0168"+
		"\b\16\1\2\u0168\u016a\3\2\2\2\u0169\u0165\3\2\2\2\u016a\u016d\3\2\2\2"+
		"\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016e\3\2\2\2\u016d\u016b"+
		"\3\2\2\2\u016e\u016f\b\16\1\2\u016f\33\3\2\2\2\31\"-8GTWcv\u0085\u0092"+
		"\u00c2\u00d1\u00de\u00e3\u00e7\u010c\u0113\u011b\u014a\u014c\u015d\u015f"+
		"\u016b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}