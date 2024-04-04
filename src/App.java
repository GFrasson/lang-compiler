import java.io.FileReader;
import java.io.IOException;
import scanner.LangScanner;

public class App {
    public static void main(String args[]) throws IOException {
        LangScanner langScanner = new LangScanner(new FileReader(args[0]));
        Token token = langScanner.nextToken();
        
        while (token != null) {
            System.out.println(token.toString());
            token = langScanner.nextToken();
        }

        System.out.println("Total de tokens lidos " + langScanner.readedTokens());
    }
}
