package kz.epam.azimkhan.text.parser.element;

import kz.epam.azimkhan.text.model.listing.Listing;
import kz.epam.azimkhan.text.model.TextElement;
import kz.epam.azimkhan.text.model.word.Word;
import kz.epam.azimkhan.text.parser.TextElementParser;
import kz.epam.azimkhan.text.parser.exception.TextParserException;

import java.io.IOException;

/**
 * Paragraph (e. g. a block of text which begins with "// Paragraph" word) parser
 */
public class ListingParser extends TextElementParser {

    @Override
    public TextElement parse(String text) throws TextParserException, IOException {
        Listing listing = new Listing();
        //TODO: parse listing
        listing.setContent(text);
        return listing;
    }
}
