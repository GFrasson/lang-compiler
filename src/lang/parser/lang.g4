grammar lang;

@parser::header {
  package lang.parser;
}

@lexer::header {
  package lang.parser;
}

/* Regras da gramática */

prog returns [Definition ast]
  : (def { $ast = $def.ast; })*
  ;

def returns [Definition ast]
  : data      { $ast = $data.ast; }
  | fun       { $ast = $fun.ast; }
  ;

data returns [DataRegister ast]
  : DATA TYPE_NAME OPEN_CURLY_BRACE decl* CLOSE_CURLY_BRACE   { $ast = new DataRegister($TYPE_NAME, $decl.ast); }
  ;

decl returns [Declaration ast]
  : ID DOUBLE_COLON type SEMICOLON       { $ast = new Declaration($ID, $type.ast); }
  ; 

fun returns [Function ast]
  : ID OPEN_PARENTHESIS params? CLOSE_PARENTHESIS (COLON type1=type (COMMA typeList=type)*)? OPEN_CURLY_BRACE cmd* CLOSE_CURLY_BRACE
    {
      List<Type> returnTypes = new ArrayList();
      if ($type1.ast != null) {
        returnTypes.add($type1.ast);

        for (Type currentType : $typeList.ast) {
          returnTypes.add(currentType.ast);
        }
      }

      $ast = new Function($ID, $params.ast, returnTypes, $cmd.ast);
    }
  ;

params returns [Parameter ast]
  : id1=ID DOUBLE_COLON type1=type { $ast = new Parameter($id1, $type1.ast) }
    (COMMA id2=ID DOUBLE_COLON type2=type { $ast = new Parameter($id2, $type2.ast) })*
  ;

type returns [Type ast]
  : type OPEN_BRACKET CLOSE_BRACKET   { $ast = new ArrayType($bType.ast); }
  | bType                             { $ast = $bType.ast; }
  ;

bType returns [Type ast]
  : TYPE_INT              { $ast = new IntType(); }
  | TYPE_CHAR             { $ast = new CharType(); }
  | TYPE_BOOL             { $ast = new BoolType(); }
  | TYPE_FLOAT            { $ast = new FloatType(); }
  | TYPE_NAME             { $ast = new DataType($TYPE_NAME); }
  ;

cmd returns [Node ast]
  : OPEN_CURLY_BRACE cmd* CLOSE_CURLY_BRACE           { $ast = $cmd.ast; }
  | IF OPEN_PARENTHESIS condition=exp CLOSE_PARENTHESIS then=cmd     { $ast = new If($condition.ast, $then.ast); }
  | IF OPEN_PARENTHESIS condition=exp CLOSE_PARENTHESIS then=cmd ELSE else=cmd    { $ast = new If($exp.ast, $then.ast, $else.ast); }
  | ITERATE OPEN_PARENTHESIS condition=exp CLOSE_PARENTHESIS body=cmd    { $ast = new Iterate($condition.ast, $body.ast); }
  | READ lvalue SEMICOLON     { $ast = new Read($lvalue.ast); }
  | PRINT exp SEMICOLON       { $ast = new Print($exp.ast); }
  | RETURN { expList = new ArrayList<Expression>(); } exp1=exp { expList.add($exp1.ast); } (COMMA exp2=exp { expList.add($exp2.ast); })* SEMICOLON
    {
      Expression[] expressionsArray = new Expression[expList.size()];
      expressionsArray = expList.toArray(expressionsArray);

      $ast = new Return(expressionsArray);
    }
  | lvalue EQUAL exp SEMICOLON          { $ast = new Assignment($lValue.ast, $exp.ast); }
  | ID OPEN_PARENTHESIS parameters=exps? CLOSE_PARENTHESIS (LESS_THAN lvalue (COMMA lvalue)* GREATER_THAN)? SEMICOLON    { $ast = new Call(); }
  ;

