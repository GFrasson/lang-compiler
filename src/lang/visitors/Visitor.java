/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.visitors;

import lang.ast.nodes.*;
import lang.ast.nodes.definitions.*;
import lang.ast.nodes.expressions.*;
import lang.ast.nodes.expressions.binaryOperators.*;
import lang.ast.nodes.expressions.literals.*;
import lang.ast.nodes.expressions.variables.ArrayAccess;
import lang.ast.nodes.expressions.variables.FieldAccess;
import lang.ast.nodes.expressions.variables.SimpleVariable;
import lang.ast.nodes.types.*;

public abstract class Visitor {
  public abstract void visit(Program program);

  public abstract void visit(Add add);
  public abstract void visit(Subtraction subtraction);
  public abstract void visit(Multiplication multiplication);
  public abstract void visit(Division division);
  public abstract void visit(Modulus modulus);
  
  public abstract void visit(And and);
  public abstract void visit(LessThan lessThan);
  public abstract void visit(Equals equals);
  public abstract void visit(NotEquals notEquals);
  public abstract void visit(Not not);

  public abstract void visit(True trueExpression);
  public abstract void visit(False falseExpression);
  public abstract void visit(LiteralChar literalChar);
  public abstract void visit(LiteralInt literalInt);
  public abstract void visit(LiteralFloat literalFloat);
  public abstract void visit(SimpleVariable simpleVariable);
  public abstract void visit(ArrayAccess arrayAccess);
  public abstract void visit(FieldAccess fieldAccess);
  public abstract void visit(Call call);
  public abstract void visit(Null nullExpression);
  public abstract void visit(UnaryMinus unaryMinus);

  public abstract void visit(Assignment assignment);
  public abstract void visit(Block block);
  public abstract void visit(Declaration declaration);
  public abstract void visit(If ifExpression);
  public abstract void visit(Iterate iterate);
  public abstract void visit(Print print);
  public abstract void visit(Read read);
  public abstract void visit(Function function);
  public abstract void visit(DataRegister dataRegister);

  public abstract void visit(Instance instance);
  public abstract void visit(Return returnCommand);
  public abstract void visit(Parameter parameter);

  public abstract void visit(IntType intType);
  public abstract void visit(FloatType floatType);
  public abstract void visit(CharType charType);
  public abstract void visit(BoolType boolType);
  public abstract void visit(ArrayType arrayType);
  public abstract void visit(DataType dataType);
}
