grammar lang;

@parser::header {
package lang.parser;

import lang.ast.*;
import lang.ast.nodes.*;
import lang.ast.nodes.base.Node;
import lang.ast.nodes.definitions.*;
import lang.ast.nodes.definitions.base.Definition;
import lang.ast.nodes.expressions.*;
import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.expressions.binaryOperators.*;
import lang.ast.nodes.expressions.binaryOperators.base.BinaryOperator;
import lang.ast.nodes.expressions.literals.*;
import lang.ast.nodes.expressions.variables.*;
import lang.ast.nodes.expressions.variables.base.Variable;
import lang.ast.nodes.types.*;
import lang.ast.nodes.types.base.Type;
import java.util.HashMap;
}

@lexer::header {
package lang.parser;

import java.util.HashMap;
}

@members {
HashMap<String, Character> specialCharacters = new HashMap<String, Character>() {{
  put("\\n", '\n');
  put("\\r", '\r');
  put("\\t", '\t');
  put("\\b", '\b');
  put("\\\\", '\\');
  put("\\'", '\'');
}};

int count = 0;
}

/* Regras da gramática */

prog returns [Program ast]
  : { List<Definition> definitions = new ArrayList<Definition>(); }
    (def { definitions.add($def.ast); })*
    {
      Definition[] definitionsArray = new Definition[definitions.size()];
      definitionsArray = definitions.toArray(definitionsArray);

      Definition definition = definitionsArray[0];
      int line = definition != null ? definition.getLine() : 0;
      int column = definition != null ? definition.getColumn() : 0;

      $ast = new Program(definitionsArray, line, column);
    }
  ;

def returns [Definition ast]
  : data      { $ast = $data.ast; }
  | fun       { $ast = $fun.ast; }
  ;

data returns [DataRegister ast]
  : DATA TYPE_NAME OPEN_CURLY_BRACE
      { List<Declaration> declarations = new ArrayList<Declaration>(); }
      (decl { declarations.add($decl.ast); })*
    CLOSE_CURLY_BRACE
      {
        Declaration[] declarationsArray = new Declaration[declarations.size()];
        declarationsArray = declarations.toArray(declarationsArray);

        $ast = new DataRegister($TYPE_NAME.text, declarationsArray, $TYPE_NAME.line, $TYPE_NAME.pos);
      }
  ;

decl returns [Declaration ast]
  : ID DOUBLE_COLON type SEMICOLON       { $ast = new Declaration($ID.text, $type.ast, $ID.line, $ID.pos); }
  ; 

fun returns [Function ast]
  : ID OPEN_PARENTHESIS params? CLOSE_PARENTHESIS
    { List<Type> returnTypes = new ArrayList<Type>(); }
    (
      COLON type1=type { returnTypes.add($type1.ast); }
      (COMMA type2=type { returnTypes.add($type2.ast); })*
    )? OPEN_CURLY_BRACE cmd* CLOSE_CURLY_BRACE
    {
      Type[] typesArray = new Type[returnTypes.size()];
      typesArray = returnTypes.toArray(typesArray);

      $ast = new Function($ID.text, $params.ast, typesArray, $cmd.ast, $ID.line, $ID.pos);
    }
  ;

params returns [Parameter[] ast]
  : id1=ID DOUBLE_COLON
    { List<Parameter> parameters = new ArrayList<Parameter>(); }
    type1=type { parameters.add(new Parameter($id1.text, $type1.ast, $id1.line, $id1.pos)); }
    (COMMA id2=ID DOUBLE_COLON type2=type { parameters.add(new Parameter($id2.text, $type2.ast, $id2.line, $id2.pos)); })*
    {
      Parameter[] parametersArray = new Parameter[parameters.size()];
      parametersArray = parameters.toArray(parametersArray);

      $ast = parametersArray;
    }
  ;

