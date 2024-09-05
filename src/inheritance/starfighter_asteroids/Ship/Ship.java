package inheritance.starfighter_asteroids.Ship;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private BufferedImage image;
	private BufferedImage current;
	private int lives;
	private int cWidth;
	private int cHeight;
	private int xSpeed;
	private int ySpeed;
	private int angle;
	private double rad;
	private boolean dead;

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		cWidth=w*4;
		cHeight=h*4;
		speed=s;
		xSpeed=0;
		ySpeed=0;
		lives=1;
		angle=0;
		rad=Math.PI/2;
		dead=false;
		try
		{
			image=ImageIO.read(new File("ship.jpg"));
			current=image;
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
	}

	public void setSpeed(int s)
	{
	   speed=s;
	}
	
	public int getSpeed()
	{
	   return speed;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void changeLives(int a){
		lives+=a;
	}
	
	public int getCH() {
		return cHeight;
	}
	
	public int getCW() {
		return cWidth;
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
	
	public void setCW(int a) {
		cWidth=a;
	}
	
	public void setCH(int a) {
		cHeight=a;
	}
	
	public double getRad() {
		return rad;
	}
	
	public void setRad(double a) {
		rad=a;
	}
	
	public void die() {
		dead=true;
	}
	
	public void move(String direction)
	{
		if(!dead) {
		if(direction.equals("LEFT")) 
		{
			angle--;
	      current=rotate(image,angle/40.0);
	     
		}
      else if(direction.equals("RIGHT")) 
      {
    	  //add code to make the ship turn right
	      
      }		
		else if(direction.equals("UP")) {
			//add code to make the ship move up
			
		}
		if(getY()< -getHeight()) {
			setY(StarFighter.HEIGHT);
		}
		if(getY()> StarFighter.HEIGHT+getHeight()/4) {
			setY(0);
		}
		if(getX()>StarFighter.WIDTH+getWidth()/4) {
			setX(0);
		}
		if(getX()<0-getWidth()+5) {
			setX(StarFighter.WIDTH-5);
		}
		}
		else {
			current=rotate(image,0);
		}
	}
	public void translate() {
		setX(getX()+getXSpeed()/10);
		setY(getY()+getYSpeed()/10);
	}
	
	//rotates an image
	public BufferedImage rotate(BufferedImage image, double angle) {
		
		if(!dead) {
	    double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
	    setRad(angle+Math.PI/2);
	    int w = image.getWidth(), h = image.getHeight();
	    int neww = (int)((Math.floor(w*cos+h*sin))), newh = (int)((Math.floor(h * cos + w * sin)));
	    
	    setCW(neww);
	    setCH(newh);
	    
	    GraphicsConfiguration gc = getDefaultConfiguration();
	    BufferedImage rotated = new BufferedImage(neww, newh, BufferedImage.TYPE_INT_ARGB);
       Graphics2D g = rotated.createGraphics();
	    AffineTransform test = new AffineTransform();
	    test.rotate(angle, (w)/2, (h)/2);
	    g.setTransform(test);
	    g.drawRenderedImage(image, null);
	    g.dispose();
	    return rotated;
		}
		return current;
	}
	
	//returns graphics configuration for the rotation
	private GraphicsConfiguration getDefaultConfiguration() {
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice gd = ge.getDefaultScreenDevice();
	    return gd.getDefaultConfiguration();
	}

	public void draw( Graphics window )
	{
		if(getCH()>=getHeight()) 
		{
			window.drawImage(current,getX(),getY(),(getCW()-getWidth())/2,(getCH()-getHeight())/2,null);			
		}			
		if(dead ) {
			if(getCH()>getHeight()) {
				setCH(getCH()-5);
			}
			if(getCW()>getWidth()) {
				setCW(getCW()-5);
			}
		}
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
