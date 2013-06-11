package kz.epam.azimkhan.text.parser.element;

import kz.epam.azimkhan.text.model.TextElement;
import kz.epam.azimkhan.text.model.character.Letter;
import kz.epam.azimkhan.text.model.paragraph.Paragraph;
import kz.epam.azimkhan.text.model.punctuation.Punctuation;
import kz.epam.azimkhan.text.model.sentence.*;
import kz.epam.azimkhan.text.model.word.Word;
import kz.epam.azimkhan.text.parser.TextElementParser;
import kz.epam.azimkhan.text.parser.exception.TextParserException;

import java.io.*;
import java.util.Arrays;


/**
 * Paragraph (e. g. a block of text which begins with "// Paragraph" word) parser
 */
public class ParagraphParser extends TextElementParser {

    @Override
    public TextElement parse(String text) throws TextParserException, IOException {

        Paragraph p = new Paragraph();
        //TODO: parse title
        StringReader sr = new StringReader(text);

        Sentence sentence = new Sentence();
        Word word = new Word();

        int i = sr.read();
        while(i != -1){

            SentenceElement element = null;
            char c = (char) i;
            switch (c){
                case '\n':
                    element = new NewLine();
                    break;
                case '\t':
                    element = new Tabulation();
                    break;
                case ' ':
                    element = new Space();
                    break;
                case '.':
                    element = new Dot();
                    break;
                default:
                    if (Arrays.asList(Punctuation.symbols).contains(c)){
                        element = new Punctuation(c);
                        break;
                    }

            }

            if (element != null){
                if (!word.isEmpty()){
                    sentence.add(word);
                    word = new Word();
                }

                sentence.add(element);
                if (element.getClass().equals(NewLine.class) || element.getClass().equals(Dot.class)){
                    p.add(sentence);
                    sentence = new Sentence();
                }
            } else {
                word.add(new Letter(c));
            }

            i = sr.read();

        }

        if (!word.isEmpty()){
            sentence.add(word);
            p.add(sentence);
        }


        return p;
    }

    private Sentence parseTitle(String rawTitle){
        return new Sentence();
    }


}
