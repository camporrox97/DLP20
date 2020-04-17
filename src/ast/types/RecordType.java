package ast.types;

import visitors.Visitor;

import java.util.List;

public class RecordType extends AbstractType {

    private List<FieldRecord> fields;

    public RecordType(int line, int column, List<FieldRecord> fields) {
        super(line, column);
        this.fields = fields;
    }

    public List<FieldRecord> getFields() {
        return fields;
    }

    public void setFields(List<FieldRecord> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "RecordType{" +
                "fields=" + fields +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);

    }

    @Override
    public Type dot(String name)
    {
        for (FieldRecord fr : fields)
        {
            if (fr.getName().equals(name))
                return fr.getType();
        }
        return null;
    }

    @Override
    public Type promotesTo(Type type) {
        if (comprobarStruct(type)) {
            return this;
        } else if (type instanceof ErrorType) {
            return type;
        }
        return null;
    }

    private boolean comprobarStruct(Type type) {

        if (!(type instanceof RecordType)) {
            return false;
        }

        RecordType rt = (RecordType)type;

        if (fields.size() != rt.fields.size()) return false;

        for (FieldRecord fr : fields) {
            FieldRecord frotro = rt.getField(fr.getName());
            if (frotro == null) return false;
            if (!frotro.getType().isBuiltInType()) return false;
            if (frotro.getType() != fr.getType()) return false;
        }
        return true;
    }
    @Override
    public int size() {
        int sum = 0;
        for (FieldRecord f : fields)
        {
            sum += f.getType().size();
        }
        return sum;
    }

    public FieldRecord getField(String name)
    {
        for (FieldRecord fr : fields) {
            if (fr.getName().equals(name))
                return fr;
        }
        return null;
    }

}
