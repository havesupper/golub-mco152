package golub.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.YELLOW);
		g.fillOval(20, 20, 100, 100);

		g.setColor(Color.BLUE);
		g.fillOval(45, 50, 15, 20);
		g.fillOval(80, 50, 15, 20);

		g.setColor(Color.RED);
		g.fillArc(40, 55, 60, 50, 180, 180);

	}

}
