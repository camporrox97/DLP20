package ast.types;

import visitors.Visitor;

public class ArrayType extends AbstractType {

    private Type ofType;
    private int size;

    public ArrayType(int line, int column, Type ofType, int size) {
        super(line, column);
        this.ofType = ofType;
        this.size = size;
    }

    public Type getOfType() {
        return ofType;
    }

    public void setOfType(Type ofType) {
        this.ofType = ofType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ArrayType{" +
                "ofType=" + ofType +
                ", size=" + size +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);

    }
    @Override
    public Type squareBrackets(Type type) {
        if (type instanceof IntType)
            return ofType;
        else if (type instanceof ErrorType) {
            return type;
        }
        return null;
    }

    @Override
    public int size() {
        return size * ofType.size();
    }

}
