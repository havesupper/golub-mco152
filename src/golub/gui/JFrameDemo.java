package golub.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameDemo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label1;
	private JLabel label2;
	private JButton button1;
	private JTextField textField;
	private JLabel response;

	public JFrameDemo() {
		setTitle("JFrameDemo");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();

		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		label1 = new JLabel("All this text is shown");
		add(label1);
		label2 = new JLabel("More text");
		add(label2);
		textField = new JTextField();
		add(textField);

		response = new JLabel();
		add(response);

		button1 = new JButton("Button1");
		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				response.setText("hello");

			}

		});
		add(button1);

	}

}
