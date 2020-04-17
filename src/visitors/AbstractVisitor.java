package visitors;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

public abstract class AbstractVisitor implements Visitor{
    public AbstractVisitor() {
        super();
    }



    @Override
    public Object visit(Program pr, Object p) {
        for (Definition d : pr.getDefinitions())
            d.accept(this, p);
        return null;
    }

    //Definitions

    @Override
    public Object visit(FuncDefinition f, Object p) {
        f.getType().accept(this,p);

        for (Statement s : f.getStatements())
            s.accept(this, p);
        return null;

    }
    @Override
    public Object visit(VarDefinition f, Object p) {
        f.getType().accept(this, p);
        return null;
    }

    //Expressions

    @Override
    public Object visit(Arithmetic a, Object p) {
        a.getRightExpression().accept(this, p);
        a.getLeftExpression().accept(this, p);
        return null;
    }

    @Override
    public Object visit(Cast c, Object p) {
        c.getExpression().accept(this, p);
        return null;
    }

    @Override
    public Object visit(CharLiteral c, Object p) {
        return null;
    }

    @Override
    public Object visit(Comparison c, Object p) {
        c.getRightExpression().accept(this, p);
        c.getLeftExpression().accept(this, p);
        return null;
    }

    @Override
    public Object visit(FieldAccess f, Object p) {
        f.getExpression().accept(this, p);
        return null;
    }

    @Override
    public Object visit(Indexing i, Object p) {
        i.getLeftExpression().accept(this, p);
        i.getRightExpression().accept(this, p);
        return null;
    }

    @Override
    public Object visit(IntLiteral i, Object p) {
        return null;
    }

    @Override
    public Object visit(Logical l, Object p) {
        l.getLeftExpression().accept(this, p);
        l.getRightExpression().accept(this, p);
        return null;
    }

    @Override
    public Object visit(RealLiteral r, Object p) {
        return null;
    }

    @Override
    public Object visit(UnaryMinus u, Object p) {
        u.getExpression().accept(this, p);
        return null;
    }

    @Override
    public Object visit(UnaryNot u, Object p) {
        u.getExpression().accept(this, p);
        return null;
    }

    @Override
    public Object visit(Variable v, Object p) {
        return null;
    }

    //Statements


    @Override
    public Object visit(Assignament a, Object p) {
        a.getLeftExpression().accept(this, p);
        a.getRightExpression().accept(this, p);

        return null;
    }

    @Override
    public Object visit(IfStatement is, Object p) {
        is.getExpression().accept(this, p);
        for (Statement s : is.getIfBody())
            s.accept(this, p);
        for(Statement s : is.getElseBody())
            s.accept(this, p);
        return null;
    }



    @Override
    public Object visit(Invocation i, Object p) {
        i.getVariable().accept(this, p);
        for (Expression e : i.getParameters())
            e.accept(this, p);

        return null;
    }

    @Override
    public Object visit(Input r, Object p) {
        r.getExpression().accept(this, p);
        return null;
    }

    @Override
    public Object visit(ReturnStatement rs, Object p) {
        rs.getReturnExpression().accept(this, p);
        return null;
    }

    @Override
    public Object visit(WhileStatement ws, Object p) {
        ws.getExpression().accept(this, p);
        for (Statement s : ws.getStatements())
            s.accept(this, p);
        return null;
    }

    @Override
    public Object visit(Print w, Object p) {
        w.getExpressions().accept(this, p);
        return null;
    }

    //Types

    @Override
    public Object visit(ArrayType a, Object p) {
        a.getOfType().accept(this, p);
        return null;
    }

    @Override
    public Object visit(CharType c, Object p) {
        return null;
    }

    @Override
    public Object visit(DoubleType d, Object p) {
        return null;
    }

    @Override
    public Object visit(FieldRecord f, Object p) {
        f.getType().accept(this, p);
        return null;
    }

    @Override
    public Object visit(FunctionType f, Object p) {
        for (VarDefinition v : f.getArguments())
            v.accept(this, p);
        f.getReturnType().accept(this, p);
        return null;
    }

    @Override
    public Object visit(IntType i, Object p) {
        return null;
    }

    @Override
    public Object visit(RecordType r, Object p) {
        for (FieldRecord f : r.getFields())
            f.accept(this, p);
        return null;
    }

    @Override
    public Object visit(VoidType v, Object p) {
        return null;
    }
}
