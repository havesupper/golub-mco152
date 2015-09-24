package golub.scrabble;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void testScrabbleDictionary() throws IOException {
		final ScrabbleDictionary word = new ScrabbleDictionary();
		Assert.assertTrue(word.contains("hello"));
	}

}
