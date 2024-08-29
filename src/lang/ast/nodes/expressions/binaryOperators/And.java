package lang.ast.nodes.expressions.binaryOperators;

import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.expressions.binaryOperators.base.BinaryOperator;

/*
 * Esta classe representa uma expressão de conjunção.
 * Expr && Expr
 */

import lang.visitors.Visitor;

public class And extends BinaryOperator {
  public And(Expression left, Expression right) {
    super(left, right);
  }

  public String toString() {
    String leftString = getLeft().toString();
    String rightString = getRight().toString();
    if (getRight() instanceof Add) {
      rightString = "(" + rightString + ")";
    }
    return leftString + " & " + rightString;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}