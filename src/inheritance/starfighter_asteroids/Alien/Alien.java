package inheritance.starfighter_asteroids.Alien;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private int xspeed;
	private int yspeed;
	private boolean dead;
	
	private Image image;
	
	public Alien(int x, int y, int w, int h, int xs , int ys)
	{
		//must make a super call
		
		//must set XSpeed and YSpeed
		
		try
		{
			image=ImageIO.read(new File("alien.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
	}
	
	public void die() {
		dead=true;
	}
	
	public void setSpeed(int s)
	{
	   speed=s;
	}

	public int getSpeed()
	{
	   return speed;
	}
	public int getYSpeed()
	{
	   return yspeed;
	}
	public int getXSpeed()
	{
	   return xspeed;
	}
	public boolean isDead() {
		return dead;
	}

	public void move(String direction)
	{
		//make your alien move	
		//you decide in what way	
	}

	//draws the frame
	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
