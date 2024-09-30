package starfighter;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;

	public Alien()
	{
		this(0,0,30,30,0);
	}

	public Alien(int x, int y)
	{
		//add code here
	}

	public Alien(int x, int y, int s)
	{
		//add code here
	}

	public Alien(int x, int y, int w, int h, int s)
	{
		super(x, y, w,h);
		speed=s;
		try
		{
			URL url = getClass().getResource("/images/alien.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
	}

	public void setSpeed(int s)
	{
	   //add code
	}

	public int getSpeed()
	{
	   return 0;
	}

   public void move(String direction)
	{
	   //add code here
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return "";
	}
}
