package kz.epam.azimkhan.text.model.listing;

import kz.epam.azimkhan.text.model.text.TextElement;

import java.io.Serializable;

/**
 * Listing
 */
public final class Listing extends TextElement implements Cloneable, Serializable{

    private static final long serialVersionUID = 8499863574717651751L;
    /**
     * Listing content
     */
    private String content;

    public Listing(String content){
        this.content = content;
    }
    
    /**
     * Listing code
     * @return the code
     */
    public String getContent() {
        return content;
    }

    
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
 
    /**
     * Listing length
     */
    @Override
    public int length() {
        return (content != null) ? content.length() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Listing listing = (Listing) o;

        if (content != null ? !content.equals(listing.content) : listing.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }
    
    /**
     * Get character at position
     */
	@Override
	public char getChar(int index) {
		return content.charAt(index);
	}
}
