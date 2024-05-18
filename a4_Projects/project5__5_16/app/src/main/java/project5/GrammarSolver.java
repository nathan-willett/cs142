import java.util.*;

/**
 * Class: GrammarSolver
 * 
 * GrammarSolver interprets a set of BNF rules from the 'lines' ArrayList in
 * GrammarMain. The program then uses these rules to generate random sentences
 * or phrases based on the grammar definitions provided. The GrammarSolver
 * class provides methods to check for non-terminals, retrieve all non-terminal
 * symbols, and generate random occurrences of symbols based on the grammar rules.
 * 
 * @author Nathan Willett
 * @section 15596
 * @course CS 142, Spring 2024
 */
public class GrammarSolver {
    private Map<String, String[]> grammarMap;

    /**
     * The constructor initializes a new GrammarSolver object with the contents of
     * the 'lines' ArrayList.
     * 
     * @param rules a list of strings representing BNF grammar rules
     * @throws IllegalArgumentException if the rules list is null, empty, contains
     *         invalid rule formats, or contains duplicate non-terminal definitions
     */
    public GrammarSolver(List<String> rules) {
        if (rules == null || rules.isEmpty()) {
            throw new IllegalArgumentException("Rules list cannot be null or empty");
        }

        grammarMap = new HashMap<>(); // initialize grammarMap
        for (String rule : rules) {
            String[] parts = rule.split("::="); // split the rule at the separator
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid rule format");
            }
            String nonTerminal = parts[0].trim(); // get the non terminal part 
            String[] expansions = parts[1].split("[|]"); // get the expansions, separated with a pipe '|'
            if (grammarMap.containsKey(nonTerminal)) {
                throw new IllegalArgumentException("Duplicate rule for non-terminal: " + nonTerminal);
            }
            grammarMap.put(nonTerminal, expansions);
        }
    }

    /**
     * Checks if the given symbol is a non-terminal in the grammar.
     *
     * @param symbol the symbol to check
     * @return true if the symbol is a non-terminal, false otherwise
     * @throws IllegalArgumentException if the symbol is null or empty
     */
    public boolean contains(String symbol) {
        if (symbol == null || symbol.isEmpty()) {
            throw new IllegalArgumentException("Symbol cannot be null or empty");
        }
        return grammarMap.containsKey(symbol);
    }

    /**
     * Returns all non-terminal symbols in the grammar as a set of strings.
     *
     * @return a set of all non-terminal symbols
     */
    public Set<String> getSymbols() {
        return grammarMap.keySet();
    }

    /**
     * Generates a random occurrence of the given symbol according to the grammar rules.
     *
     * @param symbol the symbol to generate
     * @return a randomly generated occurrence of the symbol
     * @throws IllegalArgumentException if the symbol is null or empty
     */
    public String generate(String symbol) {
        if (symbol == null || symbol.isEmpty()) {
            throw new IllegalArgumentException("Symbol cannot be null or empty");
        }
        if (!grammarMap.containsKey(symbol)) {
            return symbol; // Terminal symbol, return as is
        }

        Random random = new Random();
        String[] expansions = grammarMap.get(symbol); // Get expansions for the non-terminal
        String expansion = expansions[random.nextInt(expansions.length)].trim();
        String[] tokens = expansion.split("\\s+"); // Split the expansion into tokens
        StringBuilder result = new StringBuilder();
        for (String token : tokens) {
            result.append(generate(token)).append(" "); // Recursively generate each token
        }
        return result.toString().trim();
    }
}
