/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes.expressions.literals;

import lang.ast.nodes.expressions.base.Expression;
/*
 * Esta classe representa um valor char
 * Expr
 */
import lang.visitors.Visitor;

public class LiteralChar extends Expression {
  private char value;
  private String charText;

  public LiteralChar(char value, String charText, int line, int column) {
    super(line, column);
    
    this.value = value;
    this.charText = charText;
  }

  public char getValue() {
    return value;
  }

  public String getCharText() {
    return this.charText;
  }

  // @Override
  public String toString() {
    return "" + value;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
