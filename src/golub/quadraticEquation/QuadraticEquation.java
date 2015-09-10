package golub.quadraticEquation;

public class QuadraticEquation {
	private double a;
	private double b;
	private double c;
	private double xPositive;
	private double xNegative;

	public QuadraticEquation(double a, double b, double c) throws InvalidDataException {
		if (a == 0 || b == 0) {
			throw new InvalidDataException();
		}
		this.a = a;
		this.b = b;
		this.c = c;
		this.xPositive = getPositiveX();
		this.xNegative = getNegativeX();

	}

	public double getPositiveX() {
		double result = (-(b) + Math.sqrt((b * b) - 4 * a * c)) / (2 * a);
		return result;

	}

	public double getNegativeX() {
		double result = (-(b) - Math.sqrt((b * b) - 4 * a * c)) / (2 * a);
		return result;
	}

}
