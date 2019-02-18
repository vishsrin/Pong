import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class BoardComponent extends JComponent{
	private Board board;
	final int DELAY = 1;
	
	public BoardComponent(int x, int y, JFrame frame)
	{
		board = new Board(x, y, frame);
		
		timedDraw listener = new timedDraw(frame);
		Timer t = new Timer(DELAY, listener);
		t.start();
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		board.draw(g2);
	}
	
	public void wpressed()
	{
		board.start("leftup");
	}
	
	public void spressed()
	{
		board.start("leftdown");
	}
	
	public void uppressed()
	{
		board.start("rightup");
	}
	
	public void downpressed()
	{
		board.start("rightdown");
	}
	
	public void wreleased()
	{
		board.stop("left");
	}
	
	public void sreleased()
	{
		board.stop("left");
	}
	
	public void upreleased()
	{
		board.stop("right");
	}
	
	public void downreleased()
	{
		board.stop("right");
	}
	
	

}
