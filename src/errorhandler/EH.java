package errorhandler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class EH {

    private List<ErrorType> errors = new ArrayList<ErrorType>();
    //SINGLETON
    private static EH instance = new EH();


    public static EH getEH()
    {
        return instance;
    }

    public List<ErrorType> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorType> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ErrorHandler [errors=" + errors + "]";
    }

    public void addError(ErrorType error)
    {
        errors.add(error);
    }

    //anyerror
    public boolean hasErrors()
    {
        return !errors.isEmpty();
    }

    public void showErrors(PrintStream out)
    {
        for (ErrorType e : errors)
            out.println(e);
    }

}
