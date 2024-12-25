package inheritance.pong_project;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

class BallTestTwo extends Canvas implements Runnable
{
	private Ball ball;

	public BallTestTwo()
	{
		setBackground(Color.WHITE);
		setVisible(true);

		//instantiate a new Ball
        ball =  new Ball(10,10, 30, 30, Color.BLUE);

		//test the Ball thoroughly


		//test all constructors
        Ball ball2 = new Ball(10,10, 10, 10, Color.BLUE);
        Ball ball3 = new Ball(10,10, 10,10);

		new Thread(this).start();
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		ball.moveAndDraw(window);

		if(!(ball.getX()>=10 && ball.getX()<=550))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}

		if(!(ball.getY()>=10 && ball.getY()<=450))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(19);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}


//      public static void main(String[] args) {
//        BallTestTwo b2 = new BallTestTwo();
//        b2.run();
//      }
}

