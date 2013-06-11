package kz.epam.azimkhan.text.runner;

import kz.epam.azimkhan.text.exception.TextParseException;
import kz.epam.azimkhan.text.exception.TextReadException;
import kz.epam.azimkhan.text.exception.TextWriteException;
import kz.epam.azimkhan.text.model.Text;
import kz.epam.azimkhan.text.parser.TextParser;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import static kz.epam.azimkhan.text.writer.TextWriter.write;

/**
 * Simple runner
 */
public class Runner {

    private static final Logger logger = Logger.getRootLogger();

    public static void main(String[] args){

        String in = "text.in";
        String out = "text.out";
        TextParser tp = TextParser.getInstance();

        try {
            Text text = tp.parse(in);
            write(text,out);


        } catch (TextReadException e) {
            logger.error(e.getMessage());

        } catch (TextParseException e){
            logger.error(e.getMessage());

        } catch (TextWriteException e){
            logger.error(e.getMessage());
        }
        finally {
            logger.info("Complete.");
        }

    }
}
