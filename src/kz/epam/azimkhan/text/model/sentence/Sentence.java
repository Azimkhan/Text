package kz.epam.azimkhan.text.model.sentence;

import kz.epam.azimkhan.text.model.text.TextElement;
import kz.epam.azimkhan.text.model.text.TextPart;
import kz.epam.azimkhan.text.model.word.Word;
import kz.epam.azimkhan.text.model.word.WordProvider;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Sentence
 */
public final class Sentence extends TextPart implements Cloneable, Serializable, WordProvider{
    private static final long serialVersionUID = 2324319152735166325L;

    private List<TextElement> elements;

    private int wordCount = 0;


    public Sentence(){
        this.elements = new LinkedList<TextElement>();
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

    /**
     * Equality check
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence = (Sentence) o;

        if (wordCount != sentence.wordCount) return false;
        if (elements != null ? !elements.equals(sentence.elements) : sentence.elements != null) return false;

        return true;
    }

    /**
     * Char at position
     */
    @Override
	public char getChar(int index) {
    	int length = 0; int last = 0;
    	
        for(TextElement e : elements){
        	length += e.length();
        	if (index < length){
        		return e.getChar(index - last);
        	}
        	
        	last = length;
        }
        
        TextElement e = elements.get(elements.size()-1);
        return e.getChar(e.length()-1);
	}

    @Override
    public int hashCode() {
        int result = elements != null ? elements.hashCode() : 0;
        result = 31 * result + wordCount;
        return result;
    }

    /**
     * Empty check
     * @return
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    
    /**
     * Number of elements
     * @return
     */
    public int length() {
    	int l = 0;
        for(TextElement e : elements){
        	l += e.length();
        }
        
        return l;
    }

    /**
     * Number of elements
     */
	@Override
	public int size() {
		return elements.size();
	}

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        for(TextElement element : elements){
            builder.append(element);
        }

        return builder.toString();
    }
    
    /**
     * Number of words in sentence
     */
    @Override
    public int wordCount() {
        return wordCount;
    }

    /**
     * List of words
     */
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
}
