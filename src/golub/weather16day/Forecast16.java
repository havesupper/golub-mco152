package golub.weather16day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class Forecast16 {
	
	private DailyWeather dw;
	
	public Forecast16() throws IOException{
	
	URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?id=524901&cnt=16&appid=2de143494c0b295cca9337e1e96b00e0");
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	InputStream in = connection.getInputStream();
	BufferedReader buffer = new BufferedReader(new InputStreamReader(in));

	Gson gson = new Gson();
	dw = gson.fromJson(buffer, DailyWeather.class);
	}
	public DailyWeather getDailyWeather(){
		return this.dw;
	}

}
