package lang.ast.nodes;

import lang.ast.nodes.base.Node;
import lang.ast.nodes.expressions.base.Expression;
/*
 * Esta classe representa um comando de leitura.
 * read Expr
 */
import lang.visitors.Visitor;

public class Read extends Node {
  private Expression expression;

  public Read(Expression expression, int line, int column) {
    super(line, column);
    
    this.expression = expression;
  }

  public Expression getExpression() {
    return expression;
  }

  // @Override
  public String toString() {
    return "read " + expression.toString() + ";";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
