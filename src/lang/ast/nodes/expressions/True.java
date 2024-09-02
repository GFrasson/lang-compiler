/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes.expressions;

import lang.ast.nodes.expressions.base.Expression;

/*
 * Esta classe representa uma valor booleano True.
 * Expr
 */

import lang.visitors.Visitor;

public class True extends Expression {
  public True(int line, int column) {
    super(line, column);
  }

  public boolean getValue() {
    return true;
  }

  // @Override
  public String toString() {
    return "true";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
