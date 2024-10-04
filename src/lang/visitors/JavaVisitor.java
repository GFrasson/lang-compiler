// /*
// * Equipe:
// * ÁGATA MEIRELES CARVALHO - 202065001C
// * GABRIEL FRASSON COSTA - 202035001
// */

// package lang.visitors;

// import org.stringtemplate.v4.ST;
// import org.stringtemplate.v4.STGroup;
// import org.stringtemplate.v4.STGroupFile;

// import lang.ast.nodes.*;
// import lang.ast.nodes.base.Node;
// import lang.ast.nodes.definitions.*;
// import lang.ast.nodes.definitions.base.Definition;
// import lang.ast.nodes.expressions.*;
// import lang.ast.nodes.expressions.base.Expression;
// import lang.ast.nodes.expressions.binaryOperators.*;
// import lang.ast.nodes.expressions.literals.*;
// import lang.ast.nodes.expressions.variables.*;
// import lang.ast.nodes.expressions.variables.base.Variable;
// import lang.ast.nodes.types.*;
// import lang.ast.nodes.types.base.Type;
// import lang.utils.*;

// import lang.utils.LocalEnv;
// import lang.utils.SType;
// import lang.utils.TyEnv;

// import java.util.List;
// import java.util.ArrayList;
// import java.util.Set;

// public class JavaVisitor extends Visitor {
//   private STGroup groupTemplate;
//   private ST type, stmt, expr;
//   private List<ST> funcs, params;

//   private String fileName;

//   TyEnv<LocalEnv<SType>> env;

//   public JavaVisitor(String fileName, TyEnv<LocalEnv<SType>> env) {
//     this.groupTemplate = new STGroupFile("./templates/java.stg");
//     this.fileName = fileName;
//     this.env = env;
//   }

//   public void visit(Program program) {
//     ST template = groupTemplate.getInstanceOf("program");

//     template.add("name", fileName);
//     funcs = new ArrayList<ST>();

//     for (Definition definition : program.getDefinitions()) {
//       definition.accept(this);
//     }

//     template.add("funcs", funcs);

//     System.out.println(template.render());
//   }

//   @Override
//   public void visit(Add add) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Subtraction subtraction) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Multiplication multiplication) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Division division) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Modulus modulus) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(And and) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(LessThan lessThan) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Equals equals) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(NotEquals notEquals) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Not not) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(True trueExpression) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(False falseExpression) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(LiteralChar literalChar) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(LiteralInt literalInt) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(LiteralFloat literalFloat) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(SimpleVariable simpleVariable) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(ArrayAccess arrayAccess) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(FieldAccess fieldAccess) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Call cal) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Null nullExpression) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(UnaryMinus unaryMinus) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Assignment assignment) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Block block) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Declaration declaration) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(If ifExpression) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Iterate iterate) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Print print) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Read read) {
//     // TODO Auto-generated method stub

//   }

//   public void visit(Function function) {
//     ST functionStringTemplate = groupTemplate.getInstanceOf("func");
//     functionStringTemplate.add("name", function.getID());

//     LocalEnv<SType> local = env.get(function.getID());
//     Set<String> keys = local.getKeys();

//     function.getType().accept(this);
//     functionStringTemplate.add("type", type);

//     params = new ArrayList<ST>();
//     for (Param p : function.getParams()) {
//       keys.remove(p.getID());
//       p.accept(this);
//     }
//     functionStringTemplate.add("params", params);

//     for (String key : keys) {
//       ST decl = groupTemplate.getInstanceOf("param");
//       decl.add("name", key);
//       SType t = local.get(key);
//       processSType(t);
//       decl.add("type", type);
//       functionStringTemplate.add("decl", decl);
//     }

//     function.getBody().accept(this);
//     functionStringTemplate.add("stmt", stmt);

//     funcs.add(functionStringTemplate);
//   }

//   @Override
//   public void visit(DataRegister dataRegister) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Instance instance) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Return returnCommand) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(Parameter parameter) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(IntType intType) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(FloatType floatType) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(CharType charType) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(BoolType boolType) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(ArrayType arrayType) {
//     // TODO Auto-generated method stub

//   }

//   @Override
//   public void visit(DataType dataType) {
//     // TODO Auto-generated method stub

//   }
// }
