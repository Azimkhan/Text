package kz.epam.azimkhan.text.runner;

import static kz.epam.azimkhan.text.writer.TextWriter.write;

import java.util.List;

import kz.epam.azimkhan.text.exception.TextParseException;
import kz.epam.azimkhan.text.exception.TextReadException;
import kz.epam.azimkhan.text.exception.TextWriteException;
import kz.epam.azimkhan.text.logic.SentenceSorter;
import kz.epam.azimkhan.text.logic.WordSorter;
import kz.epam.azimkhan.text.model.punctuation.Punctuation;
import kz.epam.azimkhan.text.model.text.Text;
import kz.epam.azimkhan.text.model.text.TextElement;
import kz.epam.azimkhan.text.parser.TextParser;

import org.apache.log4j.Logger;

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
            
            List<? extends TextElement> list = SentenceSorter.sortByWordNumber(text);
            write(list, new Punctuation('\n'), System.out);
            
            List<? extends TextElement> words = WordSorter.sortByVowelRatio(text);
            write(words, new Punctuation('\n'), System.out);
            
            write(text, out);
            

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
