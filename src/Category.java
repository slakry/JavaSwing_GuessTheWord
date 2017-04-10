
public enum Category {
	COUNTRIES, CAPITALS, FEMALE_NAMES, MALE_NAMES, ANIMALS, PROGRAMMING, 
	ARTISTS, IT, EMPTY;
	
	public String toString() {
		switch(this) {
			case COUNTRIES: 		return "Pa�stwa";
			case CAPITALS: 			return "Stolice";
			case FEMALE_NAMES: 		return "�e�skie imiona";
			case MALE_NAMES: 		return "M�skie imiona";
			case ANIMALS: 			return "Zwierz�ta";
			case PROGRAMMING: 		return "Programowanie";
			case ARTISTS: 			return "Arty�ci";
			case IT: 				return "IT";
			case EMPTY:				return "Wybierz Kategori�";
			default: 				return "Nieokre�lony";
		}
	}
}