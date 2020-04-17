package ast.types;

import ast.AstNode;
import errorhandler.EH;
import visitors.Visitor;

public class ErrorType extends AbstractType {

    private String message;
    private AstNode ast;

    public ErrorType(AstNode ast, String message) {
        super(ast.getLine(), ast.getColumn());
        this.message = message;
        this.ast = ast;
        EH.getEH().addError(this);
    }

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        EH.getEH().addError(this);

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AstNode getAst() {
        return ast;
    }

    public void setAst(AstNode ast) {
        this.ast = ast;
    }

    @Override
    public String toString() {
        return "ErrorType{" +
                "linea " + ast.getLine() + " " +
                "columna " + ast.getColumn() + " " +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return null;

    }
}
