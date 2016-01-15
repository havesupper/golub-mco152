package golub.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class SearchOnlinePic {

	private static SearchObject searchObject;

	public SearchOnlinePic(String picUrl) throws IOException {

	

		URL url = new URL(picUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Authorization", "Token token=\"jkxnw6o25k3o5cd2\"");

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();
		searchObject = gson.fromJson(reader, SearchObject.class);

	}

	public SearchObject getSearchObject() {
		return searchObject;
	}

}
