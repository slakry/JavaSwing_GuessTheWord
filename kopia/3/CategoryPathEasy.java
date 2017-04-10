public enum CategoryPathEasy {
	COUNTRIES_PATH_EASY, CAPITALS_PATH_EASY, FEMALE_NAMES_PATH_EASY, MALE_NAMES_PATH_EASY, ANIMALS_PATH_EASY, PROGRAMMING_PATH_EASY, 
	ARTISTS_PATH_EASY, IT_PATH_EASY, EMPTY_NO_PATH_EASY;
	
	public String toString() {
		switch(this) {
			case COUNTRIES_PATH_EASY: 				return "words\\easy\\panstwa_easy.txt";
			case CAPITALS_PATH_EASY: 				return "words\\easy\\stolice_easy.txt";
			case FEMALE_NAMES_PATH_EASY: 			return "words\\easy\\imiona_zenskie_easy.txt";
			case MALE_NAMES_PATH_EASY: 				return "words\\easy\\imiona_meskie_easy.txt";
			case ANIMALS_PATH_EASY: 				return "words\\easy\\zwierzeta_easy.txt";
			case PROGRAMMING_PATH_EASY: 			return "words\\easy\\programowanie_easy.txt";
			case ARTISTS_PATH_EASY: 				return "words\\easy\\artysci_easy.txt";
			case IT_PATH_EASY: 						return "words\\easy\\IT_easy.txt";
			case EMPTY_NO_PATH_EASY:				return "words\\1.txt";
			default: 								return "words\\1.txt";
		}
	}
}