package com.tomcoldenhoff.parsing;

import java.util.HashMap;

/**
 * Contains the data of a parsed line
 * @author Tom Coldenhoff
 */
public class ParseData {
    
    private HashMap<String, String> parseData = new HashMap<String, String>();

    public ParseData () {
        
    }

    /**
     * Puts a entry into the HashMap containing the data from the parsed part
     * of the line.
     * @param keyName
     * @param symbols
     */
    public void setValue(String keyName, String value) {
        parseData.put(keyName, value);
    }

    /**
     * Gets the value if the given key exists.
     */
    public String getValue(String keyName) {
        return parseData.get(keyName);
    }

    public boolean isEmpty() {
        return parseData.size() == 0;
    }
}