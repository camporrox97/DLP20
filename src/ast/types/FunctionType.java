package ast.types;

import ast.definitions.VarDefinition;

import java.util.List;

public class FunctionType extends AbstractType {

    private List<VarDefinition> arguments;
    private Type returnType;
    private int sizeParams;


    public FunctionType(int line, int column,Type returnType, List<VarDefinition> arguments)
    {
        super(line, column);
        this.arguments = arguments;
        this.returnType = returnType;
    }

    public List<VarDefinition> getArguments() {
        return arguments;
    }

    public void setArguments(List<VarDefinition> arguments) {
        this.arguments = arguments;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    @Override
    public String toString() {
        return "FunctionType{" +
                "arguments=" + arguments +
                ", returnType=" + returnType +
                ", sizeParams=" + sizeParams +
                '}';
    }
}