type returns [Type ast]
  : type OPEN_BRACKET CLOSE_BRACKET   { $ast = new ArrayType($bType.ast, $OPEN_BRACKET.line, $OPEN_BRACKET.pos); }
  | bType                             { $ast = $bType.ast; }
  ;

bType returns [Type ast]
  : TYPE_INT              { $ast = new IntType($TYPE_INT.line, $TYPE_INT.pos); }
  | TYPE_CHAR             { $ast = new CharType($TYPE_CHAR.line, $TYPE_CHAR.pos); }
  | TYPE_BOOL             { $ast = new BoolType($TYPE_BOOL.line, $TYPE_BOOL.pos); }
  | TYPE_FLOAT            { $ast = new FloatType($TYPE_FLOAT.line, $TYPE_FLOAT.pos); }
  | TYPE_NAME             { $ast = new DataType($TYPE_NAME.text, $TYPE_NAME.line, $TYPE_NAME.pos); }
  ;

cmd returns [Node ast]
  : OPEN_CURLY_BRACE
    { List<Node> commands = new ArrayList<Node>(); }
    (cmd { commands.add($cmd.ast); })*
    CLOSE_CURLY_BRACE
    {
      Node[] commandsArray = new Node[commands.size()];
      commandsArray = commands.toArray(commandsArray);

      $ast = new Block(commandsArray, $OPEN_CURLY_BRACE.line, $OPEN_CURLY_BRACE.pos);
    }
  | IF OPEN_PARENTHESIS condition=exp CLOSE_PARENTHESIS then=cmd     { $ast = new If($condition.ast, $then.ast, $IF.line, $IF.pos); }
  | IF OPEN_PARENTHESIS condition=exp CLOSE_PARENTHESIS then=cmd ELSE elseCmd=cmd    { $ast = new If($exp.ast, $then.ast, $elseCmd.ast, $IF.line, $IF.pos); }
  | ITERATE OPEN_PARENTHESIS condition=exp CLOSE_PARENTHESIS body=cmd    { $ast = new Iterate($condition.ast, $body.ast, $ITERATE.line, $ITERATE.pos); }
  | READ lvalue SEMICOLON     { $ast = new Read($lvalue.ast, $READ.line, $READ.pos); }
  | PRINT exp SEMICOLON       { $ast = new Print($exp.ast, $PRINT.line, $PRINT.pos); }
  | RETURN
    { List<Expression> expList = new ArrayList<Expression>(); }
    exp1=exp { expList.add($exp1.ast); }
    (COMMA exp2=exp { expList.add($exp2.ast); })*
    SEMICOLON
    {
      Expression[] expressionsArray = new Expression[expList.size()];
      expressionsArray = expList.toArray(expressionsArray);

      $ast = new Return(expressionsArray, $RETURN.line, $RETURN.pos);
    }
  | lvalue EQUAL exp SEMICOLON          { $ast = new Assignment($lvalue.ast, $exp.ast, $EQUAL.line, $EQUAL.pos); }
  | ID OPEN_PARENTHESIS arguments=exps? CLOSE_PARENTHESIS
    { List<Variable> returnVariables = new ArrayList<Variable>(); }
    (
      LESS_THAN lvalue1=lvalue { returnVariables.add($lvalue1.ast); }
      (COMMA lvalue2=lvalue { returnVariables.add($lvalue2.ast); })*
      GREATER_THAN
    )? SEMICOLON
    {
      Variable[] variablesArray = new Variable[returnVariables.size()];
      variablesArray = returnVariables.toArray(variablesArray);

      $ast = new Call($ID.text, $arguments.ast, variablesArray, $ID.line, $ID.pos);
    }
  ;

