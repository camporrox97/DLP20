package codeGenerator;

import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.types.FieldRecord;
import ast.types.FunctionType;
import ast.types.RecordType;
import visitors.AbstractVisitor;

public class OffsetVisitor extends AbstractVisitor {

    private int contGlobales = 0; //+
    private int contLocales = 0; // -


    //VARIABLES LOCALES Y GLOBALES
    @Override
    public Object visit(VarDefinition vd, Object p){
        //VARIABLE GLOBAL
        if(vd.getScope() == 0){
            vd.setOffset(contGlobales);
            contGlobales += vd.getType().size();
         //EN ESTE CASO LOCALES (los parametros no son visitados aunq entren en este caso)
        }else{
            contLocales += vd.getType().size();
            vd.setOffset(-contLocales);
        }
        vd.getType().accept(this,p);
        return null;
    }

    @Override
    public Object visit(FuncDefinition fd, Object p) {
        contLocales = 0; // resetear nuevas locales
        super.visit(fd, p);
        return null;
    }

    @Override
    public Object visit(RecordType rt, Object p) {
        int bytesFieldsSum = 0;
        for (FieldRecord f : rt.getFields()) { //iteramos por los campos
            f.setOffset(bytesFieldsSum);
            bytesFieldsSum += f.getType().size();
            f.accept(this, p);
        }
        return bytesFieldsSum;
    }


    //PARAMETROS
    @Override
    public Object visit(FunctionType ft, Object p)
    {
        int bytesParamSum = 4; //empiezan en 4
        if (!ft.getArguments().isEmpty()) { //Si hay parametros,
            for (int i = ft.getArguments().size() - 1; i >= 0; i--) { //iteramos por ellos en orden inverso
                VarDefinition vd = ft.getArguments().get(i);
                vd.setOffset(bytesParamSum);
                bytesParamSum += vd.getType().size();
            }
        }
        ft.getReturnType().accept(this, p);
        return null;
    }
}
