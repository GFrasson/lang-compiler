package lang.ast.nodes.expressions.variables;

import lang.ast.nodes.expressions.variables.base.Variable;

/*
 * Esta classe representa uma variável.
 * Expr
 */

import lang.visitors.Visitor;

public class SimpleVariable extends Variable {
  private String name;

  public SimpleVariable(String name, int line, int column) {
    super(line, column);
    
    this.name = name;
  }

  public String getName() {
    return name;
  }

  // @Override
  public String toString() {
    return name;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
