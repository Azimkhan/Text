package kz.epam.azimkhan.text.model.sentence;

import java.util.List;

/**
 * Date: 12.06.13
 * Time: 13:27
 */
public interface SentenceProvider {
    public List<Sentence> sentences();
    public int sentenceCount();
}
