package com.tomcoldenhoff.tables;

/**
 * Look up table for the jump field.
 * @author Tom Coldenhoff
 */
public class JumpTable extends LookUpTable {

    public JumpTable() {
        table.put("", "000");
        table.put("JGT", "001");
        table.put("JEQ", "010");
        table.put("JGE", "011");
        table.put("JLT", "100");
        table.put("JNE", "101");
        table.put("JLE", "110");
        table.put("JMP", "111");
    }

}