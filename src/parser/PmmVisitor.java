// Generated from C:/Users/alvaro/IdeaProjects/DiseñoLenguajes/src/parser\Pmm.g4 by ANTLR 4.8
package parser;


import ast.*;
	import ast.expressions.*;
	import ast.definitions.*;
	import ast.statements.*;
	import ast.types.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PmmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PmmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PmmParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#definitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitions(PmmParser.DefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(PmmParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(PmmParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#defFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefFuncion(PmmParser.DefFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(PmmParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#defVariablesLocales}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefVariablesLocales(PmmParser.DefVariablesLocalesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(PmmParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#defVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefVariable(PmmParser.DefVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#idList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdList(PmmParser.IdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypes(PmmParser.TypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#defVariableCampos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefVariableCampos(PmmParser.DefVariableCamposContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#defRecord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefRecord(PmmParser.DefRecordContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#simpleTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypes(PmmParser.SimpleTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PmmParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(PmmParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#inputStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputStatement(PmmParser.InputStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#listExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpression(PmmParser.ListExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#paramsInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamsInvocation(PmmParser.ParamsInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#statementIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIf(PmmParser.StatementIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#statementWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWhile(PmmParser.StatementWhileContext ctx);
}