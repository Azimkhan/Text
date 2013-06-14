package kz.epam.azimkhan.text.model.sentence;

import java.util.List;

/**
 * Sentence provider
 */
public interface SentenceProvider {
    public List<Sentence> sentences();
    public int sentenceCount();
}
