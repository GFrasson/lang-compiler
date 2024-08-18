/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/
package lang.scanner;

//TIPOS DE TOKEN
public enum TOKEN_TYPE {
    INT,
    FLOAT,
    BOOLEAN,
    NULL,
    IF,
    ELSE,
    DATA,
    ITERATE,
    RETURN,
    PRINT,
    READ,
    NEW,
    ID,
    TYPE_NAME,
    CHAR, 
    OPEN_PARENTHESIS, //( 
    CLOSE_PARENTHESIS, //)
    OPEN_BRACKET, //[
    CLOSE_BRACKET, //]
    OPEN_CURLY_BRACE, //}
    CLOSE_CURLY_BRACE, //}
    GREATER_THAN, //>
    LESS_THAN, //<
    SEMICOLON, //;
    DOUBLE_COLON, //::
    COLON, //:
    DOT, //.
    COMMA, //,
    COMPARISON, //==
    EQUAL, //=
    NOT_EQUAL, //!=
    PLUS, //+
    MINUS, //-
    TIMES, // *
    DIVISION, // /
    MODULUS, //%
    AND, //&&
    NOT, //!   
}
