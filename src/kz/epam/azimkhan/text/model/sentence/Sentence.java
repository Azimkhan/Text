package kz.epam.azimkhan.text.model.sentence;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 07.06.13
 * Time: 1:22
 */
public class Sentence {
    private List<SentenceElement> elements = new ArrayList<SentenceElement>();

    public boolean add(SentenceElement sentenceElement) {
        return elements.add(sentenceElement);
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
        for(SentenceElement element:elements) {
            result.append(element);
        }

        return  result.toString();

    }
}
