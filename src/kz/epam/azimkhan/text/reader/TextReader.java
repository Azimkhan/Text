package kz.epam.azimkhan.text.reader;

import kz.epam.azimkhan.text.exception.TextReadException;
import kz.epam.azimkhan.text.model.Text;

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

        try{
            fr = new FileReader(new File(filename));
            char c;
            int i;

            while ((i = fr.read()) != -1){
                c = (char) i;
                builder.append(c);
            }


        } catch (FileNotFoundException e) {
            throw new TextReadException("Input file wasn't found.");
        } catch (IOException e){
            throw new TextReadException(e.getMessage(),e.getCause());
        }
        finally {
            if (fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    // TODO logging
                }
            }
        }

        return builder.toString();
    }
}
