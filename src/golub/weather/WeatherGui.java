package golub.weather;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherGui extends JFrame{
	
	private JLabel enterZip;
	private JTextField zip;
	private JButton compute;
	private JLabel description;
	private JLabel temp;
	
	public WeatherGui(){
		setTitle("Weather by Zip");
		setSize(200, 300);
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
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		});
		
		
	}
	
	public static void main(String[]args){
		WeatherGui gui = new WeatherGui();
		gui.setVisible(true);
	}

}
