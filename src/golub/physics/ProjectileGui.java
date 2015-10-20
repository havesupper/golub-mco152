package golub.physics;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProjectileGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel time;
	private JLabel velocity;
	private JLabel angle;
	private JTextField timeInput;
	private JTextField velocityInput;
	private JTextField angleInput;
	private JButton calculate;
	private JLabel x;
	private JLabel y;

	public ProjectileGui() {
		this.setTitle("Projectile");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = this.getContentPane();
		this.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		this.angle = new JLabel("Angle");
		this.velocity = new JLabel("Velocity");
		this.time = new JLabel("Time");
		this.angleInput = new JTextField();
		this.velocityInput = new JTextField();
		this.timeInput = new JTextField();
		this.calculate = new JButton("Calculate");

		this.add(this.angle);
		this.add(this.angleInput);
		this.add(this.velocity);
		this.add(this.velocityInput);
		this.add(this.time);
		this.add(this.timeInput);
		this.add(this.calculate);

		this.calculate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Projectile p = new Projectile(Double
						.parseDouble(ProjectileGui.this.angleInput.getText()),
						Double.parseDouble(ProjectileGui.this.velocityInput
								.getText()), Double
								.parseDouble(ProjectileGui.this.timeInput
										.getText()));

				ProjectileGui.this.x = new JLabel("X = "
						+ String.valueOf(p.getX()));
				ProjectileGui.this.y = new JLabel("Y = "
						+ String.valueOf(p.getY()));

				ProjectileGui.this.add(ProjectileGui.this.x);
				ProjectileGui.this.add(ProjectileGui.this.y);

			}

		});
	}

	public static void main(String[] args) {
		ProjectileGui gui = new ProjectileGui();
		gui.setVisible(true);
	}

}
