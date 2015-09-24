package golub.quadraticEquation;

public class QuadraticEquation {
	private final double a;
	private final double b;
	private final double c;

	public QuadraticEquation(double a, double b, double c) throws InvalidDataException {
		if ((a == 0) || (b == 0)) {
			throw new InvalidDataException();
		}
		this.a = a;
		this.b = b;
		this.c = c;

	}

	public double getPositiveX() {
		final double result = (-(b) + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
		return result;

	}

	public double getNegativeX() {
		final double result = (-(b) - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
		return result;
	}

}
