package kz.epam.azimkhan.text.model.text;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Text
 */
public class Text implements Cloneable,Serializable{

    private static final long serialVersionUID = 9111622295266602254L;

    private LinkedList<TextElement> elements;

    public Text(){
        elements = new LinkedList<TextElement>();
    }

    public void addFirst(TextElement textElement) {
        elements.addFirst(textElement);
    }

    public boolean add(TextElement textElement) {
        return elements.add(textElement);
    }

    public void addLast(TextElement textElement) {
        elements.addLast(textElement);
    }

    /**
     * Check if object is in text
     * @param o
     * @return
     */
    public boolean contains(Object o) {
        return elements.contains(o);
    }

    /**
     * Number of text elements
     * @return
     */
    public int size() {
        return elements.size();
    }

    /**
     * 
     * @return iterator
     */
    public Iterator<TextElement> iterator() {
        return elements.iterator();
    }
    
    public int length() {
    	int l = 0;
        for(TextElement e : elements){
        	l += e.length();
        }
        
        return l;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(TextElement element:elements) {
            result.append(element);
        }

        return  result.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text = (Text) o;

        if (elements != null ? !elements.equals(text.elements) : text.elements != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return elements != null ? elements.hashCode() : 0;
    }
}
