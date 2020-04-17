package visitors;

import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Variable;
import ast.statements.Statement;
import ast.types.ErrorType;
import symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor {

    SymbolTable st = new SymbolTable();

    //Expressions

    public IdentificationVisitor() {
    }


    @Override
    public Object visit(VarDefinition vf, Object param)
    {
        if (!st.insert(vf))
            new ErrorType(vf, "Variable already declared");
        return null;
    }

    @Override
    public Object visit(FuncDefinition fd, Object param)
    {
        if (!st.insert(fd))
            new ErrorType(fd, "Function already declared");
        st.set();
	//	fd.getType().accept(this, param);
	//	for (Statement s : fd.getStatements())

 	//		s.accept(this, param);
        super.visit(fd, param);
        st.reset();
        return null;
    }

    @Override
    public Object visit(Variable v, Object param)
    {
        Definition def = st.find(v.getName());
        if (def == null)
            def = new VarDefinition(0, 0, "VarDefinition-ErrorType", new ErrorType(v, "No variable declared"), 0, 0);
        v.setDefinition(def);
        return null;
    }
}
