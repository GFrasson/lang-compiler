package lang.ast;

import beaver.Symbol;
import lang.visitors.Visitable;

public abstract class Node extends Symbol implements Visitable {
  public Node() {
  }

  public int getLine() {
    return super.getLine(getStart());
  }

  public int getColumn() {
    return super.getColumn(getStart());
  }
}
