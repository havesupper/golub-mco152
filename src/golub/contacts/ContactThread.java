package golub.contacts;

import java.io.IOException;
import java.util.Arrays;

import javax.swing.JList;

public class ContactThread extends Thread {

	private Contacts contactsJ;
	private JList list;
	private String[] names;

	public ContactThread(JList list) {
		this.list = list;

	}

	public void run() {

		try {
			contactsJ = new Contacts();
			Contact[] c = contactsJ.getContactList();
			names = new String[c.length];

			for (int i = 0; i < c.length; i++) {
				names[i] = c[i].getName();
			}

			String[] temp;

			for (int i = 0; i < c.length; i++) {
				temp = names[i].split(" ");
				StringBuilder sb = new StringBuilder();
				sb.append(temp[1]);
				sb.append(" ");
				sb.append(temp[0]);
				names[i] = sb.toString();
			}
			Arrays.sort(names);
			for (int i = 0; i < c.length; i++) {
				temp = names[i].split(" ");
				StringBuilder sb = new StringBuilder();
				sb.append(temp[1]);
				sb.append(" ");
				sb.append(temp[0]);
				names[i] = sb.toString();
			}

			list.setListData(names);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String[] getNames() {
		return names;
	}

	public Contacts getContactsJ() {
		return contactsJ;
	}

}
