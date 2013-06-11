package kz.epam.azimkhan.text.parser;

import kz.epam.azimkhan.text.exception.TextParseException;
import kz.epam.azimkhan.text.exception.TextReadException;
import kz.epam.azimkhan.text.model.Text;
import kz.epam.azimkhan.text.model.listing.Listing;
import kz.epam.azimkhan.text.model.punctuation.Punctuation;
import kz.epam.azimkhan.text.model.word.Word;

import static kz.epam.azimkhan.text.reader.TextReader.read;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Text parser
 */
public class TextParser {

    /**
     * A file containing the text
     */
    private File file;

    private static TextParser instance;


    /**
     * Singleton
     */
    private TextParser(){

    }

    public static TextParser getInstance(){
        if(instance == null){
            instance = new TextParser();
        }

        return instance;
    }


    /**
     *
     * @return parsed text
     * @throws kz.epam.azimkhan.text.exception.TextParseException
     */
    public Text parse(String filename) throws TextParseException, TextReadException{

        Text text = new Text();
        String fileContent = read(filename);
        Pattern pattern = Pattern.compile("(?<word>[\\wа-яёЁА-Я']+)?(?<punc>[\\W\\n\\r\\t])?(?<listing>#\\s*example(?:[\\w\\W]+?#\\s*end))?");
        Matcher matcher = pattern.matcher(fileContent);

        while(matcher.find()){

            String word = matcher.group("word");
            String punctuation = matcher.group("punc");
            String listing = matcher.group("listing");

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
        return text;
    }

}
