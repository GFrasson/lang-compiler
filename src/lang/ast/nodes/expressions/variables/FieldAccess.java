package lang.ast.nodes.expressions.variables;

import lang.ast.nodes.expressions.variables.base.Variable;

/*
 * Esta classe representa uma variável de acesso a array.
 * Expr
 */

import lang.visitors.Visitor;

public class FieldAccess extends Variable {
  private Variable object;
  private String field;

  public FieldAccess(Variable object, String field, int line, int column) {
    super(line, column);

    this.object = object;
    this.field = field;
  }

  public Variable getObject() {
    return object;
  }

  public String getField() {
    return field;
  }

  // @Override
  public String toString() {
    String s = this.object.toString() + "." + field;
    return  s; 
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

}
