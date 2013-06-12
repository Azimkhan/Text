package kz.epam.azimkhan.text.model.sentence;

import kz.epam.azimkhan.text.model.text.TextElement;
import kz.epam.azimkhan.text.model.word.Word;
import kz.epam.azimkhan.text.model.word.WordProvider;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Date: 07.06.13
 * Time: 1:22
 */
public class Sentence extends TextElement implements WordProvider{
    private List<TextElement> elements;

    private int wordCount = 0;


    public Sentence(){
        this.elements = new LinkedList<TextElement>();
    }

    /**
     * Number of elements
     * @return
     */
    public int size() {
        return elements.size();
    }

    /**
     * Add element
     * @param textElement
     * @return
     */
    public boolean add(TextElement textElement) {
        if (textElement.getClass().equals(Word.class)){
            wordCount++;
        }
        return elements.add(textElement);
    }


    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public List<Word> words() {
        ArrayList<Word> words = new ArrayList<Word>();
        for (TextElement element : elements){
            if (element.getClass().equals(Word.class)){
                words.add((Word) element);
            }
        }

        return words;
    }

    @Override
    public int wordCount() {
        return wordCount;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();

        for(TextElement element : elements){
            builder.append(element);
        }

        return builder.toString();
    }
}
