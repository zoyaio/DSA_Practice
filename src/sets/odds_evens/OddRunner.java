package sets.odds_evens;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class OddRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner( new File("C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\sets\\odds_evens\\oddevent.dat"));
		while (file.hasNextLine()) {
			OddEvenSets set = new OddEvenSets(file.nextLine());
			System.out.println(set);
		}
				
	}
}