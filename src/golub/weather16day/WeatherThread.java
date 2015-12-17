package golub.weather16day;

import java.io.IOException;

public class WeatherThread extends Thread{
	
	public WeatherThread(){
		
	}
	
	public void run(){
		Forecast16 f16 = null;
		try {
			f16 = new Forecast16();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}{
			DailyWeather dw = f16.getDailyWeather();
					
			List[]list = dw.getList();
			double humidity;
			Temp temp;
			Weather[] weather = list[0].getWeather();
			String description;
			
			
			
			for (int i = 0; i < list.length; i++){
				humidity = list[i].getHumidity();
				System.out.println(humidity);
				temp = list[i].getTemp();
				System.out.println(temp.getDay() + " " + temp.getNight());
				weather = list[i].getWeather();
				description = weather[0].getDescription();
				System.out.println(description);			
			}
			}
	}

}
