package kz.epam.azimkhan.text.model.listing;

import kz.epam.azimkhan.text.model.TextElement;
import kz.epam.azimkhan.text.model.word.Word;

import java.util.List;

/**
 * Date: 07.06.13
 * Time: 11:58
 */
public final class Listing extends TextElement {

    /**
     * Listing content
     */
    private String content;

    /**
     * Default constructor
     */
    public Listing(){}

    public Listing(String content){
        this.content = content;
    }
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

    @Override
    public int size() {
        return (content != null) ? content.length() : 0;
    }
}
