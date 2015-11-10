package golub.connectFour;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ConnectFourGui extends JFrame {

	private JLabel title;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JLabel[] column1;
	private JLabel[] column2;
	private JLabel[] column3;
	private JLabel[] column4;
	private JLabel[] column5;
	private JLabel[] column6;
	private JLabel[] column7;
	private ImageIcon arrow;
	private ImageIcon emptySlot;
	private ImageIcon redSlot;
	private ImageIcon blackSlot;
	private JFrame frame;

	private int player;
	private boolean isWinner;

	public ConnectFourGui() {

		frame = new JFrame();
		this.frame.setTitle("Connect Four");
		this.frame.setSize(700, 700);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Container container = this.getContentPane();
		// this.frame.getContentPane().setLayout(new BorderLayout(800,800));
		JPanel panel = new JPanel();
		// panel.setSize(500, 500);
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

		this.button1 = new JButton(arrow);
		button1.setBackground(Color.WHITE);
		button2 = new JButton(arrow);
		button2.setBackground(Color.WHITE);
		button3 = new JButton(arrow);
		button3.setBackground(Color.WHITE);
		button4 = new JButton(arrow);
		button4.setBackground(Color.WHITE);
		button5 = new JButton(arrow);
		button5.setBackground(Color.WHITE);
		button6 = new JButton(arrow);
		button6.setBackground(Color.WHITE);
		button7 = new JButton(arrow);
		button7.setBackground(Color.WHITE);

		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);

		column1 = new JLabel[6];
		column2 = new JLabel[6];
		column3 = new JLabel[6];
		column4 = new JLabel[6];
		column5 = new JLabel[6];
		column6 = new JLabel[6];
		column7 = new JLabel[6];

		for (int j = 0; j < 6; j++) {
			column1[j] = new JLabel(emptySlot);
			column2[j] = new JLabel(emptySlot);
			column3[j] = new JLabel(emptySlot);
			column4[j] = new JLabel(emptySlot);
			column5[j] = new JLabel(emptySlot);
			column6[j] = new JLabel(emptySlot);
			column7[j] = new JLabel(emptySlot);
			panel.add(column1[j]);
			panel.add(column2[j]);
			panel.add(column3[j]);
			panel.add(column4[j]);
			panel.add(column5[j]);
			panel.add(column6[j]);
			panel.add(column7[j]);
		}
		panel2.add(title, BorderLayout.CENTER);

		panelTop.add(panel2, BorderLayout.NORTH);
		panelTop.add(panel, BorderLayout.CENTER);
		this.frame.getContentPane().add(panelTop);
		// this.frame.add(panel, BorderLayout.CENTER);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (player == 1) {
					player = 2;
					try {
						gameBoard.move(1, 0);
						for (int i = 5; i >= 0; i--) {
							if (column1[i].getIcon() == emptySlot) {
								column1[i].setIcon(redSlot);
								isWinner = gameBoard.isWinner();
								if (isWinner == true) {
									title.setText("WINNER!");
								}
								break;
							}
						}
					} catch (NoEmptySpaceColumnException e) {

					}

				} else {
					player = 1;
					try {
						gameBoard.move(2, 0);
						for (int i = 5; i >= 0; i--) {
							if (column1[i].getIcon() == emptySlot) {
								column1[i].setIcon(blackSlot);
								isWinner = gameBoard.isWinner();
								if (isWinner == true) {
									title.setText("WINNER!");
								}
								break;
							}
						}
					} catch (NoEmptySpaceColumnException e) {

					}

				}
			}

		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (player == 1) {
					player = 2;
					try {
						gameBoard.move(1, 1);
						for (int i = 5; i >= 0; i--) {
							if (column2[i].getIcon() == emptySlot) {
								column2[i].setIcon(redSlot);
								isWinner = gameBoard.isWinner();
								if (isWinner == true) {
									title.setText("WINNER!");
								}

								break;
							}
						}
					} catch (NoEmptySpaceColumnException e) {

					}

				} else {
					player = 1;
					try {
						gameBoard.move(2, 1);
						for (int i = 5; i >= 0; i--) {
							if (column2[i].getIcon() == emptySlot) {
								column2[i].setIcon(blackSlot);
								isWinner = gameBoard.isWinner();
								if (isWinner == true) {
									title.setText("WINNER!");
								}
								break;
							}
						}
					} catch (NoEmptySpaceColumnException e) {

					}

				}
			}

		});

		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (player == 1) {
					player = 2;
					try {
						gameBoard.move(1, 2);
						for (int i = 5; i >= 0; i--) {
							if (column3[i].getIcon() == emptySlot) {
								column3[i].setIcon(redSlot);
								isWinner = gameBoard.isWinner();
								if (isWinner == true) {
									title.setText("WINNER!");
								}

								break;
							}
						}
					} catch (NoEmptySpaceColumnException e) {

					}

				} else {
					player = 1;
					try {
						gameBoard.move(2, 2);
						for (int i = 5; i >= 0; i--) {
							if (column3[i].getIcon() == emptySlot) {
								column3[i].setIcon(blackSlot);
								isWinner = gameBoard.isWinner();
								if (isWinner == true) {
									title.setText("WINNER!");
								}
								break;
							}
						}
					} catch (NoEmptySpaceColumnException e) {

					}

				}
			}

		});

		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (player == 1) {
					player = 2;
					try {
						gameBoard.move(1, 3);
						for (int i = 5; i >= 0; i--) {
							if (column4[i].getIcon() == emptySlot) {
								column4[i].setIcon(redSlot);
								isWinner = gameBoard.isWinner();
								if (isWinner == true) {
									title.setText("WINNER!");
								}
								break;
							}
						}
					} catch (NoEmptySpaceColumnException e) {

					}

				} else {
					player = 1;
					try {
						gameBoard.move(2, 3);
						for (int i = 5; i >= 0; i--) {
							if (column4[i].getIcon() == emptySlot) {
								column4[i].setIcon(blackSlot);
								isWinner = gameBoard.isWinner();
								if (isWinner == true) {
									title.setText("WINNER!");
								}
								break;
							}
						}
					} catch (NoEmptySpaceColumnException e) {

					}

				}
			}

		});
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (player == 1) {
					player = 2;
					try {
						gameBoard.move(1, 4);
						for (int i = 5; i >= 0; i--) {
							if (column5[i].getIcon() == emptySlot) {
								column5[i].setIcon(redSlot);
								isWinner = gameBoard.isWinner();
								if (isWinner == true) {
									title.setText("WINNER!");
								}

								break;
							}
						}
					} catch (NoEmptySpaceColumnException e) {

					}

				} else {
					player = 1;
					try {
						gameBoard.move(2, 4);
						for (int i = 5; i >= 0; i--) {
							if (column5[i].getIcon() == emptySlot) {
								column5[i].setIcon(blackSlot);
								isWinner = gameBoard.isWinner();
								if (isWinner == true) {
									title.setText("WINNER!");
								}
								break;
							}
						}
					} catch (NoEmptySpaceColumnException e) {

					}

				}
			}

		});
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (player == 1) {
					player = 2;
					try {
						gameBoard.move(1, 5);
						for (int i = 5; i >= 0; i--) {
							if (column6[i].getIcon() == emptySlot) {
								column6[i].setIcon(redSlot);
								isWinner = gameBoard.isWinner();
								if (isWinner == true) {
									title.setText("WINNER!");
								}

								break;
							}
						}
					} catch (NoEmptySpaceColumnException e) {

					}

				} else {
					player = 1;
					try {
						gameBoard.move(2, 5);
						for (int i = 5; i >= 0; i--) {
							if (column6[i].getIcon() == emptySlot) {
								column6[i].setIcon(blackSlot);
								isWinner = gameBoard.isWinner();
								if (isWinner == true) {
									title.setText("WINNER!");
								}
								break;
							}
						}
					} catch (NoEmptySpaceColumnException e) {

					}

				}
			}

		});

		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (player == 1) {
					player = 2;
					try {
						gameBoard.move(1, 6);
						for (int i = 5; i >= 0; i--) {
							if (column7[i].getIcon() == emptySlot) {
								column7[i].setIcon(redSlot);
								isWinner = gameBoard.isWinner();
								if (isWinner == true) {
									title.setText("WINNER!");
								}

								break;
							}
						}
					} catch (NoEmptySpaceColumnException e) {

					}

				} else {
					player = 1;
					try {
						gameBoard.move(2, 6);
						for (int i = 5; i >= 0; i--) {
							if (column7[i].getIcon() == emptySlot) {
								column7[i].setIcon(blackSlot);
								isWinner = gameBoard.isWinner();
								if (isWinner == true) {
									title.setText("WINNER!");
								}
								break;
							}
						}
					} catch (NoEmptySpaceColumnException e) {

					}
				}

			}

		});
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		ConnectFourGui gui = new ConnectFourGui();

		gui.setVisible(true);
	}

}
