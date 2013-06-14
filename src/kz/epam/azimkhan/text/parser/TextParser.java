package kz.epam.azimkhan.text.parser;

import kz.epam.azimkhan.text.exception.TextParseException;
import kz.epam.azimkhan.text.exception.TextReadException;
import kz.epam.azimkhan.text.model.text.Text;
import kz.epam.azimkhan.text.model.listing.Listing;
import kz.epam.azimkhan.text.model.number.IntegerNumber;
import kz.epam.azimkhan.text.model.number.RealNumber;
import kz.epam.azimkhan.text.model.punctuation.Punctuation;
import kz.epam.azimkhan.text.model.word.Word;
import org.apache.log4j.Logger;
import static kz.epam.azimkhan.text.reader.TextReader.read;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Text parser
 */
public class TextParser {
    /**
     * Root logger
     */

    private Logger logger = Logger.getRootLogger();

    /**
     * Text parser instance
     */
    private static TextParser instance;


    /**
     * private constructor
     */
    private TextParser(){}

    /**
     * Returns the text parser instance
     * @return
     */
    public static synchronized TextParser getInstance(){
        if(instance == null){
            instance = new TextParser();
        }

        return instance;
    }


    /**
     * Creates the text object from file contents.
     * @return parsed text
     * @throws kz.epam.azimkhan.text.exception.TextParseException
     */
    public Text parse(String filename) throws TextParseException, TextReadException{

        Text text = new Text();
        String fileContent = read(filename);
        logger.info(String.format("File reading done. Got %d character(s).", fileContent.length()));

        Pattern pattern = Pattern.compile("(?<number>[1-9][0-9]*(?<floatpart>\\.[0-9]+)?)?(?<word>[\\wа-яёЁА-Я']+)?(?<punc>[\\W\\n\\r\\t])?(?<listing>#\\s*example(?:[\\w\\W]+?#\\s*end))?");
        Matcher matcher = pattern.matcher(fileContent);
        logger.info("Parsing the text...");

        while(matcher.find()){

            String word = matcher.group("word");
            String punctuation = matcher.group("punc");
            String listing = matcher.group("listing");
            String number = matcher.group("number");

            if (number != null){
            	
            	if(matcher.group("floatpart") == null){
            		text.add(new IntegerNumber(Integer.parseInt(number)));
            		
            	} else{
            		text.add(new RealNumber(Double.parseDouble(number)));
            	}
            }
            
            if (word != null){
                text.add(new Word(word.toCharArray()));
            }

            if (punctuation != null){
                text.add(new Punctuation(punctuation.charAt(0)));
            }

            if (listing != null){
                text.add(new Listing(listing));
            }


        }

        logger.info("Parsing complete.");
        return text;
    }

}
