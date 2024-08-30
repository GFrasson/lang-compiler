package lang.ast.nodes.expressions.binaryOperators;


/*
 * Esta classe representa uma expressão de Multiplicação.
 * Expression * Expression
 */
import java.util.HashMap;

import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.expressions.binaryOperators.base.BinaryOperator;
import lang.visitors.Visitor;

public class Multiplication extends BinaryOperator {
  public Multiplication(Expression left, Expression right, int line, int column) {
    super(left, right, line, column);    
  }

  // @Override
  public String toString() {
    String s = getLeft().toString();
    if (getLeft() instanceof Multiplication || getLeft() instanceof Add) {
      s = "(" + s + ")";
    }
    String ss = getRight().toString();
    if (getRight() instanceof Add) {
      ss = "(" + ss + ")";
    }
    return s + " * " + ss;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
