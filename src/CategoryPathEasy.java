import java.io.InputStream;

public enum CategoryPathEasy {
	COUNTRIES_PATH_EASY, CAPITALS_PATH_EASY, FEMALE_NAMES_PATH_EASY, MALE_NAMES_PATH_EASY, ANIMALS_PATH_EASY, PROGRAMMING_PATH_EASY, 
	ARTISTS_PATH_EASY, IT_PATH_EASY, EMPTY_NO_PATH_EASY;
	
	public String toString() {
		switch(this) {
			case COUNTRIES_PATH_EASY: 				return "/words/panstwa_easy.txt";
			case CAPITALS_PATH_EASY: 				return "/words/stolice_easy.txt";
			case FEMALE_NAMES_PATH_EASY: 			return "/words/imiona_zenskie_easy.txt";
			case MALE_NAMES_PATH_EASY: 				return "/words/imiona_meskie_easy.txt";
			case ANIMALS_PATH_EASY: 				return "/words/zwierzeta_easy.txt";
			case PROGRAMMING_PATH_EASY: 			return "/words/programowanie_easy.txt";
			case ARTISTS_PATH_EASY: 				return "/words/artysci_easy.txt";
			case IT_PATH_EASY: 						return "/words/IT_easy.txt";
			case EMPTY_NO_PATH_EASY:				return "/words/1.txt";
			default: 								return "/words/1.txt";
		}
	}
}