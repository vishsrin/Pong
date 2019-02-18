import java.awt.geom.Rectangle2D;

public class Paddle  {
	private double xCoord;
	private double yCoord;
	private double height;
	private double width;
	private double speed;
	private double maxY;
	
	//1 = up 0 = nothing -1 = down
	private int direction;
	
	public Paddle(double x, double y, double h, double w, double m, double s)
	{
		xCoord = x;
		yCoord = y;
		height = h;
		width = w;
		maxY = m;
		speed = s;
	}
	
	public Rectangle2D getBoundingBox()
	{
		return new Rectangle2D.Double((xCoord - 3),(yCoord - (height/ 2)), width, height);
	}
	
	public void autoRefresh(double y)
	{
		if(y + height / 2 + 20 < maxY && y - height / 2 > 0)
		{
			{
				yCoord = y;
			}
		}
	}
	
	public void refresh()
	{
		if(direction == 1 && (yCoord - (height / 2) - speed) < 0)
		{
			
		}
		else if(direction == -1 && (yCoord + (height / 2) + speed) > maxY )
		{
			
		}
		else if(direction == 1)
		{
			yCoord = yCoord - speed;
		}
		else if(direction == -1)
		{
			yCoord = yCoord + speed;
		}
	}
	
	public void start(String direction)
	{
		if(direction.equalsIgnoreCase("up"))
		{
			this.direction = 1;
		}
		
		if(direction.equalsIgnoreCase("down"))
		{
			this.direction = -1;
		}
	}
	
	public void stop()
	{
		this.direction = 0;
		//System.out.println("Upstop");
	}
	
	public void setY(double y)
	{
		yCoord = y;
	}
}
