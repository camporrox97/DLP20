package ast.types;

import ast.AbstractAstNode;

import java.util.List;

public abstract class AbstractType extends AbstractAstNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }


    public AbstractType(){

    }

    @Override
    public boolean isLogical() {
        return false;
    }

    @Override
    public Type arithmetic(Type type) {
        return null;
    }

    @Override
    public Type arithmetic() {
        return null;
    }

    @Override
    public Type comparison(Type type) {
        return null;
    }

    @Override
    public Type logical(Type type) {
        return null;
    }

    @Override
    public Type logical() {
        return null;
    }

    @Override
    public Type canBeCast(Type type) {
        return null;
    }

    @Override
    public boolean isBuiltInType() {
        return false;
    }

    @Override
    public Type promotesTo(Type type) {
        return null;
    }

    @Override
    public Type dot(String name) {
        return null;
    }

    @Override
    public Type squareBrackets(Type type) {
        return null;
    }

    @Override
    public Type parenthesis(List<Type> listOfTypes) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
    //throw new IllegalStateException ????

}
