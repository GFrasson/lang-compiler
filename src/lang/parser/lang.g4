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
  :;

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