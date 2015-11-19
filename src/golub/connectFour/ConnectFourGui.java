package golub.connectFour;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ConnectFourGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel title;
	private JButton[] buttons;
	private JLabel[][] board;
	private JButton reset;
	private BlinkLabel blinker;

	private ImageIcon arrow;
	private ImageIcon emptySlot;
	private ImageIcon redSlot;
	private ImageIcon blackSlot;
	

	private int player;
	private boolean isWinner;

	public ConnectFourGui() {

		setTitle("Connect Four");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7, 7));
		panel.setBackground(Color.YELLOW);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.BLACK);

		JPanel panelTop = new JPanel();
		panelTop.setLayout(new BorderLayout());

		this.title = new JLabel("Connect Four");
		title.setForeground(Color.RED);
		title.setFont(new Font("Sans-Serif", Font.BOLD, 50));
		title.setHorizontalAlignment(SwingConstants.CENTER);

		Board gameBoard = new Board();
		player = 1;
		isWinner = false;

		arrow = new ImageIcon("arrowButton.png");
		emptySlot = new ImageIcon("emptySlot.png");
		redSlot = new ImageIcon("redSlot.png");
		blackSlot = new ImageIcon("blackSlot.png");
		buttons = new JButton[7];
		board = new JLabel[6][7];
		reset = new JButton("RESTART");
		blinker = new BlinkLabel("");
		
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				gameBoard.reset();
				player = 1;
				title.setText("Connect Four");
				blinker.setBlinking(false);
				blinker.setText("");
				
				for (int i = 0; i < 6; i++){
					for (int j = 0; j < 7; j++){
						board[i][j].setIcon(emptySlot);
					}
				}
			}
		});

		for (int i = 0; i < 7; i++) {
			int column = i;
			this.buttons[i] = new JButton(arrow);
			buttons[i].setBackground(Color.WHITE);
			panel.add(buttons[i]);
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					if (player == 1) {
						player = 2;
						try {
							gameBoard.move(1, column);
							for (int k = 5; k >= 0; k--) {
								if (board[k][column].getIcon() == emptySlot) {
									board[k][column].setIcon(redSlot);
									isWinner = gameBoard.isWinner();
									if (isWinner == true) {
										title.setText("");
										blinker.setText("RED IS WINNER!");
										panel2.add(blinker, BorderLayout.CENTER);
										blinker.setBlinking(true);
									}
									break;
								}
							}
						} catch (NoEmptySpaceColumnException e) {
							player = 1;
						}

					} else {
						player = 1;
						try {
							gameBoard.move(2, column);
							for (int k = 5; k >= 0; k--) {
								if (board[k][column].getIcon() == emptySlot) {
									board[k][column].setIcon(blackSlot);
									isWinner = gameBoard.isWinner();
									if (isWinner == true) {
										title.setText("");
										blinker.setText("BLACK IS WINNER!");
										panel2.add(blinker, BorderLayout.CENTER);
										blinker.setBlinking(true);
									}
									break;
								}
							}
						} catch (NoEmptySpaceColumnException e) {
							player = 2;
						}
					}
				}
			});
		}
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 7; j++){
				board[i][j] = new JLabel(emptySlot);
				panel.add(board[i][j]);
			}
		}
		panel2.add(reset, BorderLayout.WEST);
		panel2.add(title, BorderLayout.CENTER);
		
		panelTop.add(panel2, BorderLayout.NORTH);
		panelTop.add(panel, BorderLayout.CENTER);
		
		getContentPane().add(panelTop);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	
}