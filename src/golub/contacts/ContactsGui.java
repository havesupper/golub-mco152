package golub.contacts;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JList;

public class ContactsGui extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JList list;

	public ContactsGui() {
		setTitle("Contact List");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		list = new JList();

		ContactThread ct = new ContactThread(list);
		ct.start();

		add(list);

	}

	public static void main(String[] args) {
		ContactsGui gui = new ContactsGui();
		gui.setVisible(true);

	}

}
