/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes.types;

import lang.ast.nodes.types.base.Type;
import lang.visitors.Visitor;

/*
 * Esta classe representa um tipo Data.
 * Type
 */
public class DataType extends Type {
  private String typeName;

  public DataType(String typeName, int line, int column) {
    super(line, column);

    this.typeName = typeName;
  }

  public String getTypeName() {
    return typeName;
  }

  public boolean match(Type type) {
    return type instanceof DataType;
  }

  public String toString() {
    return "Data";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
