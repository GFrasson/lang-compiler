package lang.parser;

import java.io.*;
import java.util.List;

import lang.ast.SuperNode;

// Adaptador para classe de parser. a Função parseFile deve retornar null caso o parser resulte em erro. 

public interface ParseAdaptor {
  public abstract SuperNode parseFile(String path);
}
