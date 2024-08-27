package lang.ast.nodes;

import lang.ast.nodes.base.Node;
/*
 * Esta classe representa uma lista de comandos
 * Statement ; StatementList
 */
import lang.visitors.Visitor;

public class StatementList extends Node {
  private Node command1;
  private Node command2;

  public StatementList(Node command1, Node command2) {
    this.command1 = command1;
    this.command2 = command2;
  }

  public StatementList(Node command1) {
    this.command1 = command1;
    this.command2 = null;
  }

  public Node getCommand1() {
    return command1;
  }

  public Node getCommand2() {
    return command2;
  }

  // @Override
  public String toString() {
    if (command2 != null && !(command2 instanceof StatementList)) {
      return command1.toString() + "\n" + command2.toString();
    }
    return command1.toString() + "\n" + (command2 != null ? command2.toString() : "");
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
