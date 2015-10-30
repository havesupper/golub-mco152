package golub.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xeye =2;
	private int yeye = 2;
	private int width = 30;
	private int height = 25;


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		
		g.setColor(Color.YELLOW);
		g.fillOval(20, 20, 100, 100);//20
		

		g.setColor(Color.BLUE);
		g.fillOval(45, 50, xeye, yeye);//45-50
		g.fillOval(80, 50, xeye, yeye);//80-50

		xeye ++;
		yeye ++;
	
		
		if (xeye == 20){
			xeye = 0;
		}
		if (yeye == 20){
			yeye = 0;
		}
		
		g.setColor(Color.RED);
		g.fillArc(40, 55, width, height, 180, 180);
		width++;
		height++;
		if (width == 60){
			width = 25;
		}
		if (height == 50){
			height = 30;
		}
		
		
		
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.repaint();

	}

}
