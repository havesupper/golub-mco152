package golub.weather;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherGui extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel enterZip;
	private JTextField zip;
	private JButton compute;
	private JLabel description;
	private JLabel temp;
	private JLabel icon;
	
	public WeatherGui(){
		setTitle("Weather by Zip");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		enterZip = new JLabel("Please Enter Zip");
		zip = new JTextField();
		compute = new JButton("Find Out Weather");
		
		add(enterZip);
		add(zip);
		add(compute);
		
		compute.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					WeatherReport wr = new WeatherReport(zip.getText());
					description = new JLabel(wr.getDescription());
					temp = new JLabel("Temperature is " + String.valueOf(wr.getTemp()));
					
					add(description);
					add(temp);
					
					StringBuilder builder = new StringBuilder();

					builder.append("http://openweathermap.org/img/w/");
					builder.append(wr.getIcon());
					builder.append(".png");

					URL url = new URL(builder.toString());
					Image image = ImageIO.read(url);
					ImageIcon weatherImage = new ImageIcon(image);
					
					icon = new JLabel();
					icon.setIcon(weatherImage);
					
					add(icon);
				} catch (IOException e) {
					JLabel errorMsg = new JLabel("Error: Could not connect to internet.");
					add(errorMsg);
				}
				
			}
			
			
		});
		
		
	}
	
	public static void main(String[]args){
		WeatherGui gui = new WeatherGui();
		gui.setVisible(true);
	}

}
