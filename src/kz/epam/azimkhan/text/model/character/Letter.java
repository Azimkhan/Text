package kz.epam.azimkhan.text.model.character;

import kz.epam.azimkhan.text.model.word.WordElement;

/**
 * Date: 07.06.13
 * Time: 1:27
 */
public class Letter extends WordElement {
    private char value;

    public Letter(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public char toChar() {
        return value;
    }
}
