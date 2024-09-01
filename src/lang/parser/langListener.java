// Generated from src/lang/parser/lang.g4 by ANTLR 4.8

/*
* Equipe:
* ÁGATA MEIRELES CARVALHO - 202065001C
* GABRIEL FRASSON COSTA - 202035001
*/

package lang.parser;

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
import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link langParser}.
 */
public interface langListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link langParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(langParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(langParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#def}.
	 * @param ctx the parse tree
	 */
	void enterDef(langParser.DefContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#def}.
	 * @param ctx the parse tree
	 */
	void exitDef(langParser.DefContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(langParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(langParser.DataContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(langParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(langParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#fun}.
	 * @param ctx the parse tree
	 */
	void enterFun(langParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#fun}.
	 * @param ctx the parse tree
	 */
	void exitFun(langParser.FunContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(langParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(langParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(langParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(langParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(langParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(langParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#bType}.
	 * @param ctx the parse tree
	 */
	void enterBType(langParser.BTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#bType}.
	 * @param ctx the parse tree
	 */
	void exitBType(langParser.BTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(langParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(langParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(langParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(langParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue(langParser.LvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue(langParser.LvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#exps}.
	 * @param ctx the parse tree
	 */
	void enterExps(langParser.ExpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#exps}.
	 * @param ctx the parse tree
	 */
	void exitExps(langParser.ExpsContext ctx);
}