package golub.weather;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel enterZip;
	private JTextField zip;
	private JButton compute;
	private JLabel description;
	private JLabel temp;
	private JLabel icon;

	public WeatherGui() {
		setTitle("Weather by Zip");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		enterZip = new JLabel("Please Enter Zip");
		zip = new JTextField();
		Dimension d = new Dimension(400, 150);
		zip.setMaximumSize(d);
		compute = new JButton("Find Out Weather");
		description = new JLabel();
		temp = new JLabel();
		icon = new JLabel();

		add(enterZip);
		add(zip);
		add(compute);
		add(description);
		add(temp);
		add(icon);
		compute.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				WeatherThread wt = new WeatherThread(zip.getText(), description, temp, icon);
				wt.start();
			}
		});
	}

	public static void main(String[] args) {
		WeatherGui gui = new WeatherGui();
		gui.setVisible(true);
	}

}
