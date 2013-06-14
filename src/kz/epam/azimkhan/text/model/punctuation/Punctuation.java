package kz.epam.azimkhan.text.model.punctuation;

import kz.epam.azimkhan.text.model.text.TextElement;

import java.io.Serializable;

/**
 * Date: 07.06.13
 * Time: 1:26
 */
public final class Punctuation extends TextElement implements Cloneable, Serializable{

    private static final long serialVersionUID = 2497814412755288470L;
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

    @Override
    public String toString(){
        return String.valueOf(this.value);
    }

    @Override
    public int length() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ){
            return false;
        }

        if (o.getClass().equals(String.class)){
            String str = (String) o;
            if (str.length() == 1){
                return str.charAt(0) == value;
            }
        }

        if (o.getClass().equals(Character.class)){
            return o.equals(value);
        }

        if (o.getClass().equals(this.getClass())){
        Punctuation that = (Punctuation) o;

        if (value != that.value) return false;

        return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return (int) value;
    }

	@Override
	public char getChar(int index) {
		return value;
	}
}
