/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes.types;

import lang.ast.nodes.types.base.Type;
import lang.visitors.Visitor;

/*
 * Esta classe representa um tipo array.
 * Expr
 */

public class ArrayType extends Type {
  private Type argumentType;

  public ArrayType(Type type, int line, int column) {
    super(line, column);
    
    argumentType = type;
  }

  public Type getArgumentType() {
    return argumentType;
  }

  public boolean match(Type type) {
    if (type instanceof ArrayType) {
      return argumentType.match(((ArrayType) type).getArgumentType());
    }
    return false;
  }

  public String toString() {
    return this.argumentType.toString() + "[]";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
