package main.grammar;

import java.util.LinkedHashSet;

public class SymbolCollection {

    private final String id;
    private final LinkedHashSet<String> symbols;

    public SymbolCollection(String id) {
        this.id = id;
        symbols = new LinkedHashSet<String>();
    }

    public boolean add(String symbol) {
        if (symbols.contains(symbol)) return false;

        if (!symbol.startsWith("<") || !symbol.endsWith(">")) return false;

        symbols.add(symbol);
        return true;
    }

    public String getAll() {
        StringBuilder sb = new StringBuilder();

        sb.append(id).append(" = {");

        var array = symbols.toArray();
        for (int i = 0; i < array.length - 1; i++) {
            sb.append(array[i]).append(", ");
        }

        sb.append(array[array.length - 1]);
        sb.append("}");

        return sb.toString();
    }

    public void remove(String value) {
        symbols.remove(value);
    }

    public boolean contains(String value) {
        return symbols.contains(value);
    }
}
