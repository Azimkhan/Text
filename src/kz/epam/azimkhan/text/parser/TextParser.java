package kz.epam.azimkhan.text.parser;

import kz.epam.azimkhan.text.model.Text;
import kz.epam.azimkhan.text.parser.element.ListingParser;
import kz.epam.azimkhan.text.parser.element.ParagraphParser;
import kz.epam.azimkhan.text.parser.exception.TextParserException;
import kz.epam.azimkhan.text.parser.exception.UndefinedElementException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
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

    /**
     * List of text element parsers
     */
    private Set<TextElementParser> elementParsers = new HashSet<TextElementParser>();

    {
        this.elementParsers.add(new ParagraphParser());
        this.elementParsers.add(new ListingParser());
    }

    /**
     * Constructor
     * @param file a file to read from
     */
    public TextParser(File file){
        this.file = file;
    }

    /**
     *
     * @return parsed text
     * @throws TextParserException
     */
    public Text parse() throws TextParserException{

        Text text = new Text();
        FileReader fr = null;
        BufferedReader br = null;

        try{
            fr = new FileReader(this.file);
            br = new BufferedReader(fr);
            String buffer;
            Pattern blockStart = Pattern.compile("\\/\\/\\s*(?<name>[a-zA-Z0-9]+)\\s*(?:\\s+(?<params>.*))?");
            Matcher matcher = null;
            buffer = br.readLine();


            while(buffer != null){

                matcher = blockStart.matcher(buffer);
                if (matcher.matches()){
                    String elementName = matcher.group("name");
                    String rawParams = matcher.group("params");

                    TextElementParser elementParser = this.getParser(elementName);

                    if (rawParams != null){
                        elementParser.setRawParams(rawParams);
                    }

                    buffer = br.readLine();
                    StringBuilder rawText = new StringBuilder();

                    // while have something to parse
                    while (buffer != null){
                        // is it a start of new block?
                        if (buffer.length() > 1 ){
                            // yes
                            if (!"//".equals(buffer.substring(0,2))){

                                rawText.append(buffer + "\n");
                            } else {
                                break;
                            }
                        } else{
                            // append chars from the buffer while new block isn't reached
                            rawText.append(buffer);
                        }

                        // read next line
                        buffer = br.readLine();
                    }
                    // Add element to text
                    text.add(elementParser.parse(rawText.toString()));


                } else {
                    throw new TextParserException("Malformed block start");
                }

            }


        } catch (IOException e){
            //TODO: logging

        }  finally {
            try{
                br.close();

            }catch (IOException e){
                //TODO: logging
            }
        }

        return text;
    }

    public TextElementParser getParser(String elementName) throws  UndefinedElementException{
        for(TextElementParser tep : elementParsers){
            if (tep.canParse(elementName)){
                return tep;
            }
        }

        throw  new UndefinedElementException(elementName);
    }
}
