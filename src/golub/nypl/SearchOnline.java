package golub.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class SearchOnline {

	private static SearchObject searchObject;
	

	public SearchOnline(String searchWord) throws IOException{
		
		StringBuilder builder = new StringBuilder();
		builder.append("http://api.repo.nypl.org/api/v1/items/search?q=");
		builder.append(searchWord);
		builder.append("&publicDomainOnly=true");
		
		URL url =  new URL(builder.toString());
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
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
