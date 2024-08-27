package lang.ast.nodes;

/*
 * Esta classe representa uma instância de vetor.
 * Instance
 */
import java.util.HashMap;

import lang.ast.nodes.base.Node;
import lang.ast.nodes.expressions.Variable;
import lang.ast.nodes.types.base.Type;
import lang.visitors.Visitor;

public class Instance extends Node {
  private Variable id;
  private Type type;
  private Expr size;

  public Instance(Variable id, Type type, Expr size) {
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

  public Expr getSize() {
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
