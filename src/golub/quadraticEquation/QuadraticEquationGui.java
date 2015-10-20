package golub.quadraticEquation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class QuadraticEquationGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel a;
	private JLabel b;
	private JLabel c;
	private JLabel x;
	private JLabel answer;
	private JButton compute;
	private JTextField aInput;
	private JTextField bInput;
	private JTextField cInput;

	public QuadraticEquationGui() {
		setTitle("Quadratic Equation");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		a = new JLabel("A");
		aInput = new JTextField();
		b = new JLabel("B");
		bInput = new JTextField();
		c = new JLabel("C");
		cInput = new JTextField();
		compute = new JButton("Compute");
		x = new JLabel("X = ");

		add(a);
		add(aInput);
		add(b);
		add(bInput);
		add(c);
		add(cInput);
		add(compute);
		add(x);

		compute.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				QuadraticEquation q = null;
				try {
					q = new QuadraticEquation(Double.parseDouble(aInput
							.getText()), Double.parseDouble(bInput.getText()),
							Double.parseDouble(cInput.getText()));
				} catch (NumberFormatException e) {
					System.out
					.println("Could not convert input. Please enter numeric data.");
					System.exit(1);
				} catch (InvalidDataException e) {
					System.out
					.println("Invalid Data. Please enter valid values.");
				}

				String xpos = String.valueOf(q.getPositiveX());
				String xneg = String.valueOf(q.getNegativeX());
				answer = new JLabel(xpos + "/" + xneg);
				add(answer);
			}

		});

	}

	public static void main(String[] args) {
		QuadraticEquationGui gui = new QuadraticEquationGui();
		gui.setVisible(true);
	}

}
