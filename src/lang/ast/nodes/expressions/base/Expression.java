package lang.ast.nodes.expressions.base;

import lang.ast.nodes.base.Node;

/*
 * Esta classe representa um comando de Expressão.
 * Expression
 */
public abstract class Expression extends Node {
  public Expression(int line, int column) {
    super(line, column);
  }
}
