package kz.epam.azimkhan.text.logic;

import kz.epam.azimkhan.text.model.listing.Listing;
import kz.epam.azimkhan.text.model.paragraph.Paragraph;
import kz.epam.azimkhan.text.model.punctuation.Punctuation;
import kz.epam.azimkhan.text.model.sentence.Sentence;
import kz.epam.azimkhan.text.model.text.Text;
import kz.epam.azimkhan.text.model.text.TextElement;
import kz.epam.azimkhan.text.model.word.Word;

import java.util.*;

/**
 * Text logic
 */
public class TextLogic {

    /**
     * Retrieves all words from the given text
     * @param text
     * @return
     */
    public static List<Word> words(Text text){
        Iterator<TextElement> iterator = text.iterator();
        ArrayList<Word> words = new ArrayList<Word>();
        TextElement element = null;

        while (iterator.hasNext()){
            element = iterator.next();
            if (element.getClass().equals(Word.class)){
                words.add((Word)element);
            }
        }

        return words;
    }


    /**
     * Get all characters
     * @param text
     * @return
     */
    public static List<Character> characters(Text text){
        ArrayList<Character> characters = new ArrayList<Character>();
        Iterator<TextElement> iterator = text.iterator();
        TextElement element = null;

        while (iterator.hasNext()){
            element = iterator.next();
            char[] chars = element.toString().toCharArray();
            for(int i = 0; i < chars.length; i++){
                characters.add(chars[i]);
            }
        }

        return characters;
    }

    /**
     * Search for the sentences
     * @param text
     * @return
     */
    public static List<Sentence> sentences(Text text){
        ArrayList<Sentence> sentences = new ArrayList<Sentence>();

        for (TextElement element : formSentences(text)){
            if (element.getClass().equals(Sentence.class)){
                sentences.add((Sentence) element);
            }
        }
        return sentences;
    }

    /**
     * Search for the paragraphs
     * @param text
     * @return
     */
    public static List<Paragraph> paragraphs(Text text){

        ArrayList<Paragraph> paragraphs = new ArrayList<Paragraph>();
        Paragraph p = new Paragraph();
        for (TextElement element : formSentences(text)){
                if (!element.equals('\n')){
                    p.add(element);
                } else {
                    if (!p.isEmpty()) {
                        paragraphs.add(p);
                        p = new Paragraph();
                    }
                }

        }

        if (!p.isEmpty()) {
            paragraphs.add(p);
            p = new Paragraph();
        }

        return paragraphs;
    }

    /**
     * Form sentences where it's possible
     * @param text
     * @return
     */
    private static List<TextElement> formSentences(Text text){

        ArrayList<TextElement> elements = new ArrayList<TextElement>();
        Sentence sentence = new Sentence();
        TextElement element = null;

        Iterator<TextElement> iterator = text.iterator();

        while (iterator.hasNext()){
            element = iterator.next();
            Class<? extends TextElement> elementClass = element.getClass();
            if (elementClass.equals(Punctuation.class)){
                if (sentence.wordCount() > 0){
                    if (element.equals('!') || element.equals('.') || element.equals('?')){
                        sentence.add(element);
                        elements.add(sentence);
                        sentence = new Sentence();
                    } else if (!element.equals('\n')){
                        sentence.add(element);
                    }
                } else {

                    if (!sentence.isEmpty()){
                        elements.add(sentence);
                        sentence = new Sentence();
                    }
                    elements.add(element);
                }

            } else if (!elementClass.equals(Listing.class)){
                sentence.add(element);
            }

        }

        if (!sentence.isEmpty()){
            elements.add(sentence);
        }

        return elements;
    }

    /**
     * Search for the listings
     * @param text
     * @return
     */
    public static List<Listing> listings(Text text){
        Iterator<TextElement> iterator = text.iterator();
        ArrayList<Listing> listings = new ArrayList<Listing>();
        TextElement element = null;

        while (iterator.hasNext()){
            element = iterator.next();
            if (element.getClass().equals(Listing.class)){
                listings.add((Listing)element);
            }
        }

        return listings;
    }

    /**
     * Counts the number of characters
     * @param text
     * @return
     */
    public int characterCount(Text text){
        return text.toString().length();
    }
    /**
     * Counts the number of words
     * @param text
     * @return
     */
    public int wordCount(Text text) {
        return words(text).size();
    }

    /**
     * Counts the number of sentences
     * @param text
     * @return
     */
    public int sentenceCount(Text text) {
        return sentences(text).size();
    }

    /**
     * Counts the number of listings
     * @param text
     * @return
     */
    public int listingCount(Text text){
        return listings(text).size();
    }
}
