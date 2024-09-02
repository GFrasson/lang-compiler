/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes.types.base;

import lang.ast.nodes.base.Node;

/*
 * Esta classe representa um tipo.
 */
public abstract class Type extends Node {
  public Type(int line, int column) {
    super(line, column);
  }

  public abstract boolean match(Type type);
}
