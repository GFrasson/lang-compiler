package lang.ast.nodes.expressions.literals;

import lang.ast.nodes.expressions.base.Expression;
/*
 * Esta classe representa um valor inteiro
 * Expr
 */
import lang.visitors.Visitor;

public class LiteralInt extends Expression {
  private int value;

  public LiteralInt(int value, int line, int column) {
    super(line, column);
    
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  // @Override
  public String toString() {
    return "" + value;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
