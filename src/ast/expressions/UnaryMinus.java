package ast.expressions;

import visitors.Visitor;

public class UnaryMinus extends AbstractExpression   {

    private Expression expression;

    public UnaryMinus(int line, int column, Expression exp) {
        super(line, column);
        this.expression = exp;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "UnaryMinus{" +
                "expression=" + expression +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
