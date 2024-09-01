package lang.ast.nodes;

import lang.ast.nodes.base.Node;
import lang.ast.nodes.expressions.variables.base.Variable;
/*
 * Esta classe representa um comando de leitura.
 * read Expr
 */
import lang.visitors.Visitor;

public class Read extends Node {
  private Variable variable;

  public Read(Variable variable, int line, int column) {
    super(line, column);
    
    this.variable = variable;
  }

  public Variable getVariable() {
    return variable;
  }

  // @Override
  public String toString() {
    return "read " + variable.toString() + ";";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
