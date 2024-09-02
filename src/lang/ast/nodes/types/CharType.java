/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

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
    return "Char";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
