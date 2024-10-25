package maps.relatives;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class RelativesRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\maps\\relatives\\relatives.dat"));

		Relatives test = new Relatives();

		int num = file.nextInt();
		file.nextLine();
		for(int x = 0; x < num; x++)
		{
			test.setPersonRelative(file.nextLine());
		}

		out.println(test);

		String person = file.next();
			out.println(person+" is related to "+test.getRelatives(person));
	}
}