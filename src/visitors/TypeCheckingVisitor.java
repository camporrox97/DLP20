package visitors;

import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import symboltable.SymbolTable;

import java.util.List;
import java.util.stream.Collectors;

public class TypeCheckingVisitor extends AbstractVisitor {



    //////////////////////////////////////////////////////////////L-VALUE Y FIJADO DE TIPOS///////////////////////////////////////////////////////////////////////////

    /**
     * Aritmetic() tipo -> INT, REAL, CHAR ***ACORDARSE DE PREGUNTAR A MIGUEL ESTO ULTIMO***
     * l-value a false dado que no puede ir a la derecha en una asignación
     * @param a
     * @param p
     * @return
     */
    @Override
    public Object visit(Arithmetic a, Object p) {
        super.visit(a, p);
        a.setLValue(false);
        a.setType(a.getLeftExpression().getType().arithmetic(a.getRightExpression().getType()));
        if (a.getType() == null) {
            a.setType(new ErrorType(a, "No se puede hacer la operacion aritmetica " +
                    "con los tipos" + a.getLeftExpression().getType() + " y "
                    + a.getRightExpression().getType()));
        }
        return null;
    }

    /**
     * canBeCast() -> intType, DoubleType, CharType
     * L-value false no puede ir a la izquierda
     * @param c
     * @param p
     * @return
     */
    @Override
    public Object visit(Cast c, Object p) {
        //c.getExpression().accept(this, p);

        super.visit(c, p);
        c.setLValue(false);
        c.setType(c.getExpression().getType().canBeCast(c.getCast()));
        if (c.getType() == null) {
            c.setType(new ErrorType(c, "No se puede castear: " + c.getExpression().getType() + " a: " + c.getCast()));
        }
        return null;
    }

    @Override
    public Object visit(CharLiteral c, Object p) {
        super.visit(c, p);
        c.setLValue(false);
        c.setType(CharType.getInstance());
        return null;
    }

    @Override
    public Object visit(RealLiteral r, Object p) {
        super.visit(r, p);
        r.setLValue(false);
        r.setType(DoubleType.getInstance());
        return null;
    }


    @Override
    public Object visit(IntLiteral i, Object p) {
        super.visit(i, p);
        i.setLValue(false);
        i.setType(IntType.getInstance());
        return null;
    }

    /**
     * comparison() -> intType, DoubleType, CharType
     * L-value false no puede ir a la izquierda
     * @param c
     * @param p
     * @return
     */
    @Override
    public Object visit(Comparison c, Object p) {
        super.visit(c, p);
        c.setLValue(false);
        c.setType(c.getLeftExpression().getType().comparison(c.getRightExpression().getType()));
        if (c.getType() == null) {
            c.setType(new ErrorType(c,
                    "No se puede comparar: " + c.getLeftExpression().getType() + " con: " + c.getRightExpression().getType()));
        }
        return null;
    }

    /**
     *dot() -> RecodrdType
     * LVALUE true puede ir a la izquierda a.b = 23
     * @param f
     * @param p
     * @return
     */
    @Override
    public Object visit(FieldAccess f, Object p) {
        super.visit(f, p);
        f.setLValue(true);
        f.setType(f.getExpression().getType().dot(f.getName()));
        if (f.getType() == null) {

            f.setType(new ErrorType(f, "No hay campo en el struct definido para " + f.getName()));
        }
        return null;
    }

    /**
     * squareBrackets() -> ArrayType
     * L-value true: a[2] = 5
     * @param i
     * @param p
     * @return
     */
    @Override
    public Object visit(Indexing i, Object p) {
        super.visit(i, p);
        i.setLValue(true);
        i.setType(i.getLeftExpression().getType().squareBrackets(i.getRightExpression().getType()));
        if (i.getType() == null) {

            i.setType(new ErrorType(i, "No hay array definido para:" + i.getRightExpression().getType()));
        }
        return null;
    }


    /**
     * logical() -> intType
     * L-value a false
     * @param l
     * @param p
     * @return
     */
    @Override
    public Object visit(Logical l, Object p) {
        super.visit(l, p);
        l.setLValue(false);
        l.setType(l.getLeftExpression().getType().logical(l.getRightExpression().getType()));
        if (l.getType() == null) {
            l.setType(new ErrorType(l,
                    "No hay operacion logica para: " + l.getLeftExpression().getType() + " con: " + l.getRightExpression().getType()));
        }
        return null;
    }


