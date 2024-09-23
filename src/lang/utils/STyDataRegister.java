package lang.utils;


public class STyDataRegister extends SType {
  private String name;

  public STyDataRegister(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public boolean match(SType value) {
    if (value instanceof STyErr || value instanceof STyNull) {
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
    return this.name;
  }
}
