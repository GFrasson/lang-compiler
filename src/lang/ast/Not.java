package ast;

/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

/*
 * Esta classe representa uma expressão negação.
 * !Expr
 */
 
import java.util.HashMap; 
import visitors.Visitor;

public class Not extends Expression {
      
      Expr expr; 
      
      public Not(Expr expr){
           this.expr = expr;
      }
      
      public Expr getExpr(){ return expr; }
      public String toString(){
         String exprToString = expr.toString();
         if(! (expr instanceof NInt || expr instanceof NFloat || expr instanceof Var || expr instanceof True || expr instanceof False)){
            exprToString = "!" + exprToString;
         }
         return   exprToString ;
      }
      
      public void accept(Visitor visitor){ visitor.visit(this);}
}
