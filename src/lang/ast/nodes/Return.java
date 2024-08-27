package lang.ast.nodes;

import lang.ast.nodes.base.Node;
import lang.ast.nodes.expressions.base.Expression;
/*
 * Esta classe representa um retorno.
 * Return Expr
 */
import lang.visitors.Visitor;

public class Return extends Node {
  private Expression expression;

  public Return(Expression expression) {
    this.expression = expression;
  }

  public Expression getExpression() {
    return expression;
  }

  // @Override
  public String toString() {
    return "return " + expression.toString() + ";";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
