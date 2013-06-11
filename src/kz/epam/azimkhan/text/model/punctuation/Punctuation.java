package kz.epam.azimkhan.text.model.punctuation;

import kz.epam.azimkhan.text.model.character.*;
import kz.epam.azimkhan.text.model.sentence.SentenceElement;
import kz.epam.azimkhan.text.model.word.WordElement;

import java.util.regex.Pattern;

/**
 * Date: 07.06.13
 * Time: 1:26
 */
public class Punctuation extends SentenceElement{
    public static final char[] symbols = {'-','?','!','(',')','[',']','{','}','\"','\''};

    private static String regex = null;
    private char value;

    /**
     * Constructs a newly allocated {@code Letter} object that
     * represents the specified {@code char} value.
     *
     * @param value the value to be represented by the
     *              {@code Letter} object.
     */
    public Punctuation(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public static String regex(){
        if (null == regex){
            StringBuilder regex = new StringBuilder();
            for(int i =0; i < symbols.length-1; i++){
                regex.append("\\" + symbols[i] + "|");
            }

            regex.append("\\" + symbols[symbols.length-1]);

            Punctuation.regex = regex.toString();

        }

        return Punctuation.regex;

    }

    public String toString(){
        return String.valueOf(this.value);
    }

}
