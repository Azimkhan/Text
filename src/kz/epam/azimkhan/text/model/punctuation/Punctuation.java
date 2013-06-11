package kz.epam.azimkhan.text.model.punctuation;

import kz.epam.azimkhan.text.model.TextElement;
import kz.epam.azimkhan.text.model.sentence.SentenceElement;

/**
 * Date: 07.06.13
 * Time: 1:26
 */
public class Punctuation extends TextElement{

    private char value;

    public Punctuation(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public String toString(){
        return String.valueOf(this.value);
    }

    @Override
    public int size() {
        return 1;
    }
}
