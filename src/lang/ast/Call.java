package lang.ast;

/*
 * Esta classe representa uma chamada de função.
 * Call
 */

import lang.visitors.Visitor;

public class Call extends Expression {
  private String functionName;
  private Expression[] arguments;
  private Expression returnIndex;

  public Call(String functionName, Expression[] arguments) {
    this.functionName = functionName;
    this.arguments = arguments;
  }

  public Call(String functionName, Expression[] arguments, Expression returnIndex) {
    this.functionName = functionName;
    this.arguments = arguments;
    this.returnIndex = returnIndex;
  }

  public String getFunctionName() {
    return functionName;
  }

  public Expression[] getArguments() {
    return arguments;
  }

  public Expression getReturnIndex() {
    return returnIndex;
  }

  // @Override
  public String toString() {
    String functionToString = functionName + "(";
    if (arguments.length > 0) {
      functionToString += arguments[0].toString();
      for (int i = 1; i < arguments.length; i++) {
        functionToString += "," + arguments[i].toString();
      }
    }
    functionToString += ")";
    return functionToString;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
