package ast.expressions;

public class Logical  extends  AbstractExpression {

    private Expression leftExpression;
    private String operador;
    private Expression rightExpression;

    public Logical(int line, int column, Expression leftExpression, String operador, Expression rightExpression) {
        super(line, column);
        this.leftExpression = leftExpression;
        this.operador = operador;
        this.rightExpression = rightExpression;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public void setLeftExpression(Expression leftExpression) {
        this.leftExpression = leftExpression;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    public void setRightExpression(Expression rightExpression) {
        this.rightExpression = rightExpression;
    }

    @Override
    public String toString() {
        return "Logical{" +
                "leftExpression=" + leftExpression +
                ", operador='" + operador + '\'' +
                ", rightExpression=" + rightExpression +
                '}';
    }
}
