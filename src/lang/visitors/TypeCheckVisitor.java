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
import lang.ast.nodes.types.base.Type;
import lang.utils.*;

import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;


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

        ArrayList<String> parameterNames = new ArrayList<>();
        SType[] parametersTypes = new SType[parameters.length];
        SType[] returnTypes = new SType[returns.length];
        
        for (int i = 0; i < parameters.length; i++) {
          Parameter parameter = parameters[i];

          parameter.getType().accept(this);
          parametersTypes[i] = stack.pop();

          if (parameterNames.contains(parameter.getName())) {
            logError.add(parameter.getLine() + ", " + parameter.getColumn() + ": Parâmetro " + parameter.getName() + " duplicado.");
            stack.push(typeError);
          }

          parameterNames.add(parameter.getName());
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
    add.getLeft().accept(this);
    add.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat}
    };

    typeBinOp(add, "+", typePairs, false);
  }

  public void visit(Subtraction subtraction) {
    subtraction.getLeft().accept(this);
    subtraction.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat}
    };

    typeBinOp(subtraction, "-", typePairs, false);
  }

  public void visit(Multiplication multiplication) {
    multiplication.getLeft().accept(this);
    multiplication.getRight().accept(this);
    SType[][] typePairs = {
      {typeInt, typeInt},
      {typeFloat, typeFloat}
    };

    typeBinOp(multiplication, "*", typePairs, false);
  }

  public void visit(Division division) {
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
    SType variableType = temp.get(simpleVariable.getName());

    if (variableType == null) {
      logError.add(simpleVariable.getLine() + ", " + simpleVariable.getColumn() + ": Variável não declarada " + simpleVariable.getName());
      stack.push(typeError);
      return;
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
    STyDataRegister dataRegisterType = this.fieldAccessVerify(fieldAccess);
    if (dataRegisterType == null) {
      return;
    }

    SType declarationType = this.typeDataRegisters.get(dataRegisterType.getName()).get(fieldAccess.getField());
    stack.push(declarationType);
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

    temp.set(simpleVariable.getName(), expressionType);
  }

  private void assignment(ArrayAccess arrayAccess, SType expressionType) {
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
    STyDataRegister dataRegisterType = this.fieldAccessVerify(fieldAccess);
    if (dataRegisterType == null) {
      return;
    }

    SType declarationType = this.typeDataRegisters.get(dataRegisterType.getName()).get(fieldAccess.getField());

    if (!declarationType.match(expressionType)) {
      logError.add(fieldAccess.getLine() + ", " + fieldAccess.getColumn() + ": Tentativa de atribuição de valor do tipo " + expressionType.toString() + " a um atributo do tipo " + declarationType.toString());
      return;
    }
  }

  private STyDataRegister fieldAccessVerify(FieldAccess fieldAccess) {
    fieldAccess.getObject().accept(this);
    SType dataRegister = stack.pop();

    if (!(dataRegister instanceof STyDataRegister)) {
      logError.add(fieldAccess.getLine() + ", " + fieldAccess.getColumn() + ": Tentativa de acesso de atributo em uma variável do tipo " + dataRegister.toString());
      stack.push(typeError);
      return null;
    }

    STyDataRegister dataRegisterType = (STyDataRegister) dataRegister;

    if (!this.typeDataRegisters.containsKey(dataRegisterType.getName())) {
      logError.add(fieldAccess.getLine() + ", " + fieldAccess.getColumn() + ": O tipo " + dataRegisterType.getName() + " não está definido");
      stack.push(typeError);
      return null;
    }

    HashMap<String, SType> declarations = this.typeDataRegisters.get(dataRegisterType.getName());

    String field = fieldAccess.getField();

    if (!declarations.containsKey(field)) {
      logError.add(fieldAccess.getLine() + ", " + fieldAccess.getColumn() + ": Atributo " + field + " não está definido no tipo " + dataRegisterType.toString());
      stack.push(typeError);
      return null;
    }

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
    read.getVariable().accept(this);
    SType variableType = stack.pop();

    if (
      variableType.match(typeInt) ||
      variableType.match(typeFloat) ||
      variableType.match(typeChar) ||
      variableType.match(typeBool)
    ) {
      stack.push(variableType);
    } else {
      stack.push(typeError);
      logError.add(read.getLine() + ", " + read.getColumn() + ": Operador read não se aplica à variáveis de tipo " + variableType.toString());
    }
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

    Block body = function.getBody();
    
    body.accept(this);

    if (function.getReturnTypes().length > 0 && !temp.getFuncID().equals("main0")) {
      this.checkReturnBranches(body);
    }
    
    if (!returnCheck && function.getReturnTypes().length > 0 && !temp.getFuncID().equals("main0")) {
      logError.add(function.getLine() + ", " + function.getColumn() + ": Função " + function.getID() + " deve retornar algum valor.");
    }
  }

  private void checkReturnBranches(Block body) {
    Node lastCommand = body.getCommands()[body.getCommands().length - 1];

    if (lastCommand instanceof Return) {
      return;
    }

    if (lastCommand instanceof If) {
      If ifCommand = (If) lastCommand;
      this.checkReturnBranches(ifCommand);
      return;
    }

    if (lastCommand instanceof Iterate) {
      Iterate iterateCommand = (Iterate) lastCommand;
      this.checkReturnBranches(iterateCommand);
    }
  }

  private void checkReturnBranches(If ifCommand) {
    if (ifCommand.getElse() == null || !returnCheck) {
      logError.add(ifCommand.getLine() + ", " + ifCommand.getColumn() + ": Todos os caminhos da função devem retornar um valor");
      stack.push(typeError);
    }
  }

  private void checkReturnBranches(Iterate iterateCommand) {
    Node iterateBody = iterateCommand.getBody();

    if (iterateBody instanceof Return) {
      return;
    }

    if (iterateBody instanceof Block) {
      Block iterateBodyBlock = (Block) iterateBody;
      Node lastCommandIterate = iterateBodyBlock.getCommands()[iterateBodyBlock.getCommands().length - 1];

      if (lastCommandIterate instanceof Return) {
        return;
      }

      if (lastCommandIterate instanceof If) {
        If ifCommand = (If) lastCommandIterate;
        this.checkReturnBranches(ifCommand);
        return;
      }

      if (lastCommandIterate instanceof Iterate) {
        Iterate iterateCommandRecursive = (Iterate) lastCommandIterate;
        this.checkReturnBranches(iterateCommandRecursive);
        return;
      }
    }

    logError.add(iterateCommand.getLine() + ", " + iterateCommand.getColumn() + ": Todos os caminhos da função devem retornar um valor");
    stack.push(typeError);
  }

  public void visit(Instance instance) {
    if (instance.getSize() != null) {
      instance.getSize().accept(this);
      SType sizeType = stack.pop();
      
      if (!sizeType.match(typeInt)) {
        logError.add(instance.getLine() + ", " + instance.getColumn() + ": O tamanho do vetor alocado deve ser do tipo Int");
        stack.push(typeError);
      }

      instance.getType().accept(this);
      SType argumentType = stack.pop();

      stack.push(new STyArr(argumentType));
    } else if (instance.getType() instanceof DataType) {
      DataType dataType = (DataType) instance.getType();
      dataType.accept(this);
    } else {
      logError.add(instance.getLine() + ", " + instance.getColumn() + ": Instância inválida do tipo " + instance.getType().toString());
      stack.push(typeError);
    }
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

  public void visit(DataType dataType) {
    if (!this.typeDataRegisters.containsKey(dataType.getTypeName())) {
      logError.add(dataType.getLine() + ", " + dataType.getColumn() + ": O tipo " + dataType.getTypeName() + " não está definido");
      stack.push(typeError);
      return;
    }

    stack.push(new STyDataRegister(dataType.getTypeName()));
  }

  public void visit(Declaration declaration) {    
  }

  public void visit(DataRegister dataRegister) {
    if (!this.typeDataRegisters.containsKey(dataRegister.getTypeName())) {
      logError.add(dataRegister.getLine() + ", " + dataRegister.getColumn() + ": O tipo " + dataRegister.getTypeName() + " não está definido");
      return;
    }
    
    HashMap<String, SType> declarations = new HashMap<>();

    for (Declaration declaration : dataRegister.getDeclarations()) {
      declaration.getType().accept(this);
      SType declarationType = stack.pop();

      if (declarations.containsKey(declaration.getName())) {
        logError.add(declaration.getLine() + ", " + declaration.getColumn() + ": Atributo " + declaration.getName() + " já definido anteriormente.");
      }
      
      declarations.put(declaration.getName(), declarationType);
    }

    this.typeDataRegisters.put(dataRegister.getTypeName(), declarations);
  }
}
