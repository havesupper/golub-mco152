package golub.physics;

public class ProjectileMain {

	public static void main(String[] args) {
		double degree = 31.0;
		double velocity = 20.0;
		double secondsExample = 2.7;

		
			Projectile aProjectile = new Projectile(degree, velocity, secondsExample);
			double x = aProjectile.getX();
			double y = aProjectile.getY();

			System.out.println(x + " " + y);
		

	}

}
