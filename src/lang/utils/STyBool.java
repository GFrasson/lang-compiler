package lang.utils;

public class STyBool extends SType {
  private static STyBool stype = new STyBool();

  private STyBool() {
  }

  public static STyBool newSTyBool() {
    return stype;
  }

  public boolean match(SType v) {
    return (v instanceof STyErr) || (v instanceof STyBool);
  }

  public String toString() {
    return "Bool";
  }
}
