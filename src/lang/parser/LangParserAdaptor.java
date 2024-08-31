package lang.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import lang.parser.langParser.ProgContext;

import lang.ast.SuperNode;

public class LangParserAdaptor implements ParseAdaptor {
  public LangParserAdaptor() {
  }

  public SuperNode parseFile(String path) {
    try {
      // Create a ANTLR CharStream from a file
      CharStream stream = CharStreams.fromFileName(path);
      // create a lexer that feeds off of stream
      langLexer lex = new langLexer(stream);
      // create a buffer of tokens pulled from the lexer
      CommonTokenStream tokens = new CommonTokenStream(lex);
      // create a parser that feeds off the tokens buffer
      langParser parser = new langParser(tokens);
      parser.setBuildParseTree(false);

      ProgContext tree = parser.prog();

      System.out.println(tree.toStringTree(parser));      
      for (Token token : tokens.getTokens())
      {
        System.out.println(token.getText() + " - " + token.getType());
      }

      return (SuperNode) tree.ast;
    } catch (Exception e) {
      System.out.println(e);
      e.printStackTrace();

      return null;
    }
  }
}
