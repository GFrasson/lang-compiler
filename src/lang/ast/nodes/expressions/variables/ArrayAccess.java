/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes.expressions.variables;

import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.expressions.variables.base.Variable;

/*
 * Esta classe representa uma variável de acesso a array.
 * Expr
 */

import lang.visitors.Visitor;

public class ArrayAccess extends Variable {
  private Variable array;
  private Expression index;

  public ArrayAccess(Variable array, Expression index, int line, int column) {
    super(line, column);

    this.array = array;
    this.index = index;
  }

  public Variable getArray() {
    return array;
  }

  public Expression getIndex() {
    return index;
  }

  // @Override
  public String toString() {
    String s = this.array.toString() + "[" + index + "]";
    return  s; 
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

}
