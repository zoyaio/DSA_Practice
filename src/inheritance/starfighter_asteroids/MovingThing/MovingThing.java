package inheritance.starfighter_asteroids.MovingThing;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

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

	public MovingThing(int x, int y, int w, int h)
	{
		//need to complete
	}

	public void setPos( int x, int y)
	{
		//need to complete
	}

	public void setX(int x)
	{
		//need to completexPos=x;
	}

	public void setY(int y)
	{
		//need to complete
	}

	public int getX()
	{
		return -1;
	}

	public int getY()
	{
		return -1;
	}

	public void setWidth(int w)
	{
		//need to complete
	}

	public void setHeight(int h)
	{
		//need to complete
	}

	public int getWidth()
	{
		return -1;
	}

	public int getHeight()
	{
		return -1;
	}

	public void move(String direction)
	{
		//will be overriden 
		//code written later
	}
	
	public void draw(Graphics window)
	{
		//will be overriden 
		//code written later
	}

	public String toString()
	{
		return "need to complete the toString";
	}
}