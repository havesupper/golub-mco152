package golub.mostAnagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class MostAnagrams {

	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> anagrams = new HashMap<String, ArrayList<String>>();

		try {
			Scanner input = new Scanner(new File("US.dic"));
			while (input.hasNext()) {
				//store each word
				String word = input.next();
				char[] letters = word.toCharArray();
				Arrays.sort(letters);
				//store each word sorted alphabetically
				String sortedWord = new String(letters);
				
				//if the anagram already exist add the 
				//unsorted word to the arrayList
				//else create it 
				if (anagrams.containsKey(sortedWord)) {
					anagrams.get(sortedWord).add(word);
				} else {
					ArrayList<String> words = new ArrayList<String>();
					anagrams.put(sortedWord, words);
					anagrams.get(sortedWord).add(word);
				}

			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Please check connection.");
		}
		//get the key whose value is the largest in size
		//if there are two of equal size display both
		ArrayList<String> mostAnagrams = new ArrayList<String>();
		ArrayList<String> equalAmountAnagrams = new ArrayList<String>();
		Integer largestVal = null;
		for (Entry<String, ArrayList<String>> map : anagrams.entrySet()) {
			if (largestVal == null || largestVal < map.getValue().size()) {
				largestVal = map.getValue().size();
				mostAnagrams = map.getValue();
			}
			else if (largestVal == map.getValue().size()) {
				equalAmountAnagrams = map.getValue();
			}
		}
		System.out.println(mostAnagrams.toString() + equalAmountAnagrams);

	}
}
