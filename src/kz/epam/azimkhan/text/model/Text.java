package kz.epam.azimkhan.text.model;

import java.util.LinkedList;

/**
 * //TODO: ?
 */
public class Text {
    private LinkedList<TextElement> elements = new LinkedList<TextElement>();

    public void addFirst(TextElement textElement) {
        elements.addFirst(textElement);
    }

    public boolean add(TextElement textElement) {
        return elements.add(textElement);
    }

    public void addLast(TextElement textElement) {
        elements.addLast(textElement);
    }

    public boolean contains(Object o) {
        return elements.contains(o);
    }

    public int size() {
        return elements.size();
    }

    // TODO getWords
    // TODO wordCount
    // TODO getSentences
    // TODO sentenceCount
    // TODO getLetters
    // TODO letterCount

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(TextElement element:elements) {
            result.append(element);
        }

        return  result.toString();

    }
}
