package lang.ast.nodes;

import lang.ast.nodes.base.Node;
import lang.ast.nodes.types.base.Type;

import java.util.Arrays;

/*
 * Esta classe representa uma declaração do registro.
 * id :: Type;
 */

import lang.visitors.Visitor;

public class Declaration extends Node {
  private String name;
  private Type type;

  public Declaration(String name, Type type) {
    this.name = name;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public Type getType() {
    return type;
  }

  public String toString() {
    return this.name + " :: " + this.type.toString() + ";";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
