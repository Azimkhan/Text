package kz.epam.azimkhan.text.model.word;

import kz.epam.azimkhan.text.model.sentence.SentenceElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 07.06.13
 * Time: 1:25
 */
public final class Word extends SentenceElement{
    private List<WordElement> elements = new ArrayList<WordElement>();

    public boolean add(WordElement WordElement) {
        return elements.add(WordElement);
    }


    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        for(WordElement element: elements){
            result.append(element.toChar());
        }

        return result.toString();
    }

}
