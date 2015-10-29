package golub.physics;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class ProjectileComponent extends JComponent{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke (2));
		super.paintComponent(g2);
		
		Projectile p = new Projectile (31, 20, 0);
		double x1 = p.getX();
		double y1 = getHeight()-p.getY();
		
		for (double i = 0; i < 50; i += .5){
			p = new Projectile (31, 20, i);
			double x2 = p.getX();
			double y2 = getHeight()-p.getY();
			
			g2.draw(new Line2D.Double(x1, y1, x2, y2));
			x1 = x2;
			y1 = y2;
		
		}
		
	}
}
