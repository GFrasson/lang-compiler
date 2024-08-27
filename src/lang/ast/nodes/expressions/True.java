package lang.ast.nodes.expressions;

import lang.ast.nodes.expressions.base.Expression;

/*
 * Esta classe representa uma valor booleano True.
 * Expr
 */

import lang.visitors.Visitor;

public class True extends Expression {
  public True() {
  }

  public boolean getValue() {
    return true;
  }

  // @Override
  public String toString() {
    return "true";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
