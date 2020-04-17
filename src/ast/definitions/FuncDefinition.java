package ast.definitions;

import ast.statements.Statement;
import ast.types.Type;
import visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FuncDefinition extends AbstractDefinition {

    private List<Statement> statements ;
    private int sizeLocals;
    private int scope, offset;


    public FuncDefinition(int line, int column, Type tipo, String name, List<VarDefinition> variables, List<Statement> statements) {
        super(line, column, tipo, name);
        this.statements = new ArrayList<Statement>();
        this.statements.addAll(variables);
        this.statements.addAll(statements);
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        return "FuncDefinition [statements=" + statements + "]";
    }

    public int getSizeLocals() {
        return sizeLocals;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    public int getOffset() {
        return offset;
    }

    public int getScope() {
        return scope;
    }


    @Override
    public void setScope(int i) {
            this.scope = scope;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

}
