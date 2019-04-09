package com.tomcoldenhoff.code;

import java.util.ArrayList;
import java.util.List;

import com.tomcoldenhoff.tables.CompTable;
import com.tomcoldenhoff.tables.DestTable;
import com.tomcoldenhoff.tables.JumpTable;
import com.tomcoldenhoff.tables.SymbolTable;
import com.tomcoldenhoff.parsing.ParseData;

/**
 * Contains the functionality to translate the parsed data to hack binary.
 * @author Tom Coldenhoff
 */
public class Code {

    /**
     * Translates the parsed data into hack binary.
     * @param data Parsed data.
     * @return String list containing Hack binary
     */
    public List<String> translate(List<ParseData> data) {

        SymbolTable symbolTable = new SymbolTable();

        // Loop through the parsed data.
        // First pass look for symbols of (XXX) type.
        firstPass(symbolTable, data);
        List<String> translations = secondPass(data, symbolTable);
        return translations;
    }

    /**
     * Does the first pass for the translation process. Looks for all the
     * symbols in the parsed code and stores the address.
     * @param symbolTable The {@link SymbolTable} to store the address.
     * @param data The parsed code.
     */
    private void firstPass(SymbolTable symbolTable, List<ParseData> data) {

        int address = 0;
        for (ParseData parseData : data) {
            
            if (parseData.isEmpty()) {
                continue;
            }

            String symbol = parseData.getValue("symb");
            if (symbol != null) {

                symbolTable.addSymbol(symbol, address);
            }

            address++;
        }
    }

    /**
     * Does the second pass for the translation process. translates all A
     * and C instructions.
     * @param data The parsed code.
     * @param symbolTable The {@link SymbolTable} to look up symbols.
     * @return List of strings containing all the translations.
     */
    private List<String> secondPass(List<ParseData> data, SymbolTable symbolTable) {

        // Look up tables
        DestTable destTable = new DestTable();
        JumpTable jumpTable = new JumpTable();
        CompTable compTable = new CompTable();

        // Store translation here before writing to a file
        List<String> translations = new ArrayList<String>();

        // 0 - 16 is reserved
        int ramAddr = 16;
        StringBuilder builder = new StringBuilder();


        for (ParseData parseData : data) {
            
            if (parseData.getValue("symb") != null || (parseData.isEmpty())) {
                continue;
            }

            // If @ instruction
            if (parseData.getValue("addr") != null) {
                
                String addr = parseData.getValue("addr");

                // If symbol in symbolTable
                if (symbolTable.getAddress(addr) != Integer.MIN_VALUE) {
                    translations.add(toBinary(symbolTable.getAddress(addr)));
                } else {

                    // if alphabetic address
                    char chars[] = addr.toCharArray();
                    if (Character.isAlphabetic(chars[0])) {
                        symbolTable.addSymbol(addr, ramAddr);
                        translations.add(toBinary(symbolTable.getAddress(addr)));
                        ramAddr++;
                    } else {
                        symbolTable.addSymbol(addr, Integer.parseInt(addr));
                        translations.add(toBinary(symbolTable.getAddress(addr)));
                    }

                }

            } else {
                // 111 for c instruction
                builder.append("111");
                
                // Translate parsed data
                builder.append(compTable.getValue(parseData.getValue("comp")));
                builder.append(destTable.getValue(parseData.getValue("dest")));
                builder.append(jumpTable.getValue(parseData.getValue("jump")));
                translations.add(builder.toString());
                builder.setLength(0);
            }
        
        
        }

        return translations;
    }

    /**
     * Converts a string representing a number to binary.
     * @param value The string containing a number.
     * @return Binary value of the value.
     */
    private String toBinary(int value) {
        String binary = String.format("%016d", Integer.parseInt(Integer.toBinaryString(value)));
        return binary;
    }
}