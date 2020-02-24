package ast.types;

public class CharType extends AbstractType {

    private static CharType instance = new CharType();

    private CharType(int line, int column) {
        super(line, column);
    }

    private CharType() {
        super();
    }

    public static CharType getInstance()
    {
        return instance;
    }

    @Override
    public String toString() {
        return "CharType []";
    }

}
