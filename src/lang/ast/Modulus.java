package lang.ast;

/*
 * Esta classe representa uma expressão de resto da divisão.
 * Expr % Expr
 */

import lang.visitors.Visitor;

public class Modulus extends BinaryOperator {
  public Modulus(Expr left, Expr right) {
    super(left, right);
  }

  public String toString() {
    String leftString = getLeft().toString();
    String rightString = getRight().toString();
    if (getRight() instanceof Add) {
      rightString = "(" + rightString + ")";
    }
    return leftString + " % " + rightString;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
