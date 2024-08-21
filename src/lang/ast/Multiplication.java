package ast;

/*
 * Esta classe representa uma expressão de Multiplicação.
 * Expr * Expr
 */
import java.util.HashMap; 
import visitors.Visitor;

public class Multiplication extends BinaryOperator {
      public Multiplication(Expr left, Expr right){
           super(left,right);
      }
      
      //@Override
      public String toString(){
         String leftString = getLeft().toString();
         if(getLeft() instanceof Multiplication || getLeft() instanceof Add){
            leftString = "(" + leftString + ")";
         }
         String rightString = getRight().toString();
         if( getRight() instanceof Add){
            rightString = "(" + rightString+ ")";
         }
         return   leftString + " * " + rightString;
      }
      
      public void accept(Visitor visitor){ visitor.visit(this);}
}
