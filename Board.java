import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;

public class Board {
	private int xDimension;
	private int yDimension;
	private Ball gameBall;
	private Paddle left;
	private Paddle right;
	private double ballSpeed;
	private int lScore = 0;
	private int rScore = 0;
	private double paddleSpeed;

	public Board(int xDim, int yDim, JFrame frame) {
		xDimension = xDim;
		yDimension = yDim;
		//System.out.println(ballSpeed);
		ballSpeed = yDim / 1000.0;
		paddleSpeed = ballSpeed * 1.25;
		gameBall = new Ball(xDimension / 2, yDimension / 2, ballSpeed, xDimension / 60);
		left = new Paddle(xDimension / 10, yDimension / 2, yDimension / 4, xDim / 100, yDimension, paddleSpeed);
		right = new Paddle(9 * xDimension / 10, yDimension / 2, yDimension / 4, xDim / 100, yDimension, paddleSpeed);
	}

	public void refreshBall() {
		if (ballLeftBoard()) {
			changeScore();
			gameBall.reset();
			left.setY(yDimension / 2);
			right.setY(yDimension / 2);
		}

		else if (boundingBoxCollides(gameBall.getBoundingBox(), left.getBoundingBox()) || boundingBoxCollides(gameBall.getBoundingBox(), right.getBoundingBox())) {
			gameBall.reflect("horizontal");
			gameBall.move();
		}

		else if (boundingBoxCollides(gameBall.getBoundingBox(), yDimension)) {
			gameBall.reflect("vertical");
			gameBall.move();
		} else {
			gameBall.move();
		}
	}

	public boolean boundingBoxCollides(Rectangle2D bound1, Rectangle2D bound2) {
		return bound1.intersects(bound2);
	}

	public boolean boundingBoxCollides(Rectangle2D bound1, int yCoord) {
		return bound1.getY() <= 0 || bound1.getY() + bound1.getHeight() + 20 >= yCoord;
	}
	
	public boolean ballLeftBoard()
	{
		return (gameBall.getBoundingBox().getX() < 0 || gameBall.getBoundingBox().getX() + gameBall.getBoundingBox().getWidth() > xDimension);
	}
	
	public void changeScore()
	{
		if(gameBall.getBoundingBox().getX() < 0 && rScore == 9)
		{
			rWins();
		}
		
		else if(gameBall.getBoundingBox().getX() < 0)
		{
			rScore++;
		}
		
		else if(lScore == 9)
		{
			lWins();
		}
		
		else lScore++;
	}
	
	public void start(String sideDir)
	{
		if(sideDir.equalsIgnoreCase("leftup"))
		{
			left.start("up");
		}
		
		else if(sideDir.equalsIgnoreCase("leftdown"))
		{
			left.start("down");
		}
		
		if(sideDir.equalsIgnoreCase("rightup"))
		{
			right.start("up");
		}
		
		else if(sideDir.equalsIgnoreCase("rightdown"))
		{
			right.start("down");
		}
	}
	
	public void stop(String sideDir)
	{
		if(sideDir.equalsIgnoreCase("left"))
		{
			left.stop();
		}
		else if(sideDir.equalsIgnoreCase("right"))
		{
			right.stop();
		}
	}
	
	public void rWins()
	{
		System.out.println("Right Wins");
	}
	
	public void lWins()
	{
		System.out.println("Left Wins");
	}
	
	
	public void draw(Graphics2D g2) {
		refreshBall();
		//left.refresh(gameBall.getMiddleY(), yDimension);
		//right.refresh(gameBall.getMiddleY(), yDimension);
		
		left.refresh();
		right.autoRefresh(gameBall.getMiddleY());

		g2.setColor(Color.PINK);
		Rectangle2D backBoard = new Rectangle2D.Double(0, 0, xDimension, yDimension);
		g2.fill(backBoard);
		g2.draw(backBoard);

		g2.setColor(Color.WHITE);
		g2.fill(left.getBoundingBox());
		g2.draw(left.getBoundingBox());

		g2.fill(right.getBoundingBox());
		g2.draw(right.getBoundingBox());

		g2.fill(gameBall.getDrawable());
		g2.draw(gameBall.getDrawable());

		g2.setFont(new Font("TimesRoman", Font.BOLD, 3 * yDimension / 20));
		g2.drawString(String.valueOf(lScore), xDimension / 4, yDimension / 8);
		g2.drawString(String.valueOf(rScore), 3 * xDimension / 4, yDimension / 8);
	}

}
