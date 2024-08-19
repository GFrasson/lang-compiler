package lang.parser;

import java.io.FileReader;

import lang.ast.SuperNode;
import lang.scanner.LangScanner;

public class LangParserAdaptor implements ParseAdaptor {
  public LangParserAdaptor() {
  }

  public SuperNode parseFile(String path) {
    try {
      LangScanner langScanner = new LangScanner(new FileReader(path));
      LangParser langParser = new LangParser();

      return (SuperNode) langParser.parse(langScanner);
    } catch (Exception e) {
      return null;
    }
  }
}
