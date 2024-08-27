package lang.ast.nodes.expressions;

import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.expressions.literals.LiteralFloat;
import lang.ast.nodes.expressions.literals.LiteralInt;

/*
 * Esta classe representa uma expressão menos unário.
 * -Expr
 */

import lang.visitors.Visitor;

public class UnaryMinus extends Expression {
  Expression expression;

  public UnaryMinus(Expression expression) {
    this.expression = expression;
  }

  public Expression getExpression() {
    return expression;
  }

  public String toString() {
    String unaryMinusString = expression.toString();
    if ((expression instanceof LiteralInt || expression instanceof LiteralFloat)) {
      unaryMinusString = "-" + unaryMinusString;
    }
    return unaryMinusString;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
