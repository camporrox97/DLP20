package ast.statements;

import ast.AbstractAstNode;
import ast.expressions.Expression;
import visitors.Visitor;


public class ReturnStatement extends AbstractAstNode implements Statement {

    private Expression returnExpression;

    public ReturnStatement(int line, int column, Expression returnExpression) {
        super(line, column);
        this.returnExpression = returnExpression;
    }

    public Expression getReturnExpression() {
        return returnExpression;
    }

    public void setReturnExpression(Expression returnExpression) {
        this.returnExpression = returnExpression;
    }

    @Override
    public String toString() {
        return "ReturnStatement{" +
                "returnExpression=" + returnExpression +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
