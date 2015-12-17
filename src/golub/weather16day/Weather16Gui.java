package golub.weather16day;

import java.io.IOException;

import javax.swing.JFrame;

public class Weather16Gui extends JFrame{

	public  Weather16Gui(){
		setTitle("16 Day Forecast");
		setSize(600,800);
		WeatherThread wt = new WeatherThread();
		wt.start();
		
	}
	public static void main (String[]args) throws IOException{
		
		
	}

}
