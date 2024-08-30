package lang.visitors;

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
import lang.ast.nodes.expressions.variables.base.Variable;
import lang.ast.nodes.types.*;
import lang.ast.nodes.types.base.Type;

public abstract class Visitor {
  public abstract void visit(Program p);

  public abstract void visit(Add e);
  public abstract void visit(Subtraction e);
  public abstract void visit(Multiplication e);
  public abstract void visit(Division e);
  public abstract void visit(Modulus e);

  public abstract void visit(And e);
  public abstract void visit(LessThan e);
  public abstract void visit(Equals e);
  public abstract void visit(Not e);

  public abstract void visit(True e);
  public abstract void visit(False e);
  public abstract void visit(LiteralInt e);
  public abstract void visit(LiteralFloat e);
  public abstract void visit(Variable e);
  public abstract void visit(Call e);

  public abstract void visit(Assignment e);
  public abstract void visit(If e);
  public abstract void visit(Iterate e);
  public abstract void visit(Print e);
  public abstract void visit(Read e);
  public abstract void visit(StatementList e);
  public abstract void visit(Function f);

  public abstract void visit(Instance e);
  public abstract void visit(Return e);
  public abstract void visit(Parameter e);

  public abstract void visit(IntType t);
  public abstract void visit(FloatType t);
  public abstract void visit(CharType t);
  public abstract void visit(BoolType t);
  public abstract void visit(ArrayType t);
  public abstract void visit(DataType t);
}
