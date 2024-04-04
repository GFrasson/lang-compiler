
 /*  Esta seção é copiada antes da declaração da classe do analisador léxico.
  *  É nesta seção que se deve incluir imports e declaração de pacotes.
  *  Neste exemplo não temos nada a incluir nesta seção.
  */
  
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
    
    public int getTokensAmount() {
       return tokensAmount;
    }

    private Token symbol(TOKEN_TYPE tokenType) {
        tokensAmount++;
        return new Token(tokenType, yytext(), yyline + 1, yycolumn + 1);   
    }

    private Token symbol(TOKEN_TYPE tokenType, Object value) {
        tokensAmount++;
        return new Token(tokenType, value, yyline + 1, yycolumn + 1);
    }
%}

%init{
  tokensAmount = 0; // Isto é copiado direto no construtor do lexer. 
%init}

  
  /* Agora vamos definir algumas macros */
  EndOfLine  = \r | \n | \r\n
  WhiteSpace     = {EndOfLine} | [ \t\f]
  Integer      = [:digit:] [:digit:]*  // [0-9][0-9]*
  Float = [:digit:]* . {Integer}  // [0-9]*.[0-9][0-9]*
  Identifier = [:lowercase:] ([:lowercase:] | [:uppercase:] | [:digit:] | '_')*  // [a-z] ([a-z] | [A-Z] | [0-9] | _)*
  TypeName = [:uppercase:] ([:lowercase:] | [:uppercase:] | [:digit:] | '_')*
  // Character = '\'' ([:lowercase:] | [:uppercase:] | [:digit:] | \n | \t \ | \b | \r | '\\') '\''  // TODO
  Character = '\'' (. | \r | \n) '\''  // TODO
  Boolean = "true" | "false"
  Null = "null"
  LineComment = "--" (.)* {EndOfLine}
  
%state COMMENT

%%

<YYINITIAL>{
    {Integer}       { return symbol(TOKEN_TYPE.INT, Integer.parseInt(yytext())); }
    {Float}         { return symbol(TOKEN_TYPE.FLOAT, Float.parseFloat(yytext())); }
    {Boolean}       { return symbol(TOKEN_TYPE.BOOLEAN); }
    {Null}          { return symbol(TOKEN_TYPE.NULL); }
    {Identifier}    { return symbol(TOKEN_TYPE.ID); }
    {TypeName}      { return symbol(TOKEN_TYPE.TYPE_NAME); }
    {Character}     { return symbol(TOKEN_TYPE.CHAR); }
    {WhiteSpace}    {}
    {LineComment}   {}
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
}

[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }