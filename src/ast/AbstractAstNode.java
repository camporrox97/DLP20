package ast;

public abstract class AbstractAstNode implements AstNode {

    private int line, column;

    public AbstractAstNode(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public AbstractAstNode() {

    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "AbstractAstNode [line=" + line + ", column=" + column + "]";
    }


}
