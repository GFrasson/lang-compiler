package lang.utils;

import java.util.HashMap;
import java.util.Map;

public class STyDataRegister extends SType {
  private HashMap<String, SType> declarations;

  public STyDataRegister(HashMap<String, SType> declarations) {
    this.declarations = declarations;
  }

  public HashMap<String, SType> getDeclarations() {
    return declarations;
  }

  public boolean match(SType value) {
    boolean result = false;
    if (value instanceof STyDataRegister) {
      // if (((STyDataRegister) value).getParameterTypes().length == types.length) {
      //   result = true;
      //   for (int i = 0; i < types.length; i++) {
      //     result = result && types[i].match(((STyDataRegister) value).getParameterTypes()[i]);
      //   }
      // }
    }

    return result;
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
