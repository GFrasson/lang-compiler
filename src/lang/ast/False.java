package lang.ast;

/*
 * Esta classe representa um valor booleano False.
 * Expr
 */

import lang.visitors.Visitor;

public class False extends Expr {
  public False() {
  }

  public boolean getValue() {
    return false;
  }

  // @Override
  public String toString() {
    return "false";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
