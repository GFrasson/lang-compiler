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

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.FileWriter;
import java.io.IOException;

public class JasminVisitor extends Visitor {
  private STGroup groupTemplate;
  private ST type, stmt, expression;
  private List<ST> functions, dataRegisters, declarations, params, returnExpressions;
  private Stack<List<ST>> stmts;

  private String fileName;

  TyEnv<LocalEnv<Pair<SType, Integer>>> env;
  LocalEnv<Pair<SType, Integer>> local;

  private int label = 0;

  public JasminVisitor(String fileName, TyEnv<LocalEnv<SType>> env) {
    groupTemplate = new STGroupFile("./templates/jasmin.stg");
    this.fileName = fileName;
    // this.env = env;
  }

  public void visit(Program program) {
    ST template = groupTemplate.getInstanceOf("program");

    template.add("name", fileName);

    this.functions = new ArrayList<ST>();
    for (Definition definition : program.getDefinitions()) {
      definition.accept(this);
    }

    template.add("funcs", this.functions);
    template.add("data_registers", this.dataRegisters);

    System.out.println(template.render());
    this.writeToFile(template);
  }

  private void writeToFile(ST template) {
    try {
      String fileNameWithExtension = this.fileName + ".jar";
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
    this.binaryOperator(add, "iadd");
  }

  public void visit(Subtraction subtraction) {
    this.binaryOperator(subtraction, "isub");
  }

  public void visit(Multiplication multiplication) {
    this.binaryOperator(multiplication, "imul");
  }

  public void visit(Division division) {
    this.binaryOperator(division, "idiv");
  }

  public void visit(Modulus modulus) {
    this.binaryOperator(modulus, "imod");
  }

  public void visit(And and) {
    this.binaryOperator(and, "and_expr");
  }

  public void visit(LessThan lessThan) {
    this.binaryOperator(lessThan, "ilt_expr");
    this.expression.add("num", this.label++);
  }

  public void visit(Equals equals) {
    this.binaryOperator(equals, "equals_expr");
    this.expression.add("num", this.label++);
  }

  public void visit(NotEquals notEquals) {
    this.binaryOperator(notEquals, "not_equals_expr");
    this.expression.add("num", this.label++);
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
    this.literal(true, "boolean_true");
  }

  public void visit(False falseExpression) {
    this.literal(false, "boolean_false");
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
    Pair<SType, Integer> pair = local.get(simpleVariable.getName());

    ST template = groupTemplate.getInstanceOf("iaccess");
		template.add("num", pair.second());
    
    this.expression = template;
  }

  public void visit(ArrayAccess arrayAccess) {
    ST template = groupTemplate.getInstanceOf("iaaccess");

    arrayAccess.getArray().accept(this);
    template.add("array", this.expression);

    Pair<SType, Integer> pair = local.get(this.expression.render());
		SType sType = pair.first();

    if (sType instanceof STyArr) {
			if (((STyArr) sType).getArg() instanceof STyInt) {
        template = groupTemplate.getInstanceOf("iaaccess");

				// if (arrayAccess.getIndex().length > 0)
        //   template = groupTemplate.getInstanceOf("iaaccess");
				// else
        //   template = groupTemplate.getInstanceOf("iaload");
			}
      arrayAccess.getIndex().accept(this);
      template.add("expr", this.expression);
		}
    
		template.add("num", pair.second());
    this.expression = template;
  }

  public void visit(FieldAccess fieldAccess) {
    // ST template = groupTemplate.getInstanceOf("field_access");
    
    // fieldAccess.getObject().accept(this);
    // template.add("object", this.expression);
    // template.add("field", fieldAccess.getField());

    // this.expression = template;
  }

  public void visit(Call call) {
    ST aux = groupTemplate.getInstanceOf("call");
		
    aux.add("class", fileName);
		aux.add("name", call.getFunctionName() + call.getArguments().length);

		SType[] return_types = ((STyFun) env.get(call.getFunctionName()).getFunctionType()).getReturnTypes();
		SType[] parameter_types = ((STyFun) env.get(call.getFunctionName()).getFunctionType()).getParameterTypes();
		
    // for (int i = 0; i < return_types.length; i++) {
    for (int i = 0; i < 1; i++) {
      processSType(return_types[i]);
      aux.add("return", this.type);
    }

		for (int i = 0; i < parameter_types.length - 1; ++i) {
			processSType(parameter_types[i]);
			aux.add("type", this.type);
		}

		for (Expression exp : call.getArguments()) {
			exp.accept(this);
			aux.add("args", this.expression);
		}

		this.expression = aux;
  }

  public void visit(Assignment assignment) {
    Variable variable = assignment.getID();
    
    if (variable instanceof SimpleVariable) {
      SimpleVariable simpleVariable = (SimpleVariable)variable;
      Pair<SType, Integer> pair = local.get(simpleVariable.getName());
      SType sType = pair.first();

			this.stmt = groupTemplate.getInstanceOf("istore");
      
      stmt.add("num", pair.second());

    } else if (variable instanceof ArrayAccess) {
      ArrayAccess arrayAccess = (ArrayAccess)variable;

      arrayAccess.getArray().accept(this);
      ST array = this.expression;

      Pair<SType, Integer> pair = local.get(array.render());
      SType sType = pair.first();

      if (((STyArr) sType).getArg() instanceof STyInt)
				this.stmt = groupTemplate.getInstanceOf("iastore");

      
      arrayAccess.getIndex().accept(this);
			this.stmt.add("index", this.expression);
    } else if (variable instanceof FieldAccess) {
      // FieldAccess fieldAccess = (FieldAccess)variable;

      // fieldAccess.getObject().accept(this);
      
      // @SuppressWarnings("unchecked")
      // HashMap<String, Object> dataRegister = (HashMap<String, Object>)operands.pop();
      
      // String field = fieldAccess.getField();

      // dataRegister.put(field, expressionValue);
    }

    assignment.getExpression().accept(this);
    stmt.add("expr", this.expression);
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
    ST aux = groupTemplate.getInstanceOf("if");
    
		aux.add("num", label++);
		
    ifExpression.getCondition().accept(this);
		aux.add("expr", this.expression);
		
    ifExpression.getThen().accept(this);
		aux.add("thn", this.stmt);
		
    Node n = ifExpression.getElse();
		if (n != null) {
			n.accept(this);
			aux.add("els", this.stmt);
		}
		
    this.stmt = aux;
  }

  public void visit(Iterate iterate) {
    ST aux = groupTemplate.getInstanceOf("iterate");

		aux.add("num", label++);
    
    iterate.getCondition().accept(this);
    aux.add("expr", this.expression);
    
    iterate.getBody().accept(this);
    aux.add("stmt", this.stmt);
        
    this.stmt = aux;
  }

  public void visit(Print print) {
    this.stmt = groupTemplate.getInstanceOf("iprint");
    print.getExpression().accept(this);
    this.stmt.add("expr", this.expression);
  }

  public void visit(Read read) {
    this.stmt = groupTemplate.getInstanceOf("read");
    read.getVariable().accept(this);
    this.stmt.add("var", this.expression);
  }

  public void visit(Function function) {
		ST fun = groupTemplate.getInstanceOf("func");
		fun.add("name", function.getID());

		local = env.get(function.getID());

		fun.add("decls", local.getKeys().size()); // número de váriaveis locais, incluíndo os parâmetros
		fun.add("stack", 100); // tamanho máximo da pilha. Coloquei 10, mas tem que calcular baseado no tamanho
													// das subexpressões

    if (function.getReturnTypes().length > 0) {
      function.getReturnTypes()[0].accept(this);
      fun.add("return", this.type);
    }

		this.params = new ArrayList<ST>();
		for (Parameter p : function.getParameters()) {
			p.accept(this);
		}
		fun.add("params", this.params);

		function.getBody().accept(this);
		fun.add("stmt", this.stmt);

		this.functions.add(fun);
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

      this.expression = template;
    } else if (instance.getType() instanceof DataType) {
      this.expression = groupTemplate.getInstanceOf("new_data");

      instance.getType().accept(this);
      this.expression.add("type", this.type);
    }
  }

  public void visit(Return returnCommand) {
    returnCommand.getExpressions()[0].accept(this);

		this.stmt = groupTemplate.getInstanceOf("ireturn");
		this.stmt.add("expr", this.expression);
  }

  public void visit(Parameter parameter) {
    parameter.getType().accept(this);
    this.params.add(this.type);
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