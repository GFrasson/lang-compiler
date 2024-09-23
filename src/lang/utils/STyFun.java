/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.utils;

public class STyFun extends SType {
  private SType[] parameterTypes;
  private SType[] returnTypes;

  public STyFun(SType[] types, SType[] returnTypes) {
    this.parameterTypes = types;
    this.returnTypes = returnTypes;
  }

  public SType[] getParameterTypes() {
    return parameterTypes;
  }

  public SType[] getReturnTypes() {
    return returnTypes;
  }

  public boolean match(SType value) {
    if (value instanceof STyErr) {
      return true;
    }

    if (!(value instanceof STyFun)) {
      return false;
    }

    STyFun functionValue = (STyFun) value;
    
    if (functionValue.getParameterTypes().length != parameterTypes.length) {
      return false;
    }

    if (functionValue.getReturnTypes().length != returnTypes.length) {
      return false;
    }

    for (int i = 0; i < parameterTypes.length; i++) {
      if (!parameterTypes[i].match(functionValue.getParameterTypes()[i])) {
        return false;
      }
    }

    for (int i = 0; i < returnTypes.length; i++) {
      if (!returnTypes[i].match(functionValue.getReturnTypes()[i])) {
        return false;
      }
    }

    return true;
  }

  public String toString() {
    String s = "";

    if (parameterTypes.length > 0) {
      for (int i = 0; i < parameterTypes.length; i++) {
        s += parameterTypes[i].toString() + " -> ";
      }
    } else {
      s += "() -> ";
    }

    if (returnTypes.length > 0) {
      s += "(" + returnTypes[0].toString();
      for (int i = 1; i < returnTypes.length; i++) {
        s += " -> " + returnTypes[i].toString();
      }
      s += ")";
    } else {
      s += "()";
    }

    return s;
  }
}
