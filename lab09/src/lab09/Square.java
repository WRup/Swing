	package lab09;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Square {

	private int x1;
	private int y1;
	private int a;
	private Color color;
	private int acceleration;
	private int lastAcceleration;
	private boolean state;
	
	Square(int x1, int y1, int a,Color color, int acceleration, boolean state) throws IllegalArgumentException
	{
		if(a<=0)
			throw new IllegalArgumentException();
		else
		{
			this.a = a;
			this.x1 = x1;
			this.y1 = y1;
		}
		if (color.getRGB() == Color.yellow.getRGB())
			this.color = Color.blue;
		else
			this.color = color;
		if (state) {
			this.lastAcceleration = acceleration;
			this.acceleration = 0;
			this.color = Color.yellow;
		} else {
			this.acceleration = acceleration;
			this.lastAcceleration = acceleration;

		}
	}
	


	public void draw(Graphics graphics)
	{
		graphics.setColor(color);
		graphics.fillRect(x1,y1,a,a);
	}
	public void move(Rectangle2D bounds) {
		y1 = y1 + this.acceleration;

		if (y1 > bounds.getMaxY() && bounds.getMaxY() != 0) 
		{
			y1 = (int) bounds.getMinY();
			x1 = (int) bounds.getMinX() + (int)Math.random()*((int) bounds.getMaxX() - a);
		}
	}
	public void stop()
	{
		this.lastAcceleration = this.acceleration;
		this.acceleration = 0;
	}
	public void resume()
	{
		this.acceleration = this.lastAcceleration;
		if (this.color == Color.yellow)
			this.color = new Color((0 + (int)Math.random()*256), (0 + (int)Math.random() * 256), (0 + (int)Math.random() *256));
	}

}
