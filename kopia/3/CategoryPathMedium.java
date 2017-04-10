public enum CategoryPathMedium {
	COUNTRIES_PATH_MEDIUM, CAPITALS_PATH_MEDIUM, FEMALE_NAMES_PATH_MEDIUM, MALE_NAMES_PATH_MEDIUM, ANIMALS_PATH_MEDIUM, PROGRAMMING_PATH_MEDIUM, 
	ARTISTS_PATH_MEDIUM, IT_PATH_MEDIUM, EMPTY_NO_PATH_MEDIUM;
	
	public String toString() {
		switch(this) {
			case COUNTRIES_PATH_MEDIUM: 				return "words\\medium\\panstwa_medium.txt";
			case CAPITALS_PATH_MEDIUM: 					return "words\\medium\\stolice_medium.txt";
			case FEMALE_NAMES_PATH_MEDIUM: 				return "words\\medium\\imiona_zenskie_medium.txt";
			case MALE_NAMES_PATH_MEDIUM: 				return "words\\medium\\imiona_meskie_medium.txt";
			case ANIMALS_PATH_MEDIUM: 					return "words\\medium\\zwierzeta_medium.txt";
			case PROGRAMMING_PATH_MEDIUM: 				return "words\\medium\\programowanie_medium.txt";
			case ARTISTS_PATH_MEDIUM: 					return "words\\medium\\artysci_medium.txt";
			case IT_PATH_MEDIUM: 						return "words\\medium\\IT_medium.txt";
			case EMPTY_NO_PATH_MEDIUM:					return "words\\1.txt";
			default: 									return "words\\1.txt";
		}
	}
}