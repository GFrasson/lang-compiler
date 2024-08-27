package lang.ast.nodes.types;

import lang.ast.nodes.types.base.Type;
import lang.visitors.Visitor;

/*
 * Esta classe representa um tipo Float.
 * Expr
 */
public class FloatType extends Type {
  public FloatType() {
  }

  public boolean match(Type type) {
    return type instanceof FloatType;
  }

  public String toString() {
    return "Float";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
