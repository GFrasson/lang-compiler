package lang.ast.nodes.definitions;

import lang.ast.nodes.Declaration;
import lang.ast.nodes.base.Node;
import lang.ast.nodes.definitions.base.Definition;
import lang.ast.nodes.types.base.Type;

/*
 * Esta classe representa um registro data.
 * data TypeName {}
 */

import lang.visitors.Visitor;

public class DataRegister extends Definition {
  private String typeName;
  private Declaration[] declarations;

  public DataRegister(String typeName, Declaration[] declarations, int line, int column) {
    super(line, column);
    
    this.typeName = typeName;
    this.declarations = declarations;
  }

  public String getTypeName() {
    return typeName;
  }

  public Declaration[] getDeclarations() {
    return declarations;
  }

  public String toString() {
    String dataString = "data " + this.typeName + "{";

    if (this.declarations.length > 0) {
      dataString += this.declarations[0].toString();
      for (int i = 1; i < this.declarations.length; i++) {
        dataString += this.declarations[i].toString();
      }
    }
    
    dataString += "}";

    return dataString;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
