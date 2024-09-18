package lang.utils;

import java.util.HashMap;
import java.util.Map;

public class STyDataRegister extends SType {
  private String name;
  private HashMap<String, SType> declarations;

  public STyDataRegister(String name, HashMap<String, SType> declarations) {
    this.name = name;
    this.declarations = declarations;
  }

  public HashMap<String, SType> getDeclarations() {
    return declarations;
  }

  public boolean match(SType value) {
    if (value instanceof STyErr) {
      return true;
    }
    
    if (!(value instanceof STyDataRegister)) {
      return false;
    }

    STyDataRegister dataRegisterValue = (STyDataRegister) value;

    if (dataRegisterValue.name.equals(this.name)) {
      return true;
    }

    return false;
  }

  public String toString() {
    String s = "data {";
    for (Map.Entry<String, SType> declaration : this.declarations.entrySet()) {
      s += declaration.getKey() + " :: " + declaration.getValue().toString() + ",";
    }
    s += "}";

    return s;
  }
}
