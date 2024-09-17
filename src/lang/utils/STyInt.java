package lang.utils;

public class STyInt extends SType {
  private static STyInt stype = new STyInt();

  private STyInt() {
  }

  public static STyInt newSTyInt() {
    return stype;
  }

  public boolean match(SType v) {
    return (v instanceof STyErr) || (v instanceof STyInt);
  }

  public String toString() {
    return "Int";
  }
}
