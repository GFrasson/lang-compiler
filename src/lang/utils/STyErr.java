package lang.utils;

public class STyErr extends SType {
  private static STyErr stype = new STyErr();

  private STyErr() {
  }

  public static STyErr newSTyErr() {
    return stype;
  }

  public SType clone() {
    return STyErr.newSTyErr();
  }

  public boolean match(SType v) {
    return true;
  }

  public String toString() {
    return "TyError";
  }
}
