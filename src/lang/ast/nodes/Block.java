/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes;

import lang.ast.nodes.base.Node;

/*
 * Esta classe representa um bloco de comandos.
 * { cmd* }
 */

import lang.visitors.Visitor;

public class Block extends Node {
  private Node[] commands;

  public Block(Node[] commands, int line, int column) {
    super(line, column);

    this.commands = commands;
  }

  public String toString() {
    String s = "";
    for (Node command : commands) {
      s += command.toString();
    }
    return s;
  }

  public Node[] getCommands() {
    return commands;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
