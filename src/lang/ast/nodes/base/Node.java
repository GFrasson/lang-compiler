/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes.base;

import lang.ast.SuperNode;
import lang.visitors.Visitable;

public abstract class Node implements Visitable, SuperNode {
  private int line;
  private int column;

  public Node(int line, int column){
    this.line = line;
    this.column = column;
  }

  public int getLine() {
    return this.line;
  }

  public int getColumn() {
    return this.column;
  }
}
