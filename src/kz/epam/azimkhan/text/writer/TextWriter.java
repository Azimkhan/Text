package kz.epam.azimkhan.text.writer;

import kz.epam.azimkhan.text.exception.TextWriteException;
import kz.epam.azimkhan.text.model.text.Text;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
}
