/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes.types;

import lang.ast.nodes.types.base.Type;
import lang.visitors.Visitor;

/*
 * Esta classe representa um tipo Float.
 * Expr
 */
public class FloatType extends Type {
  public FloatType(int line, int column) {
    super(line, column);
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
