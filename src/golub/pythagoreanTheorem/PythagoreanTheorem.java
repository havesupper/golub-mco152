package golub.pythagoreanTheorem;

public class PythagoreanTheorem {
	private double a;
	private double b;
	private double c;

	public PythagoreanTheorem() {
	}

	public void setAB(double a, double b) throws InvalidDataException {
		if (a <= 0 || b <= 0) {
			throw new InvalidDataException();
		}
		this.c = Math.sqrt((a * a) + (b * b));

	}

	public void setAC(double a, double c) throws InvalidDataException {
		if (a <= 0 || c <= 0 || a < c) {
			throw new InvalidDataException();
		}
		this.b = Math.sqrt((c * c) - (a * a));
	}

	public void setBC(double b, double c) throws InvalidDataException {
		if (b <= 0 || c <= 0 || b < c) {
			throw new InvalidDataException();
		}
		this.a = Math.sqrt((c * c) - (b * b));
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

}
