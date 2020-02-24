package ast.definitions;

import ast.AbstractAstNode;
import ast.types.Type;

public abstract class AbstractDefinition extends AbstractAstNode implements Definition {

    private Type tipo;
    private String name;

    public AbstractDefinition(int line, int column, Type tipo, String name) {
        super(line, column);
        this.tipo = tipo;
        this.name = name;
    }

    @Override
    public Type getType() {

        return tipo;
    }

    @Override
    public String getName() {

        return name;
    }

    public void setType(Type tipo) {

        this.tipo = tipo;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "AbstractDefinition -> (--- name=" + name + ", type=" + tipo + "---)";
    }

}