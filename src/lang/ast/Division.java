package lang.ast;

/*
 * Esta classe representa uma operação de divisão.
 * Expr / Expr
 */

import lang.visitors.Visitor;

public class Division extends BinaryOperator {
  public Division(Expr left, Expr right) {
    super(left, right);
  }

  public String toString() {
    String leftString = getLeft().toString();
    String rightString = getRight().toString();
    if (getRight() instanceof Add) {
      rightString = "(" + rightString + ")";
    }
    return leftString + " / " + rightString;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
