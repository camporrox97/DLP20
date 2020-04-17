package ast.expressions;

import ast.AstNode;
import ast.types.Type;

public interface Expression extends AstNode {

    boolean getLValue();
    void setLValue(boolean lvalue);
    Type getType();
    void setType(Type type);
}
