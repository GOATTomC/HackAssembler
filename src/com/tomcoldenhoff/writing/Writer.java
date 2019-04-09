package com.tomcoldenhoff.writing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Contains all the functionality for writing the translations to the given
 * filename.
 * 
 * @author Tom Coldenhoff
 */
public class Writer {

    /**
     * Writes the given translations to the given filename.
     * 
     * @param fileName     The fileName where we want to write to.
     * @param translations The binary translations.
     * @throws IOException
     */
    public void Write(String fileName, List<String> translations) throws IOException {
        // Create definitive file name
        StringBuilder builder = new StringBuilder();
        builder.append(fileName);
        builder.append(".hack");
        fileName = builder.toString();

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (String str : translations) {
            writer.write(str + "\n");
        }

        writer.close();
    }

}