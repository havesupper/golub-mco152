package golub.physics;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class ProjectileJFrame extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args){
		// TODO Auto-generated method stub
		new ProjectileJFrame().setVisible(true);
	}
	
	public ProjectileJFrame() {

		this.setTitle("Projectile Graph");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout layout = new BorderLayout();
		Container container = this.getContentPane();

		container.setLayout(layout);
		container.add(new ProjectileComponent(), BorderLayout.CENTER);
	}

}
