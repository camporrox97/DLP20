package ast.types;

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
}
