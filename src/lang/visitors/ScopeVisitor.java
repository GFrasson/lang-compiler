package lang.visitors;

import ast.*;
import util.*;

public class ScopeVisitor extends Visitor {

    private ScopeTable scopes;
    private int level;
    
    public ScopeVisitor() {
	scopes = new ScopeTable();
	level = scopes.getLevel();
    }

    
    public void visit(Program p) {
	Func[] funs = p.getFuncs();
	for(int i = 0; i < funs.length; i++)
	    funs[i].accept(this);
    }
     
    public void visit(Add e) {
	Expr exp = e.getLeft();
	exp.accept(this);
	exp = e.getRight();
	exp.accept(this);
    }
          
    public void visit(Var e) {
	Pair<Symbol, Integer> pair = scopes.search(e.getName());
	if(pair == null) { //
	    System.err.println("Variable not declared: " + e.getName());
	    System.exit(1);
	}
	// Diferença entre o nível atual e o da variável indica a profundidade que devemos retornar nos scopos para obter o valor da variável
	System.out.println("\u27e6" + e.getName() + "\u27e7 : " + pair.second());
    }
    
    public void visit(NInt e) {
	
    }
    
    public void visit(Call e) {
	Expr args[] = e.getArgs();
	for(int i = 0; i < args.length; ++i)
	    args[i].accept(this);
    }
     
    public void visit(Attr e) {
	String name = e.getID();
	Expr exp = e.getExp();
	Pair<Symbol, Integer> pair = scopes.search(e.getID());
	if(pair == null) { //
	    System.err.println("Variable not declared: " + name);
	    System.exit(1);
	}
	System.out.println("<- \u27e6" + name + "\u27e7: " + pair.second());
	exp.accept(this);
    }
    
    public void visit(Print e) {
	e.getExpr().accept(this);
    }
    
    public void visit(Block e) {
	// Criar um novo escopo
	level = scopes.push();
	System.out.println("<<<<<<<<<< Bloco / " + level +" >>>>>>>>");
	Node[] ns = e.getStmts();
	for(int i = 0; i < ns.length; i++)
	    ns[i].accept(this);
	level = scopes.pop();
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
    public void visit(Func f) {
	// Criar um novo escopo
	level = scopes.push();
	System.out.println("<<<<<<<<<< Função: " + f.getID() + " / " + level +" >>>>>>>>");
	Param[] ps = f.getParams();
	for(int i = 0; i < ps.length; i++)
	    ps[i].accept(this);
	Block b = f.getBody();
	// Visita cada elemento do bloco aqui para evitar criar um escopo ao entrar no corpo da função
	Node[] ns = b.getStmts();
	for(int i = 0; i < ns.length; i++)
	    ns[i].accept(this);
	level = scopes.pop();
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
     
    public void visit(Param e) {
	System.out.println("adding ... " + e.getID());
	scopes.put(e.getID(), new Symbol());
    }

    public void visit(TyInt t) {}
	 
    public void visit(TyVoid t) {}
}


