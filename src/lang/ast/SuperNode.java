package lang.ast;

public interface SuperNode {
  // The line and column of the node in the input text
  public abstract int getLine();

  public abstract int getColumn();
}
