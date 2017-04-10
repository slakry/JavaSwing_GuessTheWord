
public enum Category {
	COUNTRIES, CAPITALS, FEMALE_NAMES, MALE_NAMES, ANIMALS, PROGRAMMING, 
	ARTISTS, IT, EMPTY;
	
	public String toString() {
		switch(this) {
			case COUNTRIES: 		return "Pañstwa";
			case CAPITALS: 			return "Stolice";
			case FEMALE_NAMES: 		return "¯eñskie imiona";
			case MALE_NAMES: 		return "Mêskie imiona";
			case ANIMALS: 			return "Zwierzêta";
			case PROGRAMMING: 		return "Programowanie";
			case ARTISTS: 			return "Artyœci";
			case IT: 				return "IT";
			case EMPTY:				return "Wybierz Kategoriê";
			default: 				return "Nieokreœlony";
		}
	}
}