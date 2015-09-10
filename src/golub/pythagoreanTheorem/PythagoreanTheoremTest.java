package golub.pythagoreanTheorem;

import org.junit.Assert;
import org.junit.Test;

public class PythagoreanTheoremTest {
	@Test
	public void testSetAB() throws InvalidDataException {
		PythagoreanTheorem p = new PythagoreanTheorem();
		p.setAB(3, 4);
		Assert.assertEquals(5, p.getC(), 0.01);
	}

	@Test
	public void testSetAC() throws InvalidDataException {
		PythagoreanTheorem p = new PythagoreanTheorem();
		p.setAC(3, 5);
		Assert.assertEquals(4, p.getB(), .01);
	}

	@Test
	public void testSetBC() throws InvalidDataException {
		PythagoreanTheorem p = new PythagoreanTheorem();
		p.setBC(4, 5);
		Assert.assertEquals(3, p.getA(), .01);
	}

}
