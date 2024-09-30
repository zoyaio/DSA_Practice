package starfighter;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.net.URL;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship()
	{
		this(10,10,10,10,10);
	}

	public Ship(int x, int y)
	{
	   //add code here
		this(x,y,10,10,10);
	}

	public Ship(int x, int y, int s)
	{
	   //add code here
		this(x,y,10,10,s);
	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
//			URL url = getClass().getResource("C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\starfighter\\ship.jpg");
			image = ImageIO.read(new File("C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\starfighter\\ship.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("couldn't find image: " + e.getMessage());
		}
	}


	public void setSpeed(int s)
	{
	   speed= s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void move(String direction)
	{
		if (direction.equals("left")) {
			setX(getX() -speed * 1);
		}

		if (direction.equals("right")) {
			setX(getX() + speed * 1);
		}

		if (direction.equals("up")) {
			setY(getY() + speed * 1);
		}

		else {
			setY(getY() - speed * 1);
		}

	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + ", speed: " + getSpeed();
	}
}
