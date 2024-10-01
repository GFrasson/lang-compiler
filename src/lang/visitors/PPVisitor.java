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
import lang.ast.nodes.expressions.Call;
import lang.ast.nodes.expressions.False;
import lang.ast.nodes.expressions.Not;
import lang.ast.nodes.expressions.Null;
import lang.ast.nodes.expressions.True;
import lang.ast.nodes.expressions.UnaryMinus;
import lang.ast.nodes.expressions.binaryOperators.Add;
import lang.ast.nodes.expressions.binaryOperators.And;
import lang.ast.nodes.expressions.binaryOperators.Division;
import lang.ast.nodes.expressions.binaryOperators.Equals;
import lang.ast.nodes.expressions.binaryOperators.LessThan;
import lang.ast.nodes.expressions.binaryOperators.Modulus;
import lang.ast.nodes.expressions.binaryOperators.Multiplication;
import lang.ast.nodes.expressions.binaryOperators.NotEquals;
import lang.ast.nodes.expressions.binaryOperators.Subtraction;
import lang.ast.nodes.expressions.literals.LiteralChar;
import lang.ast.nodes.expressions.literals.LiteralFloat;
import lang.ast.nodes.expressions.literals.LiteralInt;
import lang.ast.nodes.expressions.variables.ArrayAccess;
import lang.ast.nodes.expressions.variables.FieldAccess;
import lang.ast.nodes.expressions.variables.SimpleVariable;
import lang.ast.nodes.types.ArrayType;
import lang.ast.nodes.types.BoolType;
import lang.ast.nodes.types.CharType;
import lang.ast.nodes.types.DataType;
import lang.ast.nodes.types.FloatType;
import lang.ast.nodes.types.IntType;
import lang.ast.nodes.types.base.Type;

import java.util.ArrayList;

public class PPVisitor extends Visitor{

    private ArrayList<String> lines;
    private String buff;
    private String idnt;
    private int priority;

    public PPVisitor() {
        lines = new ArrayList<String>();
        buff = "";
        idnt = "";
        priority = 0;
    }

    public String getStr() {
        String str = "";
        for (String l : lines) {
            str += l + "\n";
        }
        return str;
    }

    private void incIdnt() {
        idnt += "    ";
    }

    private void decIdnt() {
        idnt = idnt.substring(0, idnt.length() - 4);
    }

    private void closeLine() {
        lines.add(idnt + buff);
        buff = "";
    }

    // Visitação de Program
    @Override
    public void visit(Program program) {
        for (Definition def : program.getDefinitions()) {
            def.accept(this);
        }
    }

    // Operadores aritméticos
    @Override
    public void visit(Add add) {
        int x = priority;
        if (priority < 2) { buff += "("; }
        priority = 2;
        add.getLeft().accept(this);
        buff += " + ";
        add.getRight().accept(this);
        if (priority < 2) { buff += ")"; }
        priority = x;
    }

    @Override
    public void visit(Subtraction subtraction) {
        int x = priority;
        if (priority < 2) { buff += "("; }
        priority = 2;
        subtraction.getLeft().accept(this);
        buff += " - ";
        subtraction.getRight().accept(this);
        if (priority < 2) { buff += ")"; }
        priority = x;
    }

    @Override
    public void visit(Multiplication multiplication) {
        int x = priority;
        if (priority < 1) { buff += "("; }
        priority = 1;
        multiplication.getLeft().accept(this);
        buff += " * ";
        multiplication.getRight().accept(this);
        if (priority < 1) { buff += ")"; }
        priority = x;
    }

    @Override
    public void visit(Division division) {
        int x = priority;
        if (priority < 1) { buff += "("; }
        priority = 1;
        division.getLeft().accept(this);
        buff += " / ";
        division.getRight().accept(this);
        if (priority < 1) { buff += ")"; }
        priority = x;
    }

    @Override
    public void visit(Modulus modulus) {
        int x = priority;
        if (priority < 1) { buff += "("; }
        priority = 1;
        modulus.getLeft().accept(this);
        buff += " % ";
        modulus.getRight().accept(this);
        if (priority < 1) { buff += ")"; }
        priority = x;
    }

    // Operadores lógicos
    @Override
    public void visit(And and) {
        int x = priority;
        if (priority < 3) { buff += "("; }
        priority = 3;
        and.getLeft().accept(this);
        buff += " && ";
        and.getRight().accept(this);
        if (priority < 3) { buff += ")"; }
        priority = x;
    }

    @Override
    public void visit(LessThan lessThan) {
        int x = priority;
        if (priority < 4) { buff += "("; }
        priority = 4;
        lessThan.getLeft().accept(this);
        buff += " < ";
        lessThan.getRight().accept(this);
        if (priority < 4) { buff += ")"; }
        priority = x;
    }

    @Override
    public void visit(Equals equals) {
        int x = priority;
        if (priority < 5) { buff += "("; }
        priority = 5;
        equals.getLeft().accept(this);
        buff += " == ";
        equals.getRight().accept(this);
        if (priority < 5) { buff += ")"; }
        priority = x;
    }

    @Override
    public void visit(NotEquals notEquals) {
        int x = priority;
        if (priority < 5) { buff += "("; }
        priority = 5;
        notEquals.getLeft().accept(this);
        buff += " != ";
        notEquals.getRight().accept(this);
        if (priority < 5) { buff += ")"; }
        priority = x;
    }

    @Override
    public void visit(Not not) {
        int x = priority;
        if (priority < 0) { buff += "("; }
        buff += "!";
        priority = 0;
        not.getExpression().accept(this);
        if (priority < 0) { buff += ")"; }
        priority = x;
    }

    // Literais
    @Override
    public void visit(True trueExpression) {
        buff += "true";
    }

