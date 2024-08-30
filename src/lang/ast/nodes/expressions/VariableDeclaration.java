package lang.ast.nodes.expressions;

import lang.ast.nodes.base.Node;
import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.types.base.Type;

import java.util.Arrays;

/*
 * Esta classe representa uma declaração de variável.
 * new Type [exp];
 */

import lang.visitors.Visitor;

public class VariableDeclaration extends Expression {
  private Type type;
  private Expression expression;

  public VariableDeclaration(Type type, Expression expression, int line, int column) {
    super(line, column);

    this.type = type;
    this.expression = expression;
  }

  public Type getType() {
    return type;
  }

  public Expression getExpression() {
    return expression;
  }

  public String toString() {
    String s = "new " + this.type.toString();
    if (this.expression != null) {
      s += "[" + this.expression.toString() + "]";
    }
    return s;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
