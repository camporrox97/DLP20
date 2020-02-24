package ast.statements;

import ast.AbstractAstNode;
import ast.expressions.Expression;

import java.util.List;

public class IfStatement extends AbstractAstNode implements Statement {

    private Expression expression;
    private List<Statement> ifBody;
    private List<Statement> elseBody;

    public IfStatement(int line, int column, Expression expression, List<Statement> ifBody, List<Statement> elseBody) {
        super(line, column);
        this.expression = expression;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public List<Statement> getIfBody() {
        return ifBody;
    }

    public void setIfBody(List<Statement> ifBody) {
        this.ifBody = ifBody;
    }

    public List<Statement> getElseBody() {
        return elseBody;
    }

    public void setElseBody(List<Statement> elseBody) {
        this.elseBody = elseBody;
    }

    @Override
    public String toString() {
        return "IfStatement{" +
                "expression=" + expression +
                ", ifBody=" + ifBody +
                ", elseBody=" + elseBody +
                '}';
    }
}
