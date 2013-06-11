package kz.epam.azimkhan.text.model;

import kz.epam.azimkhan.text.model.word.Word;

import java.util.List;

/**
 * Date: 07.06.13
 * Time: 1:21
 */
public abstract class TextElement {
    public abstract List<Word> getWords();
}
