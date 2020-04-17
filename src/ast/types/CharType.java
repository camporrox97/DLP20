package ast.types;

import visitors.Visitor;

public class CharType extends AbstractType {

    private static CharType instance = new CharType();

    private CharType(int line, int column) {
        super(line, column);
    }

    private CharType() {
        super();
    }

    public static CharType getInstance()
    {
        return instance;
    }

    @Override
    public String toString() {
        return "CharType []";
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);

    }

    @Override
    public Type arithmetic(Type type) {
        if (type == this) {
            return IntType.getInstance();
        }
        else if (type instanceof ErrorType) {
            return type;
        }
        return null;
    }

    @Override
    public Type canBeCast (Type type) {

        if (type instanceof IntType || type instanceof ErrorType
                || type instanceof DoubleType || type instanceof CharType)
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
        return 1;
    }



}
