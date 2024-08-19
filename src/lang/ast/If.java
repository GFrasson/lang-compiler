package lang.ast;

/*
 * Esta classe representa um comando condicional.
 * ?(E) {C} : {C} 
 */

import java.util.HashMap;
import lang.visitors.Visitor;

public class If extends Node {
  private Expr condition;
  private Node thenBody;
  private Node elseBody;

  public If(Expr condition, Node thenBody, Node elseBody) {
    this.condition = condition;
    this.thenBody = thenBody;
    this.elseBody = elseBody;
  }

  public If(Expr condition, Node thenBody) {
    this.condition = condition;
    this.thenBody = thenBody;
    this.elseBody = null;
  }

  public Expr getCondition() {
    return condition;
  }

  public Node getThen() {
    return thenBody;
  }

  public Node getElse() {
    return elseBody;
  }

  public String toString() {
    String ifToString = "?(" + condition.toString() + "){" + thenBody.toString() + "}";
    String sels = elseBody != null ? " : {" + elseBody.toString() + "}" : "";
    ifToString = ifToString + sels;
    return ifToString.replace('\n', '\0');
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
