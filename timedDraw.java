
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class timedDraw implements ActionListener
{
	private JFrame fr;
	
	
	public timedDraw(JFrame frame)
	{
		fr = frame;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		fr.repaint();
	}
	


}
