package lang.ast.nodes.expressions;

import lang.ast.nodes.expressions.base.Expression;

/*
 * Esta classe representa um valor null.
 * Expr
 */

import lang.visitors.Visitor;

public class Null extends Expression {
  public Null() {
  }

  public void getValue() {
    return;
  }

  // @Override
  public String toString() {
    return "null";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