exp returns [Expression ast]
  : lvalue                                    { $ast = $lvalue.ast; }
  | OPEN_PARENTHESIS exp CLOSE_PARENTHESIS    { $ast = $exp.ast; }
  | <assoc=right> NOT exp                     { $ast = new Not($exp.ast, $NOT.line, $NOT.pos); }
  | <assoc=right> MINUS exp                   { $ast = new UnaryMinus($exp.ast, $MINUS.line, $MINUS.pos); }
  | expLeft=exp TIMES expRight=exp            { $ast = new Multiplication($expLeft.ast, $expRight.ast, $TIMES.line, $TIMES.pos); }
  | expLeft=exp DIVISION expRight=exp         { $ast = new Division($expLeft.ast, $expRight.ast, $DIVISION.line, $DIVISION.pos); }
  | expLeft=exp MODULUS expRight=exp          { $ast = new Modulus($expLeft.ast, $expRight.ast, $MODULUS.line, $MODULUS.pos); }
  | expLeft=exp PLUS expRight=exp             { $ast = new Add($expLeft.ast, $expRight.ast, $PLUS.line, $PLUS.pos); }
  | expLeft=exp MINUS expRight=exp            { $ast = new Subtraction($expLeft.ast, $expRight.ast, $MINUS.line, $MINUS.pos); }
  | expLeft=exp LESS_THAN expRight=exp        { $ast = new LessThan($expLeft.ast, $expRight.ast, $LESS_THAN.line, $LESS_THAN.pos); }
  | expLeft=exp COMPARISON expRight=exp       { $ast = new Equals($expLeft.ast, $expRight.ast, $COMPARISON.line, $COMPARISON.pos); }
  | expLeft=exp NOT_EQUAL expRight=exp        { $ast = new NotEquals($expLeft.ast, $expRight.ast, $NOT_EQUAL.line, $NOT_EQUAL.pos); }
  | expLeft=exp AND expRight=exp              { $ast = new And($expLeft.ast, $expRight.ast, $AND.line, $AND.pos); }
  | FALSE                                     { $ast = new False($FALSE.line, $FALSE.pos); }
  | TRUE                                      { $ast = new True($TRUE.line, $TRUE.pos); }
  | NULL                                      { $ast = new Null($NULL.line, $NULL.pos); }
  | INT                                       { $ast = new LiteralInt(Integer.parseInt($INT.text), $INT.line, $INT.pos); }
  | FLOAT                                     { $ast = new LiteralFloat(Float.parseFloat($FLOAT.text), $FLOAT.line, $FLOAT.pos); }
  | CHAR                                      
    {
      String text = $CHAR.text;
      String value = text.substring(1);
      value = value.substring(0, value.length() - 1);

      if (value.length() == 1) {
        $ast = new LiteralChar(value.toCharArray()[0], $CHAR.line, $CHAR.pos);
      } else if (this.specialCharacters.containsKey(value)) {
        $ast = new LiteralChar(this.specialCharacters.get(value), $CHAR.line, $CHAR.pos);
      }
    }
  | NEW type (OPEN_BRACKET exp CLOSE_BRACKET)?              { $ast = new VariableDeclaration($type.ast, $exp.ast, $NEW.line, $NEW.pos); }
  | ID OPEN_PARENTHESIS (arguments=exps)? CLOSE_PARENTHESIS OPEN_BRACKET returnIndex=exp CLOSE_BRACKET    { $ast = new Call($ID.text, $arguments.ast, $returnIndex.ast, $ID.line, $ID.pos); }
  ;

lvalue returns [Variable ast]
  : ID                                      { $ast = new SimpleVariable($ID.text, $ID.line, $ID.pos); }
  | lvalue1=lvalue OPEN_BRACKET exp CLOSE_BRACKET   { $ast = new ArrayAccess($lvalue1.ast, $exp.ast, $OPEN_BRACKET.line, $OPEN_BRACKET.pos); }
  | lvalue2=lvalue DOT ID                           { $ast = new FieldAccess($lvalue2.ast, $ID.text, $DOT.line, $DOT.pos); }
  ;

exps returns [Expression[] ast]
  : { List<Expression> expList = new ArrayList<Expression>(); }
    exp1=exp { expList.add($exp1.ast); }
    (COMMA exp2=exp { expList.add($exp2.ast); })*
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