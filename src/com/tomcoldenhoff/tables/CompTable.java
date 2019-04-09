package com.tomcoldenhoff.tables;

/**
 * Look up table for the comp field.
 * 
 * @author Tom Coldenhoff
 */
public class CompTable extends LookUpTable {

    public CompTable() {
        // A = 0
        table.put("0", "101010");
        table.put("1", "111111");
        table.put("-1", "111010");
        table.put("D", "001100");
        table.put("A", "110000");
        table.put("!D", "001101");
        table.put("!A", "110001");
        table.put("-D", "001111");
        table.put("-A", "110011");
        table.put("D+1", "011111");
        table.put("A+1", "110111");
        table.put("D-1", "001110");
        table.put("A-1", "110010");
        table.put("D+A", "000010");
        table.put("D-A", "010011");
        table.put("A-D", "000111");
        table.put("D&A", "000000");
        table.put("D|A", "010101");

        // A = 1
        table.put("M", "110000");
        table.put("!M", "110001");
        table.put("-M", "110011");
        table.put("M+1", "110111");
        table.put("M-1", "110010");
        table.put("D+M", "000010");
        table.put("D-M", "010011");
        table.put("M-D", "000111");
        table.put("D&M", "000000");
        table.put("D|M", "010101");
    }

    /**
     * Override of {@link LookUpTable} getValue method. Adds functionality to
     * check for A.
     * @param key Value to look up.
     */
    @Override
    public String getValue(String key) {

        StringBuilder builder = new StringBuilder();
        
        if (key.equals("M") || key.equals("!M") || key.equals("-M") || 
            key.equals("M+1") || key.equals("M-1") || key.equals("D+M") || 
            key.equals("D-M") || key.equals("M-D") || key.equals("D&M") ||
            key.equals("D|M")) {

                builder.append("1");
            } else {
                builder.append("0");
            }

            builder.append(super.getValue(key));
        return builder.toString();
    }


}