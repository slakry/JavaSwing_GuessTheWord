public enum CategoryPath {
	COUNTRIES_PATH, CAPITALS_PATH, CHRISTIANITY_PATH, MUSIC_PATH, ANIMALS_PATH, PROGRAMMING_PATH, 
	DJS_PRODUCENTS_PATH, VARIUOS_PATH, NAMES_PATH, POLISH_SURNAMES_PATH, EMPTY_NO_PATH;
	
	public String toString() {
		switch(this) {
			case COUNTRIES_PATH: 			return "words\\panstwa.txt";
			case CAPITALS_PATH: 			return "words\\stolice.txt";
			case CHRISTIANITY_PATH: 		return "words\\chrzescijanstwo.txt";
			case MUSIC_PATH: 				return "words\\muzyka.txt";
			case ANIMALS_PATH: 				return "words\\zwierzeta.txt";
			case PROGRAMMING_PATH: 			return "words\\programowanie.txt";
			case DJS_PRODUCENTS_PATH: 		return "words\\djs_producenci.txt";
			case VARIUOS_PATH: 				return "words\\rozne.txt";
			case NAMES_PATH:				return "words\\imiona.txt";
			case POLISH_SURNAMES_PATH: 		return "words\\polskie_nazwiska.txt";
			case EMPTY_NO_PATH:				return "words\\1.txt";
			default: 						return "words\\pusty.txt";
		}
	}
}