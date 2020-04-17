package ast.definitions;

import ast.statements.Statement;
import ast.types.Type;
import visitors.Visitor;

public class VarDefinition extends AbstractDefinition implements Statement {

    private int scope, offset;

    public VarDefinition(int line, int column, String name, Type type, int scope, int offset) {
        super(line, column, type, name);
        this.scope = scope;
        this.offset = offset;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "VarDefinition [scope=" + scope + ", offset=" + offset + "]";
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