    @Override
    public void visit(False falseExpression) {
        buff += "false";
    }

    @Override
    public void visit(LiteralChar literalChar) {
        buff += "'" + literalChar.getValue() + "'";
    }

    @Override
    public void visit(LiteralInt literalInt) {
        buff += literalInt.getValue();
    }

    @Override
    public void visit(LiteralFloat literalFloat) {
        buff += literalFloat.getValue();
    }

    // Variáveis e Acessos
    @Override
    public void visit(SimpleVariable simpleVariable) {
        buff += simpleVariable.getName();
    }

    @Override
    public void visit(ArrayAccess arrayAccess) {
        arrayAccess.getArray().accept(this);
        buff += "[";
        arrayAccess.getIndex().accept(this);
        buff += "]";
    }

    @Override
    public void visit(FieldAccess fieldAccess) {
        fieldAccess.getObject().accept(this);
        buff += "." + fieldAccess.getField();
    }

    @Override
    public void visit(Call call) {
        buff += call.getFunctionName() + "(";
        if (call.getArguments().length > 0) {
            call.getArguments()[0].accept(this);
            for (int i = 1; i < call.getArguments().length; i++) {
                buff += ", ";
                call.getArguments()[i].accept(this);
            }
        }
        buff += ")";
    }

    // Comandos
    @Override
    public void visit(Assignment assignment) {
        assignment.getID().accept(this);
        buff += " = ";
        assignment.getExpression().accept(this);
        buff += ";";
        closeLine();
    }

    @Override
    public void visit(Block block) {
        buff += "{";
        closeLine();
        incIdnt();
        for (Node command : block.getCommands()) {
            command.accept(this);
        }
        decIdnt();
        buff += "}";
        closeLine();
    }

    @Override
    public void visit(If ifExpression) {
        buff += "if (";
        ifExpression.getCondition().accept(this);
        buff += ") ";
        ifExpression.getThen().accept(this);
        if (ifExpression.getElse() != null) {
            buff += " else ";
            ifExpression.getElse().accept(this);
        }
        closeLine();
    }

    @Override
    public void visit(Iterate iterate) {
        buff += "while (";
        iterate.getCondition().accept(this);
        buff += ") ";
        iterate.getBody().accept(this);
        closeLine();
    }

    @Override
    public void visit(Print print) {
        buff += "print(";
        print.getExpression().accept(this);
        buff += ");";
        closeLine();
    }

    @Override
    public void visit(Read read) {
        buff += "read ";
        read.getVariable().accept(this);
        buff += ";";
        closeLine();
    }

    @Override
    public void visit(Return returnCommand) {
        buff += "return ";
        if (returnCommand.getExpressions().length > 0) {
            returnCommand.getExpressions()[0].accept(this);
            for (int i = 1; i < returnCommand.getExpressions().length; i++) {
                buff += ", ";
                returnCommand.getExpressions()[i].accept(this);
            }
        }
        buff += ";";
        closeLine();
    }

    // Tipos
    @Override
    public void visit(IntType intType) {
        buff += "int";
    }

    @Override
    public void visit(FloatType floatType) {
        buff += "float";
    }

    @Override
    public void visit(CharType charType) {
        buff += "char";
    }

    @Override
    public void visit(BoolType boolType) {
        buff += "bool";
    }

    @Override
    public void visit(ArrayType arrayType) {
        arrayType.getArgumentType().accept(this);
        buff += "[]";
    }

    @Override
    public void visit(DataType dataType) {
        buff += dataType.getTypeName();
    }

    @Override
    public void visit(Null nullExpression) {
        buff += "null";
    }

    @Override
    public void visit(UnaryMinus unaryMinus) {
        buff += "-";
        unaryMinus.getExpression().accept(this);
    }

    @Override
    public void visit(Declaration declaration) {
        buff += "var " + declaration.getName() + " : ";
        declaration.getType().accept(this);
        buff += ";";
        closeLine();
    }

    @Override
    public void visit(Function function) {
        buff += "function " + function.getID() + "(";
        if (function.getParameters().length > 0) {
            function.getParameters()[0].accept(this);
            for (int i = 1; i < function.getParameters().length; i++) {
                buff += ", ";
                function.getParameters()[i].accept(this);
            }
        }
        buff += ") : ";
        
        if (function.getReturnTypes().length > 0) {
            for (Type returnType : function.getReturnTypes()) {
                returnType.accept(this);
                buff += " ";
            }
        }
        
        buff += "{";
        closeLine();
        incIdnt();
        function.getBody().accept(this);
        decIdnt();
        buff += "}";
        closeLine();
    }

    @Override
public void visit(DataRegister dataRegister) {
    buff += "data " + dataRegister.getTypeName() + " {";
    closeLine();
    incIdnt();
    
    // Visit each declaration within the DataRegister
    for (Declaration declaration : dataRegister.getDeclarations()) {
        declaration.accept(this);
    }
    
    decIdnt();
    buff += "}";
    closeLine();
}

@Override
public void visit(Instance instance) {
    buff += "new ";
    instance.getType().accept(this); // Visitando o tipo para gerar a string correspondente
    buff += " "; // Espaço após o tipo
    instance.getSize().accept(this); // Visitando o tamanho para gerar a string correspondente
    buff += ";"; // Finalizando a declaração da instância
    closeLine(); // Fecha a linha
}

@Override
public void visit(Parameter parameter) {
    buff += parameter.getName() + ": ";  // Adiciona o nome do parâmetro seguido por dois pontos
    parameter.getType().accept(this);      // Visita o tipo do parâmetro para gerar a string correspondente
    buff += ";";                           // Finaliza a linha do parâmetro
    closeLine();                           // Fecha a linha para adicionar ao resultado final
}
    
    
}
