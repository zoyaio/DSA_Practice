package graphs.graph_all_paths;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AllPathsGraphRunner
{
	public static void main( String[] args ) throws IOException
	{
		Scanner file = new Scanner(new File("C:\\Users\\sturner\\IdeaProjects\\DSA_Practice\\src\\graphs\\graph_all_paths\\graph3.dat"));
		int howManyTimes = file.nextInt();
		file.nextLine();
		for(int x=0; x<howManyTimes; x++)
		{
			//do some stuff
		}
	}
}