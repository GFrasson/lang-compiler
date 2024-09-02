/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.parser;

import java.io.*;
import lang.ast.SuperNode;
import lang.parser.*;
import java.util.List;


// Adaptador para classe de parser. a Função parseFile deve retornar null caso o parser resulte em erro. 

public interface ParseAdaptor{
   public abstract SuperNode parseFile(String path);
   
}



