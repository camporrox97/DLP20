package visitors;

import ast.Program;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

public interface Visitor {

    // Definitions
    Object visit(FuncDefinition f, Object p);

    Object visit(VarDefinition vd, Object p);

    // Expressions
    Object visit(Arithmetic a, Object p);

    Object visit(Cast c, Object p);

    Object visit(CharLiteral c, Object p);

    Object visit(Comparison c, Object p);

    Object visit(FieldAccess f, Object p);

    Object visit(Indexing i, Object p);

    Object visit(IntLiteral i, Object p);

    Object visit(Logical l, Object p);

    Object visit(RealLiteral r, Object p);

    Object visit(UnaryMinus u, Object p);

    Object visit(UnaryNot u, Object p);

    Object visit(Variable v, Object p);

    // Statements
    Object visit(Assignament a, Object p);

    Object visit(IfStatement is, Object p);

    Object visit(Invocation i, Object p);

    Object visit(Input r, Object p);

    Object visit(ReturnStatement rs, Object p);

    Object visit(WhileStatement ws, Object p);

    Object visit(Print w, Object p);

    // Types
    Object visit(ArrayType a, Object p);

    Object visit(CharType c, Object p);

    Object visit(DoubleType d, Object p);

    Object visit(FieldRecord f, Object p);

    Object visit(FunctionType f, Object p);

    Object visit(IntType i, Object p);

    Object visit(RecordType r, Object p);

    Object visit(VoidType v, Object p);

    // Program
    Object visit(Program pr, Object p);

}
