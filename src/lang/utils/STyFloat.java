package lang.utils;

public class STyFloat extends SType {
  private static STyFloat stype = new STyFloat();

  private STyFloat() {
  }

  public static STyFloat newSTyFloat() {
    return stype;
  }

  public boolean match(SType v) {
    return (v instanceof STyErr) || (v instanceof STyFloat);
  }

  public String toString() {
    return "Float";
  }
}
