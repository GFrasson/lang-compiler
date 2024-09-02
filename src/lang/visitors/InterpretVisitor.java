/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.visitors;

import lang.ast.nodes.*;
import lang.ast.nodes.base.Node;
import lang.ast.nodes.definitions.*;
import lang.ast.nodes.definitions.base.Definition;
import lang.ast.nodes.expressions.*;
import lang.ast.nodes.expressions.base.Expression;
import lang.ast.nodes.expressions.binaryOperators.*;
import lang.ast.nodes.expressions.literals.*;
import lang.ast.nodes.expressions.variables.*;
import lang.ast.nodes.expressions.variables.base.Variable;
import lang.ast.nodes.types.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.Scanner;

@SuppressWarnings("deprecation")
public class InterpretVisitor extends Visitor {
  private Stack<HashMap<String, Object>> environment;
  private HashMap<String, Function> functions;
  private HashMap<String, DataRegister> dataRegisters;
  private Stack<Object> operands;
  private boolean returnMode, debugMode;
  private Scanner keyboard;

  public InterpretVisitor() {
    environment = new Stack<HashMap<String, Object>>();
    environment.push(new HashMap<String, Object>());
    functions = new HashMap<String, Function>();
    dataRegisters = new HashMap<String, DataRegister>();
    operands = new Stack<Object>();
    keyboard = new Scanner(System.in);
    returnMode = false;
    debugMode = false;
  }

  public InterpretVisitor(boolean debug) {
    this();
    this.debugMode = debug;
  }

  public void visit(Program program) {
    Node main = null;

    for (Definition definition : program.getDefinitions()) {
      if (definition instanceof Function) {
        Function function = (Function) definition;

        functions.put(function.getID(), function);
        if (function.getID().equals("main")) {
          main = function;
        }

      } else if (definition instanceof DataRegister) {
        DataRegister dataRegister = (DataRegister) definition;
        dataRegisters.put(dataRegister.getTypeName(), dataRegister);
      }
    }

    if (main == null) {
      throw new RuntimeException("Não há uma função chamada main ! abortando ! ");
    }
    main.accept(this);
    keyboard.close();
  }

