package com.tomcoldenhoff.tables;

import java.util.HashMap;

/**
 * The table for symbols
 * @author Tom Coldenhoff
 */
public class SymbolTable {

    private HashMap<String, Integer> symbolTable = new HashMap<String, Integer>();

    public SymbolTable() {

        symbolTable.put("R0", 0);
        symbolTable.put("R1", 1);
        symbolTable.put("R2", 2);
        symbolTable.put("R3", 3);
        symbolTable.put("R4", 4);
        symbolTable.put("R5", 5);
        symbolTable.put("R6", 6);
        symbolTable.put("R7", 7);
        symbolTable.put("R8", 8);
        symbolTable.put("R9", 9);
        symbolTable.put("R10", 10);
        symbolTable.put("R11", 11);
        symbolTable.put("R12", 12);
        symbolTable.put("R13", 13);
        symbolTable.put("R14", 14);
        symbolTable.put("R15", 15);

        symbolTable.put("SCREEN", 16384);
        symbolTable.put("KBD", 24576);
    }

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