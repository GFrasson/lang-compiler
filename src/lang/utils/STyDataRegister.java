package lang.utils;

import java.util.HashMap;
import java.util.Map;

public class STyDataRegister extends SType {
  private String name;
  private HashMap<String, SType> declarations = new HashMap<>();
  private boolean initialized;

  public STyDataRegister(String name, boolean initialized) {
    this.name = name;
    this.initialized = initialized;
  }

  public STyDataRegister(String name, boolean initialized, HashMap<String, SType> declarations) {
    this.name = name;
    this.initialized = initialized;
    this.declarations = declarations;
  }

  public boolean hasDeclaration(String key) {
    return this.declarations.containsKey(key);
  }

  public SType getDeclaration(String key) {
    SType declaration = this.declarations.get(key);

    // if (declaration instanceof STyDataRegister) {
    //   STyDataRegister dataRegisterType = (STyDataRegister) declaration;
    //   System.out.println("DATA " + this.name);
    //   System.out.println("DECLARATION " + declaration.toString());
    //   System.out.println(dataRegisterType.isInitialized());
    //   return dataRegisterType.isInitialized() ? declaration : null;
    // }

    // if (declaration instanceof STyArr) {
    //   STyArr arrayType = (STyArr) declaration;
    //   System.out.println("ARRAY");
    //   System.out.println(arrayType.isInitialized());
    //   return arrayType.isInitialized() ? declaration : null;
    // }

    return declaration;
  }

  public HashMap<String, SType> getDeclarations() {
    return this.declarations;
  }

  public void putDeclaration(String name, SType value) {
    this.declarations.put(name, value);
  }

  public String getName() {
    return this.name;
  }

  public boolean isInitialized() {
    return this.initialized;
  }

  public void setInitialized(boolean value) {
    this.initialized = value;
  }

  public STyDataRegister clone() {    
    HashMap<String, SType> declarationsCopy = new HashMap<>();
    for (Map.Entry<String, SType> entry : this.declarations.entrySet()) {
      declarationsCopy.put(entry.getKey(), entry.getValue().clone());
    }

    return new STyDataRegister(this.name, this.initialized, declarationsCopy);
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
    return this.name + " / " + this.declarations.toString() + " / " + this.initialized;
  }
}
