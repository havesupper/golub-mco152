package golub.morsecode;

import java.util.HashMap;

public class MorseCode {
	private HashMap<Character, String> toMorse;
	private HashMap<String, Character> toEnglish;

	public MorseCode() {
		char[] letters = new char[]{
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
				'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
				'Y', 'Z'
		};
		String[] code = new String[]{
				".-", "-...", "-.-.", "-..", ".", "..-.", "--.", 
				"....", "..", ".---", "-.-", ".-..", "--", "-.", 
				"---", ".--.", "--.-", ".-.", "...", "-", "..-", 
				"...-", ".--", "-..-", "-.--", "--.."
		};
		this.toMorse = new HashMap<Character, String>();
		this.toEnglish = new HashMap<String, Character>();
		//fill the hash map
		for (int i = 0; i < 26; i++){
			toMorse.put(letters[i], code[i]);
			toEnglish.put(code[i], letters[i]);
		}
		

	}

	public String encode(String english) {
		String englishPhrase = english.toUpperCase();
		StringBuilder encodedString = new StringBuilder();
		try {
			for (int i = 0; i <englishPhrase.length(); i++){
				if (this.toMorse.containsKey(englishPhrase.charAt(i))){
					encodedString.append(toMorse.get(englishPhrase.charAt(i)));
					encodedString.append(" ");
				}
				else if (String.valueOf(englishPhrase.charAt(i)).equals(" ")){
					encodedString.append("   ");
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Unable to convert input.");
		}
		return encodedString.toString();
	}

	public String decode(String morseCode) {
		StringBuilder decodedString = new StringBuilder();
		String[] words = morseCode.split("   ");
		// loop through each word of morse code
		for (int i = 0; i < words.length; i++) {
			String[] letters = words[i].split(" ");
			// loop through each letter of each word
			for (int j = 0; j < letters.length; j++) {
				if (this.toEnglish.containsKey(letters[j])){
					decodedString.append(toEnglish.get(letters[j]));
				}
			}
			decodedString.append(" ");	
		}
		return decodedString.toString();
	}

}
