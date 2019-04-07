package com.tomcoldenhoff;

import java.io.File;
import java.io.FileNotFoundException;

import com.tomcoldenhoff.assembler.Assembler;

/**
 * Main class and entry point of the assembler for the Hack Assembly language
 * 
 * @author Tom Coldenhoff
 */
public class HackAssembler {

    public HackAssembler() {

    }

    public static void main(String[] args) throws FileNotFoundException {

        // Check if there are enough arguments passed through the CLI
        if (args.length < 1) {
            System.out.println("You need to enter a filepath to assemble.");
            System.out.println("Usage: java com.tomcoldenhoff.HackAssembler " +
            "{filepath}");

            return;
        }
        
        // Check if the file exists before assembling
        File temp = new File(args[0]);
        if (!temp.exists() && !temp.isDirectory()) {
            System.out.println("Can't find the given file, please check the " +
            "given path.");

            return;
        }

        // Assemble the given file
        Assembler assembler = new Assembler();
        assembler.assemble(args[0]);

    }
}