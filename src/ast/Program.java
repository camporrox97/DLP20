package ast;

import ast.definitions.Definition;
import ast.definitions.FuncDefinition;

import java.util.List;

public class Program extends  AbstractAstNode {

    private List<Definition> definitions;


    public Program(int line, int column, List<Definition> definitions, FuncDefinition main) {
        super(line, column);
        this.definitions = definitions;
        this.definitions.add(main);
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }
    @Override
    public String toString() {
        return "Program [definitions=" + definitions + "]";
    }

}
