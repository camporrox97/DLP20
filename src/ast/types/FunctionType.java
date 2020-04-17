package ast.types;

import ast.definitions.VarDefinition;
import visitors.Visitor;

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

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);

    }

    @Override
    public Type parenthesis(List<Type> types)
    {
        if (this.getArguments().size() != types.size())
            return null;

        int i = 0;
        for (VarDefinition vf : arguments)
        {
            if (vf.getType() != types.get(i))
                return null;
            i++;
        }
        return returnType;
    }

    public int getsizeParams() {
        return sizeParams;
    }

    public void setsizeParams(int sizeParams) {
        this.sizeParams = sizeParams;
    }

}
