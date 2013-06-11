package kz.epam.azimkhan.text.reader;

import kz.epam.azimkhan.text.exception.TextReadException;
import kz.epam.azimkhan.text.model.Text;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * Performs file reading
 */
public class TextReader {

    /**
     * Get file contents
     * @param filename name of the file that contains the text to be parsed
     * @return file contents
     * @throws kz.epam.azimkhan.text.exception.TextReadException
     */
    public static String read(String filename) throws TextReadException {
        Text text = new Text();
        FileReader fr = null;
        String buffer = null;
        StringBuilder builder = new StringBuilder();
        Logger logger = Logger.getRootLogger();

        File file = new File(filename);

        try{
            if (!file.exists() || !file.isFile()){
                throw new TextReadException("Invalid input filename. Please ensure the filename is correct.");
            }

            fr = new FileReader(file);
            logger.info(String.format("%s is opened.",file.getAbsolutePath()));

            char c;
            int i;

            while ((i = fr.read()) != -1){
                c = (char) i;
                builder.append(c);
            }


        } catch (IOException e){
            throw new TextReadException(e.getMessage(),e.getCause());
        }
        finally {
            if (fr != null){
                try {
                    fr.close();
                    logger.info(String.format("%s is closed.",file.getAbsolutePath()));
                } catch (IOException e) {
                    logger.error("Failed to close the file reader: " + e.getMessage());
                }
            }
        }

        return builder.toString();
    }
}
