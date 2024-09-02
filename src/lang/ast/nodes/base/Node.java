package lang.ast.nodes.base;

import lang.ast.SuperNode;
import lang.visitors.Visitable;

public abstract class Node extends SuperNode implements Visitable {
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
