package kz.epam.azimkhan.text.model.listing;

import kz.epam.azimkhan.text.model.TextElement;
import kz.epam.azimkhan.text.model.word.Word;

/**
 * Date: 07.06.13
 * Time: 11:58
 */
public class Listing extends TextElement {

    // TODO: replace
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        //TODO ПЕРЕДЕЛАТЬ
        StringBuilder result = new StringBuilder();
        result.append("//Listing\n");
        result.append(content+ "\n");
        return result.toString();
    }
}
