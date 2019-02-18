
import javax.swing.JFrame;

public class Pong{

	public static void main(String[] args) {
	
		JFrame Frame = new JFrame();
		Frame.setSize(700, 500);
		Frame.setTitle("Pong");
		BoardComponent board = new BoardComponent(Frame.getWidth(), Frame.getHeight(), Frame);
		Frame.add(board);
		Frame.setFocusable(true);
		Frame.addKeyListener(new pongListener(board));
		Frame.setVisible(true);
		Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);

	}

}
