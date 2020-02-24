package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1.0;
	}

	public static char lexemeToChar(String str) {
		try {
			if (str.equals("'\\n'")) {
				return '\n';
			}
			else if (str.equals("'\\t'")) {
				return '\t';
			}
			else if (str.startsWith("'\\")) {
				str = str.replace("'", "").replace("\\", "");
				return (char)Integer.parseInt(str);
			}
			else {
				return str.charAt(1);
			}
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return 0;

	}

	// TODO: Implement the lexemeToChar and lexemeToReal methods
	
}
