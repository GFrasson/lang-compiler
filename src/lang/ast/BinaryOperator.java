package lang.ast;

/*
 * Esta classe representa uma Operação binária.
 * Expr [operação] Expr
 */

public abstract class BinaryOperator extends Expr {
  private Expr left;
  private Expr right;

  public BinaryOperator(Expr left, Expr right) {
    this.left = left;
    this.right = right;
  }

  public void setLeft(Expr expression) {
    left = expression;
  }

  public void setRight(Expr expression) {
    right = expression;
  }

  public Expr getLeft() {
    return left;
  }

  public Expr getRight() {
    return right;
  }
}
