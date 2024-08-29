package lang.ast.nodes;

import lang.ast.nodes.base.Node;
import lang.ast.nodes.expressions.base.Expression;
/*
 * Esta classe representa um retorno.
 * Return Expr
 */
import lang.visitors.Visitor;

public class Return extends Node {
  private Expression[] expressions;

  public Return(int line, int column, Expression[] expressions) {
    super(line, column);
    
    this.expressions = expressions;
  }

  public Expression[] getExpressions() {
    return expressions;
  }

  // @Override
  public String toString() {
    return "return " + expressions.toString() + ";";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
