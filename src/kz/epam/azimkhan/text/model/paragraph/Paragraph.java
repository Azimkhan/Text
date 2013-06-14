package kz.epam.azimkhan.text.model.paragraph;

import kz.epam.azimkhan.text.model.text.TextElement;
import kz.epam.azimkhan.text.model.text.TextPart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Paragraph
 */
public final class Paragraph extends TextPart implements Cloneable, Serializable{
    private static final long serialVersionUID = 8408297251313588384L;
    private List<TextElement> elements;

    public Paragraph(){
        this.elements = new ArrayList<TextElement>();
    }

    public boolean add(TextElement element) {
        return elements.add(element);
    }

    /**
     * Paragraph length
     */
    public int length() {
    	int l = 0;
        for(TextElement e : elements){
        	l += e.length();
        }
        
        return l;
    }

    /**
     * Empty check
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        for (TextElement element : elements){
            builder.append(element);
        }

        return builder.toString();
    }

    /**
     * Equiality check
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paragraph paragraph = (Paragraph) o;

        if (elements != null ? !elements.equals(paragraph.elements) : paragraph.elements != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return elements != null ? elements.hashCode() : 0;
    }

    /**
     * Number of paragraph elements
     */
	@Override
	public int size() {
		return elements.size();
	}

	/**
	 * Get char at position
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
}
