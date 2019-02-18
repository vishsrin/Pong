import java.awt.geom.Rectangle2D;

public class Paddle  {
	private double xCoord;
	private double yCoord;
	private double height;
	private double width;
	
	public Paddle(double x, double y, double h, double w)
	{
		xCoord = x;
		yCoord = y;
		height = h;
		width = w;
	}
	
	public Rectangle2D getBoundingBox()
	{
		return new Rectangle2D.Double((xCoord - 3),(yCoord - (height/ 2)), width, height);
	}
	
	public void refresh(double y, double maxY)
	{
		if(y + height / 2 + 20 < maxY && y - height / 2 > 0)
		{
			{
				yCoord = y;
			}
		}
	}
	
	public void move(double amtUp)
	{
		yCoord = yCoord - amtUp;
	}
}
