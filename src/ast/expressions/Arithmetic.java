package ast.expressions;

public class Arithmetic extends  AbstractExpression {

    private Expression leftExpression;
    private String operador;
    private Expression rightExpression;

    public Arithmetic(int line, int column, Expression leftExpression, String operador, Expression rightExpression) {
        super(line, column);
        this.operador = operador;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public String getOperador() {
        return operador;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    public void setLeftExpression(Expression leftExpression) {
        this.leftExpression = leftExpression;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public void setRightExpression(Expression rightExpression) {
        this.rightExpression = rightExpression;
    }

    @Override
    public String toString() {
        return "Arithmetic{" +
                "leftExpression=" + leftExpression +
                ", operador='" + operador + '\'' +
                ", rightExpression=" + rightExpression +
                '}';
    }
}
