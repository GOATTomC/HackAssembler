package com.tomcoldenhoff.assembler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tomcoldenhoff.code.Code;
import com.tomcoldenhoff.parsing.ParseData;
import com.tomcoldenhoff.parsing.Parser;
import com.tomcoldenhoff.writing.Writer;

/**
 * Assembler class contains all the logic to assemble the given file.
 * 
 * @author Tom Coldenhoff
 */
public class Assembler {

    public Assembler() {

    }

    /**
     * Assembles the given file(path) to a hack binary file.
     * 
     * @param filePath the path of the file to assemble
     * @throws FileNotFoundException
     */
    public void assemble(String filePath) throws FileNotFoundException {

        Parser parser = new Parser();
        File fileToParse = new File(filePath);

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileToParse));
            
            // Read lines of file
            String line;

            List<ParseData> parsedDatas = new ArrayList<ParseData>();
            
            // Parse and store all the lines
            while ((line = reader.readLine()) != null) {
                parsedDatas.add(parser.parse(line));
                
            }

            // Translate the parsed data into binary code
            Code translater = new Code();
            List<String> translations = translater.translate(parsedDatas);

            // Close the reader because we are done reading
            reader.close();

            // Write the translation to a hack file
            Writer writer = new Writer();
            String str = filePath.split("\\.")[0];
            writer.Write(str, translations);



        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}