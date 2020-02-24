package ast.statements;


import ast.AbstractAstNode;
import ast.expressions.Expression;

import java.util.List;

public class WhileStatement extends AbstractAstNode implements Statement {

    private Expression expression;
    private List<Statement> statements;

    public WhileStatement(int line, int column, Expression exp, List<Statement> statements) {
        super(line, column);
        this.expression = exp;
        this.statements = statements;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        return "WhileStatement{" +
                "expression=" + expression +
                ", statements=" + statements +
                '}';
    }
}
