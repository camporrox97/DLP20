package ast.types;

public class VoidType extends AbstractType {

    private static VoidType instance = new VoidType();

    private VoidType(int line, int column) {
        super(line, column);
    }

    private VoidType() {
        super();
    }

    public static VoidType getInstance()
    {
        return instance;
    }

    @Override
    public String toString() {
        return "VoidType []";
    }
}
