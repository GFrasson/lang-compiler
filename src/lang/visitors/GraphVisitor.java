package lang.visitors;

import lang.ast.*;
import lang.ast.nodes.*;
import lang.ast.nodes.base.Node;
import lang.ast.nodes.expressions.*;
import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.expressions.binaryOperators.*;
import lang.ast.nodes.expressions.literals.LiteralChar;
import lang.ast.nodes.expressions.literals.LiteralFloat;
import lang.ast.nodes.expressions.literals.LiteralInt;
import lang.ast.nodes.expressions.variables.ArrayAccess;
import lang.ast.nodes.expressions.variables.FieldAccess;
import lang.ast.nodes.expressions.variables.SimpleVariable;
import lang.ast.nodes.definitions.*;
import lang.ast.nodes.definitions.base.Definition;
import lang.ast.nodes.types.ArrayType;
import lang.ast.nodes.types.BoolType;
import lang.ast.nodes.types.CharType;
import lang.ast.nodes.types.DataType;
import lang.ast.nodes.types.FloatType;
import lang.ast.nodes.types.IntType;
import lang.ast.nodes.types.base.Type;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class GraphVisitor extends Visitor {
    private ArrayList<String> gfz; // Lista que armazena a representação do grafo
    private Stack<String> nodes; // Pilha para gerenciar nós
    private int nc; // Contador de nós

    public GraphVisitor() {
        gfz = new ArrayList<>();
        gfz.add("digraph G {"); // Início do grafo no formato DOT
        nodes = new Stack<>();
        nc = 0;
    }

    // Método para salvar o grafo em um arquivo
    public void saveToFile(String filename) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
            for (String line : gfz) {
                out.write(line);
                out.newLine();
            }
            out.write("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para adicionar uma linha ao grafo
    private void addLine(String s) {
        gfz.add("    " + s);
    }

    // Método auxiliar para criar um novo nó
    private String node(String label) {
        String n = "node" + (nc++);
        gfz.add(n + " [label=\"" + label + "\"];");
        return n;
    }

    // Método auxiliar para criar uma aresta
    private void edge(String node1, String node2) {
        gfz.add(node1 + " -> " + node2 + ";");
    }

    @Override
    public void visit(Program program) {
        String s = node("Program");
        for (Definition definition : program.getDefinitions()) {
            definition.accept(this);
            edge(s, nodes.pop()); // Conecta o nó do programa à definição
        }
    }

    @Override
    public void visit(Add add) {
        add.getLeft().accept(this);
        add.getRight().accept(this);
        String r = nodes.pop();
        String l = nodes.pop();
        String n = node("+");
        edge(n, l);
        edge(n, r);
        nodes.push(n);
    }

    @Override
    public void visit(Subtraction subtraction) {
        subtraction.getLeft().accept(this);
        subtraction.getRight().accept(this);
        String r = nodes.pop();
        String l = nodes.pop();
        String n = node("-");
        edge(n, l);
        edge(n, r);
        nodes.push(n);
    }

    @Override
    public void visit(Multiplication multiplication) {
        multiplication.getLeft().accept(this);
        multiplication.getRight().accept(this);
        String r = nodes.pop();
        String l = nodes.pop();
        String n = node("*");
        edge(n, l);
        edge(n, r);
        nodes.push(n);
    }

    @Override
    public void visit(Division division) {
        division.getLeft().accept(this);
        division.getRight().accept(this);
        String r = nodes.pop();
        String l = nodes.pop();
        String n = node("/");
        edge(n, l);
        edge(n, r);
        nodes.push(n);
    }

    @Override
    public void visit(Modulus modulus) {
        modulus.getLeft().accept(this);
        modulus.getRight().accept(this);
        String r = nodes.pop();
        String l = nodes.pop();
        String n = node("%");
        edge(n, l);
        edge(n, r);
        nodes.push(n);
    }

    @Override
    public void visit(And and) {
        and.getLeft().accept(this);
        and.getRight().accept(this);
        String r = nodes.pop();
        String l = nodes.pop();
        String n = node("&&");
        edge(n, l);
        edge(n, r);
        nodes.push(n);
    }

    @Override
    public void visit(LessThan lessThan) {
        lessThan.getLeft().accept(this);
        lessThan.getRight().accept(this);
        String r = nodes.pop();
        String l = nodes.pop();
        String n = node("<");
        edge(n, l);
        edge(n, r);
        nodes.push(n);
    }

    @Override
    public void visit(Equals equals) {
        equals.getLeft().accept(this);
        equals.getRight().accept(this);
        String r = nodes.pop();
        String l = nodes.pop();
        String n = node("==");
        edge(n, l);
        edge(n, r);
        nodes.push(n);
    }

    @Override
    public void visit(NotEquals notEquals) {
        notEquals.getLeft().accept(this);
        notEquals.getRight().accept(this);
        String r = nodes.pop();
        String l = nodes.pop();
        String n = node("!=");
        edge(n, l);
        edge(n, r);
        nodes.push(n);
    }

    @Override
    public void visit(Not not) {
        not.getExpression().accept(this);
        String r = nodes.pop();
        String n = node("!");
        edge(n, r);
        nodes.push(n);
    }

    @Override
    public void visit(True trueExpression) {
        nodes.push(node("true"));
    }

    @Override
    public void visit(False falseExpression) {
        nodes.push(node("false"));
    }

    @Override
    public void visit(LiteralInt literalInt) {
        nodes.push(node(String.valueOf(literalInt.getValue())));
    }

    @Override
    public void visit(LiteralFloat literalFloat) {
        nodes.push(node(String.valueOf(literalFloat.getValue())));
    }

    @Override
    public void visit(SimpleVariable simpleVariable) {
        nodes.push(node(simpleVariable.getName()));
    }

    @Override
    public void visit(ArrayAccess arrayAccess) {
        arrayAccess.getArray().accept(this);
        String arrayNode = nodes.pop();
        arrayAccess.getIndex().accept(this);
        String indexNode = nodes.pop();
        String n = node("ArrayAccess");
        edge(n, arrayNode);
        edge(n, indexNode);
        nodes.push(n);
    }

    @Override
    public void visit(FieldAccess fieldAccess) {
        fieldAccess.getObject().accept(this);
        String objectNode = nodes.pop();
        String n = node("FieldAccess: " + fieldAccess.getField());
        edge(n, objectNode);
        nodes.push(n);
    }

    @Override
    public void visit(Call call) {
        String n = node("Call " + call.getFunctionName());
        for (Expression arg : call.getArguments()) {
            arg.accept(this);
            edge(n, nodes.pop());
        }
        nodes.push(n);
    }

    @Override
    public void visit(Null nullExpression) {
        nodes.push(node("null"));
    }

    @Override
    public void visit(UnaryMinus unaryMinus) {
        unaryMinus.getExpression().accept(this);
        String exprNode = nodes.pop();
        String n = node("-");
        edge(n, exprNode);
        nodes.push(n);
    }

    @Override
    public void visit(Assignment assignment) {
        String n = node("Assignment");
        assignment.getID().accept(this);
        edge(n, nodes.pop());
        assignment.getExpression().accept(this);
        edge(n, nodes.pop());
        nodes.push(n);
    }

    @Override
    public void visit(Block block) {
        String n = node("Block");
        for (Node cmd : block.getCommands()) {
            cmd.accept(this);
            edge(n, nodes.pop());
        }
        nodes.push(n);
    }

    @Override
    public void visit(Declaration declaration) {
        nodes.push(node("Declaration: " + declaration.toString()));
    }

    @Override
    public void visit(If ifExpression) {
        String n = node("If");
        ifExpression.getCondition().accept(this);
        edge(n, nodes.pop());
        ifExpression.getThen().accept(this);
        edge(n, nodes.pop());
        if (ifExpression.getElse() != null) {
            ifExpression.getElse().accept(this);
            edge(n, nodes.pop());
        }
        nodes.push(n);
    }

    @Override
    public void visit(Iterate iterate) {
        String n = node("While");
        iterate.getCondition().accept(this);
        edge(n, nodes.pop());
        iterate.getBody().accept(this);
        edge(n, nodes.pop());
        nodes.push(n);
    }

    @Override
    public void visit(Print print) {
        String n = node("Print");
        print.getExpression().accept(this);
        edge(n, nodes.pop());
        nodes.push(n);
    }

    @Override
    public void visit(Read read) {
        String n = node("Read");
        read.getVariable().accept(this);
        edge(n, nodes.pop());
        nodes.push(n);
    }

    @Override
    public void visit(Function function) {
        String n = node("Function: " + function.getID());
        for (Parameter param : function.getParameters()) {
            param.accept(this);
            edge(n, nodes.pop());
        }
        function.getBody().accept(this);
        edge(n, nodes.pop());
        nodes.push(n);
    }

    @Override
    public void visit(DataRegister dataRegister) {
        String n = node("DataRegister: " + dataRegister.getTypeName());
        for (Declaration decl : dataRegister.getDeclarations()) {
            decl.accept(this);
            edge(n, nodes.pop());
        }
        nodes.push(n);
    }

    @Override
    public void visit(Instance instance) {
        String n = node("Instance");
        instance.getType().accept(this);
        edge(n, nodes.pop());
        instance.getSize().accept(this);
        edge(n, nodes.pop());
        nodes.push(n);
    }

    @Override
    public void visit(Return returnCommand) {
        String n = node("Return");
        for (Expression expr : returnCommand.getExpressions()) {
            expr.accept(this);
            edge(n, nodes.pop());
        }
        nodes.push(n);
    }

    @Override
    public void visit(Parameter parameter) {
        String n = node("Parameter: " + parameter.getName());
        edge(n, parameter.getType().toString());
        nodes.push(n);
    }

    @Override
    public void visit(IntType intType) {
        nodes.push(node("IntType"));
    }

    @Override
    public void visit(FloatType floatType) {
        nodes.push(node("FloatType"));
    }

    @Override
    public void visit(CharType charType) {
        nodes.push(node("CharType"));
    }

    @Override
    public void visit(BoolType boolType) {
        nodes.push(node("BoolType"));
    }

    @Override
    public void visit(ArrayType arrayType) {
        String n = node("ArrayType");
        arrayType.getArgumentType().accept(this);
        edge(n, nodes.pop());
        nodes.push(n);
    }

    @Override
    public void visit(DataType dataType) {
        nodes.push(node("DataType: " + dataType.getTypeName()));
    }

    @Override
    public void visit(LiteralChar literalChar) {
        nodes.push(node("'" + literalChar.getValue() + "'")); // Adiciona o literal char entre aspas simples
    }

}
