package golub.weather;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class WeatherThread extends Thread {

	JLabel description;
	JLabel temp;
	JLabel icon;
	String zip;

	public WeatherThread(String zipcode, JLabel description, JLabel temp, JLabel icon) {
		this.description = description;
		this.temp = temp;
		this.icon = icon;
		zip = zipcode;
	}

	public void run() {

		try {
			WeatherReport wr = new WeatherReport(zip);
			description.setText(wr.getDescription());
			temp.setText("Temperature is " + String.valueOf(wr.getTemp()));

			StringBuilder builder = new StringBuilder();
			builder.append("http://openweathermap.org/img/w/");
			builder.append(wr.getIcon());
			builder.append(".png");

			URL url = new URL(builder.toString());
			Image image = ImageIO.read(url);
			ImageIcon weatherImage = new ImageIcon(image);

			icon.setIcon(weatherImage);

		} catch (IOException e) {
			// JLabel errorMsg = new
			// JLabel("Error: Could not connect to internet.");
			// add(errorMsg);
		}

	}
}
