package golub.pi;

import javax.swing.JLabel;

public class PiCalculationThread extends Thread{

	private JLabel label;
	
	public PiCalculationThread(JLabel label){
		this.label = label;
	}
	
	public void run(){

		PiCalculator calc = new PiCalculator();
		double pi = calc.calculate(100000000L);
		label.setText(String.valueOf(pi));
	}
}
