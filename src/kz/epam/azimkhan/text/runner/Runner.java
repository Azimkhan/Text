package kz.epam.azimkhan.text.runner;

import kz.epam.azimkhan.text.exception.TextParseException;
import kz.epam.azimkhan.text.exception.TextReadException;
import kz.epam.azimkhan.text.exception.TextWriteException;
import kz.epam.azimkhan.text.model.Text;
import kz.epam.azimkhan.text.parser.TextParser;
import static kz.epam.azimkhan.text.writer.TextWriter.write;
import java.io.IOException;

/**
 * Date: 07.06.13
 * Time: 11:12
 */
public class Runner {
    public static void main(String[] args){

        String in = "text.in";
        String out = "text.out";
        TextParser tp = TextParser.getInstance();

        try {
            Text text = tp.parse(in);
            write(text,out);


        } catch (TextReadException e) {

        } catch (TextParseException e){

        } catch (TextWriteException e){

        }
        finally {

        }

    }
}
