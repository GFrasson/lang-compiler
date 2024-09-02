/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes;

import lang.ast.nodes.base.Node;
import lang.ast.nodes.types.base.Type;

/*
 * Esta classe representa uma declaração do registro.
 * id :: Type;
 */

import lang.visitors.Visitor;

public class Declaration extends Node {
  private String name;
  private Type type;

  public Declaration(String name, Type type, int line, int column) {
    super(line, column);
    
    this.name = name;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public Type getType() {
    return type;
  }

  public String toString() {
    return this.name + " :: " + this.type.toString() + ";";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
