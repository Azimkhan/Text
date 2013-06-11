package kz.epam.azimkhan.text.model.word;

import kz.epam.azimkhan.text.model.TextElement;
import kz.epam.azimkhan.text.model.sentence.SentenceElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 07.06.13
 * Time: 1:25
 */
public final class Word extends TextElement{
    private List<Character> characters;

    public Word(){
        characters = new ArrayList<Character>();
    }

    public Word(char[] chars){
        this();
        if (null != chars){
            for(int i = 0; i < chars.length; i++){
                characters.add(chars[i]);
            }
        }
    }

    public boolean isEmpty() {
        return characters.isEmpty();
    }

    @Override
    public int size() {
        return characters.size();
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        for(Character c: characters){
            result.append(c);
        }

        return result.toString();
    }

}
