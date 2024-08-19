package lang.ast;

/*
 * Esta classe representa uma função.
 * Function
 */

import lang.visitors.Visitor;

public class Function extends Node {
  private String functionName;
  private Param[] params;
  private Tipo[] type;
  private Node body;

  public Function(String functionName, Param[] params, Tipo[] type, Node body) {
    this.functionName = functionName;
    this.type = type;
    this.params = params;
    this.body = body;
  }

  public String getID() {
    return functionName;
  }

  public Tipo[] getType() {
    return type;
  }

  public Param[] getParams() {
    return params;
  }

  public Node getBody() {
    return body;
  }

  public String toString() {
    String functionToString = functionName.toString() + "(";
    if (params.length > 0) {
      functionToString += params[0].toString();
      for (int i = 1; i < params.length; i++) {
        functionToString += params[i].toString();
      }
    }
    functionToString += ") : " + type.toString() + "{" + body.toString() + "}";
    return functionToString;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
