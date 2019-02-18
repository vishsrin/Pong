import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {
	private double centerX;
	private double centerY;
	private double startingV;
	private double radius;
	private double xCoord;
	private double yCoord;
	private double velocity;
	private double angle;

	public Ball(double x, double y, double v, double rad) {
		centerX = x;
		centerY = y;
		startingV = v;
		radius = rad;
		xCoord = x;
		yCoord = y;
		velocity = v;
		angle = (Math.random() * 2 * Math.PI);
	}
	
	public Rectangle2D getBoundingBox()
	{
		return new Rectangle2D.Double( (xCoord - radius), (yCoord - radius), radius * 2, radius * 2);
	}
	
	public void reset()
	{
		xCoord = centerX;
		yCoord = centerY;
		velocity = startingV;
		angle = (Math.random() * 2 * Math.PI);
	}
	
	public void reflect(String side)
	{
		if(side.equals("horizontal"))
		{
			angle = Math.PI - angle;
			velocity = velocity * 1.2;
		}
		
		else if(side.equals("vertical"))
		{
			 angle = (2 * Math.PI) - angle;
		}
	}
	
	public void move()
	{
		xCoord = xCoord + (velocity * Math.cos(angle));
		yCoord = yCoord - (velocity * Math.sin(angle));
	}
	
	public Rectangle2D getDrawable()
	{
		return new Rectangle2D.Double(xCoord - radius, yCoord - radius, radius * 2, radius * 2);
	}
	
	public double getMiddleY()
	{
		return yCoord + radius;
	}

}
