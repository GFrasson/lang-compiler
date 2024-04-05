package scanner;

public class Token {
    public int line, column;
    public TOKEN_TYPE tokenType;
    public String lexeme;
    public Object value;

    public Token(TOKEN_TYPE tokenType, String lexeme, Object value, int line, int column) {
        this.tokenType = tokenType;
        this.lexeme = lexeme;
        this.value = value;
        this.line = line;
        this.column = column;
    }

    public Token(TOKEN_TYPE tokenType, String lexeme, int line, int column) {
        this.tokenType = tokenType;
        this.lexeme = lexeme;
        this.value = null;
        this.line = line;
        this.column = column;
    }

    public Token(TOKEN_TYPE tokenType, Object value, int line, int column) {
        this.tokenType = tokenType;
        this.lexeme = "";
        this.value = value;
        this.line = line;
        this.column = column;
    }

    @Override
    public String toString() {
        return "[(" + this.line + "," + this.column + ") \"" + this.tokenType + "\" \"" + this.lexeme + "\" : <" + (this.value == null ? "" : this.value.toString()) + ">]";
    }
}
