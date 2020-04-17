package ast.types;

import visitors.Visitor;

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

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);

    }
    @Override
    public Type arithmetic(Type type) {
        if (type == this) {
            return this;
        }
        else if (type instanceof ErrorType) {
            return type;
        }
        return null;
    }

    @Override
    public Type canBeCast (Type type) {
        if (type instanceof ErrorType || type instanceof DoubleType || type instanceof IntType)
            return type;
        return null;

    }

    @Override
    public Type comparison (Type type) {
        if (type == this) {
            return IntType.getInstance();
        }
        else if (type instanceof ErrorType) {
            return type;
        }
        return null;

    }

    @Override
    public Type arithmetic()
    {
        return this;
    }

    @Override
    public Type promotesTo (Type type) {
        if (type == this) {
            return this;
        }
        else if (type instanceof ErrorType) {
            return type;
        }
        return null;

    }

    @Override
    public boolean isBuiltInType()
    {
        return true;
    }

    @Override
    public int size() {
        return 4;
    }



}
