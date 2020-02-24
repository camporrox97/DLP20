package ast.types;

public class IntType  extends AbstractType {

    private static IntType instance = new IntType();

    public IntType() {
        super();
    }

    public IntType(int line, int column) {
        super(line, column);
    }



    public static IntType getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "IntType []";
    }
}
