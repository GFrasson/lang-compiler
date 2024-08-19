package lang.ast;

/*
 * Esta classe representa um comando de atribuição.
 * ID = Expr
 */

import lang.visitors.Visitor;

public class Assignment extends Node {
  private Var id;
  private Expr expression;

  public Assignment(Var id, Expr expression) {
    this.id = id;
    this.expression = expression;
  }

  public Var getID() {
    return id;
  }

  public Expr getExpression() {
    return expression;
  }

  public String toString() {
    return id.toString() + " = " + expression.toString() + ";";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
