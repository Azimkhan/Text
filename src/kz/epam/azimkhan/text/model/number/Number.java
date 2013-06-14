package kz.epam.azimkhan.text.model.number;

import kz.epam.azimkhan.text.model.text.TextElement;

/**
 * Base nummber
 * @author azimkhan
 *
 */
public abstract class Number extends TextElement{
	
	/**
	 * Number length
	 */
	@Override
	public int length() {
		return toString().length();
	}

	/**
	 * Char at position
	 */
	@Override
	public char getChar(int index) {
		return toString().charAt(index);
	}

}
