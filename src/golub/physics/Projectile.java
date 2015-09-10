package golub.physics;

public class Projectile {

	private double angle;
	private double velocity;
	private double time;
	private double radians;

	public Projectile(double angle, double velocity, double time) {
		this.angle = angle;
		this.velocity = velocity;
		this.time = time;
		radians = Math.toRadians(angle);
		
	}
	
	public void setTime(){
		for (int time = 0; time <11; time++){
			this.time = time;
			
		}
	}

	public double getX() {
		
		Double formulaX = Math.sin(radians) * velocity * time;
		return formulaX;
	}

	public double getY() {
		
		Double formulaY = Math.cos(radians) * velocity * time - (.5 * 9.8 * (time * time));
		return formulaY;
	}
}
