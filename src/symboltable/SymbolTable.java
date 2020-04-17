package symboltable;

import ast.definitions.Definition;

import java.util.*;

public class SymbolTable {
	
	private int scope=0;
	private List<Map<String, Definition>> table;

	public SymbolTable()  {
		this.table = new ArrayList<Map<String, Definition>>();
		set();
	}

	public void set() {
		this.scope++;
		table.add(new HashMap<String, Definition>()); //añade
	}
	
	public void reset() {
		table.remove(this.scope-1); //elimina tabla del scope actual
		this.scope--;
	}

	public boolean insert(Definition definition) {
		Definition def = findInCurrentScope(definition.getName());
		if (def != null)
			return false; // hay alguna insertada ya en la tabla

		table.get(this.scope-1).put(definition.getName(), definition);
		definition.setScope(this.scope - 1); //true puedo insertar. No hay ninguna
		return true;
	}
	
	public Definition find(String id) {

		for (int i = this.scope-1; i >= 0; i--)
		{
			Map<String, Definition> dic = table.get(i);
			Definition def = dic.get(id);
			if (def != null)
				return def;
		}
		return null;
	}


	public Definition findInCurrentScope(String id) {
		return table.get(this.scope-1).get(id);
	}
}
