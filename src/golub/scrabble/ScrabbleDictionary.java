package golub.scrabble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ScrabbleDictionary {

	private final HashSet<String> dictionary = new HashSet<String>();

	public ScrabbleDictionary() throws IOException {

		try {
			final BufferedReader input = new BufferedReader(new FileReader("US.dic"));
			String line;
			while ((line = input.readLine()) != null) {
				dictionary.add(line);
			}
			input.close();
		} catch (final IOException e) {
			System.out.println("File not found. Please check connection.");
		}

	}

	public boolean contains(String word) {
		return dictionary.contains(word.toLowerCase());
	}
}
