public enum CategoryPathHard {
	COUNTRIES_PATH_HARD, CAPITALS_PATH_HARD, FEMALE_NAMES_PATH_HARD, MALE_NAMES_PATH_HARD, ANIMALS_PATH_HARD, PROGRAMMING_PATH_HARD, 
	ARTISTS_PATH_HARD, IT_PATH_HARD, EMPTY_NO_PATH_HARD;
	
	public String toString() {
		switch(this) {
			case COUNTRIES_PATH_HARD: 				return "words\\hard\\panstwa_hard.txt";
			case CAPITALS_PATH_HARD: 				return "words\\hard\\stolice_hard.txt";
			case FEMALE_NAMES_PATH_HARD: 			return "words\\hard\\imiona_zenskie_hard.txt";
			case MALE_NAMES_PATH_HARD: 				return "words\\hard\\imiona_meskie_hard.txt";
			case ANIMALS_PATH_HARD: 				return "words\\hard\\zwierzeta_hard.txt";
			case PROGRAMMING_PATH_HARD: 			return "words\\hard\\programowanie_hard.txt";
			case ARTISTS_PATH_HARD: 				return "words\\hard\\artysci_hard.txt";
			case IT_PATH_HARD: 						return "words\\hard\\IT_hard.txt";
			case EMPTY_NO_PATH_HARD:				return "words\\1.txt";
			default: 								return "words\\1.txt";
		}
	}
}
