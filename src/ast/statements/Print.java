package ast.statements;

import ast.AbstractAstNode;
import ast.expressions.Expression;
import visitors.Visitor;

//Write
public class Print extends AbstractAstNode implements Statement {

    private Expression expression;

    public Print(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpressions() {
        return expression;
    }

    public void setExpressions(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Print{" +
                "expression=" + expression +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);

    }
}
