package com.tomcoldenhoff.parsing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * The Parser class parses the given line into seperate data that can be used
 * later.
 * 
 * @author Tom Coldenhoff
 */
public class Parser {
    
    // The file containing the rules for the parser. must be in the bin path.
    private final String RULES_FILE_PATH = "ParseRules.hckp";

    private ParseRules rules = new ParseRules();

    public Parser() {

        // Load rules
        File rulesFile = new File(RULES_FILE_PATH);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(rulesFile));
            
            // Read lines from the rule file
            String line;
            while ((line = reader.readLine()) != null) {
                
                // Split lines on white space
                line = line.trim();
                String[] parts = line.split("//");
                line = parts[0];

                parts = line.split("\\s");
                
                // If empty line skip
                if (parts.length < 2) {
                    continue;
                }

                // Assign name
                String name = "", start = "", end = "";
                name = parts[0];

                for (int i = 1; i < parts.length; i++) {
                    if (("=>").equals(parts[i])) {
                        start = parts[i + 1];
                    } else if (("<=".equals(parts[i]))) {
                        end = parts[i + 1];
                    }
                }

                // Add rule to rules
                rules.addRule(name, new ParseSymbols(start, end));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Parses the given string into the specified field.
     * @return ParseData the data.
     */
    public ParseData parse(String line) {

        ParseData data = new ParseData();

        // Remove all white space and comments
        line = line.replaceAll("\\s", "");
        String lines[] = line.split("//");

        line = lines[0];

        String label = "";
        StringBuilder builder = new StringBuilder();

        // Loop through all the characters from the line
        for (char c : line.toCharArray()) {
            
            // If is alphabetic
            if (Character.isAlphabetic(c)) {
                builder.append(c);
            } else { // If symbol

                boolean isUsed = false;

                HashMap<String, ParseSymbols> rulesMap = rules.getRules();

                // First iteration to check for endings
                for (String key : rulesMap.keySet()) {

                    if (Character.toString(c).equals(rulesMap.get(key).getEndSymbol())) {
                        label = key;
                        data.setValue(label, builder.toString());

                        label = "";
                        builder.setLength(0);
                        isUsed = true;
                    }
                }

                // Second iteration to check for starts
                for (String key : rulesMap.keySet()) {
                    if (Character.toString(c).equals(rulesMap.get(key).getStartSymbol())) {
                        label = key;
                        isUsed = true;
                    }
                }

                if (!isUsed) {
                    builder.append(c);
                }
            }

        }

        if (label != "") {
            data.setValue(label, builder.toString());
        }

        return data;
    }
}