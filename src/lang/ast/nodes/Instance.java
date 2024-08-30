package lang.ast.nodes;

/*
 * Esta classe representa uma instância de vetor.
 * Instance
 */
import java.util.HashMap;

import lang.ast.nodes.base.Node;
import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.expressions.variables.base.Variable;
import lang.ast.nodes.types.base.Type;
import lang.visitors.Visitor;

public class Instance extends Node {
  private Variable id;
  private Type type;
  private Expression size;

  public Instance(Variable id, Type type, Expression size, int line, int column) {
    super(line, column);
    
    this.id = id;
    this.type = type;
    this.size = size;
  }

  public Type getType() {
    return type;
  }

  public Variable getID() {
    return id;
  }

  public Expression getSize() {
    return size;
  }

  // @Override
  public String toString() {
    return "$" + id.toString() + " " + type.toString() + " " + size.toString() + ";";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
