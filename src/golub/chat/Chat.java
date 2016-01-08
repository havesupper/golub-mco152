package golub.chat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.eclipse.jetty.server.Server;

public class Chat extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton button;
	private JTextArea area;

	public Chat() {
		setTitle("Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		Panel bottom = new Panel();
		bottom.setLayout(new BorderLayout());
		area = new JTextArea();
		textField = new JTextField();
		button = new JButton("Connect");

		bottom.add(textField, BorderLayout.CENTER);
		bottom.add(button, BorderLayout.EAST);

		add(area, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);

		Server server = new Server(8080);
		server.setHandler(new ChatP2PHandler(area));
		try {
			server.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					URL url = new URL("http://192.168.117.59:8080");
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setDoOutput(true);
					OutputStream out = connection.getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					writer.println(textField.getText());
					textField.setText("");
					writer.flush();

					connection.getInputStream();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
	}

	public static void main(String[] args) {
		Chat chat = new Chat();
		chat.setVisible(true);

	}

}
