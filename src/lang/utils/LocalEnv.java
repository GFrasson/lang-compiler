/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.utils;

public class LocalEnv<A> extends TyEnv<A> {
  private String id;
  private SType type;

  public LocalEnv(String id, SType type) {
    this.type = type;
    this.id = id;
  }

  public String getFuncID() {
    return id;
  }

  public SType getFunctionType() {
    return type;
  }

  public String toString() {
    String s = "--------------- (" + id + "," + type.toString() + ") ---------------\n";
    s += super.toString();
    return s;
  }
}
