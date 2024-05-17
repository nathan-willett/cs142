package a4_Projects.project5__5_16.app.src.main.java.project5;

import java.util.*;

/**
 * Class: GrammarSolver
 * 
 * GrammarSolver processes a set of BNF grammar rules from a text file, then outputs a random sentance using the 
 * 
 * @author Nathan Willett
 * @section 15596
 * @course CS 142, Spring 2024
 */
public class GrammarSolver {
    private Map<String, String[]> grammarMap;

    /**
     * This constructor initializes a new GrammarSolver object with the BNF rules provided in the 
     * 
     * @param rules
     */
    public GrammarSolver(List<String> rules) {
        if (rules == null || rules.isEmpty()) {
            throw new IllegalArgumentException("Rules list cannot be null or empty");
        }
        
        grammarMap = new HashMap<>();
        for (String rule : rules) {
            String[] parts = rule.split("::=");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid rule format");
            }
            String nonTerminal = parts[0].trim();
            String[] expansions = parts[1].split("[|]");
            if (grammarMap.containsKey(nonTerminal)) {
                throw new IllegalArgumentException("Duplicate rule for non-terminal: " + nonTerminal);
            }
            grammarMap.put(nonTerminal, expansions);
        }
    }

    public boolean contains(String symbol) {
        if (symbol == null || symbol.isEmpty()) {
            throw new IllegalArgumentException("Symbol cannot be null or empty");
        }
        return grammarMap.containsKey(symbol);
    }

    public Set<String> getSymbols() {
        return grammarMap.keySet();
    }

    public String generate(String symbol) {
        if (symbol == null || symbol.isEmpty()) {
            throw new IllegalArgumentException("Symbol cannot be null or empty");
        }
        if (!grammarMap.containsKey(symbol)) {
            return symbol;  // Terminal symbol, return as is
        }

        Random random = new Random();
        String[] expansions = grammarMap.get(symbol);
        String expansion = expansions[random.nextInt(expansions.length)].trim();
        String[] tokens = expansion.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String token : tokens) {
            result.append(generate(token)).append(" ");
        }
        return result.toString().trim();
    }
}
