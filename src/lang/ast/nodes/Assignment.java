package lang.ast.nodes;

import lang.ast.nodes.base.Node;
import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.expressions.variables.base.Variable;

/*
 * Esta classe representa um comando de atribuição.
 * ID = Expr
 */

import lang.visitors.Visitor;

public class Assignment extends Node {
  private Variable id;
  private Expression expression;

  public Assignment(Variable id, Expression expression, int line, int column) {
    super(line, column);
    
    this.id = id;
    this.expression = expression;
  }

  public Variable getID() {
    return id;
  }

  public Expression getExpression() {
    return expression;
  }

  public String toString() {
    return id.toString() + " = " + expression.toString() + ";";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
