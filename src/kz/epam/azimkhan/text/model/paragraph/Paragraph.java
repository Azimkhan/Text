package kz.epam.azimkhan.text.model.paragraph;

import kz.epam.azimkhan.text.model.TextElement;
import kz.epam.azimkhan.text.model.word.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 07.06.13
 * Time: 1:22
 */
public class Paragraph extends TextElement {
    private List<TextElement> elements = new ArrayList<TextElement>();

    public boolean add(TextElement TextElement) {
        return elements.add(TextElement);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("//Paragraph\n");
        for(TextElement element : elements){
            result.append(element.toString());
        }
        result.append("\n");
        return result.toString();
    }

    @Override
    public int size() {
        return 0; //TODO !!!
    }
}
