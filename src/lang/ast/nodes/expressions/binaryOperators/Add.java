/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes.expressions.binaryOperators;

import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.expressions.binaryOperators.base.BinaryOperator;

/*
 * Esta classe representa uma expressão de soma.
 * Expr + Expr
 */

import lang.visitors.Visitor;

public class Add extends BinaryOperator {
  public Add(Expression left, Expression right, int line, int column) {
    super(left, right, line, column);
  }

  public String toString() {
    String leftString = getLeft().toString();
    String rightString = getRight().toString();
    if (getRight() instanceof Add) {
      rightString = "(" + rightString + ")";
    }
    return leftString + " + " + rightString;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
