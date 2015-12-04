package golub.weather;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = getContentPane();
		setLayout(new BorderLayout());
		
		enterZip = new JLabel("Please Enter Zip");
		zip = new JTextField();
		compute = new JButton("Find Out Weather");
		
		add(enterZip);
		add(zip);
		add(compute);
		
		compute.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				WeatheAccess w;
				
			}
			
			
		});
		
		
	}
	
	public static void main(String[]args){
		WeatherGui gui = new WeatherGui();
		gui.setVisible(true);
	}

}
