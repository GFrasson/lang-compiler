package lang.ast.nodes.expressions.variables.base;

import lang.ast.nodes.expressions.base.Expression;

/*
 * Esta classe representa uma variável.
 * Expr
 */

public abstract class Variable extends Expression {
  public Variable(int line, int column) {
    super(line, column);
  }
}
