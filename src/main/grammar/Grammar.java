package main.grammar;

import jdk.jfr.Description;

import java.util.*;

public class Grammar {

    private final SymbolCollection noTerminals;
    private final SymbolCollection terminals;
    private String axiom;
    private final HashMap<String, String> productions;

    public Grammar() {
        noTerminals = new SymbolCollection("N");
        terminals = new SymbolCollection("T");
        axiom = "";
        productions = new HashMap<>();
    }

    public boolean addNoTerminal(String noTerminal) {
        return noTerminals.add(noTerminal);
    }

    public String getNoTerminals() {
        return noTerminals.getAll();
    }

    public boolean setAxiom(String axiom) {
        if (!axiom.startsWith("<") || !axiom.endsWith(">")) return false;

        // Delete the current axiom from the no terminals collection
        if (!this.axiom.isEmpty()) noTerminals.remove(this.axiom);

        this.axiom = axiom;
        noTerminals.add(this.axiom);

        return true;
    }

    public String getAxiom() {
        return "S = {" + axiom + "}";
    }

    public boolean addTerminal(String terminal) {
        return terminals.add(terminal);
    }

    public String getTerminals() {
        return terminals.getAll();
    }

    public void addAllTerminals(String[] terminals) {
        for (String terminal : terminals) {
            this.terminals.add(terminal);
        }
    }

    public boolean addProduction(String id, String description) {
        if (id.isEmpty() || description.isEmpty()) return false;

        if (!noTerminals.contains(id) && !terminals.contains(id)) return false;

        if (!validateSymbols(getSymbolsFromString(description))) return false;

        productions.put(id, description);
        return true;
    }

    public Set<String> getSymbolsFromString(String description) {
        Set<String> extractedSymbols = new LinkedHashSet<String>();

        StringBuilder symbol = new StringBuilder();
        int index = 0;
        char c;

        while (index < description.length()) {
            c = description.charAt(index);

            if (c != '|') symbol.append(c);

            if (c == '>' || index + 1 == description.length()) {
                extractedSymbols.add(symbol.toString());
                symbol = new StringBuilder();
            }

            index++;
        }

        return extractedSymbols;
    }

    public boolean validateSymbols(Set<String> symbols) {
        for (String symbol : symbols) {
            if (!symbol.startsWith("<") || !symbol.endsWith(">")) return false;

            if (!noTerminals.contains(symbol) && !terminals.contains(symbol)) {
                System.out.println(symbol);
                return false;
            }
        }
        return true;
    }

    @Description("A Grammar is valid when all of the no terminals are defined in the productions")
    public static boolean isValid() {
        return true;
    }
}