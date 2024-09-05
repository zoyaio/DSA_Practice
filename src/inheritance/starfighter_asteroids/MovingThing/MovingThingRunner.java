package inheritance.starfighter_asteroids.MovingThing; //(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class MovingThingRunner 
{
	public static void main( String args[] )
	{
		MovingThing it = new MovingThing( 20, 66, 13, 11 );
		System.out.println( "x position " + it.getX() );
		System.out.println( "y position " + it.getY() );		
		System.out.println( "width " + it.getWidth() );
		System.out.println( "height " + it.getHeight() );
		System.out.println( it );
		
		//create more MovingThing objects
		//call all methods
		
	
	}
}