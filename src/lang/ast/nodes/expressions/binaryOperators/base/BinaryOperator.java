/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes.expressions.binaryOperators.base;


import lang.ast.nodes.expressions.base.Expression;

/*
 * Esta classe representa uma Operação binária.
 * Expression [operação] Expression
 */

public abstract class BinaryOperator extends Expression {
  private Expression left;
  private Expression right;

  public BinaryOperator(Expression left, Expression right, int line, int column) {
    super(line, column);
    
    this.left = left;
    this.right = right;
  }

  public void setLeft(Expression expression) {
    left = expression;
  }

  public void setRight(Expression expression) {
    right = expression;
  }

  public Expression getLeft() {
    return left;
  }

  public Expression getRight() {
    return right;
  }
}
