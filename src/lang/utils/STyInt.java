/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

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
