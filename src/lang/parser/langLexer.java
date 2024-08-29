// Generated from src/lang/parser/lang.g4 by ANTLR 4.8

  package lang.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class langLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FLOAT", "INT", "FALSE", "TRUE", "NULL", "IF", "ELSE", "DATA", "ITERATE", 
			"RETURN", "PRINT", "READ", "NEW", "ID", "TYPE_INT", "TYPE_FLOAT", "TYPE_BOOL", 
			"TYPE_CHAR", "TYPE_NAME", "CHAR", "OPEN_PARENTHESIS", "CLOSE_PARENTHESIS", 
			"OPEN_BRACKET", "CLOSE_BRACKET", "OPEN_CURLY_BRACE", "CLOSE_CURLY_BRACE", 
			"GREATER_THAN", "LESS_THAN", "SEMICOLON", "DOUBLE_COLON", "COLON", "DOT", 
			"COMMA", "COMPARISON", "EQUAL", "NOT_EQUAL", "PLUS", "MINUS", "TIMES", 
			"DIVISION", "MODULUS", "AND", "NOT", "NEWLINE", "WHITESPACE", "LINE_COMMENT", 
			"COMMENT"
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


	public langLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u013f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\7\2c\n\2\f\2\16\2f\13\2\3\2\3"+
		"\2\3\2\7\2k\n\2\f\2\16\2n\13\2\3\3\3\3\7\3r\n\3\f\3\16\3u\13\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\7\17\u00b4\n\17\f\17\16\17\u00b7"+
		"\13\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\7\24\u00cf\n\24\f\24\16"+
		"\24\u00d2\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u00e2\n\25\5\25\u00e4\n\25\3\25\3\25\3\26\3\26\3"+
		"\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3"+
		"\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3%\3"+
		"&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,\3-\5-\u011b\n-\3-\3-\3-"+
		"\3-\3.\6.\u0122\n.\r.\16.\u0123\3.\3.\3/\3/\3/\7/\u012b\n/\f/\16/\u012e"+
		"\13/\3/\3/\3\60\3\60\3\60\3\60\7\60\u0136\n\60\f\60\16\60\u0139\13\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\u0137\2\61\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61\3\2\t\3\2\62;\3\2c|\6\2\62;C\\aac|\3\2C\\\4\2))^^\5\2\13\13"+
		"\16\16\"\"\4\2\f\f\17\17\2\u014d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\3d\3\2\2\2\5o\3\2\2\2\7v\3\2\2\2\t|\3\2\2\2"+
		"\13\u0081\3\2\2\2\r\u0086\3\2\2\2\17\u0089\3\2\2\2\21\u008e\3\2\2\2\23"+
		"\u0093\3\2\2\2\25\u009b\3\2\2\2\27\u00a2\3\2\2\2\31\u00a8\3\2\2\2\33\u00ad"+
		"\3\2\2\2\35\u00b1\3\2\2\2\37\u00b8\3\2\2\2!\u00bc\3\2\2\2#\u00c2\3\2\2"+
		"\2%\u00c7\3\2\2\2\'\u00cc\3\2\2\2)\u00d3\3\2\2\2+\u00e7\3\2\2\2-\u00e9"+
		"\3\2\2\2/\u00eb\3\2\2\2\61\u00ed\3\2\2\2\63\u00ef\3\2\2\2\65\u00f1\3\2"+
		"\2\2\67\u00f3\3\2\2\29\u00f5\3\2\2\2;\u00f7\3\2\2\2=\u00f9\3\2\2\2?\u00fc"+
		"\3\2\2\2A\u00fe\3\2\2\2C\u0100\3\2\2\2E\u0102\3\2\2\2G\u0105\3\2\2\2I"+
		"\u0107\3\2\2\2K\u010a\3\2\2\2M\u010c\3\2\2\2O\u010e\3\2\2\2Q\u0110\3\2"+
		"\2\2S\u0112\3\2\2\2U\u0114\3\2\2\2W\u0117\3\2\2\2Y\u011a\3\2\2\2[\u0121"+
		"\3\2\2\2]\u0127\3\2\2\2_\u0131\3\2\2\2ac\t\2\2\2ba\3\2\2\2cf\3\2\2\2d"+
		"b\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7\60\2\2hl\t\2\2\2ik\t\2\2\2"+
		"ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\4\3\2\2\2nl\3\2\2\2os\t\2\2"+
		"\2pr\t\2\2\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\6\3\2\2\2us\3\2"+
		"\2\2vw\7h\2\2wx\7c\2\2xy\7n\2\2yz\7u\2\2z{\7g\2\2{\b\3\2\2\2|}\7v\2\2"+
		"}~\7t\2\2~\177\7w\2\2\177\u0080\7g\2\2\u0080\n\3\2\2\2\u0081\u0082\7p"+
		"\2\2\u0082\u0083\7w\2\2\u0083\u0084\7n\2\2\u0084\u0085\7n\2\2\u0085\f"+
		"\3\2\2\2\u0086\u0087\7k\2\2\u0087\u0088\7h\2\2\u0088\16\3\2\2\2\u0089"+
		"\u008a\7g\2\2\u008a\u008b\7n\2\2\u008b\u008c\7u\2\2\u008c\u008d\7g\2\2"+
		"\u008d\20\3\2\2\2\u008e\u008f\7f\2\2\u008f\u0090\7c\2\2\u0090\u0091\7"+
		"v\2\2\u0091\u0092\7c\2\2\u0092\22\3\2\2\2\u0093\u0094\7k\2\2\u0094\u0095"+
		"\7v\2\2\u0095\u0096\7g\2\2\u0096\u0097\7t\2\2\u0097\u0098\7c\2\2\u0098"+
		"\u0099\7v\2\2\u0099\u009a\7g\2\2\u009a\24\3\2\2\2\u009b\u009c\7t\2\2\u009c"+
		"\u009d\7g\2\2\u009d\u009e\7v\2\2\u009e\u009f\7w\2\2\u009f\u00a0\7t\2\2"+
		"\u00a0\u00a1\7p\2\2\u00a1\26\3\2\2\2\u00a2\u00a3\7r\2\2\u00a3\u00a4\7"+
		"t\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7v\2\2\u00a7\30"+
		"\3\2\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7c\2\2\u00ab"+
		"\u00ac\7f\2\2\u00ac\32\3\2\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af\7g\2\2\u00af"+
		"\u00b0\7y\2\2\u00b0\34\3\2\2\2\u00b1\u00b5\t\3\2\2\u00b2\u00b4\t\4\2\2"+
		"\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b6\36\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7K\2\2\u00b9"+
		"\u00ba\7p\2\2\u00ba\u00bb\7v\2\2\u00bb \3\2\2\2\u00bc\u00bd\7H\2\2\u00bd"+
		"\u00be\7n\2\2\u00be\u00bf\7q\2\2\u00bf\u00c0\7c\2\2\u00c0\u00c1\7v\2\2"+
		"\u00c1\"\3\2\2\2\u00c2\u00c3\7D\2\2\u00c3\u00c4\7q\2\2\u00c4\u00c5\7q"+
		"\2\2\u00c5\u00c6\7n\2\2\u00c6$\3\2\2\2\u00c7\u00c8\7E\2\2\u00c8\u00c9"+
		"\7j\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb\7t\2\2\u00cb&\3\2\2\2\u00cc\u00d0"+
		"\t\5\2\2\u00cd\u00cf\t\4\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1(\3\2\2\2\u00d2\u00d0\3\2\2\2"+
		"\u00d3\u00e3\7)\2\2\u00d4\u00e4\n\6\2\2\u00d5\u00d6\7^\2\2\u00d6\u00e2"+
		"\7t\2\2\u00d7\u00d8\7^\2\2\u00d8\u00e2\7p\2\2\u00d9\u00da\7^\2\2\u00da"+
		"\u00e2\7v\2\2\u00db\u00dc\7^\2\2\u00dc\u00e2\7d\2\2\u00dd\u00de\7^\2\2"+
		"\u00de\u00e2\7^\2\2\u00df\u00e0\7^\2\2\u00e0\u00e2\7)\2\2\u00e1\u00d5"+
		"\3\2\2\2\u00e1\u00d7\3\2\2\2\u00e1\u00d9\3\2\2\2\u00e1\u00db\3\2\2\2\u00e1"+
		"\u00dd\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00d4\3\2"+
		"\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\7)\2\2\u00e6"+
		"*\3\2\2\2\u00e7\u00e8\7*\2\2\u00e8,\3\2\2\2\u00e9\u00ea\7+\2\2\u00ea."+
		"\3\2\2\2\u00eb\u00ec\7]\2\2\u00ec\60\3\2\2\2\u00ed\u00ee\7_\2\2\u00ee"+
		"\62\3\2\2\2\u00ef\u00f0\7}\2\2\u00f0\64\3\2\2\2\u00f1\u00f2\7\177\2\2"+
		"\u00f2\66\3\2\2\2\u00f3\u00f4\7@\2\2\u00f48\3\2\2\2\u00f5\u00f6\7>\2\2"+
		"\u00f6:\3\2\2\2\u00f7\u00f8\7=\2\2\u00f8<\3\2\2\2\u00f9\u00fa\7<\2\2\u00fa"+
		"\u00fb\7<\2\2\u00fb>\3\2\2\2\u00fc\u00fd\7<\2\2\u00fd@\3\2\2\2\u00fe\u00ff"+
		"\7\60\2\2\u00ffB\3\2\2\2\u0100\u0101\7.\2\2\u0101D\3\2\2\2\u0102\u0103"+
		"\7?\2\2\u0103\u0104\7?\2\2\u0104F\3\2\2\2\u0105\u0106\7?\2\2\u0106H\3"+
		"\2\2\2\u0107\u0108\7#\2\2\u0108\u0109\7?\2\2\u0109J\3\2\2\2\u010a\u010b"+
		"\7-\2\2\u010bL\3\2\2\2\u010c\u010d\7/\2\2\u010dN\3\2\2\2\u010e\u010f\7"+
		",\2\2\u010fP\3\2\2\2\u0110\u0111\7\61\2\2\u0111R\3\2\2\2\u0112\u0113\7"+
		"\'\2\2\u0113T\3\2\2\2\u0114\u0115\7(\2\2\u0115\u0116\7(\2\2\u0116V\3\2"+
		"\2\2\u0117\u0118\7#\2\2\u0118X\3\2\2\2\u0119\u011b\7\17\2\2\u011a\u0119"+
		"\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\7\f\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u011f\b-\2\2\u011fZ\3\2\2\2\u0120\u0122\t\7\2\2\u0121"+
		"\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124\u0125\3\2\2\2\u0125\u0126\b.\2\2\u0126\\\3\2\2\2\u0127\u0128"+
		"\7/\2\2\u0128\u012c\7/\2\2\u0129\u012b\n\b\2\2\u012a\u0129\3\2\2\2\u012b"+
		"\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012f\3\2"+
		"\2\2\u012e\u012c\3\2\2\2\u012f\u0130\5Y-\2\u0130^\3\2\2\2\u0131\u0132"+
		"\7}\2\2\u0132\u0133\7/\2\2\u0133\u0137\3\2\2\2\u0134\u0136\13\2\2\2\u0135"+
		"\u0134\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0138\3\2\2\2\u0137\u0135\3\2"+
		"\2\2\u0138\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013b\7/\2\2\u013b"+
		"\u013c\7\177\2\2\u013c\u013d\3\2\2\2\u013d\u013e\b\60\2\2\u013e`\3\2\2"+
		"\2\20\2dls\u00b3\u00b5\u00ce\u00d0\u00e1\u00e3\u011a\u0123\u012c\u0137"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}