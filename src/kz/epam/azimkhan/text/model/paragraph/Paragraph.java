package kz.epam.azimkhan.text.model.paragraph;

import kz.epam.azimkhan.text.model.TextElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 07.06.13
 * Time: 1:22
 */
public class Paragraph extends TextElement {
    private List<ParagraphElement> elements = new ArrayList<ParagraphElement>();

    public boolean add(ParagraphElement paragraphElement) {
        return elements.add(paragraphElement);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("//Paragraph\n");
        for(ParagraphElement element : elements){
            result.append(element.toString());
        }
        result.append("\n");
        return result.toString();
    }
}
