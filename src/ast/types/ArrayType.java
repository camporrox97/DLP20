package ast.types;

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
}
