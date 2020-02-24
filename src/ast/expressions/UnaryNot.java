package ast.expressions;

public class UnaryNot extends AbstractExpression   {

    private Expression expression;

    public UnaryNot(int line, int column, Expression exp) {
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
        return "UnaryNot{" +
                "expression=" + expression +
                '}';
    }
}


