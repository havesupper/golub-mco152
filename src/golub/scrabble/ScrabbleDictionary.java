package golub.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class ScrabbleDictionary {
	
	private HashSet<String> dictionary = new HashSet<String>();

	public ScrabbleDictionary() {
		Scanner input;
		try {
			input = new Scanner(new File("US.dic"));
			while (input.hasNext()) {
				dictionary.add(input.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Please check connection.");
		}
	}

	public boolean contains(String word) {
		return dictionary.contains(word);
	}
}
