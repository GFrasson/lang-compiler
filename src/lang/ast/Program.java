package lang.ast;

/*
 * Esta classe representa um Programa.
 * Program
 */

import lang.visitors.Visitor;

public class Program extends Node {
  private Function[] functions;

  public Program(Function[] f) {
    functions = f;
  }

  public Function[] getFuncs() {
    return functions;
  }

  public String toString() {
    String s = "";
    for (Function f : functions) {
      s += f.toString();
    }
    return s;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
