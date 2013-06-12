package kz.epam.azimkhan.text.logic;

import kz.epam.azimkhan.text.comparator.SentenceWordNumberComparator;
import kz.epam.azimkhan.text.model.sentence.Sentence;
import kz.epam.azimkhan.text.model.text.Text;
import kz.epam.azimkhan.text.model.text.TextElement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Performs sentence sort operations
 */
public class SentenceSorter {
    public static Text sortByWordNumber(Text text){
        List<Sentence> sentences = TextLogic.sentences(text);
        Iterator<Sentence> iterator = sentences.iterator();
        Collections.sort(sentences, new SentenceWordNumberComparator());

        Text text2 = new Text();

        for(TextElement sentence : sentences){
            text2.add(sentence);
        }

        return text2;
    }
}
