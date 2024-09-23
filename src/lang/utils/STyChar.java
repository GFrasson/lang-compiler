/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.utils;

public class STyChar extends SType {
  private static STyChar stype = new STyChar();

  private STyChar() {
  }

  public static STyChar newSTyChar() {
    return stype;
  }

  public boolean match(SType v) {
    return (v instanceof STyErr) || (v instanceof STyChar);
  }

  public String toString() {
    return "Char";
  }
}
