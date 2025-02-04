package ast.statements;

import ast.AbstractAstNode;
import ast.expressions.Expression;
import visitors.Visitor;

//read
public class Input extends AbstractAstNode implements Statement {

    private Expression expression;

    public Input(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpressions(Expression expressions) {
        this.expression = expressions;
    }

    @Override
    public String toString() {
        return "Input{" +
                "expression=" + expression +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);

    }
}
