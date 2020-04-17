package ast.types;

import visitors.Visitor;

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

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);

    }

    @Override
    public int size() {
        return 0;
    }
}
