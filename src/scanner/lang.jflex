/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 
*/
 /*  Esta seção é copiada antes da declaração da classe do analisador léxico.
  *  É nesta seção que se deve incluir imports e declaração de pacotes.
  *  Neste exemplo não temos nada a incluir nesta seção.
  */
package scanner;

import java.util.HashMap;
%%

%unicode
%line
%column
%class LangScanner
%public
%function nextToken
%type Token

%{
    /* Código arbitrário pode ser inserido diretamente no analisador dessa forma. 
     * Aqui podemos declarar variáveis e métodos adicionais que julgarmos necessários. 
     */
    private int tokensAmount;
    private HashMap<String, Character> specialCharacters = new HashMap<String, Character>();
    
    public int getTokensAmount() {
       return tokensAmount;
    }

    private Token symbol(TOKEN_TYPE tokenType) {
        tokensAmount++;
        return new Token(tokenType, yytext(), yyline + 1, yycolumn + 1);   
    }

    private Token symbol(TOKEN_TYPE tokenType, Object value) {
        tokensAmount++;
        return new Token(tokenType, yytext(), value, yyline + 1, yycolumn + 1);
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
  Boolean = "true" | "false"
  Null = "null"
  LineComment = "--" (.)* {EndOfLine}
  
%state COMMENT

%%

<YYINITIAL>{
    {Float}         { return symbol(TOKEN_TYPE.FLOAT, Float.parseFloat(yytext())); }
    {Integer}       { return symbol(TOKEN_TYPE.INT, Integer.parseInt(yytext())); }
    {Boolean}       { return symbol(TOKEN_TYPE.BOOLEAN, "true".compareTo(yytext()) == 0 ? true : false); }
    {Null}          { return symbol(TOKEN_TYPE.NULL); }

    //CMD
    "if"            { return symbol(TOKEN_TYPE.IF); }
    "else"          { return symbol(TOKEN_TYPE.ELSE); }
    "data"          { return symbol(TOKEN_TYPE.DATA); }
    "iterate"       { return symbol(TOKEN_TYPE.ITERATE); }
    "return"        { return symbol(TOKEN_TYPE.RETURN); }
    "print"         { return symbol(TOKEN_TYPE.PRINT); }
    "read"          { return symbol(TOKEN_TYPE.READ); }
    "new"           { return symbol(TOKEN_TYPE.NEW); }

    {Identifier}    { return symbol(TOKEN_TYPE.ID); }
    {TypeName}      { return symbol(TOKEN_TYPE.TYPE_NAME); }
    {Character}     {
                      String text = yytext();
                      String value = text.substring(1);
                      value = value.substring(0, value.length() - 1);

                      if (value.length() == 1) {
                        return symbol(TOKEN_TYPE.CHAR, value.toCharArray()[0]);
                      }

                      if (this.specialCharacters.containsKey(value)) {
                        return symbol(TOKEN_TYPE.CHAR, this.specialCharacters.get(value));
                      }
                    }
    {WhiteSpace}    {}
    {LineComment}   {}

   //OPERADORES E SEPARADORES
    "{-"            { yybegin(COMMENT); }
    "("             { return symbol(TOKEN_TYPE.OPEN_PARENTHESIS); }
    ")"             { return symbol(TOKEN_TYPE.CLOSE_PARENTHESIS); }
    "["             { return symbol(TOKEN_TYPE.OPEN_BRACKET); }
    "]"             { return symbol(TOKEN_TYPE.CLOSE_BRACKET); }
    "{"             { return symbol(TOKEN_TYPE.OPEN_CURLY_BRACE); }
    "}"             { return symbol(TOKEN_TYPE.CLOSE_CURLY_BRACE); }
    ">"             { return symbol(TOKEN_TYPE.GREATER_THAN); }
    "<"             { return symbol(TOKEN_TYPE.LESS_THAN); }
    ";"             { return symbol(TOKEN_TYPE.SEMICOLON); }
    "::"            { return symbol(TOKEN_TYPE.DOUBLE_COLON); }
    ":"             { return symbol(TOKEN_TYPE.COLON); }
    "."             { return symbol(TOKEN_TYPE.DOT); }
    ","             { return symbol(TOKEN_TYPE.COMMA); }
    "=="            { return symbol(TOKEN_TYPE.COMPARISON); }
    "="             { return symbol(TOKEN_TYPE.EQUAL); }
    "!="            { return symbol(TOKEN_TYPE.NOT_EQUAL); }
    "+"             { return symbol(TOKEN_TYPE.PLUS); }
    "-"             { return symbol(TOKEN_TYPE.MINUS); }
    "*"             { return symbol(TOKEN_TYPE.TIMES); }
    "/"             { return symbol(TOKEN_TYPE.DIVISION); }
    "%"             { return symbol(TOKEN_TYPE.MODULUS); }
    "&&"            { return symbol(TOKEN_TYPE.AND); }
    "!"             { return symbol(TOKEN_TYPE.NOT); }
}

<COMMENT>{
   "-}"     { yybegin(YYINITIAL); } 
   [^"-}"]* {}
   "-"      {}
   "}"      {}
   <<EOF>>    { throw new RuntimeException("Comment block did not close"); } //Verifica se chega ao final do arquivo para verificar se o comentário de bloco é fechado
}

[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }
