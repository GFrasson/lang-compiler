package lang.ast.nodes.definitions;

import lang.ast.nodes.Block;
import lang.ast.nodes.Parameter;
import lang.ast.nodes.base.Node;
import lang.ast.nodes.definitions.base.Definition;
import lang.ast.nodes.types.base.Type;

/*
 * Esta classe representa uma função.
 * ID (Params) ReturnType? { Cmd* }
 */

import lang.visitors.Visitor;

public class Function extends Definition {
  private String functionName;
  private Parameter[] parameters;
  private Type[] returnTypes;
  private Block body;

  public Function(String functionName, Parameter[] parameters, Type[] returnTypes, Block body, int line, int column) {
    super(line, column);
    
    this.functionName = functionName;
    this.returnTypes = returnTypes;
    this.parameters = parameters;
    this.body = body;
  }

  public String getID() {
    return functionName;
  }

  public Type[] getReturnTypes() {
    return returnTypes;
  }

  public Parameter[] getParameters() {
    return parameters;
  }

  public Block getBody() {
    return body;
  }

  public String toString() {
    String functionToString = functionName.toString() + "(";
    if (parameters.length > 0) {
      functionToString += parameters[0].toString();
      for (int i = 1; i < parameters.length; i++) {
        functionToString += parameters[i].toString();
      }
    }
    functionToString += ") : " + returnTypes.toString() + "{" + body.toString() + "}";
    return functionToString;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
