package ast.expressions;

public class CharLiteral extends AbstractExpression   {

    private char value;

    public CharLiteral(int line, int column, char value) {
        super(line, column);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "RealLiteral [value=" + value + "]";
    }
}
