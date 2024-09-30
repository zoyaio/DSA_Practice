package pong_project;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200, 10,10);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
    public Ball(int x, int y, int width, int height, Color color, int xsp, int ysp) {
        super(x,y,width, height, color);
        xSpeed = xsp;
        ySpeed = ysp;

    }

    // add the other set methods
    public Ball(int x, int y, int width, int height, int xsp, int ysp) {
        super(x,y,width, height, Color.RED);
        xSpeed = xsp;
        ySpeed = ysp;
    }

   //add the set methods


    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
        super.draw(window, Color.WHITE);

      setX(getX()+xSpeed);
		//setY
       setY(getY() + ySpeed);

		//draw the ball at its new location
       super.draw(window);
   }


    //add the get methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        if (!super.equals(o)) return false;
        Ball ball = (Ball) o;
        return getxSpeed() == ball.getxSpeed() && getySpeed() == ball.getySpeed();
    }



    //add a toString() method


    @Override
    public String toString() {
        return "Ball{" +
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }
}