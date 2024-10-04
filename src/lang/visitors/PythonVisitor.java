/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.visitors;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

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


public class PythonVisitor extends Visitor {
  private STGroup groupTemplate;
  private ST type, stmt, expression;
  private List<ST> functions, dataRegisters, declarations, params, returnExpressions;
  private Stack<List<ST>> stmts;

  String fileName;
  TyEnv<LocalEnv<SType>> env;

  public PythonVisitor(String fileName, TyEnv<LocalEnv<SType>> env) {
    this.groupTemplate = new STGroupFile("./templates/python.stg");
    this.fileName = fileName;
    this.env = env;
    this.functions = new ArrayList<ST>();
    this.dataRegisters = new ArrayList<ST>();
    this.declarations = new ArrayList<>();
    this.params = new ArrayList<ST>();
    this.stmts = new Stack<List<ST>>();
    this.returnExpressions = new ArrayList<ST>();
  }

  public void visit(Program program) {
    ST template = groupTemplate.getInstanceOf("program");
    
    this.functions = new ArrayList<ST>();
    for (Definition definition : program.getDefinitions()) {
      definition.accept(this);
    }

    template.add("functions", this.functions);
    template.add("data_registers", this.dataRegisters);

    this.writePythonFile(template);
  }

  private void writePythonFile(ST template) {
    try {
      String fileNameWithExtension = this.fileName + ".py";
      FileWriter fileWriter = new FileWriter(fileNameWithExtension);

      fileWriter.write(template.render());
      fileWriter.close();

      System.out.println("Successfully wrote to file " + fileNameWithExtension);
    } catch (IOException exception) {
      System.out.println("An error occurred on file writing.");
      exception.printStackTrace();
    }
  }

  private void binaryOperator(BinaryOperator binaryOperator, String operatorName) {
    ST template = groupTemplate.getInstanceOf(operatorName);

    binaryOperator.getLeft().accept(this);
    template.add("left_expr", this.expression);

    binaryOperator.getRight().accept(this);
    template.add("right_expr", this.expression);
    
    this.expression = template;
  }

  public void visit(Add add) {
    this.binaryOperator(add, "add_expr");
  }

  public void visit(Subtraction subtraction) {
    this.binaryOperator(subtraction, "sub_expr");
  }

  public void visit(Multiplication multiplication) {
    this.binaryOperator(multiplication, "mul_expr");
  }

  public void visit(Division division) {
    this.binaryOperator(division, "div_expr");
  }

  public void visit(Modulus modulus) {
    this.binaryOperator(modulus, "mod_expr");
  }

  public void visit(And and) {
    this.binaryOperator(and, "and_expr");
  }

  public void visit(LessThan lessThan) {
    this.binaryOperator(lessThan, "lessthan_expr");
  }

  public void visit(Equals equals) {
    this.binaryOperator(equals, "equals_expr");
  }

  public void visit(NotEquals notEquals) {
    this.binaryOperator(notEquals, "not_equals_expr");
  }

  public void visit(Not not) {
    ST template = groupTemplate.getInstanceOf("not_expr");

    not.getExpression().accept(this);
    template.add("expr", this.expression);
    
    this.expression = template;
  }

  public void visit(UnaryMinus unaryMinus) {
    ST template = groupTemplate.getInstanceOf("minus_expr");

    unaryMinus.getExpression().accept(this);
    template.add("expr", this.expression);
    
    this.expression = template;    
  }

  private void literal(Object value, String name) {
    this.expression = groupTemplate.getInstanceOf(name);
    this.expression.add("value", value); 
  }

  public void visit(True trueExpression) {
    this.literal("True", "boolean_expr");
  }

  public void visit(False falseExpression) {
    this.literal("False", "boolean_expr");   
  }

  public void visit(LiteralChar literalChar) {
    this.literal(literalChar.getCharText(), "char_expr");
  }

  public void visit(LiteralInt literalInt) {
    this.literal(literalInt.getValue(), "int_expr");
  }

