/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

import java.io.FileReader;
import java.io.IOException;

import lang.scanner.LangScanner;
import lang.scanner.Token;

public class App {
    public static void main(String args[]) throws IOException {
        LangScanner langScanner = new LangScanner(new FileReader(args[0]));
        Token token = langScanner.nextToken();
        
        while (token != null) {
            // Padrao de impressao: TAG: lexema | valor
            System.out.println(token.toStringShortRepresentation());
            
            // Padrao de impressao: TAG: [(linha, coluna) TAG: "lexema" : <valor>]
            // System.out.println(token.toString());
            
            token = langScanner.nextToken();
        }

        System.out.println("Total de tokens lidos " + langScanner.getTokensAmount());
    }
}
