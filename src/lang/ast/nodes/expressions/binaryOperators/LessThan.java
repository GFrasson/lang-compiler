package lang.ast.nodes.expressions.binaryOperators;


import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.expressions.binaryOperators.base.BinaryOperator;

/*
 * Esta classe representa uma operação de comparação menor que.
 * Expr < Expr
 */

import lang.visitors.Visitor;

public class LessThan extends BinaryOperator {
  public LessThan(Expression left, Expression right) {
    super(left, right);
  }

  public String toString() {
    String leftString = getLeft().toString();
    String rightString = getRight().toString();
    if (getRight() instanceof Add) {
      rightString = "(" + rightString + ")";
    }
    return leftString + " < " + rightString;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