  public void visit(LiteralFloat literalFloat) {
    this.literal(literalFloat.getValue(), "float_expr");
  }

  public void visit(Null nullExpression) {
    this.expression = groupTemplate.getInstanceOf("null_expr");
  }

  public void visit(SimpleVariable simpleVariable) {
    ST template = groupTemplate.getInstanceOf("simple_variable");
    template.add("name", simpleVariable.getName());

    this.expression = template;
  }

  public void visit(ArrayAccess arrayAccess) {
    ST template = groupTemplate.getInstanceOf("array_access");

    arrayAccess.getArray().accept(this);
    template.add("array", this.expression);

    arrayAccess.getIndex().accept(this);
    template.add("expr", this.expression);

    this.expression = template;
  }

  public void visit(FieldAccess fieldAccess) {
    ST template = groupTemplate.getInstanceOf("field_access");
    
    fieldAccess.getObject().accept(this);
    template.add("object", this.expression);
    template.add("field", fieldAccess.getField());

    this.expression = template;
  }

  public void visit(Call call) {
    ST callTemplate = groupTemplate.getInstanceOf("call");

    String functionSignature = call.getFunctionName() + call.getArguments().length;
    callTemplate.add("name", functionSignature);

    for (Expression expression : call.getArguments()) {
      expression.accept(this);
      callTemplate.add("args", this.expression);
    }

    if (call.getReturnIndex() != null) {
      ST callReturnTemplate = groupTemplate.getInstanceOf("call_return");
      callReturnTemplate.add("call", callTemplate);
      
      call.getReturnIndex().accept(this);
      callReturnTemplate.add("index", this.expression);

      this.expression = callReturnTemplate;
      return;
    }

    if (call.getVariables() != null && call.getVariables().length > 0) {
      ST callAssignmentTemplate = groupTemplate.getInstanceOf("call_assignment");
      callAssignmentTemplate.add("call", callTemplate);

      List<ST> variables = new ArrayList<>();
      for (Variable variable : call.getVariables()) {
        variable.accept(this);
        variables.add(this.expression);
      }

      callAssignmentTemplate.add("variables", variables);

      this.stmt = callAssignmentTemplate;
      return;
    }

    this.stmt = callTemplate;
  }

  public void visit(Assignment assignment) {
    this.stmt = groupTemplate.getInstanceOf("assignment");

    assignment.getID().accept(this);
    this.stmt.add("var", this.expression);

    assignment.getExpression().accept(this);
    this.stmt.add("expr", this.expression);
  }

  public void visit(Block block) {
    ST aux = groupTemplate.getInstanceOf("block");
    
    this.stmts.add(new ArrayList<>());

    for (Node command : block.getCommands()) {
      command.accept(this);
      this.stmts.peek().add(this.stmt);
    }

    aux.add("stmts", this.stmts.pop());
    
    this.stmt = aux;
  }

  public void visit(If ifExpression) {
    ST template = groupTemplate.getInstanceOf("if");

    ifExpression.getCondition().accept(this);
    template.add("expr", this.expression);

    ifExpression.getThen().accept(this);
    template.add("then", this.stmt);

    Node node = ifExpression.getElse();
    if (node != null) {
      node.accept(this);
      template.add("els", this.stmt);
    }

    this.stmt = template;
  }

  public void visit(Iterate iterate) {
    ST aux = groupTemplate.getInstanceOf("iterate");
    
    iterate.getCondition().accept(this);
    aux.add("expr", this.expression);
    
    iterate.getBody().accept(this);
    aux.add("stmt", this.stmt);
        
    this.stmt = aux;
  }

  public void visit(Print print) {
    this.stmt = groupTemplate.getInstanceOf("print");
    print.getExpression().accept(this);
    this.stmt.add("expr", this.expression);
  }

  public void visit(Read read) {
    this.stmt = groupTemplate.getInstanceOf("read");
    read.getVariable().accept(this);
    this.stmt.add("var", this.expression);
  }

