package golub.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScrabbleDictionary {
	public ScrabbleDictionary() {

	}

	public boolean contains(String word) {
		Scanner input;
		try {
			input = new Scanner(new File("US.dic"));
			while (input.hasNext()) {
				String compareWord = input.next();
				if (word.equalsIgnoreCase(compareWord)) {
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Please check connection.");
		}
		return false;
	}
}
