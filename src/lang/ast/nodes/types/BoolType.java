package lang.ast.nodes.types;

import lang.ast.nodes.types.base.Type;
import lang.visitors.Visitor;

/*
 * Esta classe representa um tipo Bool.
 * Expr
 */
public class BoolType extends Type {
  public BoolType(int line, int column) {
    super(line, column);
  }

  public boolean match(Type type) {
    return type instanceof BoolType;
  }

  public String toString() {
    return "Bool";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
