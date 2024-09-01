package lang.ast.nodes;

/*
 * Esta classe representa um comando condicional.
 * ?(E) {C} : {C} 
 */

import lang.ast.nodes.base.Node;
import lang.ast.nodes.expressions.base.Expression;
import lang.visitors.Visitor;

public class If extends Node {
  private Expression condition;
  private Node thenBody;
  private Node elseBody;

  public If(Expression condition, Node thenBody, Node elseBody, int line, int column) {
    super(line, column);
    
    this.condition = condition;
    this.thenBody = thenBody;
    this.elseBody = elseBody;
  }

  public If(Expression condition, Node thenBody, int line, int column) {
    super(line, column);
    
    this.condition = condition;
    this.thenBody = thenBody;
    this.elseBody = null;
  }

  public Expression getCondition() {
    return condition;
  }

  public Node getThen() {
    return thenBody;
  }

  public Node getElse() {
    return elseBody;
  }

  public String toString() {
    String ifToString = "if (" + condition.toString() + ") {" + thenBody.toString() + "}";
    String selse = elseBody != null ? " : {" + elseBody.toString() + "}" : "";
    ifToString = ifToString + selse;
    return ifToString.replace('\n', '\0');
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
