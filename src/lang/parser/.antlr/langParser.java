// Generated from /home/gfrasson/projects/ufjf/08periodo/compiladores/lang-compiler/src/lang/parser/lang.g4 by ANTLR 4.13.1

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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33578560L) != 0)) {
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9070974099518L) != 0)) {
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

	@SuppressWarnings("CheckReturnValue")
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
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9070974099518L) != 0)) {
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

	@SuppressWarnings("CheckReturnValue")
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
		"\u0004\u00010\u016f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"\u001f\b\u0000\n\u0000\f\u0000\"\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001,\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u00025\b\u0002\n\u0002\f\u00028\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004F\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004Q\b\u0004\n\u0004\f\u0004T\t\u0004\u0003\u0004V\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005`\b\u0005\n\u0005\f\u0005c\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006s\b\u0006\n\u0006\f\u0006v\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0082\b\u0007\n\u0007"+
		"\f\u0007\u0085\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0091\b\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00bf\b\t\n\t\f\t\u00c2"+
		"\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t\u00d0\b\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00db\b\t\n\t\f\t\u00de"+
		"\t\t\u0001\t\u0001\t\u0003\t\u00e2\b\t\u0001\t\u0001\t\u0003\t\u00e6\b"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u010b\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0112\b\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u011a\b\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u0149\b\n\n\n\f\n\u014c\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u015c"+
		"\b\u000b\n\u000b\f\u000b\u015f\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0005\f\u0168\b\f\n\f\f\f\u016b\t\f\u0001\f\u0001"+
		"\f\u0001\f\u0000\u0003\u000e\u0014\u0016\r\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0000\u0193\u0000\u001a\u0001"+
		"\u0000\u0000\u0000\u0002+\u0001\u0000\u0000\u0000\u0004-\u0001\u0000\u0000"+
		"\u0000\u0006<\u0001\u0000\u0000\u0000\bB\u0001\u0000\u0000\u0000\nZ\u0001"+
		"\u0000\u0000\u0000\fg\u0001\u0000\u0000\u0000\u000ey\u0001\u0000\u0000"+
		"\u0000\u0010\u0090\u0001\u0000\u0000\u0000\u0012\u00e5\u0001\u0000\u0000"+
		"\u0000\u0014\u0119\u0001\u0000\u0000\u0000\u0016\u014d\u0001\u0000\u0000"+
		"\u0000\u0018\u0160\u0001\u0000\u0000\u0000\u001a \u0006\u0000\uffff\uffff"+
		"\u0000\u001b\u001c\u0003\u0002\u0001\u0000\u001c\u001d\u0006\u0000\uffff"+
		"\uffff\u0000\u001d\u001f\u0001\u0000\u0000\u0000\u001e\u001b\u0001\u0000"+
		"\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000"+
		"\u0000 !\u0001\u0000\u0000\u0000!#\u0001\u0000\u0000\u0000\" \u0001\u0000"+
		"\u0000\u0000#$\u0006\u0000\uffff\uffff\u0000$\u0001\u0001\u0000\u0000"+
		"\u0000%&\u0003\u0004\u0002\u0000&\'\u0006\u0001\uffff\uffff\u0000\',\u0001"+
		"\u0000\u0000\u0000()\u0003\b\u0004\u0000)*\u0006\u0001\uffff\uffff\u0000"+
		"*,\u0001\u0000\u0000\u0000+%\u0001\u0000\u0000\u0000+(\u0001\u0000\u0000"+
		"\u0000,\u0003\u0001\u0000\u0000\u0000-.\u0005\b\u0000\u0000./\u0005\u0013"+
		"\u0000\u0000/0\u0005\u0019\u0000\u000006\u0006\u0002\uffff\uffff\u0000"+
		"12\u0003\u0006\u0003\u000023\u0006\u0002\uffff\uffff\u000035\u0001\u0000"+
		"\u0000\u000041\u0001\u0000\u0000\u000058\u0001\u0000\u0000\u000064\u0001"+
		"\u0000\u0000\u000067\u0001\u0000\u0000\u000079\u0001\u0000\u0000\u0000"+
		"86\u0001\u0000\u0000\u00009:\u0005\u001a\u0000\u0000:;\u0006\u0002\uffff"+
		"\uffff\u0000;\u0005\u0001\u0000\u0000\u0000<=\u0005\u000e\u0000\u0000"+
		"=>\u0005\u001e\u0000\u0000>?\u0003\u000e\u0007\u0000?@\u0005\u001d\u0000"+
		"\u0000@A\u0006\u0003\uffff\uffff\u0000A\u0007\u0001\u0000\u0000\u0000"+
		"BC\u0005\u000e\u0000\u0000CE\u0005\u0015\u0000\u0000DF\u0003\f\u0006\u0000"+
		"ED\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000"+
		"\u0000GH\u0005\u0016\u0000\u0000HU\u0006\u0004\uffff\uffff\u0000IJ\u0005"+
		"\u001f\u0000\u0000JK\u0003\u000e\u0007\u0000KR\u0006\u0004\uffff\uffff"+
		"\u0000LM\u0005!\u0000\u0000MN\u0003\u000e\u0007\u0000NO\u0006\u0004\uffff"+
		"\uffff\u0000OQ\u0001\u0000\u0000\u0000PL\u0001\u0000\u0000\u0000QT\u0001"+
		"\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000"+
		"SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000UI\u0001\u0000\u0000"+
		"\u0000UV\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0003\n\u0005"+
		"\u0000XY\u0006\u0004\uffff\uffff\u0000Y\t\u0001\u0000\u0000\u0000Z[\u0005"+
		"\u0019\u0000\u0000[a\u0006\u0005\uffff\uffff\u0000\\]\u0003\u0012\t\u0000"+
		"]^\u0006\u0005\uffff\uffff\u0000^`\u0001\u0000\u0000\u0000_\\\u0001\u0000"+
		"\u0000\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001"+
		"\u0000\u0000\u0000bd\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000"+
		"de\u0005\u001a\u0000\u0000ef\u0006\u0005\uffff\uffff\u0000f\u000b\u0001"+
		"\u0000\u0000\u0000gh\u0005\u000e\u0000\u0000hi\u0005\u001e\u0000\u0000"+
		"ij\u0006\u0006\uffff\uffff\u0000jk\u0003\u000e\u0007\u0000kt\u0006\u0006"+
		"\uffff\uffff\u0000lm\u0005!\u0000\u0000mn\u0005\u000e\u0000\u0000no\u0005"+
		"\u001e\u0000\u0000op\u0003\u000e\u0007\u0000pq\u0006\u0006\uffff\uffff"+
		"\u0000qs\u0001\u0000\u0000\u0000rl\u0001\u0000\u0000\u0000sv\u0001\u0000"+
		"\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uw\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000wx\u0006\u0006\uffff\uffff"+
		"\u0000x\r\u0001\u0000\u0000\u0000yz\u0006\u0007\uffff\uffff\u0000z{\u0003"+
		"\u0010\b\u0000{|\u0006\u0007\uffff\uffff\u0000|\u0083\u0001\u0000\u0000"+
		"\u0000}~\n\u0002\u0000\u0000~\u007f\u0005\u0017\u0000\u0000\u007f\u0080"+
		"\u0005\u0018\u0000\u0000\u0080\u0082\u0006\u0007\uffff\uffff\u0000\u0081"+
		"}\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u000f"+
		"\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0005\u000f\u0000\u0000\u0087\u0091\u0006\b\uffff\uffff\u0000\u0088\u0089"+
		"\u0005\u0012\u0000\u0000\u0089\u0091\u0006\b\uffff\uffff\u0000\u008a\u008b"+
		"\u0005\u0011\u0000\u0000\u008b\u0091\u0006\b\uffff\uffff\u0000\u008c\u008d"+
		"\u0005\u0010\u0000\u0000\u008d\u0091\u0006\b\uffff\uffff\u0000\u008e\u008f"+
		"\u0005\u0013\u0000\u0000\u008f\u0091\u0006\b\uffff\uffff\u0000\u0090\u0086"+
		"\u0001\u0000\u0000\u0000\u0090\u0088\u0001\u0000\u0000\u0000\u0090\u008a"+
		"\u0001\u0000\u0000\u0000\u0090\u008c\u0001\u0000\u0000\u0000\u0090\u008e"+
		"\u0001\u0000\u0000\u0000\u0091\u0011\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0003\n\u0005\u0000\u0093\u0094\u0006\t\uffff\uffff\u0000\u0094\u00e6"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0005\u0006\u0000\u0000\u0096\u0097"+
		"\u0005\u0015\u0000\u0000\u0097\u0098\u0003\u0014\n\u0000\u0098\u0099\u0005"+
		"\u0016\u0000\u0000\u0099\u009a\u0003\u0012\t\u0000\u009a\u009b\u0006\t"+
		"\uffff\uffff\u0000\u009b\u00e6\u0001\u0000\u0000\u0000\u009c\u009d\u0005"+
		"\u0006\u0000\u0000\u009d\u009e\u0005\u0015\u0000\u0000\u009e\u009f\u0003"+
		"\u0014\n\u0000\u009f\u00a0\u0005\u0016\u0000\u0000\u00a0\u00a1\u0003\u0012"+
		"\t\u0000\u00a1\u00a2\u0005\u0007\u0000\u0000\u00a2\u00a3\u0003\u0012\t"+
		"\u0000\u00a3\u00a4\u0006\t\uffff\uffff\u0000\u00a4\u00e6\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a6\u0005\t\u0000\u0000\u00a6\u00a7\u0005\u0015\u0000\u0000"+
		"\u00a7\u00a8\u0003\u0014\n\u0000\u00a8\u00a9\u0005\u0016\u0000\u0000\u00a9"+
		"\u00aa\u0003\u0012\t\u0000\u00aa\u00ab\u0006\t\uffff\uffff\u0000\u00ab"+
		"\u00e6\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005\f\u0000\u0000\u00ad\u00ae"+
		"\u0003\u0016\u000b\u0000\u00ae\u00af\u0005\u001d\u0000\u0000\u00af\u00b0"+
		"\u0006\t\uffff\uffff\u0000\u00b0\u00e6\u0001\u0000\u0000\u0000\u00b1\u00b2"+
		"\u0005\u000b\u0000\u0000\u00b2\u00b3\u0003\u0014\n\u0000\u00b3\u00b4\u0005"+
		"\u001d\u0000\u0000\u00b4\u00b5\u0006\t\uffff\uffff\u0000\u00b5\u00e6\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b7\u0005\n\u0000\u0000\u00b7\u00b8\u0006\t"+
		"\uffff\uffff\u0000\u00b8\u00b9\u0003\u0014\n\u0000\u00b9\u00c0\u0006\t"+
		"\uffff\uffff\u0000\u00ba\u00bb\u0005!\u0000\u0000\u00bb\u00bc\u0003\u0014"+
		"\n\u0000\u00bc\u00bd\u0006\t\uffff\uffff\u0000\u00bd\u00bf\u0001\u0000"+
		"\u0000\u0000\u00be\u00ba\u0001\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c3\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c4\u0005\u001d\u0000\u0000\u00c4\u00c5\u0006\t\uffff"+
		"\uffff\u0000\u00c5\u00e6\u0001\u0000\u0000\u0000\u00c6\u00c7\u0003\u0016"+
		"\u000b\u0000\u00c7\u00c8\u0005#\u0000\u0000\u00c8\u00c9\u0003\u0014\n"+
		"\u0000\u00c9\u00ca\u0005\u001d\u0000\u0000\u00ca\u00cb\u0006\t\uffff\uffff"+
		"\u0000\u00cb\u00e6\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005\u000e\u0000"+
		"\u0000\u00cd\u00cf\u0005\u0015\u0000\u0000\u00ce\u00d0\u0003\u0018\f\u0000"+
		"\u00cf\u00ce\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005\u0016\u0000\u0000"+
		"\u00d2\u00e1\u0006\t\uffff\uffff\u0000\u00d3\u00d4\u0005\u001c\u0000\u0000"+
		"\u00d4\u00d5\u0003\u0016\u000b\u0000\u00d5\u00dc\u0006\t\uffff\uffff\u0000"+
		"\u00d6\u00d7\u0005!\u0000\u0000\u00d7\u00d8\u0003\u0016\u000b\u0000\u00d8"+
		"\u00d9\u0006\t\uffff\uffff\u0000\u00d9\u00db\u0001\u0000\u0000\u0000\u00da"+
		"\u00d6\u0001\u0000\u0000\u0000\u00db\u00de\u0001\u0000\u0000\u0000\u00dc"+
		"\u00da\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd"+
		"\u00df\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0005\u001b\u0000\u0000\u00e0\u00e2\u0001\u0000\u0000\u0000\u00e1"+
		"\u00d3\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005\u001d\u0000\u0000\u00e4"+
		"\u00e6\u0006\t\uffff\uffff\u0000\u00e5\u0092\u0001\u0000\u0000\u0000\u00e5"+
		"\u0095\u0001\u0000\u0000\u0000\u00e5\u009c\u0001\u0000\u0000\u0000\u00e5"+
		"\u00a5\u0001\u0000\u0000\u0000\u00e5\u00ac\u0001\u0000\u0000\u0000\u00e5"+
		"\u00b1\u0001\u0000\u0000\u0000\u00e5\u00b6\u0001\u0000\u0000\u0000\u00e5"+
		"\u00c6\u0001\u0000\u0000\u0000\u00e5\u00cc\u0001\u0000\u0000\u0000\u00e6"+
		"\u0013\u0001\u0000\u0000\u0000\u00e7\u00e8\u0006\n\uffff\uffff\u0000\u00e8"+
		"\u00e9\u0003\u0016\u000b\u0000\u00e9\u00ea\u0006\n\uffff\uffff\u0000\u00ea"+
		"\u011a\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005\u0015\u0000\u0000\u00ec"+
		"\u00ed\u0003\u0014\n\u0000\u00ed\u00ee\u0005\u0016\u0000\u0000\u00ee\u00ef"+
		"\u0006\n\uffff\uffff\u0000\u00ef\u011a\u0001\u0000\u0000\u0000\u00f0\u00f1"+
		"\u0005+\u0000\u0000\u00f1\u00f2\u0003\u0014\n\u0013\u00f2\u00f3\u0006"+
		"\n\uffff\uffff\u0000\u00f3\u011a\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005"+
		"&\u0000\u0000\u00f5\u00f6\u0003\u0014\n\u0012\u00f6\u00f7\u0006\n\uffff"+
		"\uffff\u0000\u00f7\u011a\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005\u0003"+
		"\u0000\u0000\u00f9\u011a\u0006\n\uffff\uffff\u0000\u00fa\u00fb\u0005\u0004"+
		"\u0000\u0000\u00fb\u011a\u0006\n\uffff\uffff\u0000\u00fc\u00fd\u0005\u0005"+
		"\u0000\u0000\u00fd\u011a\u0006\n\uffff\uffff\u0000\u00fe\u00ff\u0005\u0002"+
		"\u0000\u0000\u00ff\u011a\u0006\n\uffff\uffff\u0000\u0100\u0101\u0005\u0001"+
		"\u0000\u0000\u0101\u011a\u0006\n\uffff\uffff\u0000\u0102\u0103\u0005\u0014"+
		"\u0000\u0000\u0103\u011a\u0006\n\uffff\uffff\u0000\u0104\u0105\u0005\r"+
		"\u0000\u0000\u0105\u010a\u0003\u000e\u0007\u0000\u0106\u0107\u0005\u0017"+
		"\u0000\u0000\u0107\u0108\u0003\u0014\n\u0000\u0108\u0109\u0005\u0018\u0000"+
		"\u0000\u0109\u010b\u0001\u0000\u0000\u0000\u010a\u0106\u0001\u0000\u0000"+
		"\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000"+
		"\u0000\u010c\u010d\u0006\n\uffff\uffff\u0000\u010d\u011a\u0001\u0000\u0000"+
		"\u0000\u010e\u010f\u0005\u000e\u0000\u0000\u010f\u0111\u0005\u0015\u0000"+
		"\u0000\u0110\u0112\u0003\u0018\f\u0000\u0111\u0110\u0001\u0000\u0000\u0000"+
		"\u0111\u0112\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000"+
		"\u0113\u0114\u0005\u0016\u0000\u0000\u0114\u0115\u0005\u0017\u0000\u0000"+
		"\u0115\u0116\u0003\u0014\n\u0000\u0116\u0117\u0005\u0018\u0000\u0000\u0117"+
		"\u0118\u0006\n\uffff\uffff\u0000\u0118\u011a\u0001\u0000\u0000\u0000\u0119"+
		"\u00e7\u0001\u0000\u0000\u0000\u0119\u00eb\u0001\u0000\u0000\u0000\u0119"+
		"\u00f0\u0001\u0000\u0000\u0000\u0119\u00f4\u0001\u0000\u0000\u0000\u0119"+
		"\u00f8\u0001\u0000\u0000\u0000\u0119\u00fa\u0001\u0000\u0000\u0000\u0119"+
		"\u00fc\u0001\u0000\u0000\u0000\u0119\u00fe\u0001\u0000\u0000\u0000\u0119"+
		"\u0100\u0001\u0000\u0000\u0000\u0119\u0102\u0001\u0000\u0000\u0000\u0119"+
		"\u0104\u0001\u0000\u0000\u0000\u0119\u010e\u0001\u0000\u0000\u0000\u011a"+
		"\u014a\u0001\u0000\u0000\u0000\u011b\u011c\n\u0011\u0000\u0000\u011c\u011d"+
		"\u0005\'\u0000\u0000\u011d\u011e\u0003\u0014\n\u0012\u011e\u011f\u0006"+
		"\n\uffff\uffff\u0000\u011f\u0149\u0001\u0000\u0000\u0000\u0120\u0121\n"+
		"\u0010\u0000\u0000\u0121\u0122\u0005(\u0000\u0000\u0122\u0123\u0003\u0014"+
		"\n\u0011\u0123\u0124\u0006\n\uffff\uffff\u0000\u0124\u0149\u0001\u0000"+
		"\u0000\u0000\u0125\u0126\n\u000f\u0000\u0000\u0126\u0127\u0005)\u0000"+
		"\u0000\u0127\u0128\u0003\u0014\n\u0010\u0128\u0129\u0006\n\uffff\uffff"+
		"\u0000\u0129\u0149\u0001\u0000\u0000\u0000\u012a\u012b\n\u000e\u0000\u0000"+
		"\u012b\u012c\u0005%\u0000\u0000\u012c\u012d\u0003\u0014\n\u000f\u012d"+
		"\u012e\u0006\n\uffff\uffff\u0000\u012e\u0149\u0001\u0000\u0000\u0000\u012f"+
		"\u0130\n\r\u0000\u0000\u0130\u0131\u0005&\u0000\u0000\u0131\u0132\u0003"+
		"\u0014\n\u000e\u0132\u0133\u0006\n\uffff\uffff\u0000\u0133\u0149\u0001"+
		"\u0000\u0000\u0000\u0134\u0135\n\f\u0000\u0000\u0135\u0136\u0005\u001c"+
		"\u0000\u0000\u0136\u0137\u0003\u0014\n\r\u0137\u0138\u0006\n\uffff\uffff"+
		"\u0000\u0138\u0149\u0001\u0000\u0000\u0000\u0139\u013a\n\u000b\u0000\u0000"+
		"\u013a\u013b\u0005\"\u0000\u0000\u013b\u013c\u0003\u0014\n\f\u013c\u013d"+
		"\u0006\n\uffff\uffff\u0000\u013d\u0149\u0001\u0000\u0000\u0000\u013e\u013f"+
		"\n\n\u0000\u0000\u013f\u0140\u0005$\u0000\u0000\u0140\u0141\u0003\u0014"+
		"\n\u000b\u0141\u0142\u0006\n\uffff\uffff\u0000\u0142\u0149\u0001\u0000"+
		"\u0000\u0000\u0143\u0144\n\t\u0000\u0000\u0144\u0145\u0005*\u0000\u0000"+
		"\u0145\u0146\u0003\u0014\n\n\u0146\u0147\u0006\n\uffff\uffff\u0000\u0147"+
		"\u0149\u0001\u0000\u0000\u0000\u0148\u011b\u0001\u0000\u0000\u0000\u0148"+
		"\u0120\u0001\u0000\u0000\u0000\u0148\u0125\u0001\u0000\u0000\u0000\u0148"+
		"\u012a\u0001\u0000\u0000\u0000\u0148\u012f\u0001\u0000\u0000\u0000\u0148"+
		"\u0134\u0001\u0000\u0000\u0000\u0148\u0139\u0001\u0000\u0000\u0000\u0148"+
		"\u013e\u0001\u0000\u0000\u0000\u0148\u0143\u0001\u0000\u0000\u0000\u0149"+
		"\u014c\u0001\u0000\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014a"+
		"\u014b\u0001\u0000\u0000\u0000\u014b\u0015\u0001\u0000\u0000\u0000\u014c"+
		"\u014a\u0001\u0000\u0000\u0000\u014d\u014e\u0006\u000b\uffff\uffff\u0000"+
		"\u014e\u014f\u0005\u000e\u0000\u0000\u014f\u0150\u0006\u000b\uffff\uffff"+
		"\u0000\u0150\u015d\u0001\u0000\u0000\u0000\u0151\u0152\n\u0002\u0000\u0000"+
		"\u0152\u0153\u0005\u0017\u0000\u0000\u0153\u0154\u0003\u0014\n\u0000\u0154"+
		"\u0155\u0005\u0018\u0000\u0000\u0155\u0156\u0006\u000b\uffff\uffff\u0000"+
		"\u0156\u015c\u0001\u0000\u0000\u0000\u0157\u0158\n\u0001\u0000\u0000\u0158"+
		"\u0159\u0005 \u0000\u0000\u0159\u015a\u0005\u000e\u0000\u0000\u015a\u015c"+
		"\u0006\u000b\uffff\uffff\u0000\u015b\u0151\u0001\u0000\u0000\u0000\u015b"+
		"\u0157\u0001\u0000\u0000\u0000\u015c\u015f\u0001\u0000\u0000\u0000\u015d"+
		"\u015b\u0001\u0000\u0000\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015e"+
		"\u0017\u0001\u0000\u0000\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u0160"+
		"\u0161\u0006\f\uffff\uffff\u0000\u0161\u0162\u0003\u0014\n\u0000\u0162"+
		"\u0169\u0006\f\uffff\uffff\u0000\u0163\u0164\u0005!\u0000\u0000\u0164"+
		"\u0165\u0003\u0014\n\u0000\u0165\u0166\u0006\f\uffff\uffff\u0000\u0166"+
		"\u0168\u0001\u0000\u0000\u0000\u0167\u0163\u0001\u0000\u0000\u0000\u0168"+
		"\u016b\u0001\u0000\u0000\u0000\u0169\u0167\u0001\u0000\u0000\u0000\u0169"+
		"\u016a\u0001\u0000\u0000\u0000\u016a\u016c\u0001\u0000\u0000\u0000\u016b"+
		"\u0169\u0001\u0000\u0000\u0000\u016c\u016d\u0006\f\uffff\uffff\u0000\u016d"+
		"\u0019\u0001\u0000\u0000\u0000\u0017 +6ERUat\u0083\u0090\u00c0\u00cf\u00dc"+
		"\u00e1\u00e5\u010a\u0111\u0119\u0148\u014a\u015b\u015d\u0169";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}