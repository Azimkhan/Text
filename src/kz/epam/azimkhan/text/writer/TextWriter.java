package kz.epam.azimkhan.text.writer;

import kz.epam.azimkhan.text.exception.TextWriteException;
import kz.epam.azimkhan.text.model.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Date: 11.06.13
 * Time: 17:36
 */
public class TextWriter {

    public static void write(Text text, String filename) throws TextWriteException{

        File file = new File(filename);
        FileWriter fw = null;

        try {
            fw = new FileWriter(file);
            fw.write(text.toString());

        } catch (IOException e) {
            throw  new TextWriteException(e.getMessage(), e.getCause());
        } finally {
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    //TODO logging
                }
            }
        }
    }
}