exp returns [Expression ast]
  : expLeft=exp AND expRight=exp            { $ast = new And($expLeft.ast, $expRight.ast); }
  | expLeft=exp COMPARISON expRight=exp     { $ast = new Equals($expLeft.ast, $expRight.ast); }
  | expLeft=exp NOT_EQUAL expRight=exp      { $ast = new NotEqual($expLeft.ast, $expRight.ast); }
  | expLeft=exp LESS_THAN expRight=exp      { $ast = new LessThan($expLeft.ast, $expRight.ast); }
  | expLeft=exp PLUS expRight=exp           { $ast = new Add($expLeft.ast, $expRight.ast); }
  | expLeft=exp MINUS expRight=exp          { $ast = new Minus($expLeft.ast, $expRight.ast); }
  | expLeft=exp TIMES expRight=exp          { $ast = new Multiplication($expLeft.ast, $expRight.ast); }
  | expLeft=exp DIVISION expRight=exp              { $ast = new Division($expLeft.ast, $expRight.ast); }
  | expLeft=exp MODULUS expRight=exp           { $ast = new Modulus($expLeft.ast, $expRight.ast); }
  | <assoc=right> NOT exp                                     { $ast = new Not($exp.ast); }
  | <assoc=right> MINUS exp                                   { $ast = new UnaryMinus($exp.ast); }
  | FALSE                                     { $ast = new False(); }
  | TRUE                                       { $ast = new True(); }
  | NULL                                            { $ast = new Null(); }
  | INT                                  { $ast = new LiteralInt(Integer.parseInt($INT)); }
  | FLOAT                              { $ast = new LiteralFloat(Float.parseFloat($FLOAT)); }
  | CHAR                                { $ast = new LiteralChar($CHAR); }
  | lvalue                                   { $ast = $lValue.ast; }
  | OPEN_PARENTHESIS exp CLOSE_PARENTHESIS      { $ast = $exp.ast; }
  | NEW type (OPEN_BRACKET exp CLOSE_BRACKET)?              { $ast = ; }
  | ID OPEN_PARENTHESIS (arguments=exps)? CLOSE_PARENTHESIS OPEN_BRACKET returnIndex=exp CLOSE_BRACKET    { $ast = new Call($ID, $arguments.ast, $returnIndex.ast); }
  ;

lvalue returns [Variable ast]
  : ID                  { $ast = new Variable($ID); }
  | lvalue OPEN_BRACKET exp CLOSE_BRACKET  { $ast = new Variable($ID, $exp.ast); }
  | lvalue DOT ID   { $ast = ; }
  ;

exps returns [Expression[] ast]
  : { expList = new ArrayList<Expression>(); } exp1=exp { expList.add($exp1.ast); } (COMMA exp2=exp { expList.add($exp2.ast); })*
    {
      Expression[] expressionsArray = new Expression[expList.size()];
      expressionsArray = expList.toArray(expressionsArray);

      $ast = expressionsArray;
    }
  ;

/* Regras léxicas */

FLOAT: [0-9]* '.' [0-9][0-9]*;
INT: [0-9][0-9]*;
FALSE: 'false';
TRUE: 'true';
NULL: 'null';
IF: 'if';
ELSE: 'else';
DATA: 'data';
ITERATE: 'iterate';
RETURN: 'return';
PRINT: 'print';
READ: 'read'; 
NEW: 'new';
ID: [a-z] ([a-z] | [A-Z] | [0-9] | '_')*;
TYPE_INT: 'Int';
TYPE_FLOAT: 'Float';
TYPE_BOOL: 'Bool';
TYPE_CHAR: 'Char';
TYPE_NAME: [A-Z] ([a-z] | [A-Z] | [0-9] | '_')*;
CHAR:  '\'' (~('\'' | '\\') | ('\\r' | '\\n' | '\\t' | '\\b' | '\\\\' | '\\\'')) '\'';
OPEN_PARENTHESIS: '(';
CLOSE_PARENTHESIS: ')';
OPEN_BRACKET: '[';
CLOSE_BRACKET: ']';
OPEN_CURLY_BRACE: '{';
CLOSE_CURLY_BRACE: '}';
GREATER_THAN: '>';
LESS_THAN: '<';
SEMICOLON: ';';
DOUBLE_COLON: '::';
COLON: ':';
DOT: '.';
COMMA: ',';
COMPARISON: '==';
EQUAL: '=';
NOT_EQUAL: '!=';
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIVISION: '/';
MODULUS: '%';
AND: '&&';
NOT: '!';

NEWLINE: '\r'? '\n' -> skip;
WHITESPACE: [ \t\f]+ -> skip;
LINE_COMMENT: '-' '-' ~('\r' | '\n' | [\r\n])* NEWLINE;
COMMENT: '{-' .*? '-}' -> skip;