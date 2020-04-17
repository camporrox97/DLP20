package ast.types;

import visitors.Visitor;

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

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);

    }

    @Override
    public Type arithmetic(Type type) {
        if (type == this) {
            return this;
        } else if (type instanceof ErrorType) {
            return type;
        }
        return null;
    }

    @Override
    public Type canBeCast(Type type) {

        if (type instanceof IntType || type instanceof ErrorType || type instanceof DoubleType || type instanceof CharType)
            return type;
        return null;

    }

    @Override
    public Type comparison(Type type) {
        if (type == this) {
            return this;
        } else if (type instanceof ErrorType) {
            return type;
        }
        return null;

    }

    @Override
    public Type logical(Type type) {
        if (type == this) {
            return this;
        } else if (type instanceof ErrorType) {
            return type;
        }
        return null;

    }

    @Override
    public Type arithmetic() {
        return this;
    }

    @Override
    public Type logical() {
        return this;
    }

    @Override
    public Type promotesTo(Type type) {
        if (type == this) {
            return this;
        } else if (type instanceof ErrorType) {
            return type;
        }
        return null;

    }

    @Override
    public boolean isLogical() {
        //return false;
        return true; //hacer en todos con false
    }

    @Override
    public boolean isBuiltInType() {
        return true;
    }

    @Override
    public int size() {
        return 2;
    }


}