    /**
     *  arithmetic() -> intType, DoubleType,
     *  L-value false
     * @param u
     * @param p
     * @return
     */
    @Override
    public Object visit(UnaryMinus u, Object p) {
        super.visit(u, p);
        u.setLValue(false);
        u.setType(u.getExpression().getType().arithmetic());
        if (u.getType() == null) {
            u.setType(new ErrorType(u, "No unary minus para " + u.getExpression().getType()));
        }

        return null;
    }

    /**
     *  logical() -> intType
     *  L-value false
     * @param u
     * @param p
     * @return
     */
    @Override
    public Object visit(UnaryNot u, Object p) {
        super.visit(u, p);
        u.setLValue(false);
        u.setType(u.getExpression().getType().logical());
        if (u.getType() == null) {
            u.setType(new ErrorType(u, "No unary not para " + u.getExpression().getType()));
        }
        return null;
    }

    /**
     * Su tipo es el de su definicion
     * Puede ir a la izquierda en una asignacion a = 234 L-value true
     * @param v
     * @param p
     * @return
     */
    @Override
    public Object visit(Variable v, Object p) {

        super.visit(v, p);
        v.setLValue(true);
        v.setType(v.getDefinition().getType());

        return null;
    }

//Statements

    /**
     * promosto() -> intType, char real int a int char a char real a real
     * @param a
     * @param p
     * @return
     */
    @Override
    public Object visit(Assignament a, Object p) {

        super.visit(a, p);

        if (!a.getLeftExpression().getLValue())
            new ErrorType(a, "Se espera LValue en la expresion de la izquierda de la asignacion.");

        Type type = a.getRightExpression().getType().promotesTo(a.getLeftExpression().getType());
        if (type == null)
        {
            new ErrorType(a, "No hay promocion a:  " + a.getLeftExpression().getType() + " en la asignación");
        }


        return null;
    }

    @Override
    public Object visit(Invocation i, Object p) {
        super.visit(i, p);
        i.setLValue(false);
        List<Type> types = i.getParameters().stream()
                .map((e) -> e.getType())
                .collect(Collectors.toList());
        i.setType(i.getVariable().getType().parenthesis(types));
        if (i.getType() == null) {
            i.setType(new ErrorType(i, "Invocaion no valida"));
        }
        return null;
    }

    /**
     * Necesita ser buildintype
     * @param r
     * @param p
     * @return
     */
    @Override
    public Object visit(Input r, Object p) {
        super.visit(r, p);
        if (!r.getExpression().getLValue())
            new ErrorType(r, "Se espera LValue en la expresion del INPUT WRITE.");

        if (!r.getExpression().getType().isBuiltInType()){
            new ErrorType(r.getExpression(), "No isBuiltInType en el input");

        }

        return null;
    }

    @Override
    public Object visit(IfStatement is, Object p) {

        //¿SUPER VISIT?
        is.getExpression().accept(this, p);

        if (!is.getExpression().getType().isLogical()) {
            new ErrorType(is.getExpression(), "Se esperaba expresion logica en el if");
        }

        for (Statement s : is.getIfBody())
            s.accept(this, p);
        for (Statement s : is.getElseBody())
            s.accept(this, p);

        return null;
    }

    @Override
    public Object visit(FuncDefinition f, Object p) {
        FunctionType fType = (FunctionType)f.getType();
        Type returnType = fType.getReturnType();
        return super.visit(f, returnType);
        //heredado
    }

    @Override
    public Object visit(ReturnStatement rs, Object p) {
        Type returnType = (Type)p;
        super.visit(rs, returnType);
        if (rs.getReturnExpression() != null) {
            Type t = rs.getReturnExpression().getType().promotesTo(returnType);
            if (t == null) {

                //error
                new ErrorType(rs.getReturnExpression(),
                        "Tipo de la expresion de retorno (" + rs.getReturnExpression().getType()
                                +") no coincide con el de la funcion (" + returnType +")");
            }
        }
        else {
            if (returnType != VoidType.getInstance()) {

                new ErrorType(rs.getReturnExpression(),
                        "Falta expresion en return en funcion que no es void");
            }
        }
        return null;
    }

    @Override
    public Object visit(WhileStatement ws, Object p) {
        ws.getExpression().accept(this, p);


        if (!ws.getExpression().getType().isLogical()) {
            new ErrorType(ws.getExpression(), "Se esperaba expresión lógica en el while");
        }

        for (Statement s : ws.getStatements())
            s.accept(this, p);

        return null;
    }

    @Override
    public Object visit(Print w, Object p) {
        super.visit(w, p);
        if (!w.getExpressions().getType().isBuiltInType()){
            new ErrorType(w.getExpressions(), "No isBuiltInType en el print");

        }
        return null;
    }













}
