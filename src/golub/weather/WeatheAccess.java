package golub.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.google.gson.Gson;

public class WeatheAccess {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Scanner keyboard = new Scanner(System.in);
		StringBuilder builder = new StringBuilder();
		
		System.out.println("Please enter zipcode");
		String zip = keyboard.nextLine();
		
		builder.append("http://api.openweathermap.org/data/2.5/weather?zip=");
		builder.append(zip);
		builder.append(",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");
	
		URL url = new URL(builder.toString());	
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		InputStream in = connection.getInputStream();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
		
		Gson gson = new Gson();
		CurrentWeather cw = gson.fromJson(buffer, CurrentWeather.class);
		
		String description = null;
		String icon;
		double temp;
		
		Weather[] weather = cw.getWeather();
		Main main = cw.getMain();
		
		for (Weather w :weather){
			description = w.getDescription();
			icon = w.getIcon();
		}
		temp = main.getTemp();
		
		
		System.out.println(description);
		System.out.println(temp);
		
			
		
		

	}


}
