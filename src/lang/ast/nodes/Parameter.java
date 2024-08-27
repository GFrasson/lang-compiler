package lang.ast.nodes;

import lang.ast.nodes.base.Node;
import lang.ast.nodes.types.base.Type;
/*
 * Esta classe representa um Parâmetro.
 * Node
 */
import lang.visitors.Visitor;

public class Parameter extends Node {
  private String name;
  private Type type;

  public Parameter(String name, Type type) {
    this.name = name;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public Type getType() {
    return type;
  }

  // @Override
  public String toString() {
    return name.toString() + ":" + type.toString();
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
