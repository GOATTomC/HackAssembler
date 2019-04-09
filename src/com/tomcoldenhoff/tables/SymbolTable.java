package com.tomcoldenhoff.tables;

import java.util.HashMap;

/**
 * The table for symbols
 * @author Tom Coldenhoff
 */
public class SymbolTable {

    private HashMap<String, Integer> symbolTable = new HashMap<String, Integer>();

    /**
     * Adds a symbol to the symbol table.
     * @param name The name of the symbol.
     * @param address The address.
     */
    public void addSymbol(String name, Integer address) {
        symbolTable.put(name, address);
    }

    /**
     * Gets the address of the symbol.
     * @param name The name of the symbol.
     * @return The address of the symbol.
     */
    public Integer getAddress(String name) {

        if (symbolTable.get(name) == null) {
            return Integer.MIN_VALUE;
        } else {
            return symbolTable.get(name);
        }
 
    }



}