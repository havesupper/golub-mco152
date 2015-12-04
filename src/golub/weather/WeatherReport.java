package golub.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class WeatherReport {

	private String zip;
	private String description;
	private double temp;
	private String icon;

	public WeatherReport(String zip) throws IOException {
		this.zip = zip;
		
		StringBuilder builder = new StringBuilder();

		builder.append("http://api.openweathermap.org/data/2.5/weather?zip=");
		builder.append(zip);
		builder.append(",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");

		URL url = new URL(builder.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();
		CurrentWeather cw = gson.fromJson(buffer, CurrentWeather.class);


		Weather[] weather = cw.getWeather();
		Main main = cw.getMain();

		for (Weather w : weather) {
			description = w.getDescription();
			icon = w.getIcon();
		}
		temp = main.getTemp();
	}
	
	public String getDescription(){
		return this.description;
	}
}
