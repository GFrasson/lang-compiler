/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.utils;

public class STyErr extends SType {
  private static STyErr stype = new STyErr();

  private STyErr() {
  }

  public static STyErr newSTyErr() {
    return stype;
  }

  public boolean match(SType v) {
    return true;
  }

  public String toString() {
    return "TyError";
  }
}
