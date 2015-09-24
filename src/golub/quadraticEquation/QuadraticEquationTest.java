package golub.quadraticEquation;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {

	@Test
	public void testGetPositiveX() throws InvalidDataException {
		final QuadraticEquation q = new QuadraticEquation(5, 6, 1);
		Assert.assertEquals(-.2, q.getPositiveX(), .01);
	}

	@Test
	public void testGetNegativeX() throws InvalidDataException {
		final QuadraticEquation q = new QuadraticEquation(5, 6, 1);
		Assert.assertEquals(-1, q.getNegativeX(), .01);
	}

	@Test
	public void testZeros() {
		try {
			new QuadraticEquation(0, 0, 0);
			Assert.fail("didn't throw exception");
		} catch (final InvalidDataException e) {
			// expected
		}
	}

}
