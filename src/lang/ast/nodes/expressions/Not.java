package lang.ast.nodes.expressions;

import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.expressions.literals.LiteralFloat;
import lang.ast.nodes.expressions.literals.LiteralInt;

/*
 * Esta classe representa uma expressão negação.
 * !Expr
 */

import lang.visitors.Visitor;

public class Not extends Expression {
  Expression expression;

  public Not(Expression expression) {
    this.expression = expression;
  }

  public Expression getExpression() {
    return expression;
  }

  public String toString() {
    String notString = expression.toString();
    if (!(expression instanceof LiteralInt || expression instanceof LiteralFloat || expression instanceof Variable || expression instanceof True
        || expression instanceof False)) {
      notString = "!" + notString;
    }
    return notString;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
