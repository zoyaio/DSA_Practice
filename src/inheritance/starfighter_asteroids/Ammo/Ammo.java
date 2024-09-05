package inheritance.starfighter_asteroids.Ammo;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed;
	private int xSpeed;
	private int ySpeed;
	private double rad;

	public Ammo()
	{
		//must complete 
	}

	public Ammo(int x, int y, int w, int h, int s, double z)
	{
		//must complete 
	}

	//setters and getters are complete
	public void setSpeed(int s)
	{
	   speed=s;
	}
	
	public int getSpeed()
	{
	   return speed;
	}
	
	public int getXSpeed() {
		return xSpeed;
	}
	
	public int getYSpeed() {
		return ySpeed;
	}
	
	public void setXSpeed(int a) {
		xSpeed=a;
	}
	
	public void setYSpeed(int a) {
		ySpeed=a;
	}	

	public void move(String direction)
	{		
		//must complete 
	}

	public void draw( Graphics window )
	{
		//draw your ammo using Java Graphics
	}

	public String toString()
	{
		return "going to need a super method call";
	}
}
