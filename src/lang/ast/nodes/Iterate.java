package lang.ast.nodes;

import lang.ast.nodes.base.Node;
import lang.ast.nodes.expressions.base.Expression;

/*
 * Esta classe representa um comando iterate.
 * Iterate (condition) { body }
 */

import lang.visitors.Visitor;

public class Iterate extends Node {
  private Expression condition;
  private Node body;

  public Iterate(Expression condition, Node body, int line, int column) {
    super(line, column);
    
    this.condition = condition;
    this.body = body;
  }

  public String toString() {
    String s = "[" + condition.toString() + "]{" + body.toString() + "}";
    return s.replace('\n', '\0');
  }

  public Expression getCondition() {
    return condition;
  }

  public Node getBody() {
    return body;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
