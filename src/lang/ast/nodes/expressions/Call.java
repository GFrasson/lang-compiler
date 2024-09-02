/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.ast.nodes.expressions;

import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.expressions.variables.base.Variable;

/*
 * Esta classe representa uma chamada de função.
 * Call
 */

import lang.visitors.Visitor;

public class Call extends Expression {
  private String functionName;
  private Expression[] arguments;
  private Expression returnIndex;
  private Variable[] variables;

  public Call(String functionName, Expression[] arguments, int line, int column) {
    super(line, column);
    
    this.functionName = functionName;
    this.arguments = arguments;
  }

  public Call(String functionName, Expression[] arguments, Expression returnIndex, int line, int column) {
    super(line, column);
    
    this.functionName = functionName;
    this.arguments = arguments;
    this.returnIndex = returnIndex;
  }

  public Call(String functionName, Expression[] arguments, Variable[] variables, int line, int column) {
    super(line, column);
    
    this.functionName = functionName;
    this.arguments = arguments;
    this.variables = variables;
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

  public Variable[] getVariables() {
    return variables;
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
