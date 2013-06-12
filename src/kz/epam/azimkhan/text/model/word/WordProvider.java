package kz.epam.azimkhan.text.model.word;

import java.util.List;

/**
 * Date: 12.06.13
 * Time: 2:35
 */
public interface WordProvider {
    public List<Word> words();
    public int wordCount();
}
