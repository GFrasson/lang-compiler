package lang.visitors;

import lang.ast.nodes.*;
import lang.ast.nodes.base.Node;
import lang.ast.nodes.definitions.*;
import lang.ast.nodes.definitions.base.Definition;
import lang.ast.nodes.expressions.*;
import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.expressions.binaryOperators.*;
import lang.ast.nodes.expressions.binaryOperators.base.BinaryOperator;
import lang.ast.nodes.expressions.literals.*;
import lang.ast.nodes.expressions.variables.*;
import lang.ast.nodes.expressions.variables.base.Variable;
import lang.ast.nodes.types.*;
import lang.ast.nodes.types.base.Type;
import lang.utils.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Stack;
import java.io.FileWriter;
import java.io.IOException;

public class JasminVisitor extends Visitor {
    private StringBuilder jasminCode;
    private Stack<String> labels;
    private int labelCounter;

    public JasminVisitor() {
        jasminCode = new StringBuilder();
        labels = new Stack<>();
        labelCounter = 0;
    }

    public void visit(Program program) {
        jasminCode.append(".class public ").append("Main").append("\n");
        jasminCode.append(".super java/lang/Object").append("\n\n");
        jasminCode.append(".method public static main([Ljava/lang/String;)V\n");
        jasminCode.append(".limit stack 100\n");
        jasminCode.append(".limit locals 100\n");

        for (Definition def : program.getDefinitions()) {
            def.accept(this);
        }

        jasminCode.append("return\n");
        jasminCode.append(".end method\n");

        writeToFile("Main.j", jasminCode.toString());
    }

    @Override
    public void visit(Add add) {
        add.getLeft().accept(this);
        add.getRight().accept(this);
        jasminCode.append("iadd\n");
    }

    @Override
    public void visit(Subtraction sub) {
        sub.getLeft().accept(this);
        sub.getRight().accept(this);
        jasminCode.append("isub\n");
    }

    @Override
    public void visit(Multiplication mul) {
        mul.getLeft().accept(this);
        mul.getRight().accept(this);
        jasminCode.append("imul\n");
    }

    @Override
    public void visit(Division div) {
        div.getLeft().accept(this);
        div.getRight().accept(this);
        jasminCode.append("idiv\n");
    }

    @Override
    public void visit(Assignment assignment) {
        assignment.getExpression().accept(this);
        String varName = assignment.getID().getName();
        int varIndex = getLocalVarIndex(varName);
        jasminCode.append("istore ").append(varIndex).append("\n");
    }

    @Override
    public void visit(If ifStmt) {
        String elseLabel = createLabel("else");
        String endLabel = createLabel("endif");

        ifStmt.getCondition().accept(this);
        jasminCode.append("ifeq ").append(elseLabel).append("\n");

        ifStmt.getThen().accept(this);
        jasminCode.append("goto ").append(endLabel).append("\n");

        jasminCode.append(elseLabel).append(":\n");
        if (ifStmt.getElse() != null) {
            ifStmt.getElse().accept(this);
        }

        jasminCode.append(endLabel).append(":\n");
    }

    @Override
    public void visit(Iterate iterate) {
        String startLabel = createLabel("loopstart");
        String endLabel = createLabel("loopend");

        jasminCode.append(startLabel).append(":\n");
        iterate.getCondition().accept(this);
        jasminCode.append("ifeq ").append(endLabel).append("\n");

        iterate.getBody().accept(this);
        jasminCode.append("goto ").append(startLabel).append("\n");
        jasminCode.append(endLabel).append(":\n");
    }

    @Override
    public void visit(Print print) {
        jasminCode.append("getstatic java/lang/System/out Ljava/io/PrintStream;\n");
        print.getExpression().accept(this);
        jasminCode.append("invokevirtual java/io/PrintStream/print(I)V\n");
    }

    @Override
    public void visit(LiteralInt literalInt) {
        jasminCode.append("ldc ").append(literalInt.getValue()).append("\n");
    }

    private String createLabel(String prefix) {
        String label = prefix + labelCounter++;
        labels.push(label);
        return label;
    }

    private int getLocalVarIndex(String varName) {
        return 1; // Aqui, o índice é fixo. Em uma implementação real, seria necessário rastrear as variáveis.
    }

    private void writeToFile(String fileName, String content) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(content);
            fileWriter.close();
            System.out.println("Arquivo Jasmin gerado com sucesso: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}