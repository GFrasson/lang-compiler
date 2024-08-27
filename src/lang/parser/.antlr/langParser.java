// Generated from /home/gfrasson/projects/ufjf/08periodo/compiladores/lang-compiler/src/parser/lang.g4 by ANTLR 4.13.1

  package parser;

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
		FLOAT=1, INT=2, BOOLEAN=3, NULL=4, IF=5, ELSE=6, DATA=7, ITERATE=8, RETURN=9, 
		PRINT=10, READ=11, NEW=12, ID=13, TYPE_NAME=14, CHAR=15, OPEN_PARENTHESIS=16, 
		CLOSE_PARENTHESIS=17, OPEN_BRACKET=18, CLOSE_BRACKET=19, OPEN_CURLY_BRACE=20, 
		CLOSE_CURLY_BRACE=21, GREATER_THAN=22, LESS_THAN=23, SEMICOLON=24, DOUBLE_COLON=25, 
		COLON=26, DOT=27, COMMA=28, COMPARISON=29, EQUAL=30, NOT_EQUAL=31, PLUS=32, 
		MINUS=33, TIMES=34, DIVISION=35, MODULUS=36, AND=37, NOT=38, NEWLINE=39, 
		WHITESPACE=40, LINE_COMMENT=41, COMMENT=42;
	public static final int
		RULE_prog = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'null'", "'if'", "'else'", "'data'", "'iterate'", 
			"'return'", "'print'", "'read'", "'new'", null, null, null, "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "'>'", "'<'", "';'", "'::'", "':'", "'.'", 
			"','", "'=='", "'='", "'!='", "'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", 
			"'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FLOAT", "INT", "BOOLEAN", "NULL", "IF", "ELSE", "DATA", "ITERATE", 
			"RETURN", "PRINT", "READ", "NEW", "ID", "TYPE_NAME", "CHAR", "OPEN_PARENTHESIS", 
			"CLOSE_PARENTHESIS", "OPEN_BRACKET", "CLOSE_BRACKET", "OPEN_CURLY_BRACE", 
			"CLOSE_CURLY_BRACE", "GREATER_THAN", "LESS_THAN", "SEMICOLON", "DOUBLE_COLON", 
			"COLON", "DOT", "COMMA", "COMPARISON", "EQUAL", "NOT_EQUAL", "PLUS", 
			"MINUS", "TIMES", "DIVISION", "MODULUS", "AND", "NOT", "NEWLINE", "WHITESPACE", 
			"LINE_COMMENT", "COMMENT"
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
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2);
			match(ID);
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

	public static final String _serializedATN =
		"\u0004\u0001*\u0005\u0002\u0000\u0007\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0000\u0000\u0001\u0000\u0000\u0000\u0003\u0000\u0002\u0001\u0000"+
		"\u0000\u0000\u0002\u0003\u0005\r\u0000\u0000\u0003\u0001\u0001\u0000\u0000"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}