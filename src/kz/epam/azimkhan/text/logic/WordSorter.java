package kz.epam.azimkhan.text.logic;

import java.util.Collections;
import java.util.List;

import kz.epam.azimkhan.text.comparator.VowelRatioComparator;
import kz.epam.azimkhan.text.model.text.Text;
import kz.epam.azimkhan.text.model.word.Word;

/**
 * Performs word sort operations
 *
 */
public class WordSorter {
	
	/**
	 * Sorts the list depending on vowel ratio of words in ascending order
	 * Formula: (number of vowels / number of characters) in the word
	 * Example: 
	 * 		the word 'sentence' has the ratio of (3/8)=0.375, 
	 * 		whereas the word 'Java' has the ratio of (2/4) = 0.5
	 * 
	 * @param text
	 * @return
	 */
	public static List<Word> sortByVowelRatio(Text text){
		
		List<Word> words = TextLogic.words(text);
		
		Collections.sort(words, new VowelRatioComparator());
		
		return words;
	}

}
