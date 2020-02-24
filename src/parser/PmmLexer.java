// Generated from C:/Users/alvaro/IdeaProjects/DiseñoLenguajes/src/parser\Pmm.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, INT_CONSTANT=2, REAL_CONSTANT=3, CHAR_CONSTANT=4, WS=5, LINE_COMMENT=6, 
		MULTILINE_COMMENT=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGITO", "LETRA", "OPTION1", "OPTION2", "OPTION3", "OPTION4", "ID", 
			"INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "WS", "LINE_COMMENT", 
			"MULTILINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "WS", "LINE_COMMENT", 
			"MULTILINE_COMMENT"
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


	public PmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\t\u0099\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\7\2!\n\2\f\2\16\2$\13\2\5"+
		"\2&\n\2\3\3\3\3\3\4\3\4\3\4\3\4\5\4.\n\4\3\4\5\4\61\n\4\3\5\3\5\3\5\5"+
		"\5\66\n\5\3\5\5\59\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6B\n\6\3\6\5\6E\n"+
		"\6\5\6G\n\6\3\7\3\7\3\7\5\7L\n\7\3\7\3\7\3\b\3\b\5\bR\n\b\3\b\3\b\3\b"+
		"\7\bW\n\b\f\b\16\bZ\13\b\3\t\6\t]\n\t\r\t\16\t^\3\n\3\n\3\n\3\n\5\ne\n"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13x\n\13\3\f\6\f{\n\f\r\f\16\f|\3\f\3\f\3\r\3\r\7"+
		"\r\u0083\n\r\f\r\16\r\u0086\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7\16"+
		"\u008f\n\16\f\16\16\16\u0092\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\u0090"+
		"\2\17\3\2\5\2\7\2\t\2\13\2\r\2\17\3\21\4\23\5\25\6\27\7\31\b\33\t\3\2"+
		"\t\3\2\63;\3\2\62;\4\2C\\c|\4\2GGgg\4\2--//\5\2\13\f\17\17\"\"\4\2\f\f"+
		"\17\17\2\u00aa\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3%\3\2\2\2\5\'\3\2\2\2\7)\3\2\2\2\t"+
		"\62\3\2\2\2\13<\3\2\2\2\rH\3\2\2\2\17Q\3\2\2\2\21\\\3\2\2\2\23d\3\2\2"+
		"\2\25w\3\2\2\2\27z\3\2\2\2\31\u0080\3\2\2\2\33\u0089\3\2\2\2\35&\7\62"+
		"\2\2\36\"\t\2\2\2\37!\t\3\2\2 \37\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2"+
		"\2\2#&\3\2\2\2$\"\3\2\2\2%\35\3\2\2\2%\36\3\2\2\2&\4\3\2\2\2\'(\t\4\2"+
		"\2(\6\3\2\2\2)*\7\60\2\2*\60\5\21\t\2+-\t\5\2\2,.\7/\2\2-,\3\2\2\2-.\3"+
		"\2\2\2./\3\2\2\2/\61\5\21\t\2\60+\3\2\2\2\60\61\3\2\2\2\61\b\3\2\2\2\62"+
		"8\5\21\t\2\63\65\t\5\2\2\64\66\t\6\2\2\65\64\3\2\2\2\65\66\3\2\2\2\66"+
		"\67\3\2\2\2\679\5\21\t\28\63\3\2\2\289\3\2\2\29:\3\2\2\2:;\7\60\2\2;\n"+
		"\3\2\2\2<=\5\21\t\2=F\7\60\2\2>D\5\21\t\2?A\t\5\2\2@B\7/\2\2A@\3\2\2\2"+
		"AB\3\2\2\2BC\3\2\2\2CE\5\21\t\2D?\3\2\2\2DE\3\2\2\2EG\3\2\2\2F>\3\2\2"+
		"\2FG\3\2\2\2G\f\3\2\2\2HI\5\21\t\2IK\t\5\2\2JL\t\6\2\2KJ\3\2\2\2KL\3\2"+
		"\2\2LM\3\2\2\2MN\5\21\t\2N\16\3\2\2\2OR\5\5\3\2PR\7a\2\2QO\3\2\2\2QP\3"+
		"\2\2\2RX\3\2\2\2SW\5\5\3\2TW\5\3\2\2UW\7a\2\2VS\3\2\2\2VT\3\2\2\2VU\3"+
		"\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\20\3\2\2\2ZX\3\2\2\2[]\5\3\2\2\\"+
		"[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\22\3\2\2\2`e\5\7\4\2ae\5\t\5"+
		"\2be\5\13\6\2ce\5\r\7\2d`\3\2\2\2da\3\2\2\2db\3\2\2\2dc\3\2\2\2e\24\3"+
		"\2\2\2fg\7)\2\2gh\13\2\2\2hx\7)\2\2ij\7)\2\2jk\7^\2\2kl\7p\2\2lx\7)\2"+
		"\2mn\7)\2\2no\7^\2\2op\7v\2\2px\7)\2\2qr\7)\2\2rs\7^\2\2st\3\2\2\2tu\5"+
		"\21\t\2uv\7)\2\2vx\3\2\2\2wf\3\2\2\2wi\3\2\2\2wm\3\2\2\2wq\3\2\2\2x\26"+
		"\3\2\2\2y{\t\7\2\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}~\3\2\2\2~"+
		"\177\b\f\2\2\177\30\3\2\2\2\u0080\u0084\7%\2\2\u0081\u0083\n\b\2\2\u0082"+
		"\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\b\r\2\2\u0088"+
		"\32\3\2\2\2\u0089\u008a\7$\2\2\u008a\u008b\7$\2\2\u008b\u008c\7$\2\2\u008c"+
		"\u0090\3\2\2\2\u008d\u008f\13\2\2\2\u008e\u008d\3\2\2\2\u008f\u0092\3"+
		"\2\2\2\u0090\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0093\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0093\u0094\7$\2\2\u0094\u0095\7$\2\2\u0095\u0096\7$\2"+
		"\2\u0096\u0097\3\2\2\2\u0097\u0098\b\16\2\2\u0098\34\3\2\2\2\26\2\"%-"+
		"\60\658ADFKQVX^dw|\u0084\u0090\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}