package com.tomcoldenhoff.tables;

import java.util.HashMap;

/**
 * Contains the main functionality and data for the look up tables.
 * @author Tom Coldenhoff
 */
public class LookUpTable {

    protected HashMap<String, String> table = new HashMap<String, String>();

    /**
     * Gets the binary value (String) that belongs to this key.
     * @param key The value you want to get.
     * @return The value that belongs to the key.
     */
    public String getValue(String key) {

        if (key == null) {
            key = "";
        }

        return table.get(key);
    }
}