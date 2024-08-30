package lang.ast.nodes.types;

import lang.ast.nodes.types.base.Type;
import lang.visitors.Visitor;

/*
 * Esta classe representa um tipo Char.
 * Expr
 */
public class CharType extends Type {
  public CharType(int line, int column) {
    super(line, column);
  }

  public boolean match(Type type) {
    return type instanceof CharType;
  }

  public String toString() {
    return "Float";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
