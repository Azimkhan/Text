package kz.epam.azimkhan.text.model.paragraph;

import kz.epam.azimkhan.text.model.text.TextElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 07.06.13
 * Time: 1:22
 */
public class Paragraph{
    private List<TextElement> elements;

    public Paragraph(){
        this.elements = new ArrayList<TextElement>();
    }

    public boolean add(TextElement element) {
        return elements.add(element);
    }

    public int size() {
        return elements.size();
    }

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
}
