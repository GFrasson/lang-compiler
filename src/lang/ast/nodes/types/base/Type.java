package lang.ast.nodes.types.base;

import lang.ast.nodes.base.Node;

/*
 * Esta classe representa um tipo.
 */
public abstract class Type extends Node {
  public Type() {
  }

  public abstract boolean match(Type type);
}
