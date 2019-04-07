package com.tomcoldenhoff.parsing;

import java.util.HashMap;

/**
 * Contains the functionality to store and read the rules for the parser.
 * @author Tom Coldenhoff
 */
public class ParseRules {
    private HashMap<String, ParseSymbols> parseRules = new HashMap<String, ParseSymbols>();

    public ParseRules() {

    }

    /**
     * Adds a rule to the rules for the parser.
     * @param name The key name
     * @param symbols the symbols
     */
    public void addRule(String name, ParseSymbols symbols) {
        parseRules.put(name, symbols);
    }

    /**
     * Gets the current rules for the parser.
     * @return the rules for the parser
     */
    public HashMap<String, ParseSymbols> getRules() {
        return parseRules;
    }

    
}