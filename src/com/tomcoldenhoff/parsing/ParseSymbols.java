package com.tomcoldenhoff.parsing;

/**
 * A struct for the start and end symbol used in the parser.
 * @author Tom Coldenhoff
 */
public class ParseSymbols {

    private String start, end;

    public ParseSymbols(String start, String end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Gets the start symbol.
     * @return the start symbol
     */
    public String getStartSymbol() {
        return start;
    }

    /**
     * Gets the end symbol.
     * @return the end symbol
     */
    public String getEndSymbol() {
        return end;
    }

}