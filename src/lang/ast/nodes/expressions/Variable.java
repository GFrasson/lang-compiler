package lang.ast.nodes.expressions;

import lang.ast.nodes.expressions.base.Expression;

/*
 * Esta classe representa uma variável.
 * Expr
 */

import lang.visitors.Visitor;

public class Variable extends Expression {
  private Expression[] indexes;
  private String name;

  public Variable(String name, Expression[] indexes) {
    this.indexes = indexes;
    this.name = name;
  }

  public Variable(String name) {
    this.name = name;
    this.indexes = null;
  }

  public Expression[] getIndexes() {
    return indexes;
  }

  public String getName() {
    return name;
  }

  // @Override
  public String toString() {
    String s = name;
    if (indexes != null) {
      for (Expression expression : indexes) {
        s += "[";
        s += expression.toString();
        s += "]";
      }
    }
    return s;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
