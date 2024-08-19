/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/
 /*  Esta seção é copiada antes da declaração da classe do analisador léxico.
  *  É nesta seção que se deve incluir imports e declaração de pacotes.
  *  Neste exemplo não temos nada a incluir nesta seção.
  */
package lang.scanner;

import beaver.Symbol;
import beaver.Scanner;
import java.util.HashMap;
%%

%unicode
%line
%column
%class LangScanner
%extends Scanner
%public
%function nextToken
%type Token
%yylexthrow Scanner.Exception
%eofval{
	return newToken(Terminals.EOF, "end-of-file");
%eofval}

%{
    /* Código arbitrário pode ser inserido diretamente no analisador dessa forma. 
     * Aqui podemos declarar variáveis e métodos adicionais que julgarmos necessários. 
     */
    private int tokensAmount;
    private HashMap<String, Character> specialCharacters = new HashMap<String, Character>();
    
    public int getTokensAmount() {
       return tokensAmount;
    }

    private Token symbol(short terminal) {
        tokensAmount++;
        return new Token(terminal, yytext(), yyline + 1, yycolumn + 1, yylength());   
    }

    private Token symbol(short terminal, Object value) {
        tokensAmount++;
        return new Token(terminal, yytext(), value, yyline + 1, yycolumn + 1, yylength());
    }
%}

%init{
  tokensAmount = 0; // Isto é copiado direto no construtor do lexer. 

  this.specialCharacters.put("\\n", '\n');
  this.specialCharacters.put("\\r", '\r');
  this.specialCharacters.put("\\t", '\t');
  this.specialCharacters.put("\\b", '\b');
  this.specialCharacters.put("\\\\", '\\');
  this.specialCharacters.put("\\'", '\'');
%init}

  
  /* Agora vamos definir algumas macros */
  EndOfLine  = \r | \n | \r\n
  WhiteSpace     = {EndOfLine} | [ \t\f]
  Integer      = [:digit:] [:digit:]*  // [0-9][0-9]*
  Float = [:digit:]* "." {Integer}  // [0-9]*.[0-9][0-9]*
  Identifier = [:lowercase:] ([:lowercase:] | [:uppercase:] | [:digit:] | "_")*  // [a-z] ([a-z] | [A-Z] | [0-9] | _)*
  TypeName = [:uppercase:] ([:lowercase:] | [:uppercase:] | [:digit:] | "_")* // [A-Z] ([a-z] | [A-Z] | [0-9] | _)*
  SpecialCharacter = "\\r" | "\\n" | "\\t" | "\\b" | "\\\\" | "\\'"
  Character = "'" ([^"'" "\\"] | {SpecialCharacter}) "'" //Regra para capturar caracteres não reconhecidos ([^])
  Null = "null"
  LineComment = "--" (.)* {EndOfLine}
  
%state COMMENT

%%

<YYINITIAL>{
    {Float}         { return symbol(Terminals.FLOAT, Float.parseFloat(yytext())); }
    {Integer}       { return symbol(Terminals.INT, Integer.parseInt(yytext())); }
    "false"         { return symbol(Terminals.FALSE, false); }
    "true"          { return symbol(Terminals.TRUE, true); }
    {Null}          { return symbol(Terminals.NULL); }

    //CMD
    "if"            { return symbol(Terminals.IF); }
    "else"          { return symbol(Terminals.ELSE); }
    "data"          { return symbol(Terminals.DATA); }
    "iterate"       { return symbol(Terminals.ITERATE); }
    "return"        { return symbol(Terminals.RETURN); }
    "print"         { return symbol(Terminals.PRINT); }
    "read"          { return symbol(Terminals.READ); }
    "new"           { return symbol(Terminals.NEW); }

    {Identifier}    { return symbol(Terminals.ID); }
    "Int"           { return symbol(Terminals.TYPE_INT); }
    "Float"         { return symbol(Terminals.TYPE_FLOAT); } 
    "Bool"          { return symbol(Terminals.TYPE_BOOL); } 
    "Char"          { return symbol(Terminals.TYPE_CHAR); }
    {TypeName}      { return symbol(Terminals.TYPE_NAME); }
    {Character}     {
                      String text = yytext();
                      String value = text.substring(1);
                      value = value.substring(0, value.length() - 1);

                      if (value.length() == 1) {
                        return symbol(Terminals.CHAR, value.toCharArray()[0]);
                      }

                      if (this.specialCharacters.containsKey(value)) {
                        return symbol(Terminals.CHAR, this.specialCharacters.get(value));
                      }
                    }
    {WhiteSpace}    {}
    {LineComment}   {} 

   //OPERADORES E SEPARADORES
    "{-"            { yybegin(COMMENT); }
    "("             { return symbol(Terminals.OPEN_PARENTHESIS); }
    ")"             { return symbol(Terminals.CLOSE_PARENTHESIS); }
    "["             { return symbol(Terminals.OPEN_BRACKET); }
    "]"             { return symbol(Terminals.CLOSE_BRACKET); }
    "{"             { return symbol(Terminals.OPEN_CURLY_BRACE); }
    "}"             { return symbol(Terminals.CLOSE_CURLY_BRACE); }
    ">"             { return symbol(Terminals.GREATER_THAN); }
    "<"             { return symbol(Terminals.LESS_THAN); }
    ";"             { return symbol(Terminals.SEMICOLON); }
    "::"            { return symbol(Terminals.DOUBLE_COLON); }
    ":"             { return symbol(Terminals.COLON); }
    "."             { return symbol(Terminals.DOT); }
    ","             { return symbol(Terminals.COMMA); }
    "=="            { return symbol(Terminals.COMPARISON); }
    "="             { return symbol(Terminals.EQUAL); }
    "!="            { return symbol(Terminals.NOT_EQUAL); }
    "+"             { return symbol(Terminals.PLUS); }
    "-"             { return symbol(Terminals.MINUS); }
    "*"             { return symbol(Terminals.TIMES); }
    "/"             { return symbol(Terminals.DIVISION); }
    "%"             { return symbol(Terminals.MODULUS); }
    "&&"            { return symbol(Terminals.AND); }
    "!"             { return symbol(Terminals.NOT); }
}

<COMMENT>{
   "-}"     { yybegin(YYINITIAL); } 
   [^"-}"]* {}
   "-"      {}
   "}"      {}
   <<EOF>>    { throw new RuntimeException("Comment block did not close"); } //Verifica se chega ao final do arquivo para verificar se o comentário de bloco é fechado
}

[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }
