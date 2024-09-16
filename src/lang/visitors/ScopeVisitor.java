package lang.visitors;

import lang.ast.nodes.Assignment;
import lang.ast.nodes.Block;
import lang.ast.nodes.Declaration;
import lang.ast.nodes.If;
import lang.ast.nodes.Instance;
import lang.ast.nodes.Iterate;
import lang.ast.nodes.Parameter;
import lang.ast.nodes.Print;
import lang.ast.nodes.Program;
import lang.ast.nodes.Read;
import lang.ast.nodes.Return;
import lang.ast.nodes.base.Node;
import lang.ast.nodes.definitions.DataRegister;
import lang.ast.nodes.definitions.Function;
import lang.ast.nodes.definitions.base.Definition;
import lang.ast.nodes.expressions.*;
import lang.ast.nodes.expressions.base.*;
import lang.ast.nodes.expressions.binaryOperators.*;
import lang.ast.nodes.expressions.literals.*;
import lang.ast.nodes.expressions.variables.*;
import lang.ast.nodes.types.*;
import lang.util.*;

public class ScopeVisitor extends Visitor {

	private ScopeTable scopes; // Tabela de escopos para armazenar variáveis e suas informações
	private int level; // Nível atual de escopo

	public ScopeVisitor() {
		scopes = new ScopeTable(); // Inicializa a tabela de escopos
		level = scopes.getLevel(); // Obtém o nível inicial de escopo
	}

	@Override
	public void visit(Program program) {
		// Visita cada definição no programa
		Definition[] definitions = program.getDefinitions();
		for (Definition definition : definitions) {
			definition.accept(this);
		}
	}

	@Override
	public void visit(Add add) {
		// Verifica as expressões nos operadores binários de adição
		add.getLeft().accept(this); // Verifica o operando esquerdo
		add.getRight().accept(this); // Verifica o operando direito
	}

	@Override
	public void visit(Subtraction subtraction) {
		// Verifica as expressões nos operadores binários de subtração
		subtraction.getLeft().accept(this); // Verifica o operando esquerdo
		subtraction.getRight().accept(this); // Verifica o operando direito
	}

	@Override
	public void visit(Multiplication multiplication) {
		// Verifica as expressões nos operadores binários de multiplicação
		multiplication.getLeft().accept(this); // Verifica o operando esquerdo
		multiplication.getRight().accept(this); // Verifica o operando direito
	}

	@Override
	public void visit(Division division) {
		// Verifica as expressões nos operadores binários de divisão
		division.getLeft().accept(this); // Verifica o operando esquerdo
		division.getRight().accept(this); // Verifica o operando direito
	}

	@Override
	public void visit(Modulus modulus) {
		// Verifica as expressões nos operadores binários de módulo
		modulus.getLeft().accept(this); // Verifica o operando esquerdo
		modulus.getRight().accept(this); // Verifica o operando direito
	}

	@Override
	public void visit(And and) {
		// Verifica as expressões nos operadores binários lógicos de "E"
		and.getLeft().accept(this); // Verifica o operando esquerdo
		and.getRight().accept(this); // Verifica o operando direito
	}

	@Override
	public void visit(LessThan lessThan) {
		// Verifica as expressões nos operadores binários de comparação menor que
		lessThan.getLeft().accept(this); // Verifica o operando esquerdo
		lessThan.getRight().accept(this); // Verifica o operando direito
	}

	@Override
	public void visit(Equals equals) {
		// Verifica as expressões nos operadores binários de comparação igual
		equals.getLeft().accept(this); // Verifica o operando esquerdo
		equals.getRight().accept(this); // Verifica o operando direito
	}

	@Override
	public void visit(NotEquals notEquals) {
		// Verifica as expressões nos operadores binários de comparação diferente
		notEquals.getLeft().accept(this); // Verifica o operando esquerdo
		notEquals.getRight().accept(this); // Verifica o operando direito
	}

	@Override
	public void visit(Not not) {
		// Verifica a expressão no operador unário de negação
		not.getExpression().accept(this); // Verifica a expressão
	}

	@Override
	public void visit(True trueExpression) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void visit(False falseExpression) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void visit(LiteralChar literalChar) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void visit(LiteralInt literalInt) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void visit(LiteralFloat literalFloat) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void visit(SimpleVariable simpleVariable) {
		// Verifica se a variável foi declarada no escopo atual
		Pair<Symbol, Integer> pair = scopes.search(simpleVariable.getName());
		if (pair == null) {
			System.err.println("Variable not declared: " + simpleVariable.getName());
			System.exit(1); // Sai do programa se a variável não for encontrada
		}
		System.out.println("\u27e6" + simpleVariable.getName() + "\u27e7 : " + pair.second());
	}

	@Override
	public void visit(ArrayAccess arrayAccess) {
		// Verifica a expressão de índice e a expressão de array em ArrayAccess
		arrayAccess.getIndex().accept(this); // Verifica o índice
		arrayAccess.getArray().accept(this); // Verifica o array
	}

	@Override
	public void visit(FieldAccess fieldAccess) {
		// Verifica a expressão do objeto em FieldAccess
		fieldAccess.getObject().accept(this); // Verifica o objeto
	}

	@Override
	public void visit(Call call) {
		// Verifica cada argumento na chamada de função
		for (Expression arg : call.getArguments()) {
			arg.accept(this); // Verifica cada argumento
		}
	}

	@Override
	public void visit(Null nullExpression) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void visit(UnaryMinus unaryMinus) {
		// Verifica a expressão no operador unário UnaryMinus
		unaryMinus.getExpression().accept(this); // Verifica a expressão
	}

	@Override
	public void visit(IntType intType) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void visit(FloatType floatType) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void visit(CharType charType) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void visit(BoolType boolType) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void visit(ArrayType arrayType) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void visit(DataType dataType) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void visit(Assignment assignment) {

	}

	@Override
	public void visit(Block block) {
		// Criar um novo escopo
		level = scopes.push();
		System.out.println("<<<<<<<<<< Bloco / " + level + " >>>>>>>>");
		Node[] nodes = block.getCommands();
		for (int i = 0; i < nodes.length; i++)
			nodes[i].accept(this);
		level = scopes.pop();
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

	@Override
	public void visit(Declaration declaration) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public void visit(If ifExpression) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public void visit(Iterate iterate) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public void visit(Print print) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public void visit(Read read) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public void visit(Function function) {
		// Criar um novo escopo
		level = scopes.push();
		System.out.println("<<<<<<<<<< Função: " + function.getID() + " / " + level + " >>>>>>>>");
		Parameter[] parameters = function.getParameters();
		for (int i = 0; i < parameters.length; i++)
			parameters[i].accept(this);
		Block block = function.getBody();
		// Visita cada elemento do bloco aqui para evitar criar um escopo ao entrar no
		// corpo da função
		Node[] nodes = block.getCommands();
		for (int i = 0; i < nodes.length; i++)
			nodes[i].accept(this);
		level = scopes.pop();
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

	@Override
	public void visit(DataRegister dataRegister) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public void visit(Instance instance) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public void visit(Return returnCommand) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public void visit(Parameter parameter) {
		// Cria um símbolo para o parâmetro com base no nome
		Symbol symbol = new Symbol();
    
		// Associa o nome do parâmetro ao símbolo
		String paramName = parameter.getName();
		scopes.put(paramName, symbol);
		
		// Imprime uma mensagem indicando que o parâmetro foi adicionado
		System.out.println("Adding parameter: " + paramName);
	}

}