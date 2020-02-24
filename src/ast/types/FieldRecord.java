package ast.types;

public class FieldRecord extends AbstractType  {

    private String name;
    private int offset;
    private Type type;

    public FieldRecord(int line, int column, String name, Type type) {
        super(line, column);
        this.name = name;
        this.offset = 0;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FieldRecord{" +
                "name='" + name + '\'' +
                ", offset=" + offset +
                ", type=" + type +
                '}';
    }
}
