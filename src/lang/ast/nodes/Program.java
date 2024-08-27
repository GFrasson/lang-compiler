package lang.ast.nodes;

import lang.ast.nodes.base.Node;
import lang.ast.nodes.definitions.Function;
import lang.ast.nodes.definitions.base.Definition;

/*
 * Esta classe representa um Programa.
 * Definition*
 */

import lang.visitors.Visitor;

public class Program extends Node {
  private Definition[] definitions;

  public Program(Definition[] definitions) {
    this.definitions = definitions;
  }

  public Definition[] getDefinitions() {
    return this.definitions;
  }

  public String toString() {
    String programString = "";
    for (Definition definition : this.definitions) {
      programString += definition.toString();
    }

    return programString;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
