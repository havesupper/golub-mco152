package golub.mostAnagrams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class MostAnagrams {

	public static void main(String[] args) throws IOException {
		final HashMap<String, ArrayList<String>> anagrams = new HashMap<String, ArrayList<String>>();

		try {
			final BufferedReader input = new BufferedReader(new FileReader("US.dic"));
			String line;
			while ((line = input.readLine()) != null) {
				// store each word
				final char[] letters = line.toCharArray();
				Arrays.sort(letters);
				// store each word sorted alphabetically
				final String sortedWord = new String(letters);

				// if the anagram already exist add the
				// unsorted word to the arrayList
				// else create it
				if (anagrams.containsKey(sortedWord)) {
					anagrams.get(sortedWord).add(line);
				} else {
					final ArrayList<String> words = new ArrayList<String>();
					anagrams.put(sortedWord, words);
					anagrams.get(sortedWord).add(line);
				}

			}
			input.close();
		} catch (final FileNotFoundException e) {
			System.out.println("File not found. Please check connection.");
		}
		// get the key whose value is the largest in size
		// if there are two of equal size display both
		ArrayList<String> mostAnagrams = new ArrayList<String>();
		ArrayList<String> equalAmountAnagrams = new ArrayList<String>();
		int largestVal = 0;
		for (final Entry<String, ArrayList<String>> map : anagrams.entrySet()) {
			if ((largestVal == 0) || (largestVal < map.getValue().size())) {
				largestVal = map.getValue().size();
				mostAnagrams = map.getValue();
			} else if (largestVal == map.getValue().size()) {
				equalAmountAnagrams = map.getValue();
			}
		}
		System.out.println(mostAnagrams.toString() + equalAmountAnagrams.toString());

	}
}
