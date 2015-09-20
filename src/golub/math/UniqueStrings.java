package golub.math;

import java.util.HashSet;

public class UniqueStrings {

	public static void main(String[] args) {
		String array[] = new String[] { "A", "B", "B", "B", "C", "C" };

		HashSet<String> set = new HashSet<String>();
		HashSet<String> duplicate = new HashSet<String>();
		for (String s : array) {
			if (set.contains(s) && !duplicate.contains(s)) {
				System.out.println(s);
				duplicate.add(s);
			}
			set.add(s);
		}

	}
}
