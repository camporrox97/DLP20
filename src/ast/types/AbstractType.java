package ast.types;

import ast.AbstractAstNode;

public abstract class AbstractType extends AbstractAstNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }


    public AbstractType() {
        super();
    }
}
