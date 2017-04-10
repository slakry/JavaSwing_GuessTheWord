

import java.util.Random;

public class WordMixer {
	
	public final static String mixOneWord(String word) {
		
		StringBuilder builderMixedWord = new StringBuilder();
		StringBuilder builderWord = new StringBuilder();
		builderWord.append(word);
		
		Random number = new Random();
		
		int posision;
		
		while(builderWord.length()!=0) {
			posision = number.nextInt(builderWord.length());
			builderMixedWord.append(builderWord.charAt(posision));	//dodaje 1 znak
			builderWord.deleteCharAt(posision);						//usuwa 1 znak
		}
		
		String completedMixedWord = builderMixedWord.toString();
		return completedMixedWord.toUpperCase();
	}
	
	public static String mixWords(String word) {
		StringBuilder builderWord = new StringBuilder();
		builderWord.append(word);
		StringBuilder builderMixedWord = new StringBuilder();
		
		int indexOfBlankChar = builderWord.indexOf(" ");
		String tempSubWord;
		String mixedSubWord;

		do {
			tempSubWord = builderWord.substring(0,indexOfBlankChar);
			mixedSubWord = mixOneWord(tempSubWord);
			builderMixedWord.append(mixedSubWord);
			builderMixedWord.append(" ");
			builderWord.delete(0, indexOfBlankChar+1);
			indexOfBlankChar = builderWord.indexOf(" ");
			
			if (indexOfBlankChar == -1) {
				tempSubWord = builderWord.toString();
				mixedSubWord = mixOneWord(tempSubWord);
				builderMixedWord.append(mixedSubWord);
			}
		} while (indexOfBlankChar >= 0);
		String mixedEndWord = builderMixedWord.toString();
		return mixedEndWord.toUpperCase();
	}
	
	public static String checkAndMixWord(String word) {
	
		int index = word.indexOf(' ');
			
		if (index == -1) {
			return mixOneWord(word);
		} else {
			return mixWords(word);
		}		
	}
}
