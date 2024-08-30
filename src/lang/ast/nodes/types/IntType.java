package lang.ast.nodes.types;

import lang.ast.nodes.types.base.Type;
import lang.visitors.Visitor;

/*
 * Esta classe representa um tipo Inteiro.
 * Type
 */
public class IntType extends Type {
  public IntType(int line, int column) {
    super(line, column);
  }

  public boolean match(Type type) {
    return type instanceof IntType;
  }

  public String toString() {
    return "Int";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
