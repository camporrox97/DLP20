package ast.definitions;

import ast.AstNode;
import ast.types.Type;

public interface Definition extends AstNode {

    public Type getType();
    public String getName();
    public void setScope(int scope);
    public int getScope();

}
