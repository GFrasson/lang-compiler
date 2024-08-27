// Generated from /home/gfrasson/projects/ufjf/08periodo/compiladores/lang-compiler/src/parser/lang.g4 by ANTLR 4.13.1
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
	 * Enter a parse tree produced by {@link langParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(langParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(langParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(langParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(langParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(langParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(langParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(langParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(langParser.FactorContext ctx);
}