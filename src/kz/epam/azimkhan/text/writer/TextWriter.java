package kz.epam.azimkhan.text.writer;

import kz.epam.azimkhan.text.exception.TextWriteException;
import kz.epam.azimkhan.text.model.text.Text;
import kz.epam.azimkhan.text.model.text.TextElement;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Performs text writing
 */
public class TextWriter {


    /**
     * Outputs the text to given file
     * @param text text object
     * @param filename a file to open
     * @throws TextWriteException
     */
    public static void write(Text text, String filename) throws TextWriteException{

        Logger logger = Logger.getRootLogger();

        File file = new File(filename);
        FileWriter fw = null;

        try {

            fw = new FileWriter(file);
            logger.info(String.format("%s is opened.", file.getAbsolutePath()));

            fw.write(text.toString());

        } catch (IOException e) {
            throw  new TextWriteException(e.getMessage(), e.getCause());
        } finally {
            if (fw != null){
                try {
                    fw.close();
                    logger.info(String.format("%s is closed.", file.getAbsolutePath()));

                } catch (IOException e) {
                    logger.error("Failed to close file writer");
                }
            }
        }
    }
    
    /**
     * Write out list of text elements separated by another text elementex
     * @param elements
     * @param separator
     * @param out
     * @throws TextWriteException
     */
    public static void write(List<? extends TextElement> elements, TextElement separator, PrintStream out) throws TextWriteException{
    	
    	if (null == out || null == separator || null == elements){
    		throw new TextWriteException("Invalid argument(s)");
    	};
    	
    	for (TextElement e : elements){
    		out.println(e);
    	}
    	
    	
    }
}
