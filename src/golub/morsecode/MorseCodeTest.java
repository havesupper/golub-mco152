package golub.morsecode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void EncodeMorseCodeTest() {
		MorseCode english = new MorseCode();
		String toMorse = english.encode("Hello Malka");
		Assert.assertEquals(
				"...., ., .-.., .-.., ---, --, .-, .-.., -.-, .-, ",
				toMorse);
	}

	@Test
	public void DecodeMorseCodeTest() {
		MorseCode morse = new MorseCode();
		String toEnglish = morse.decode(".... ..");
		Assert.assertEquals("HI", toEnglish);

	}
}
