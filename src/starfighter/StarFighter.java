package starfighter;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class StarFighter extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public StarFighter() throws IOException {
		super("STARFIGHTER");
		setSize(WIDTH,HEIGHT);

		OuterSpace theGame = new OuterSpace();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
//		theGame.run();
	}

	public static void main( String args[] ) throws IOException {
		StarFighter run = new StarFighter();
	}
}