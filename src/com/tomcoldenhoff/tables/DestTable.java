package com.tomcoldenhoff.tables;

/**
 * Look up table for the dest field.
 * @author Tom Coldenhoff
 */
public class DestTable extends LookUpTable {

    public DestTable() {
        table.put("", "000");
        table.put("M", "001");
        table.put("D", "010");
        table.put("MD", "011");
        table.put("A", "100");
        table.put("AM", "101");
        table.put("AD", "110");
        table.put("AMD", "111");
    }



}