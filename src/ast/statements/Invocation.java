package ast.statements;

import ast.expressions.AbstractExpression;
import ast.expressions.Expression;
import ast.expressions.Variable;
import visitors.Visitor;

import java.util.List;

public class Invocation extends AbstractExpression implements Statement {

    private List<Expression> parameters;
    private Variable variable;

    public Invocation(int line, int column, List<Expression> parameters, Variable variable) {
        super(line, column);
        this.parameters = parameters;
        this.variable = variable;
    }

    public List<Expression> getParameters() {
        return parameters;
    }

    public void setParameters(List<Expression> parameters) {
        this.parameters = parameters;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    @Override
    public String toString() {
        return "Invocation{" +
                "parameters=" + parameters +
                ", variable=" + variable +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);

    }
}
