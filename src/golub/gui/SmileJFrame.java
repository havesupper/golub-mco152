package golub.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class SmileJFrame extends JFrame {

	public static void main(String[] args) {
		new SmileJFrame().setVisible(true);

	}

	public SmileJFrame() {

		this.setTitle("Smile");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout layout = new BorderLayout();
		Container container = this.getContentPane();

		container.setLayout(layout);
		container.add(new SmileComponent(), BorderLayout.CENTER);
	}

}
