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
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;


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
  private HashMap<String, HashMap<String, SType>> typeDataRegisters;

  private Stack<SType> stack;
  private boolean returnCheck;

  public TypeCheckVisitor() {
    stack = new Stack<SType>();
    env = new TyEnv<LocalEnv<SType>>();
    logError = new ArrayList<String>();
    typeDataRegisters = new HashMap<>();
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
    System.out.println("PROGRAM");
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

        // STyDataRegister dataRegisterType = new STyDataRegister(dataRegister.getTypeName(), false);

        if (this.typeDataRegisters.containsKey(dataRegister.getTypeName())) {
          logError.add(dataRegister.getLine() + ", " + dataRegister.getColumn() + ": Tipo " + dataRegister.getTypeName() + " já definido anteriormente");
          stack.push(typeError);
        }

        this.typeDataRegisters.put(dataRegister.getTypeName(), null);
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

  private void typeBinOp(Node node, String opName, SType[][] typePairs, boolean logical) {
    SType typeRight = stack.pop();
    SType typeLeft = stack.pop();

    for (int i = 0; i < typePairs.length; i++) {
      SType[] typePair = typePairs[i];
      if (typeLeft.match(typePair[0]) && typeRight.match(typePair[1])) {
        if (logical) {
          stack.push(typeBool);
          return;
        }

        stack.push(typeLeft);
        return;
      }
    }

    stack.push(typeError);
    logError.add(node.getLine() + ", " + node.getColumn() + ": Operador " + opName + " não se aplica aos tipos "
          + typeLeft.toString() + " e " + typeRight.toString());
  }

  public void visit(Add add) {
    System.out.println("ADD");

    add.getLeft().accept(this);
    add.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat}
    };

    typeBinOp(add, "+", typePairs, false);
  }

  public void visit(Subtraction subtraction) {
    System.out.println("SUB");

    subtraction.getLeft().accept(this);
    subtraction.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat}
    };

    typeBinOp(subtraction, "-", typePairs, false);
  }

  public void visit(Multiplication multiplication) {
    System.out.println("MULT");

    multiplication.getLeft().accept(this);
    multiplication.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat}
    };

    typeBinOp(multiplication, "*", typePairs, false);
  }

  public void visit(Division division) {
    System.out.println("DIV");

    division.getLeft().accept(this);
    division.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat}
    };

    typeBinOp(division, "/", typePairs, false);
  }

  public void visit(Modulus modulus) {
    modulus.getLeft().accept(this);
    modulus.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt}
    };

    typeBinOp(modulus, "%", typePairs, false);
  }

  public void visit(And and) {
    and.getLeft().accept(this);
    and.getRight().accept(this);
    SType[][] typePairs = {
      {typeBool, typeBool}
    };

    typeBinOp(and, "&&", typePairs, true);
  }

  public void visit(LessThan lessThan) {
    lessThan.getLeft().accept(this);
    lessThan.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat},
      {typeChar, typeChar}
    };

    typeBinOp(lessThan, "<", typePairs, true);
  }

  public void visit(Equals equals) {
    equals.getLeft().accept(this);
    equals.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat},
      {typeChar, typeChar}
    };

    typeBinOp(equals, "==", typePairs, true);
  }

  public void visit(NotEquals notEquals) {
    notEquals.getLeft().accept(this);
    notEquals.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat},
      {typeChar, typeChar}
    };

    typeBinOp(notEquals, "!=", typePairs, true);
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
    System.out.println("SIMPLE VARIABLE");
    System.out.println(stack);
    System.out.println(simpleVariable);

    SType variableType = temp.get(simpleVariable.getName());

    System.out.println(variableType);


    if (variableType == null) {
      logError.add(simpleVariable.getLine() + ", " + simpleVariable.getColumn() + ": Variável não declarada " + simpleVariable.getName());
      stack.push(typeError);
      return;
    }

    stack.push(variableType);

    System.out.println(stack);

  }

  public void visit(ArrayAccess arrayAccess) {
    System.out.println("ARRAY ACCESS");
    
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
    System.out.println("FIELD ACCESS");

    STyDataRegister dataRegisterType = this.fieldAccessVerify(fieldAccess);
    if (dataRegisterType == null) {
      return;
    }

    fieldAccess.getObject().accept(this);
    
    SType declarationType = dataRegisterType.getDeclaration(fieldAccess.getField());
    // SType declarationType = this.typeDataRegisters.get(dataRegisterType.getName()).get(fieldAccess.getField());
    stack.push(declarationType);

    System.out.println("FIELD ACCESS");
    
  }

  public void visit(Call call) {
    System.out.println("CALL");

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

    System.out.println(stack);

    SType[] returnTypes = typeFunction.getReturnTypes();

    if (call.getReturnIndex() != null) {
      if (!(call.getReturnIndex() instanceof LiteralInt)) {
        logError.add(call.getLine() + ", " + call.getColumn() + ": " + (k + 1)
        + "\u00BA índice de acesso ao retorno precisa ser uma constante do tipo Int");
        stack.push(typeError);
        return;
      }

      LiteralInt returnIndex = (LiteralInt) call.getReturnIndex();

      if (returnIndex.getValue() < 0 || returnIndex.getValue() >= returnTypes.length) {
        logError.add(call.getLine() + ", " + call.getColumn() + ": " + (k + 1)
        + "\u00BA tentativa de acesso a uma posição inexistente dos valores de retorno");
        stack.push(typeError);
        return;
      }

      stack.push(returnTypes[returnIndex.getValue()]);

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
      if (variables.length != returnTypes.length) {
        logError.add(call.getLine() + ", " + call.getColumn() + ": " + (k + 1)
            + "\u00BA A quantidade de valores de retorno da função é diferente do número de variáveis para atribuição");
      }

      for (int i = 0; i < variables.length; i++) {
        if (i <= returnTypes.length - 1) {
          this.assignment(variables[i], returnTypes[i]);
        }
      }
    }
  }

  public void visit(Assignment assignmentExpression) {
    System.out.println("ASSIGNMENT");

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
    System.out.println("ASSIGNMENT AUX - SIMPLE VARIABLE");

    if (!temp.elem(simpleVariable.getName())) {
      temp.set(simpleVariable.getName(), expressionType);

      System.out.println("PRINT TABLE");
      temp.printTable();
      return;
    }

    SType variableType = temp.get(simpleVariable.getName());

    if (!variableType.match(expressionType)) {
      logError.add(simpleVariable.getLine() + ", " + simpleVariable.getColumn() + ": Atribuição ilegal para a variável " + simpleVariable.getName());
    }

    temp.set(simpleVariable.getName(), expressionType);


    System.out.println("PRINT TABLE 2");
    temp.printTable();
  }

  private void assignment(ArrayAccess arrayAccess, SType expressionType) {
    System.out.println("ASSIGNMENT AUX - ARRAY ACCESS");

    System.out.println(expressionType);

    arrayAccess.getArray().accept(this);
    arrayAccess.getIndex().accept(this);
    
    SType indexType = stack.pop();
    if (!indexType.match(typeInt)) {
      logError.add(arrayAccess.getLine() + ", " + arrayAccess.getColumn() + ": Índice de acesso a um vetor deve ser do tipo Int ");
    }

    SType array = stack.pop();

    if (!(array instanceof STyArr)) {
      logError.add(arrayAccess.getLine() + ", " + arrayAccess.getColumn() + ": Tentativa de acesso de posição de vetor em uma variável do tipo " + array.toString());
      return;
    }

    STyArr arrayType = (STyArr) array;
    if (!arrayType.getArg().match(expressionType)) {
      logError.add(arrayAccess.getLine() + ", " + arrayAccess.getColumn() + ": Tentativa de atribuição de valor do tipo " + expressionType.toString() + " a um vetor do tipo " + arrayType.toString());
    }
  }

  private void assignment(FieldAccess fieldAccess, SType expressionType) {
    System.out.println("ASSIGNMENT AUX - FIELD ACCESS");

    System.out.println(stack);

    STyDataRegister dataRegisterType = this.fieldAccessVerify(fieldAccess);
    if (dataRegisterType == null) {
      return;
    }

    SType declarationType = dataRegisterType.getDeclaration(fieldAccess.getField());
    // SType declarationType = this.typeDataRegisters.get(dataRegisterType.getName()).get(fieldAccess.getField());

    if (!declarationType.match(expressionType)) {
      logError.add(fieldAccess.getLine() + ", " + fieldAccess.getColumn() + ": Tentativa de atribuição de valor do tipo " + expressionType.toString() + " a um atributo do tipo " + declarationType.toString());
      return;
    }

    dataRegisterType.putDeclaration(fieldAccess.getField(), expressionType);

    System.out.println(dataRegisterType.toString());
    System.out.println(fieldAccess.getField());
    System.out.println(declarationType.toString());
    System.out.println("PRINT TABLE 3");
    temp.printTable();
  }

  private STyDataRegister fieldAccessVerify(FieldAccess fieldAccess) {
    System.out.println("FIELD ACCESS VERIFY");

    fieldAccess.getObject().accept(this);
    System.out.println(stack);
    SType dataRegister = stack.pop();


    if (!(dataRegister instanceof STyDataRegister)) {
      logError.add(fieldAccess.getLine() + ", " + fieldAccess.getColumn() + ": Tentativa de acesso de atributo em uma variável do tipo " + dataRegister.toString());
      return null;
    }

    STyDataRegister dataRegisterType = (STyDataRegister) dataRegister;

    System.out.println("VERIFY");
    System.out.println(dataRegisterType);
    System.out.println(dataRegisterType.isInitialized());
    
    if (!this.typeDataRegisters.containsKey(dataRegisterType.getName())) {
      logError.add(fieldAccess.getLine() + ", " + fieldAccess.getColumn() + ": O tipo " + dataRegisterType.getName() + " não está definido");
      return null;
    }

    HashMap<String, SType> declarations = this.typeDataRegisters.get(dataRegisterType.getName());

    String field = fieldAccess.getField();

    if (!declarations.containsKey(field)) {
      logError.add(fieldAccess.getLine() + ", " + fieldAccess.getColumn() + ": Atributo " + field + " não está definido no tipo " + dataRegisterType.toString());
      return null;
    }

    if (!dataRegisterType.isInitialized()) {
      System.out.println("ERRO");
      logError.add(fieldAccess.getLine() + ", " + fieldAccess.getColumn() + ": Atributo " + dataRegisterType.toString() + " não foi inicializado");
      return null;
    }

    // SType declaration = declarations.get(field);

    // if (declaration instanceof STyDataRegister) {
    //   STyDataRegister declarationDataRegisterType = (STyDataRegister) declaration;
    //   // System.out.println("DATA " + this.name);
    //   // System.out.println("DECLARATION " + declaration.toString());
    //   // System.out.println(dataRegisterType.isInitialized());
    //   if (!declarationDataRegisterType.isInitialized()) {
    //     logError.add(fieldAccess.getLine() + ", " + fieldAccess.getColumn() + ": Atributo " + field + " não foi inicializado");
    //     return null;
    //   }
    // }

    // if (declaration instanceof STyArr) {
    //   STyArr arrayType = (STyArr) declaration;
    //   // System.out.println("ARRAY");
    //   // System.out.println(arrayType.isInitialized());
    //   if (!arrayType.isInitialized()) {
    //     logError.add(fieldAccess.getLine() + ", " + fieldAccess.getColumn() + ": Atributo " + field + " não foi inicializado");
    //     return null;
    //   }
    // }

    // if (declaration == null) {
    //   logError.add(fieldAccess.getLine() + ", " + fieldAccess.getColumn() + ": Atributo " + field + " não foi inicializado");
    //   return null;
    // }

    return dataRegisterType;
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
    System.out.println("FUNCTION");

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
    if (instance.getSize() != null) {
      System.out.println("INSTANCE - ARRAY");

      instance.getSize().accept(this);
      SType sizeType = stack.pop();
      
      if (!sizeType.match(typeInt)) {
        logError.add(instance.getLine() + ", " + instance.getColumn() + ": O tamanho do vetor alocado deve ser do tipo Int");
        stack.push(typeError);
      }

      instance.getType().accept(this);
      stack.push(new STyArr(stack.pop()));
    } else if (instance.getType() instanceof DataType) {
      System.out.println("INSTANCE - DATA");

      DataType dataType = (DataType) instance.getType();
      dataType.accept(this);
      
      SType dataRegisterTypeAux = stack.pop();

      System.out.println(dataRegisterTypeAux);

      if (dataRegisterTypeAux instanceof STyDataRegister) {
        System.out.println("INITIALIZE");
        STyDataRegister dataRegisterType = (STyDataRegister) dataRegisterTypeAux;
        dataRegisterType.setInitialized(true);
        System.out.println(dataRegisterTypeAux);

        stack.push(dataRegisterType);
      }

      System.out.println(stack);

      // STyDataRegister dataRegisterType = new STyDataRegister(dataType.getTypeName(), true);


    } else {
      logError.add(instance.getLine() + ", " + instance.getColumn() + ": Instância inválida do tipo " + instance.getType().toString());
      stack.push(typeError);
    }
  }

  public void visit(Return returnExpression) {
    System.out.println("RETURN");

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
    System.out.println("ARRAY TYPE");

    arrayType.getArgumentType().accept(this);
    stack.push(new STyArr(stack.pop()));
  }

  public void visit(DataType dataType) {
    System.out.println("DATA TYPE");

    // LocalEnv<SType> dataRegisterEnv = env.get(dataType.getTypeName());

    // if (dataRegisterEnv == null) {
    //   logError.add(dataType.getLine() + ", " + dataType.getColumn() + ": O tipo " + dataType.getTypeName() + " não está definido");
    //   stack.push(typeError);
    //   return;
    // }

    // stack.push(dataRegisterEnv.getFunctionType());


    if (!this.typeDataRegisters.containsKey(dataType.getTypeName())) {
      logError.add(dataType.getLine() + ", " + dataType.getColumn() + ": O tipo " + dataType.getTypeName() + " não está definido");
      stack.push(typeError);
      return;
    }

    HashMap<String, SType> declarations = this.typeDataRegisters.get(dataType.getTypeName());

    if (declarations == null) {
      stack.push(new STyDataRegister(dataType.getTypeName(), false));
      return;
    }

    HashMap<String, SType> declarationsCopy = new HashMap<>();
    for (Map.Entry<String, SType> entry : declarations.entrySet())
    {
      declarationsCopy.put(entry.getKey(), entry.getValue().clone());
    }

    stack.push(new STyDataRegister(dataType.getTypeName(), false, declarationsCopy));
  }

  public void visit(Declaration declaration) {    
  }

  public void visit(DataRegister dataRegister) {
    System.out.println("DATA REGISTER");

    // STyDataRegister dataRegisterType = this.getDataRegisterType(dataRegister);
    // if (dataRegisterType == null) {
    //   return;
    // }

    if (!this.typeDataRegisters.containsKey(dataRegister.getTypeName())) {
      logError.add(dataRegister.getLine() + ", " + dataRegister.getColumn() + ": O tipo " + dataRegister.getTypeName() + " não está definido");
      return;
    }
    
    HashMap<String, SType> declarations = new HashMap<>();

    System.out.println("AAAAAAAAA");

    for (Declaration declaration : dataRegister.getDeclarations()) {
      declaration.getType().accept(this);
      SType declarationType = stack.pop();

      if (declarations.containsKey(declaration.getName())) {
        logError.add(declaration.getLine() + ", " + declaration.getColumn() + ": Atributo " + declaration.getName() + " já definido anteriormente.");
      }
      
      declarations.put(declaration.getName(), declarationType);
    }

    this.typeDataRegisters.put(dataRegister.getTypeName(), declarations);

    System.out.println(this.typeDataRegisters);
  }

  // private STyDataRegister getDataRegisterDeclarations(DataRegister dataRegister) {
  //   if (!this.typeDataRegisters.containsKey(dataRegister.getTypeName())) {
  //     logError.add(dataRegister.getLine() + ", " + dataRegister.getColumn() + ": O tipo " + dataRegister.getTypeName() + " não está definido");
  //     return null;
  //   }
    
  //   return this.typeDataRegisters.get(dataRegister.getTypeName());


  //   // SType dataRegisterTypeAux = dataRegisterEnv.getFunctionType();

  //   // if (!(dataRegisterTypeAux instanceof STyDataRegister)) {
  //   //   logError.add(dataRegister.getLine() + ", " + dataRegister.getColumn() + ": O tipo " + dataRegister.getTypeName() + " não está definido");
  //   //   return null;
  //   // }

  //   // return (STyDataRegister) dataRegisterTypeAux;
  // }
}