  public void visit(Add add) {
    try {
      add.getLeft().accept(this);
      add.getRight().accept(this);

      Number right = (Number) operands.pop();
      Number left = (Number) operands.pop();

      if (right instanceof Float) {
        operands.push(new Float(left.floatValue() + right.floatValue()));
      } else {
        operands.push(new Integer(left.intValue() + right.intValue()));
      }
    } catch (Exception x) {
      throw new RuntimeException(" (" + add.getLine() + ", " + add.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(Subtraction subtraction) {
    try {
      subtraction.getLeft().accept(this);
      subtraction.getRight().accept(this);

      Number right = (Number) operands.pop();
      Number left = (Number) operands.pop();

      if (right instanceof Float) {
        operands.push(new Float(left.floatValue() - right.floatValue()));
      } else {
        operands.push(new Integer(left.intValue() - right.intValue()));
      }
    } catch (Exception x) {
      throw new RuntimeException(" (" + subtraction.getLine() + ", " + subtraction.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(Multiplication multiplication) {
    try {
      multiplication.getLeft().accept(this);
      multiplication.getRight().accept(this);

      Number right = (Number) operands.pop();
      Number left = (Number) operands.pop();

      if (right instanceof Float) {
        operands.push(new Float(left.floatValue() * right.floatValue()));
      } else {
        operands.push(new Integer(left.intValue() * right.intValue()));
      }
    } catch (Exception x) {
      throw new RuntimeException(
          " (" + multiplication.getLine() + ", " + multiplication.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(Division division) {
    try {
      division.getLeft().accept(this);
      division.getRight().accept(this);

      Number right = (Number) operands.pop();
      Number left = (Number) operands.pop();

      if (right instanceof Float) {
        operands.push(new Float(left.floatValue() / right.floatValue()));
      } else {
        operands.push(new Integer(left.intValue() / right.intValue()));
      }
    } catch (Exception x) {
      throw new RuntimeException(" (" + division.getLine() + ", " + division.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(Modulus modulus) {
    try {
      modulus.getLeft().accept(this);
      modulus.getRight().accept(this);

      Number right = (Number) operands.pop();
      Number left = (Number) operands.pop();

      if (right instanceof Float) {
        operands.push(new Float(left.floatValue() % right.floatValue()));
      } else {
        operands.push(new Integer(left.intValue() % right.intValue()));
      }
    } catch (Exception x) {
      throw new RuntimeException(" (" + modulus.getLine() + ", " + modulus.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(And and) {
    try {
      and.getLeft().accept(this);
      and.getRight().accept(this);

      Object right = operands.pop();
      Object left = operands.pop();

      operands.push(new Boolean((Boolean) left && (Boolean) right));
    } catch (Exception x) {
      throw new RuntimeException(" (" + and.getLine() + ", " + and.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(LessThan lessThan) {
    try {
      lessThan.getLeft().accept(this);
      lessThan.getRight().accept(this);

      Object right = operands.pop();
      Object left = operands.pop();

      operands.push(new Boolean((Integer) left < (Integer) right));
    } catch (Exception x) {
      throw new RuntimeException(" (" + lessThan.getLine() + ", " + lessThan.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(Equals equals) {
    try {
      equals.getLeft().accept(this);
      equals.getRight().accept(this);
      operands.push(new Boolean(operands.pop().equals(operands.pop())));
    } catch (Exception x) {
      throw new RuntimeException(" (" + equals.getLine() + ", " + equals.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(NotEquals notEquals) {
    try {
      notEquals.getLeft().accept(this);
      notEquals.getRight().accept(this);
      operands.push(new Boolean(!operands.pop().equals(operands.pop())));
    } catch (Exception x) {
      throw new RuntimeException(" (" + notEquals.getLine() + ", " + notEquals.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(Not not) {
    try {
      not.getExpression().accept(this);
      operands.push(new Boolean(!(Boolean) operands.pop()));
    } catch (Exception x) {
      throw new RuntimeException(" (" + not.getLine() + ", " + not.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(UnaryMinus unaryMinus) {
    try {
      unaryMinus.getExpression().accept(this);

      Number expression = (Number) operands.pop();

      if (expression instanceof Float) {
        operands.push(new Float(-expression.floatValue()));
      } else {
        operands.push(new Integer(-expression.intValue()));
      }
    } catch (Exception x) {
      throw new RuntimeException(" (" + unaryMinus.getLine() + ", " + unaryMinus.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(Call call) {
    try {
      Function function = functions.get(call.getFunctionName());
      if (function == null) {
        throw new RuntimeException(
            " (" + call.getLine() + ", " + call.getColumn() + ") Função não definida " + call.getFunctionName());
      }

      for (Expression exp : call.getArguments()) {
        exp.accept(this);
      }

      function.accept(this);

      if (!returnMode) {
        return;
      }
      
      returnMode = false;

      @SuppressWarnings("unchecked")
      ArrayList<Object> returnValues = (ArrayList<Object>)operands.pop();

      if (call.getReturnIndex() != null) {
        call.getReturnIndex().accept(this);
        int returnIndex = (int)operands.pop();
        
        Object returnValue = returnValues.get(returnIndex);
        operands.push(returnValue);
      }

      Variable[] variables = call.getVariables();
      if (variables != null && variables.length > 0) {
        for (int i = 0; i < variables.length; i++) {
          if (i > returnValues.size() - 1) {
            throw new RuntimeException(" (" + call.getLine() + ", " + call.getColumn() + ") " + "Trying to unpack too many values");
          }
          
          this.assignment(variables[i], returnValues.get(i));
        }
      }      
    } catch (Exception x) {
      throw new RuntimeException(" (" + call.getLine() + ", " + call.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(True trueExpression) {
    try {
      operands.push(new Boolean(true));
    } catch (Exception x) {
      throw new RuntimeException(
          " (" + trueExpression.getLine() + ", " + trueExpression.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(False falseExpression) {
    try {
      operands.push(new Boolean(false));
    } catch (Exception x) {
      throw new RuntimeException(
          " (" + falseExpression.getLine() + ", " + falseExpression.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(Null nullExpression) {
    try {
      operands.push(null);
    } catch (Exception x) {
      throw new RuntimeException(
          " (" + nullExpression.getLine() + ", " + nullExpression.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(LiteralInt literalInt) {
    try {
      operands.push(new Integer(literalInt.getValue()));
    } catch (Exception x) {
      throw new RuntimeException(" (" + literalInt.getLine() + ", " + literalInt.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(LiteralFloat literalFloat) {
    try {
      operands.push(new Float(literalFloat.getValue()));
    } catch (Exception x) {
      throw new RuntimeException(
          " (" + literalFloat.getLine() + ", " + literalFloat.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(LiteralChar literalChar) {
    try {
      operands.push(literalChar.getValue());
    } catch (Exception x) {
      throw new RuntimeException(" (" + literalChar.getLine() + ", " + literalChar.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(SimpleVariable simpleVariable) {
    try {
      Object variableValue = environment.peek().get(simpleVariable.getName());

      if (variableValue != null) {
        operands.push(variableValue);
      } else {
        throw new RuntimeException(
            " (" + simpleVariable.getLine() + ", " + simpleVariable.getColumn() + ") variável não declarada "
                + simpleVariable.getName());
      }
    } catch (Exception x) {
      throw new RuntimeException(" (" + simpleVariable.getLine() + ", " + simpleVariable.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(ArrayAccess arrayAccess) {
    try {
      arrayAccess.getArray().accept(this);
      arrayAccess.getIndex().accept(this);

      int index = (int)operands.pop();
      @SuppressWarnings("unchecked")
      ArrayList<Object> array = (ArrayList<Object>)operands.pop();

      if (index < 0 || index >= array.size()) {
        throw new RuntimeException(" (" + arrayAccess.getLine() + ", " + arrayAccess.getColumn() + ") Index out of bounds.");
      }

      operands.push(array.get(index));
    } catch (Exception x) {
      throw new RuntimeException(" (" + arrayAccess.getLine() + ", " + arrayAccess.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(FieldAccess fieldAccess) {
    try {
      fieldAccess.getObject().accept(this);
      
      @SuppressWarnings("unchecked")
      HashMap<String, Object> dataRegister = (HashMap<String, Object>)operands.pop();
      
      String field = fieldAccess.getField();

      if (!dataRegister.containsKey(field)) {
        throw new RuntimeException(" (" + fieldAccess.getLine() + ", " + fieldAccess.getColumn() + ") The data register does not have the attribute " + field);
      }

      operands.push(dataRegister.get(field));
    } catch (Exception x) {
      throw new RuntimeException(" (" + fieldAccess.getLine() + ", " + fieldAccess.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(Assignment assignment) {
    try {
      Variable variable = assignment.getID();

      assignment.getExpression().accept(this);
      Object expressionValue = operands.pop();

      this.assignment(variable, expressionValue);
    } catch (Exception x) {
      throw new RuntimeException(" (" + assignment.getLine() + ", " + assignment.getColumn() + ") " + x.getMessage());
    }
  }

  private void assignment(Variable variable, Object expressionValue) {
    if (variable instanceof SimpleVariable) {
      SimpleVariable simpleVariable = (SimpleVariable)variable;
      
      environment.peek().put(simpleVariable.getName(), expressionValue);
    } else if (variable instanceof ArrayAccess) {
      ArrayAccess arrayAccess = (ArrayAccess)variable;

      arrayAccess.getArray().accept(this);
      arrayAccess.getIndex().accept(this);
      
      int index = (int)operands.pop();
      @SuppressWarnings("unchecked")
      ArrayList<Object> array = (ArrayList<Object>)operands.pop();

      array.set(index, expressionValue);
    } else if (variable instanceof FieldAccess) {
      FieldAccess fieldAccess = (FieldAccess)variable;

      fieldAccess.getObject().accept(this);
      
      @SuppressWarnings("unchecked")
      HashMap<String, Object> dataRegister = (HashMap<String, Object>)operands.pop();
      
      String field = fieldAccess.getField();

      dataRegister.put(field, expressionValue);
    } else {
      throw new RuntimeException(" (" + variable.getLine() + ", " + variable.getColumn() + ") Invalid assignment");
    }
  }

  public void visit(If ifExpression) {
    try {
      ifExpression.getCondition().accept(this);
      if ((Boolean) operands.pop()) {
        ifExpression.getThen().accept(this);
      } else if (ifExpression.getElse() != null) {
        ifExpression.getElse().accept(this);
      }
    } catch (Exception x) {
      throw new RuntimeException(
          " (" + ifExpression.getLine() + ", " + ifExpression.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(Iterate iterate) {
    try {
      iterate.getCondition().accept(this);

      int executionAmount = (int)operands.pop();
      for (int i = 0; i < executionAmount; i ++) {
        iterate.getBody().accept(this);
      }
    } catch (Exception x) {
      throw new RuntimeException(" (" + iterate.getLine() + ", " + iterate.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(Print print) {
    try {
      print.getExpression().accept(this);
      Object object = operands.pop();
      System.out.print(object != null ? object.toString() : null);
    } catch (Exception x) {
      throw new RuntimeException(" (" + print.getLine() + ", " + print.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(Read read) {
    String text = keyboard.next();

    ArrayList<java.util.function.Function<String, Object>> parseFunctions = new ArrayList<>(
      Arrays.asList(
        (String input) -> { return Integer.parseInt(input); },
        (String input) -> { return Float.parseFloat(input); },
        (String input) -> { return input.toCharArray()[0]; }
      )
    );

    try {
      for (java.util.function.Function<String, Object> parseFunction : parseFunctions) {
        Object result = this.parseInput(text, parseFunction);
        if (result != null) {
          this.assignment(read.getVariable(), result);
          return;
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(" (" + read.getLine() + ", " + read.getColumn() + ") Invalid input.");
    }

    throw new RuntimeException(" (" + read.getLine() + ", " + read.getColumn() + ") Invalid input");
  }

  private Object parseInput(String input, java.util.function.Function<String, Object> parseFunction) {
    try {
      return parseFunction.apply(input);
    } catch (NumberFormatException e) {
      return null;
    } catch (Exception e) {
      throw e;
    }
  }

  public void visit(Block block) {
    if (returnMode) {
      return;
    }

    try {
      for (Node command : block.getCommands()) {
        command.accept(this);
        if (returnMode) {
          return;
        }
      }
    } catch (Exception x) {
      throw new RuntimeException(" (" + block.getLine() + ", " + block.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(Function function) {
    HashMap<String, Object> localEnv = new HashMap<String, Object>();
    for (int i = function.getParameters().length - 1; i >= 0; i--) {
      localEnv.put(function.getParameters()[i].getName(), operands.pop());
    }
    environment.push(localEnv);
    
    function.getBody().accept(this);
    
    if (debugMode && function.getID().equals("main")) {
      Object[] x = environment.peek().keySet().toArray();
      System.out.println("-------------- Memoria ----------------");
      for (int i = 0; i < x.length; i++) {
        System.out.println(((String) x[i]) + " : " + environment.peek().get(x[i]).toString());
      }
    }
    
    environment.pop();
  }

  public void visit(Instance instance) {
    try {
      if (instance.getSize() != null) {
        instance.getSize().accept(this);
        int size = (int)operands.pop();
        
        ArrayList<Object> array = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
          array.add(null);
        }

        operands.push(array);
      } else if (instance.getType() instanceof DataType) {
        DataType dataType = (DataType) instance.getType();
        DataRegister dataRegister = this.dataRegisters.get(dataType.getTypeName());

        if (dataRegister == null) {
          throw new RuntimeException(" (" + instance.getLine() + ", " + instance.getColumn() + ") Data type not defined.");
        }

        HashMap<String, Object> dataRegisterInstance = new HashMap<>();
        for (Declaration declaration : dataRegister.getDeclarations()) {
          dataRegisterInstance.put(declaration.getName(), null);
        }

        operands.push(dataRegisterInstance);
      }

    } catch (Exception x) {
      throw new RuntimeException(" (" + instance.getLine() + ", " + instance.getColumn() + ") " + x.getMessage());
    }
  }

  public void visit(Return returnExpression) {
    ArrayList<Object> returnValues = new ArrayList<>();

    for (Expression expression : returnExpression.getExpressions()) {
      expression.accept(this);
      returnValues.add(operands.pop());
    }

    operands.push(returnValues);
    returnMode = true;
  }

  public void visit(Declaration e) {
    
  }

  public void visit(DataRegister d) {
    
  }

  public void visit(Parameter e) {
  
  }

  public void visit(IntType t) {
  
  }

  public void visit(FloatType t) {
  
  }

  public void visit(BoolType t) {

  }

  public void visit(CharType t) {
    
  }

  public void visit(ArrayType t) {

  }

  public void visit(DataType t) {

  }
}
