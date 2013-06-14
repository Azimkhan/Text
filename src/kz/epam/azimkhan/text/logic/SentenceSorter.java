package kz.epam.azimkhan.text.logic;

import kz.epam.azimkhan.text.comparator.SentenceWordNumberComparator;
import kz.epam.azimkhan.text.model.sentence.Sentence;
import kz.epam.azimkhan.text.model.text.Text;

import java.util.Collections;
import java.util.List;

/**
 * Performs sentence sort operations
 */
public class SentenceSorter {
	
	/**
	 * Sorts by number of words
	 * @param text
	 * @return
	 */
    public static List<Sentence> sortByWordNumber(Text text){
        List<Sentence> sentences = TextLogic.sentences(text);
        Collections.sort(sentences, new SentenceWordNumberComparator());

        return sentences;
    }
}
