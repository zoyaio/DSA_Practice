package starfighter;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.*;

public class MovingThing
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	public MovingThing()
	{
		xPos = 10;
		yPos = 10;
		width = 10;
		height = 10;
	}

	public MovingThing(int x, int y)
	{
		xPos = x;
		yPos = y;
		width = 10;
		height = 10;
	}

	public MovingThing(int x, int y, int w, int h)
	{
		//add code here
		xPos = x;
		yPos = y;
		width = w;
		height = h;
	}

	public void setPos( int x, int y)
	{
		//add code here
		xPos = x;
		yPos = y;
	}

	public void setX(int x)
	{
		//add code here
		xPos = x;
	}

	public void setY(int y)
	{
		//add code here
		yPos = y;
	}

	public int getX()
	{
		return xPos;   //finish this method
	}

	public int getY()
	{
		return yPos;  //finish this method
	}

	public void setWidth(int w)
	{
		width = w;
	}

	public void setHeight(int h)
	{
		height = h;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public void move(String direction)
	{
		//this method will be fully implemented
		//in the sub class
		//treat this method as if it was abstract
	}
	
	public void draw(Graphics window)
	{
		//this method will be fully implemented
		//in the sub class
		//treat this method as if it was abstract
		// why can't we make it abstracT??
	
	}

	public String toString()
	{
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
	}
}