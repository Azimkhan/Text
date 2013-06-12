package kz.epam.azimkhan.text.runner;

import kz.epam.azimkhan.text.exception.TextParseException;
import kz.epam.azimkhan.text.exception.TextReadException;
import kz.epam.azimkhan.text.exception.TextWriteException;
import kz.epam.azimkhan.text.logic.SentenceSorter;
import kz.epam.azimkhan.text.model.paragraph.Paragraph;
import kz.epam.azimkhan.text.model.sentence.Sentence;
import kz.epam.azimkhan.text.model.text.Text;
import kz.epam.azimkhan.text.model.word.Word;
import kz.epam.azimkhan.text.parser.TextParser;
import org.apache.log4j.Logger;

import static kz.epam.azimkhan.text.logic.TextLogic.paragraphs;
import static kz.epam.azimkhan.text.logic.TextLogic.words;
import static kz.epam.azimkhan.text.logic.TextLogic.sentences;

import java.util.List;

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
            Text text2 = SentenceSorter.sortByWordNumber(text);
            write(text2,out);

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
