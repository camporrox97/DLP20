// Generated from C:/Users/alvaro/IdeaProjects/DiseñoLenguajes/src/parser\Pmm.g4 by ANTLR 4.8
package parser;


import ast.*;
	import ast.expressions.*;
	import ast.definitions.*;
	import ast.statements.*;
	import ast.types.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PmmParser}.
 */
public interface PmmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PmmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PmmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#definitions}.
	 * @param ctx the parse tree
	 */
	void enterDefinitions(PmmParser.DefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#definitions}.
	 * @param ctx the parse tree
	 */
	void exitDefinitions(PmmParser.DefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(PmmParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(PmmParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(PmmParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(PmmParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#defFuncion}.
	 * @param ctx the parse tree
	 */
	void enterDefFuncion(PmmParser.DefFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#defFuncion}.
	 * @param ctx the parse tree
	 */
	void exitDefFuncion(PmmParser.DefFuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(PmmParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(PmmParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#defVariablesLocales}.
	 * @param ctx the parse tree
	 */
	void enterDefVariablesLocales(PmmParser.DefVariablesLocalesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#defVariablesLocales}.
	 * @param ctx the parse tree
	 */
	void exitDefVariablesLocales(PmmParser.DefVariablesLocalesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(PmmParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(PmmParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#defVariable}.
	 * @param ctx the parse tree
	 */
	void enterDefVariable(PmmParser.DefVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#defVariable}.
	 * @param ctx the parse tree
	 */
	void exitDefVariable(PmmParser.DefVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(PmmParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(PmmParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#types}.
	 * @param ctx the parse tree
	 */
	void enterTypes(PmmParser.TypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#types}.
	 * @param ctx the parse tree
	 */
	void exitTypes(PmmParser.TypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#defVariableCampos}.
	 * @param ctx the parse tree
	 */
	void enterDefVariableCampos(PmmParser.DefVariableCamposContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#defVariableCampos}.
	 * @param ctx the parse tree
	 */
	void exitDefVariableCampos(PmmParser.DefVariableCamposContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#defRecord}.
	 * @param ctx the parse tree
	 */
	void enterDefRecord(PmmParser.DefRecordContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#defRecord}.
	 * @param ctx the parse tree
	 */
	void exitDefRecord(PmmParser.DefRecordContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#simpleTypes}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypes(PmmParser.SimpleTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#simpleTypes}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypes(PmmParser.SimpleTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PmmParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PmmParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(PmmParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(PmmParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void enterInputStatement(PmmParser.InputStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void exitInputStatement(PmmParser.InputStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#listExpression}.
	 * @param ctx the parse tree
	 */
	void enterListExpression(PmmParser.ListExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#listExpression}.
	 * @param ctx the parse tree
	 */
	void exitListExpression(PmmParser.ListExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#paramsInvocation}.
	 * @param ctx the parse tree
	 */
	void enterParamsInvocation(PmmParser.ParamsInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#paramsInvocation}.
	 * @param ctx the parse tree
	 */
	void exitParamsInvocation(PmmParser.ParamsInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#statementIf}.
	 * @param ctx the parse tree
	 */
	void enterStatementIf(PmmParser.StatementIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#statementIf}.
	 * @param ctx the parse tree
	 */
	void exitStatementIf(PmmParser.StatementIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#statementWhile}.
	 * @param ctx the parse tree
	 */
	void enterStatementWhile(PmmParser.StatementWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#statementWhile}.
	 * @param ctx the parse tree
	 */
	void exitStatementWhile(PmmParser.StatementWhileContext ctx);
}