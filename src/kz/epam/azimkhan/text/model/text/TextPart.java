package kz.epam.azimkhan.text.model.text;

/**
 * Date: 12.06.13
 * Time: 14:09
 */
public abstract class TextPart extends TextElement{

	/**
	 * 
	 * @return size of a text part
	 */
	public abstract int size();
    public abstract boolean isEmpty();
    public abstract boolean add(TextElement element);
}
