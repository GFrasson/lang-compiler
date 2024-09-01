package lang.ast.nodes.expressions.literals;

import lang.ast.nodes.expressions.base.Expression;
/*
 * Esta classe representa um valor char
 * Expr
 */
import lang.visitors.Visitor;

public class LiteralChar extends Expression {
  private char value;

  public LiteralChar(char value, int line, int column) {
    super(line, column);
    
    this.value = value;
  }

  public char getValue() {
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
