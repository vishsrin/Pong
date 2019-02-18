import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class pongListener implements KeyListener {
	BoardComponent boardComp;
	
	public pongListener(BoardComponent boardComp)
	{
		this.boardComp = boardComp;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_W)
		{
			//System.out.println("w pressed");
			boardComp.wpressed();
		}
		else if(key == KeyEvent.VK_S)
		{
			boardComp.spressed();
		}
		else if(key == KeyEvent.VK_UP)
		{
			boardComp.uppressed();
		}
		else if(key == KeyEvent.VK_DOWN)
		{
			boardComp.downpressed();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_W)
		{
			//System.out.println("w released");
			boardComp.wreleased();
		}
		else if(key == KeyEvent.VK_S)
		{
			boardComp.sreleased();
		}
		else if(key == KeyEvent.VK_UP)
		{
			boardComp.upreleased();
		}
		else if(key == KeyEvent.VK_DOWN)
		{
			boardComp.downreleased();
		}
	}
	

}
