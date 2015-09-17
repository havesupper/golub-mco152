package golub.morsecode;

public class MorseCode {

	public MorseCode() {

	}

	public String encode(String englishPhrase) {
		String encodedString = null;
		try {
			// converts parameter string to Upper Case bc enum type is UpperCase
			String english = englishPhrase.toUpperCase();
			String[] words = english.split(" ");// splits the phrase by words
			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < words[i].length(); j++) {
					// temp string of each character in string
					String temp = Character.toString(words[i].charAt(j));
					MorseCodeLanguage morse = MorseCodeLanguage.valueOf(temp);
					// if its the first word and first letter replace null value
					// else concatenate it
					if (i == 0 && j == 0) {
						encodedString = morse + ", ";
					} else {
						encodedString += morse + ", ";
					}
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Unable to convert input.");
		}
		return encodedString;
	}

	public String decode(String morseCode) {
		String decodedString = null;
		String[] words = morseCode.split("   ");
		// loop through each word of morse code
		for (int i = 0; i < words.length; i++) {
			String[] letters = words[i].split(" ");
			// loop through each letter of each word
			for (int j = 0; j < letters.length; j++) {
				for (MorseCodeLanguage morses : MorseCodeLanguage.values()) {
					if (morses.getMorseCode().equals(letters[j])) {
						// if its the first word and first letter replace null
						// value
						if (i == 0 && j == 0) {
							decodedString = morses.name();
						} else {
							decodedString += morses.name();
						}
					}
				}
			}
		}
		return decodedString;
	}

}
