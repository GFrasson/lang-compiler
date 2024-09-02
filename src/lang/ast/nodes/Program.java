/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes;

import lang.ast.nodes.base.Node;
import lang.ast.nodes.definitions.base.Definition;

/*
 * Esta classe representa um Programa.
 * Definition*
 */

import lang.visitors.Visitor;

public class Program extends Node {
  private Definition[] definitions;

  public Program(Definition[] definitions, int line, int column) {
    super(line, column);
    
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
