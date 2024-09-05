package inheritance.starfighter_asteroids.Alien; //(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import javax.swing.JFrame;
import java.awt.Component;
import java.awt.Graphics;

public class StarFighter extends JFrame
{
	public static int WIDTH = 800;
	public static int HEIGHT = 600;

	public StarFighter()
	{
		//sets the title for the window
		super("STARFIGHTER");

		//sets the size of the window
		setSize(WIDTH, HEIGHT);

		//creates an instance of the game
		OuterSpace theGame = new OuterSpace();
		((Component)theGame).setFocusable(true);
		
		//adds the game into the frame
		getContentPane().add( theGame );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main( String args[] )
	{
		//runs the game
		StarFighter run = new StarFighter();
	}
}