  public void visit(Function function) {
    ST template = groupTemplate.getInstanceOf("func");

    System.out.println(template);

    template.add("name", function.getSignature());

    LocalEnv<SType> local = env.get(function.getSignature());
    Set<String> keys = local.getKeys();

    List<ST> returnTypes = new ArrayList<>();
    for (Type returnType : function.getReturnTypes()) {
      returnType.accept(this);
      returnTypes.add(this.type);
    }

    template.add("return_types", returnTypes);

    this.params = new ArrayList<ST>();
    for (Parameter parameter : function.getParameters()) {
      keys.remove(parameter.getName());
      parameter.accept(this);
    }

    template.add("params", this.params);

    for (String key : keys) {
      ST declaration = groupTemplate.getInstanceOf("param");
      declaration.add("name", key);

      SType sType = local.get(key);
      this.processSType(sType);

      declaration.add("type", this.type);
    }

    function.getBody().accept(this);
    template.add("stmt", stmt);

    this.functions.add(template);
  }

  private void processSType(SType sType) {
    if (sType instanceof STyInt) {
      this.type = groupTemplate.getInstanceOf("int_type");
    } else if (sType instanceof STyBool) {
      this.type = groupTemplate.getInstanceOf("boolean_type");
    } else if (sType instanceof STyFloat) {
      this.type = groupTemplate.getInstanceOf("float_type");
    } else if (sType instanceof STyArr) {
      ST aux = groupTemplate.getInstanceOf("array_type");
      this.processSType(((STyArr) sType).getArg());
      aux.add("type", type);
      this.type = aux;
    }
  }

  public void visit(DataRegister dataRegister) {
    ST template = groupTemplate.getInstanceOf("data_register");
    template.add("datatype_name", dataRegister.getTypeName());

    this.declarations = new ArrayList<>();
    for (Declaration declaration : dataRegister.getDeclarations()) {
      declaration.accept(this);
    }

    template.add("declarations", this.declarations);
    this.dataRegisters.add(template);
  }

  public void visit(Declaration declaration) {
    ST template = groupTemplate.getInstanceOf("declaration");
    template.add("name", declaration.getName());

    declaration.getType().accept(this);
    template.add("type", this.type);

    this.declarations.add(template);
  }

  public void visit(Instance instance) {
    if (instance.getSize() != null) {
      ST template = groupTemplate.getInstanceOf("new_array");

      instance.getSize().accept(this);
      template.add("size", this.expression);

      this.expression = template;
    } else if (instance.getType() instanceof DataType) {
      this.expression = groupTemplate.getInstanceOf("new_data");

      instance.getType().accept(this);
      this.expression.add("type", this.type);
    }
  }

  public void visit(Return returnCommand) {
    this.stmt = groupTemplate.getInstanceOf("return");
    
    this.returnExpressions = new ArrayList<ST>();
    for (Expression expression : returnCommand.getExpressions()) {
      expression.accept(this);
      this.returnExpressions.add(this.expression);
    }
    
    this.stmt.add("expressions", this.returnExpressions);
  }

  public void visit(Parameter parameter) {
    ST param = groupTemplate.getInstanceOf("param");

    parameter.getType().accept(this);
    param.add("type", this.type);

    param.add("name", parameter.getName());
    this.params.add(param);
  }

  public void visit(IntType intType) {
    this.type = groupTemplate.getInstanceOf("int_type");
  }

  public void visit(FloatType floatType) {
    this.type = groupTemplate.getInstanceOf("float_type");
  }

  public void visit(CharType charType) {
    this.type = groupTemplate.getInstanceOf("char_type");
  }

  public void visit(BoolType boolType) {
    this.type = groupTemplate.getInstanceOf("boolean_type");  
  }

  public void visit(ArrayType arrayType) {
    ST template = groupTemplate.getInstanceOf("array_type");

    arrayType.getArgumentType().accept(this);
    template.add("type", this.type);

    this.type = template;
  }

  public void visit(DataType dataType) {
    ST template = groupTemplate.getInstanceOf("data_type");
    template.add("type", dataType.getTypeName());

    this.type = template;
  }
}