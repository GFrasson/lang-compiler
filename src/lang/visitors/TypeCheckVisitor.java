package lang.visitors;

import lang.ast.*;
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

import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class TypeCheckVisitor extends Visitor {
  private STyInt typeInt = STyInt.newSTyInt();
  private STyFloat typeFloat = STyFloat.newSTyFloat();
  private STyChar typeChar = STyChar.newSTyChar();
  private STyBool typeBool = STyBool.newSTyBool();
  private STyNull typeNull = STyNull.newSTyNull();
  private STyErr typeError = STyErr.newSTyErr();

  private ArrayList<String> logError;

  private TyEnv<LocalEnv<SType>> env;
  private LocalEnv<SType> temp;

  private Stack<SType> stack;
  private boolean returnCheck;

  public TypeCheckVisitor() {
    stack = new Stack<SType>();
    env = new TyEnv<LocalEnv<SType>>();
    logError = new ArrayList<String>();
  }

  public int getNumErrors() {
    return logError.size();
  }

  public void printErrors() {
    for (String s : logError) {
      System.out.println(s);
    }
  }

  public void visit(Program program) {
    ArrayList<Function> functions = new ArrayList<>();
    ArrayList<DataRegister> dataRegisters = new ArrayList<>();

    boolean hasMainFunction = false;

    for (Definition definition : program.getDefinitions()) {
      if (definition instanceof Function) {
        Function function = (Function) definition;

        Parameter[] parameters = function.getParameters();
        Type[] returns = function.getReturnTypes();

        if (function.getID().equals("main")) {
          hasMainFunction = true;

          if (parameters.length > 0) {
            logError.add(function.getLine() + ", " + function.getColumn() + ": Função main não pode ter parâmetros");
            stack.push(typeError);
          }
        }

        SType[] parametersTypes = new SType[parameters.length];
        SType[] returnTypes = new SType[returns.length];
        
        for (int i = 0; i < parameters.length; i++) {
          parameters[i].getType().accept(this);
          parametersTypes[i] = stack.pop();
        }

        for (int i = 0; i < returns.length; i++) {
          returns[i].accept(this);
          returnTypes[i] = stack.pop();
        }

        STyFun functionType = new STyFun(parametersTypes, returnTypes);
        
        if (env.elem(function.getSignature())) {
          logError.add(function.getLine() + ", " + function.getColumn() + ": Função já definida anteriormente");
          stack.push(typeError);
        }

        env.set(function.getSignature(), new LocalEnv<SType>(function.getSignature(), functionType));
        functions.add(function);

      } else if (definition instanceof DataRegister) {
        DataRegister dataRegister = (DataRegister) definition;

        HashMap<String, SType> declarations = new HashMap<>();

        for (Declaration declaration : dataRegister.getDeclarations()) {
          declaration.getType().accept(this);
          declarations.put(declaration.getName(), stack.pop());
        }

        STyDataRegister dataRegisterType = new STyDataRegister(dataRegister.getTypeName(), declarations);

        if (env.elem(dataRegister.getTypeName())) {
          logError.add(dataRegister.getLine() + ", " + dataRegister.getColumn() + ": Tipo " + dataRegister.getTypeName() + " já definido anteriormente");
          stack.push(typeError);
        }

        env.set(dataRegister.getTypeName(), new LocalEnv<SType>(dataRegister.getTypeName(), dataRegisterType));
        dataRegisters.add(dataRegister);
      }
    }

    if (!hasMainFunction) {
      logError.add("Um programa na linguagem lang precisa ter uma função main");
      stack.push(typeError);
    }

    for (DataRegister dataRegister : dataRegisters) {
      dataRegister.accept(this);
    }

    for (Function function : functions) {
      function.accept(this);
    }
    
    env.printTable();
  }

  private void typeArithmeticBinOp(Node node, String opName, SType[][] typePairs) {
    SType typeRight = stack.pop();
    SType typeLeft = stack.pop();

    for (int i = 0; i < typePairs.length; i++) {
      SType[] typePair = typePairs[i];
      if (typeLeft.match(typePair[0]) && typeRight.match(typePair[1])) {
        stack.push(typeLeft);
        return;
      }
    }

    stack.push(typeError);
    logError.add(node.getLine() + ", " + node.getColumn() + ": Operador " + opName + " não se aplica aos tipos "
          + typeLeft.toString() + " e " + typeRight.toString());
  }

  public void visit(Add add) {
    add.getLeft().accept(this);
    add.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat}
    };

    typeArithmeticBinOp(add, "+", typePairs);
  }

  public void visit(Subtraction subtraction) {
    subtraction.getLeft().accept(this);
    subtraction.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat}
    };

    typeArithmeticBinOp(subtraction, "-", typePairs);
  }

  public void visit(Multiplication multiplication) {
    multiplication.getLeft().accept(this);
    multiplication.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat}
    };

    typeArithmeticBinOp(multiplication, "*", typePairs);
  }

  public void visit(Division division) {
    division.getLeft().accept(this);
    division.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat}
    };

    typeArithmeticBinOp(division, "/", typePairs);
  }

  public void visit(Modulus modulus) {
    modulus.getLeft().accept(this);
    modulus.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt}
    };

    typeArithmeticBinOp(modulus, "%", typePairs);
  }

  public void visit(And and) {
    and.getLeft().accept(this);
    and.getRight().accept(this);
    SType[][] typePairs = {
      {typeBool, typeBool}
    };

    typeArithmeticBinOp(and, "&&", typePairs);
  }

  public void visit(LessThan lessThan) {
    lessThan.getLeft().accept(this);
    lessThan.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat},
      {typeChar, typeChar}
    };

    typeArithmeticBinOp(lessThan, "<", typePairs);
  }

  public void visit(Equals equals) {
    equals.getLeft().accept(this);
    equals.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat},
      {typeChar, typeChar}
    };

    typeArithmeticBinOp(equals, "==", typePairs);
  }

  public void visit(NotEquals notEquals) {
    notEquals.getLeft().accept(this);
    notEquals.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat},
      {typeChar, typeChar}
    };

    typeArithmeticBinOp(notEquals, "!=", typePairs);
  }

  public void visit(Not not) {
    not.getExpression().accept(this);
    SType typeExpression = stack.pop();
    
    if (typeExpression.match(typeBool)) {
      stack.push(typeBool);
    } else {
      stack.push(typeError);

      logError.add(not.getLine() + ", " + not.getColumn() + ": Operador ! não se aplica ao tipo " + typeExpression.toString());
    }
  }

  public void visit(UnaryMinus unaryMinus) {
    unaryMinus.getExpression().accept(this);
    SType typeExpression = stack.pop();
    
    if (typeExpression.match(typeInt) || typeExpression.match(typeFloat)) {
      stack.push(typeExpression);
    } else {
      stack.push(typeError);

      logError.add(unaryMinus.getLine() + ", " + unaryMinus.getColumn() + ": Operador - não se aplica ao tipo " + typeExpression.toString());
    }
  }

  public void visit(True trueExpression) {
    stack.push(typeBool);
  }

  public void visit(False falseExpression) {
    stack.push(typeBool);
  }

  public void visit(Null nullExpression) {
    stack.push(typeNull);    
  }

  public void visit(LiteralInt literalInt) {
    stack.push(typeInt);
  }

  public void visit(LiteralFloat literalFloat) {
    stack.push(typeFloat);
  }

  public void visit(LiteralChar literalChar) {
    stack.push(typeChar);
  }

  public void visit(SimpleVariable simpleVariable) {
    SType variableType = temp.get(simpleVariable.getName());

    if (variableType == null) {
      logError.add(simpleVariable.getLine() + ", " + simpleVariable.getColumn() + ": Variável não declarada " + simpleVariable.getName());
      stack.push(typeError);
    }

    stack.push(variableType);
  }

  public void visit(ArrayAccess arrayAccess) {
    arrayAccess.getArray().accept(this);
    arrayAccess.getIndex().accept(this);

    SType indexType = stack.pop();
    SType arrayType = stack.pop();

    if (!indexType.match(typeInt)) {
      logError.add(arrayAccess.getLine() + ", " + arrayAccess.getColumn() + ": Índice de acesso ao vetor precisa ser do tipo Int");
      stack.push(typeError);
      return;
    }

    if (!(arrayType instanceof STyArr)) {
      logError.add(arrayAccess.getLine() + ", " + arrayAccess.getColumn() + ": Atribuição de tipos incompatíveis");
      stack.push(typeError);
      return;
    }

    stack.push(((STyArr) arrayType).getArg());
  }

  public void visit(FieldAccess fieldAccess) {
    // TODO Auto-generated method stub
    
  }

  public void visit(Call call) {
    String functionSignature = call.getFunctionName() + call.getArguments().length;
    LocalEnv<SType> localEnv = env.get(functionSignature);

    if (localEnv == null) {
      logError.add(call.getLine() + ", " + call.getColumn() + ": Chamada a função não declarada: " + call.getFunctionName());
      stack.push(typeError);
      return;
    }

    STyFun typeFunction = (STyFun) localEnv.getFunctionType();

    if (call.getArguments().length != typeFunction.getParameterTypes().length) {
      logError.add(call.getLine() + ", " + call.getColumn() + ": Chamada da função " + call.getFunctionName()
          + " incompatível com argumentos.");
      stack.push(typeError);
      return;
    }

    int k = 0;
    for (Expression argument : call.getArguments()) {
      argument.accept(this);
      if (!typeFunction.getParameterTypes()[k].match(stack.pop())) {
        logError.add(argument.getLine() + ", " + argument.getColumn() + ": " + (k + 1)
            + "\u00BA argumento incompatível com o respectivo parâmetro de " + call.getFunctionName());
      }
      k++;
    }

    SType[] returnValues = new SType[typeFunction.getReturnTypes().length];

    for (int i = typeFunction.getReturnTypes().length - 1; i >= 0; i--) {
      returnValues[i] = stack.pop();
    }

    if (call.getReturnIndex() != null) {
      if (!(call.getReturnIndex() instanceof LiteralInt)) {
        logError.add(call.getLine() + ", " + call.getColumn() + ": " + (k + 1)
        + "\u00BA índice de acesso ao retorno precisa ser uma constante do tipo Int");
        stack.push(typeError);
        return;
      }

      LiteralInt returnIndex = (LiteralInt) call.getReturnIndex();

      if (returnIndex.getValue() < 0 || returnIndex.getValue() >= returnValues.length) {
        logError.add(call.getLine() + ", " + call.getColumn() + ": " + (k + 1)
        + "\u00BA tentativa de acesso a uma posição inexistente dos valores de retorno");
        stack.push(typeError);
        return;
      }

      stack.push(returnValues[returnIndex.getValue()]);

      // call.getReturnIndex().accept(this);
      // SType returnIndexType = stack.pop();

      // if (!returnIndexType.match(typeInt)) {
      //   logError.add(call.getLine() + ", " + call.getColumn() + ": " + (k + 1)
      //       + "\u00BA índice de acesso ao retorno precisa ser do tipo Int");
      //   stack.push(typeError);
      //   return;
      // }
    }

    Variable[] variables = call.getVariables();
    if (variables != null && variables.length > 0) {
      if (variables.length != returnValues.length) {
        logError.add(call.getLine() + ", " + call.getColumn() + ": " + (k + 1)
            + "\u00BA A quantidade de valores de retorno da função é diferente do número de variáveis para atribuição");
      }

      for (int i = 0; i < variables.length; i++) {
        if (i <= returnValues.length - 1) {
          this.assignment(variables[i], returnValues[i]);
        }
      }
    }
  }

  public void visit(Assignment assignmentExpression) {
    assignmentExpression.getExpression().accept(this);
    SType expressionType = stack.pop();

    this.assignment(assignmentExpression.getID(), expressionType);
  }

  private void assignment(Variable variable, SType expressionType) {
    if (variable instanceof SimpleVariable) {
      this.assignment((SimpleVariable)variable, expressionType);

    } else if (variable instanceof ArrayAccess) {
      this.assignment((ArrayAccess)variable, expressionType);

    } else if (variable instanceof FieldAccess) {
      this.assignment((FieldAccess)variable, expressionType);

    } else {
      logError.add(variable.getLine() + ", " + variable.getColumn() + ": Atribuição ilegal para a variável ");
    }
  }

  private void assignment(SimpleVariable simpleVariable, SType expressionType) {
    if (!temp.elem(simpleVariable.getName())) {
      temp.set(simpleVariable.getName(), expressionType);
      return;
    }

    SType variableType = temp.get(simpleVariable.getName());

    if (!variableType.match(expressionType)) {
      logError.add(simpleVariable.getLine() + ", " + simpleVariable.getColumn() + ": Atribuição ilegal para a variável " + simpleVariable.getName());
    }
  }

  private void assignment(ArrayAccess arrayAccess, SType expressionType) {
    arrayAccess.getArray().accept(this);
    arrayAccess.getIndex().accept(this);
    
    SType indexType = stack.pop();
    if (!indexType.match(typeInt)) {
      logError.add(arrayAccess.getLine() + ", " + arrayAccess.getColumn() + ": Índice de acesso a um vetor deve ser do tipo Int ");
    }

    SType arrayType = stack.pop();

    if (!arrayType.match(expressionType)) {
      logError.add(arrayAccess.getLine() + ", " + arrayAccess.getColumn() + ": Tentativa de acesso de posição de vetor em uma variável do tipo " + expressionType.toString());
    }


    // array.set(index, expressionValue); 
  }

  private void assignment(FieldAccess variable, SType expressionType) {
    // FieldAccess fieldAccess = (FieldAccess)variable;

    // fieldAccess.getObject().accept(this);
    
    // @SuppressWarnings("unchecked")
    // HashMap<String, Object> dataRegister = (HashMap<String, Object>)operands.pop();
    
    // String field = fieldAccess.getField();

    // dataRegister.put(field, expressionValue);
  }

  public void visit(If ifExpression) {
    ifExpression.getCondition().accept(this);
    
    if (!stack.pop().match(typeBool)) {
      logError.add(ifExpression.getLine() + ", " + ifExpression.getColumn() + ": Expressão de teste do IF deve ter tipo Bool");
      return;
    }

    boolean returnThen, returnElse;
    returnElse = true;
    returnCheck = false;

    ifExpression.getThen().accept(this);
    returnThen = returnCheck;

    if (ifExpression.getElse() != null) {
      returnCheck = false;
      ifExpression.getElse().accept(this);
      returnElse = returnCheck;
    }

    returnCheck = returnThen && returnElse;
  }

  public void visit(Iterate iterate) {
    iterate.getCondition().accept(this);

    if (stack.pop().match(typeInt)) {
      iterate.getBody().accept(this);
    } else {
      logError.add(iterate.getLine() + ", " + iterate.getColumn() + ": Expressão de teste do iterate deve ter tipo Int");
    }
  }

  public void visit(Print print) {
    print.getExpression().accept(this);
    SType typeExpression = stack.pop();
    
    if (
      typeExpression.match(typeInt) ||
      typeExpression.match(typeFloat) ||
      typeExpression.match(typeBool) ||
      typeExpression.match(typeChar)
    ) {
      stack.push(typeExpression);
    } else {
      stack.push(typeError);

      logError.add(print.getLine() + ", " + print.getColumn() + ": Operador print não se aplica ao tipo " + typeExpression.toString());
    }
  }

  public void visit(Read read) {
    
  }

  public void visit(Block block) {
    for (Node command : block.getCommands()) {
      command.accept(this);
    }
  }

  public void visit(Function function) {
    returnCheck = false;
    temp = env.get(function.getSignature());
    
    for (Parameter parameter : function.getParameters()) {
      parameter.getType().accept(this);
      temp.set(parameter.getName(), stack.pop());
    }
    
    function.getBody().accept(this);
    
    if (!returnCheck && !temp.getFuncID().equals("main0")) {
      logError.add(function.getLine() + ", " + function.getColumn() + ": Função " + function.getID() + " deve retornar algum valor.");
    }
  }

  public void visit(Instance instance) {
    // if (temp.get(instance.getID().getName()) != null) {
    //   logError.add(instance.getLine() + ", " + instance.getColumn() + ": Redefinição da variável " + instance.getID());
    // } else {
    //   instance.getSize().accept(this);
    //   if (stack.pop().match(typeInt)) {
    //     instance.getTipo().accept(this);

    //     temp.set(instance.getID().getName(), new STyArr(stack.pop()));
    //   }
    // }
  }

  public void visit(Return returnExpression) {
    if (!(temp.getFunctionType() instanceof STyFun)) {
      logError.add(returnExpression.getLine() + ", " + returnExpression.getColumn() + "Retorno fora de uma função");
      return;
    }

    STyFun functionType = (STyFun) temp.getFunctionType();

    for (int i = 0; i < returnExpression.getExpressions().length; i++) {
      Expression expression = returnExpression.getExpressions()[i];
      SType returnType = functionType.getReturnTypes()[i];

      expression.accept(this);
      SType expressionType = stack.pop();
      
      if (expressionType.match(returnType)) {
        stack.push(expressionType);
      } else {
        logError.add(returnExpression.getLine() + ", " + returnExpression.getColumn() + "Retorno de tipo " 
        + expressionType.toString() + ", na posição " + i + " é incompatível com o tipo de retorno " + returnType.toString() + " da função.");
        
        stack.push(typeError);
      }
    }

    returnCheck = true;
  }

  public void visit(Parameter parameter) {
  }

  public void visit(IntType t) {
    stack.push(typeInt);
  }

  public void visit(FloatType t) {
    stack.push(typeFloat);
  }

  public void visit(BoolType t) {
    stack.push(typeBool);
  }

  public void visit(CharType t) {
    stack.push(typeChar);
  }

  public void visit(ArrayType arrayType) {
    arrayType.getArgumentType().accept(this);
    stack.push(new STyArr(stack.pop()));
  }

  @Override
  public void visit(DataType dataType) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void visit(Declaration declaration) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void visit(DataRegister dataRegister) {
    // TODO Auto-generated method stub
    
  }
}
