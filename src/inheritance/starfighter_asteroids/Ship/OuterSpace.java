package inheritance.starfighter_asteroids.Ship;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component;

public class OuterSpace extends JPanel implements KeyListener, Runnable
{
	//create a Ship instance variable
	//going to test Ship 
	//phase 1
	private Ship ship;	

	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		keys = new boolean[4];

		setBackground(Color.black);

		//make a new Ship
		//phase 1
		ship = new Ship(310,250,10,10,15);

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and save it as an image
		//that is the exact same width and height as the current screen
		if(back==null){
			StarFighter.HEIGHT = this.getHeight();
	      StarFighter.WIDTH = this.getWidth();
	      //System.out.println(StarFighter.WIDTH);
		   back = (BufferedImage)(createImage(this.getWidth(),this.getHeight()));
		   ship.move("LEFT");
	   }

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		
		//sets the movement behavior of the ship
		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
		if(keys[2] == true)
		{
			//uncomment once the ship
			//correctly rotates left and right
			//ship.move("UP");
		}
		if(keys[3] == true)
		{
			//controls the direction that the shots are going in relative to the ship
			//shots.add(new Ammo(ship.getX()+(ship.getCW()-ship.getWidth())/4-5, ship.getY()+(ship.getCH()-ship.getHeight())/4-10, 10, 10, ship.getSpeed()+1,ship.getRad()));
			//keys[4] = false;		
		}		
			
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,this.getWidth(),this.getHeight());
		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("STARFIGHTER", 25, 50 );
		graphToBack.setColor(Color.GREEN);
		
		graphToBack.drawString("Lives: "+ship.getLives(), 25, 100 );
		
		ship.translate();
		ship.draw(graphToBack);
		
		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[3] = true;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[3] = false;
		}
	}

	public void keyTyped(KeyEvent e)
	{
		//not needed for this project
		//must be present as the method
		//is part of the KeyListener interface
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(18);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

