package inheritance.pong_project;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
       super(10,10, 10, 10,Color.gray);
      speed =5;
   }


    //add the other Paddle constructors
    public Paddle(int x, int y, int width, int height, Color color, int xsp) {
        super(x,y,width, height, color);
        speed = xsp;

    }
    public Paddle(int x, int y) {
        super(x,y,10, 10, Color.gray);
        speed = 10;
    }
    // add the other set methods
    public Paddle(int x, int y, int speedI) {
        super(x,y,10, 10, Color.gray);
        speed = speedI;
    }

    public Paddle(int x, int y, int width, int height, int speedt ){
        super(x,y,width, height, Color.gray);
        speed = speedt;
    }



   public void moveUpAndDraw(Graphics window)
   {
       //draw a white ball at old ball location
       super.draw(window, Color.WHITE);

       setY(getY() - speed);
       drawNew(window);
   }

   public void moveDownAndDraw(Graphics window)
   {
       //draw a white ball at old ball location
       super.draw(window, Color.WHITE);

       setY(getY() + speed);
       // the problem is that it doesn't clear the window after every iteration?
       drawNew(window);
   }

   //add get methods

    public int getSpeed() {
       return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
//add a toString() method

    @Override
    public String toString() {
        return "Paddle{" +
                "speed=" + speed +
                '}';
    }
}