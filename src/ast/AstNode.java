package ast;

import visitors.Visitor;

public interface AstNode {

    public int getLine();
    public int getColumn();
    public Object accept(Visitor v, Object param);


}
