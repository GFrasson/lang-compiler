/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.scanner;

import beaver.Symbol;

public class Token extends Symbol {
    public int line, column;
    public short terminal;
    public String lexeme;
    public Object value;

    public Token(short terminal, String lexeme, Object value, int line, int column, int length) {
        super(terminal, line, column, length, value);

        this.terminal = terminal;
        this.lexeme = lexeme;
        this.value = value;
        this.line = line;
        this.column = column;
    }

    public Token(short terminal, String lexeme, int line, int column, int length) {
        super(terminal, line, column, length);

        this.terminal = terminal;
        this.lexeme = lexeme;
        this.value = null;
        this.line = line;
        this.column = column;
    }

    public Token(short terminal, Object value, int line, int column, int length) {
        super(terminal, line, column, length, value);

        this.terminal = terminal;
        this.lexeme = "";
        this.value = value;
        this.line = line;
        this.column = column;
    }

    @Override
    public String toString() {
        // TAG: [(linha, coluna) TAG: "lexema" : <valor>]
        return "[(" + this.line + "," + this.column + ") " + this.terminal + ": \"" + this.lexeme + "\" : <" + (this.value == null ? "" : this.value.toString()) + ">]";
    }

    public String toStringShortRepresentation() {
        // TAG: lexema | valor
        String stringRepresentation = this.terminal + ": ";
        if (this.value != null) {
            stringRepresentation += this.value;
        } else {
            stringRepresentation += this.lexeme;
        }

        return stringRepresentation;
    }
}
