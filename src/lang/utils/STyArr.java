/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.utils;

public class STyArr extends SType {
  private SType arg;

  public STyArr(SType type) {
    arg = type;
  }

  public SType getArg() {
    return arg;
  }

  public boolean match(SType value) {
    return (value instanceof STyErr) || (value instanceof STyNull) || (value instanceof STyArr) && (arg.match(((STyArr) value).getArg()));
  }

  public String toString() {
    return arg.toString() + "[]";
  }
}
