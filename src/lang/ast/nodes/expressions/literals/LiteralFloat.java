/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes.expressions.literals;

import lang.ast.nodes.expressions.base.Expression;
/*
 * Esta classe representa um valor float
 * Expr
 */
import lang.visitors.Visitor;

public class LiteralFloat extends Expression {
  private float value;

  public LiteralFloat(float value, int line, int column) {
    super(line, column);
    
    this.value = value;
  }

  public float getValue() {
    return value;
  }

  // @Override
  public String toString() {
    return "" + value;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
