package lang.ast.nodes;

import lang.ast.nodes.base.Node;
import lang.ast.nodes.expressions.base.Expression;
/*
 * Esta classe representa um comando de Impressão.
 * print Expr
 */
import lang.visitors.Visitor;

public class Print extends Node {
  private Expression expression;

  public Print(Expression expression) {
    this.expression = expression;
  }

  public Expression getExpression() {
    return expression;
  }

  // @Override
  public String toString() {
    return "print " + expression.toString() + ";";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
