package golub.scrabble;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void ScrabbleDictionaryTest() {
		ScrabbleDictionary word = new ScrabbleDictionary();
		Assert.assertTrue(word.contains("hello"));
	}

}
