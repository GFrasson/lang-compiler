package lang.parser;

import java.io.FileReader;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import lang.parser.langLexer;
import lang.parser.langParser;

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

      ParseTree tree = parser.prog();
      System.out.println(tree.toStringTree(parser));
      
      System.out.println(tokens.getTokens());
      for (Token token : tokens.getTokens())
      {
          System.out.println(token.getType());
      }

      return (SuperNode) tree;
    } catch (Exception e) {
      return null;
    }
  }
}
