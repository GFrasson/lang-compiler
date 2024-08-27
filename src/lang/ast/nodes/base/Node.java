package lang.ast.nodes.base;

import beaver.Symbol;
import lang.ast.SuperNode;
import lang.visitors.Visitable;

public abstract class Node extends Symbol implements Visitable, SuperNode {
  public Node() {
  }

  public int getLine() {
    return super.getLine(getStart());
  }

  public int getColumn() {
    return super.getColumn(getStart());
  }
}
