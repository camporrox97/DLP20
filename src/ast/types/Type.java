package ast.types;

import ast.AstNode;

import java.util.List;

public interface Type extends AstNode {


    boolean isLogical();
    Type arithmetic(Type type);
    Type arithmetic();
    Type comparison(Type type);
    Type logical(Type type);
    Type logical();
    Type canBeCast(Type type);
    boolean isBuiltInType();
    Type promotesTo(Type type);
    Type dot(String name);
    Type squareBrackets(Type type);
    Type parenthesis(List<Type> listOfTypes);
    int size();

}
