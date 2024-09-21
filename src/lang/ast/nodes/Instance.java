/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes;

/*
 * Esta classe representa uma instância de vetor ou registro.
 * Instance
 */
import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.types.base.Type;
import lang.visitors.Visitor;

public class Instance extends Expression {
  private Type type;
  private Expression size;

  public Instance(Type type, Expression size, int line, int column) {
    super(line, column);
    
    this.type = type;
    this.size = size;
  }

  public Type getType() {
    return type;
  }

  public Expression getSize() {
    return size;
  }

  // @Override
  public String toString() {
    return "new " + type.toString() + " " + size.toString() + ";";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
