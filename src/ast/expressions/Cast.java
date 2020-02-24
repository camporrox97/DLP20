package ast.expressions;

import ast.types.Type;

public class Cast extends AbstractExpression {

    private Expression expression;
    private Type cast;

    public Cast(int line, int column, Expression exp, Type castType) {
        super(line, column);
        this.expression = exp;
        this.cast = castType;
    }

    public Expression getExpression() {
        return expression;
    }

    public Type getCast() {
        return cast;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public void setCast(Type cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "expression=" + expression +
                ", cast=" + cast +
                '}';
    }
}
