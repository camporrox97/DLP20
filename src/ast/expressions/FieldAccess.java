package ast.expressions;

import visitors.Visitor;

public class FieldAccess extends AbstractExpression {

    private Expression expression;
    private String name;

    public FieldAccess(int line, int column, Expression exp, String name) {
        super(line, column);
        this.expression = exp;
        this.name = name;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FieldAccess{" +
                "expression=" + expression +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
