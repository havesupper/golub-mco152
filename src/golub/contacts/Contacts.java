package golub.contacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class Contacts {

	private Contact[] contactList;

	public Contacts() throws IOException {

		URL url = new URL("http://jsonplaceholder.typicode.com/users");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();
		contactList = gson.fromJson(buffer, Contact[].class);
	}

	public Contact[] getContactList() {
		return contactList;
	}

}
