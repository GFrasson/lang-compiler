package lang.utils;

public class STyNull extends SType {
  private static STyNull stype = new STyNull();

  private STyNull() {
  }

  public static STyNull newSTyNull() {
    return stype;
  }

  public boolean match(SType v) {
    return (v instanceof STyErr) || (v instanceof STyNull);
  }

  public String toString() {
    return "Null";
  }
}
