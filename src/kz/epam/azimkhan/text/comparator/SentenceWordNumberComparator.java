package kz.epam.azimkhan.text.comparator;

import kz.epam.azimkhan.text.model.sentence.Sentence;

import java.util.Comparator;

/**
 * Sentence comparator
 */
public class SentenceWordNumberComparator implements Comparator<Sentence> {

    @Override
    public int compare(Sentence o1, Sentence o2) {
        if (o1.wordCount() < o2.wordCount()){
            return -1;
        } else if (o1.wordCount() > o2.wordCount()){
            return 1;
        }

        return 0;
    }
}
