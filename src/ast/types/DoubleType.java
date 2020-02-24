package ast.types;

public class DoubleType extends AbstractType {

    private static DoubleType instance = new DoubleType();

    public DoubleType(int line, int column) {
        super(line, column);
    }

    public DoubleType() {
        super();
    }

    public static DoubleType getInstance()
    {
        return instance;
    }

    @Override
    public String toString() {
        return "DoubleType []";
    }
}
