/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes.definitions.base;

import lang.ast.nodes.base.Node;

/*
 * Esta classe representa um Definition.
 * Function | DataRegister
 */

public abstract class Definition extends Node {
  public Definition(int line, int column) {
    super(line, column);
  }
}
