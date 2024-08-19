package lang.ast;

/*
 * Esta classe representa uma instância de vetor.
 * Instance
 */
import java.util.HashMap;
import lang.visitors.Visitor;

public class Instance extends Node {
  private Var id;
  private Tipo type;
  private Expr size;

  public Instance(Var id, Tipo type, Expr size) {
    this.id = id;
    this.type = type;
    this.size = size;
  }

  public Tipo getType() {
    return type;
  }

  public Var getID() {
    return id;
  }

  public Expr getSize() {
    return size;
  }

  // @Override
  public String toString() {
    return "$" + id.toString() + " " + type.toString() + " " + size.toString() + ";";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
