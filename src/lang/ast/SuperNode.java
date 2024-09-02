/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast;

public interface SuperNode {
  // The line and column of the node in the input text
  public abstract int getLine();

  public abstract int getColumn();
}
