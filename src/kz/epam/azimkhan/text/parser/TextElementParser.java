package kz.epam.azimkhan.text.parser;

import kz.epam.azimkhan.text.model.TextElement;
import kz.epam.azimkhan.text.parser.exception.TextParserException;

import java.io.IOException;

/**
 * Basic text element parser
 */
public abstract class TextElementParser {

    /**
     * "raw" parameters, e.g. the string following after "// ELEMENT" statement
     * Example: //Paragraph "Java regular expressions"
     */
    private String rawParams;

    /**
     * Parses the text into text element object
     * @return parsed text element
     */
    public abstract TextElement parse(String text) throws TextParserException, IOException;

    public String getRawParams() {
        return rawParams;
    }

    public void setRawParams(String rawParams) {
        this.rawParams = rawParams;
    }

    /**
     * Check if this parser can create required element from a piece of text
     * @param elementName element name
     * @return true if the unit can parse the element
     */
    public boolean canParse(String elementName){
        String className = this.getClass().getSimpleName();
        int length = className.length();

        return elementName.equals(className.substring(0,length-6));
    }
}
