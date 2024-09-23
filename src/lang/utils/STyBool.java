/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

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
