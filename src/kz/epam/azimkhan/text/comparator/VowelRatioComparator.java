package kz.epam.azimkhan.text.comparator;

import java.util.Comparator;
import java.util.HashSet;
import kz.epam.azimkhan.text.model.word.Word;

/**
 * Vowel ratio comparator
 */
public class VowelRatioComparator implements Comparator<Word>{
	
	private static HashSet<Character> vowelSet = new HashSet<>();
	{
		char[] vowels = {'a','o','i','e','u',
				'A','O','I','E','U',
			'а','у','э','я','е','ё','и','о','ы','ю',
			'А','У','Э','Я','Е','Ё','И','О','Ы','Ю'};
	
		for(char c: vowels){
			vowelSet.add(c);
		}
		
	}

	/**
	 * Comparison
	 */
	@Override
	public int compare(Word o1, Word o2) {
	
		double ratio1 = ratio(o1);
		double ratio2 = ratio(o2);
		
		if (ratio1 > ratio2){
			return 1;
		} else if(ratio2 > ratio1){
			return -1;
		}
		
		return 0;
	}
	
	/**
	 * Calculates vowel ratio, e.g. (vowel count / character count)
	 * @param word
	 * @return ratio
	 */
	private double ratio(Word word){
		
		
		int size = word.length();
		int found = 0;
		
		for(int i = 0; i < size; i++){
			if (vowelSet.contains(word.getChar(i))){
				found++;
			}
		}
		
		return (double) found/size;
	}
	
	

}
