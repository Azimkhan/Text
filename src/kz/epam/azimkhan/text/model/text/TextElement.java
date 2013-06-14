package kz.epam.azimkhan.text.model.text;


/**
 * Text element
 */
public abstract class TextElement{

	/**
	 * Element length
	 * @return
	 */
    public abstract int length();
    
    /**
     * Get character on <i>index</i> position
     * @param index
     * @return
     */
    public abstract char getChar(int index);
}
