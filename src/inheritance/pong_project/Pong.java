package inheritance.pong_project;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;


	public Pong()
	{
		//set up all variables related to the game
        //instantiate a Ball
        ball = new Ball(10,10,10,10, Color.blue, 1,1);


        //instantiate a left Paddle

        leftPaddle = new Paddle(100,400,10,30, Color.pink, 10);


        //instantiate a right Paddle
        rightPaddle = new Paddle(550,400,10,30, Color.pink, 10);




		keys = new boolean[4];


    	setBackground(Color.WHITE);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}

   public void update(Graphics window){
	   paint(window);
   }
public void paint2(Graphics window) {
        ball.moveAndDraw(window);
		leftPaddle.drawNew(window);
		rightPaddle.drawNew(window);

		if(!(ball.getX()>=10 && ball.getX()<=550))
    {
        ball.setXSpeed(-ball.getXSpeed());
    }

		if(!(ball.getY()>=10 && ball.getY()<=450))
    {
        ball.setYSpeed(-ball.getYSpeed());
    }

		if(keys[0] == true)
    {
        //move left paddle up and draw it on the window
        leftPaddle.moveUpAndDraw(window);
    }
		if(keys[1] == true)
    {
        //move left paddle down and draw it on the window
        leftPaddle.moveDownAndDraw(window);
    }
		if(keys[2] == true)
    {

        rightPaddle.moveUpAndDraw(window); // only increases its widtth? cahnge yinstead ofx THEYRE ON TOP OF EASCH OTHER
    }
		if(keys[3] == true)
    {
        rightPaddle.moveDownAndDraw(window);
    }
}
   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

       ball.moveAndDraw(graphToBack);
       leftPaddle.drawNew(graphToBack);
       rightPaddle.drawNew(graphToBack);


		//see if ball hits left wall or right wall
		if(!(ball.getX()>=10 && ball.getX()<=780))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
		}


		//see if the ball hits the top or bottom wall
        if (!(ball.getY() >= 10 && ball.getY() <=780 ) ) {
            ball.setXSpeed(0);
            ball.setYSpeed(0);
        }



		//see if the ball hits the left paddle
       int currX = ball.getX();
       int currY = ball.getY();
       int currWid = ball.getWidth();
       int currHeight = ball.getHeight();
       int currXSp = ball.getXSpeed();
       int currYsp = ball.getYSpeed();

       int leftWidth= leftPaddle.getWidth();
       int leftHeight = leftPaddle.getHeight();
       int leftYPos = leftPaddle.getY();
       int leftXPos = leftPaddle.getX();
       int leftSp = leftPaddle.getSpeed();

	   int rightWidth= rightPaddle.getWidth();
	   int rightHeight = rightPaddle.getHeight();
	   int rightYPos = rightPaddle.getY();
	   int rightXPos = rightPaddle.getX();
	   int rightSp = rightPaddle.getSpeed();


       if ((currX <= leftXPos + leftWidth + Math.abs(leftSp) )
               &&
               currY >= leftYPos && currY <= leftYPos + leftHeight ||
               currY + currHeight >= leftYPos && currY + currHeight < leftYPos + leftHeight) {
           if (currX <= leftXPos + leftWidth - Math.abs(currXSp)) {
               ball.setYSpeed(ball.getYSpeed() *-1);
           }
           else{
               ball.setXSpeed(ball.getXSpeed() *-1);
           }
       }



	   if ((currX >= rightXPos + rightWidth + Math.abs(rightSp))
			   &&
			   (currY >= rightYPos && currY <= rightYPos + rightHeight ||
					   currY + currHeight >= rightYPos && currY + currHeight > rightYPos + rightHeight)) {
		   if (currX >= rightXPos + rightWidth - Math.abs(currXSp)) {
			   ball.setYSpeed(ball.getYSpeed() *-1);
		   }
		   else{
			   ball.setXSpeed(ball.getXSpeed() *-1);
		   }
	   }




		//see if the paddles need to be moved
       if(keys[0] == true)
       {
           //move left paddle up and draw it on the window
           leftPaddle.moveUpAndDraw(graphToBack);
       }
       if(keys[1] == true)
       {
           //move left paddle down and draw it on the window
           leftPaddle.moveDownAndDraw(graphToBack);
       }
       if(keys[2] == true)
       {

           rightPaddle.moveUpAndDraw(graphToBack); // only increases its widtth? cahnge yinstead ofx THEYRE ON TOP OF EASCH OTHER
       }
       if(keys[3] == true)
       {
           rightPaddle.moveDownAndDraw(graphToBack);
       }


		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}