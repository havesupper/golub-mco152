package golub.connectFour;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
 
public class BlinkLabel extends JLabel {
  private static final long serialVersionUID = 1L;
  
  private final int BLINKING_RATE = 500; 

  private boolean blinkingOn = true;
  
  public BlinkLabel(String text) {
    super(text);
    Timer timer = new Timer( BLINKING_RATE , new TimerListener(this));
    timer.setInitialDelay(0);
    timer.start();
  }

  public void setBlinking(boolean flag) {
    this.blinkingOn = flag;
  }
  public boolean getBlinking(boolean flag) {
    return this.blinkingOn;
  }

  
  private class TimerListener implements ActionListener {
    private BlinkLabel bl;
    private Color bg;
    private Color fg;
    private boolean isForeground = true;
    
    public TimerListener(BlinkLabel bl) {
      this.bl = bl;
      fg = Color.RED;
      bg = Color.BLACK;
     this.bl.setFont(new Font("Sans-Serif", Font.BOLD, 50));
    }
 
    public void actionPerformed(ActionEvent e) {
      if (bl.blinkingOn) {
        if (isForeground) {
          bl.setForeground(fg);
        }
        else {
          bl.setForeground(bg);
        }
        isForeground = !isForeground;
      }
      else {
        if (isForeground) {
          bl.setForeground(fg);
          isForeground = false;
        }
      }
    }
    
  }}