package kz.epam.azimkhan.text.model.word;

import kz.epam.azimkhan.text.model.text.TextElement;

import java.util.LinkedList;
import java.util.List;

/**
 * Word
 */
public final class Word extends TextElement{
    private List<Character> characters;

    public Word(){
        characters = new LinkedList<Character>();
    }

    /**
     * Construct form string
     * @param str
     */
    public Word(String str){
        this();
        if (str != null){
        for(int i = 0; i<str.length(); i++){
            characters.add(str.charAt(i));
        } }
    }

    /**
     * Construct form single character
     * @param c
     */
    public Word(char c){
        this();
        characters.add(c);
    }
    
    /**
     * Construct from array of characters
     * @param chars
     */
    public Word(char[] chars){
        this();
        if (null != chars){
            for(int i = 0; i < chars.length; i++){
                characters.add(chars[i]);
            }
        }
    }
    
    /**
     * Empty check
     * @return
     */
    public boolean isEmpty() {
        return characters.isEmpty();
    }

    @Override
    public String toString(){
        char[] chars = new char[characters.size()];
        for (int i = 0; i < characters.size(); i++){
            chars[i] = characters.get(i);
        }

        return new String(chars);
    }

    /**
     * Word length;
     */
    @Override
    public int length() {
        return characters.size();
    }

    /**
     * Char at position
     */
    public char getChar(int index){
    	return characters.get(index);
    }

    /**
     * Equality check
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null){
            return false;
        }

        String str = this.toString();

        if(str.length() == 1 && o.getClass().equals(Character.class)){
            return ((Character) o).equals(new Character(str.charAt(0)));
        }

        if (o.getClass().equals(String.class)){
            String other = (String) o;
            return str.equals(other);
        }

        if (o.getClass().equals(this.getClass())){
            Word word = (Word) o;

            if (!characters.equals(word.characters)) return false;

            return true;
        }
        return false;
    }

    
    @Override
    public int hashCode() {
        return characters.hashCode();
    }
}
