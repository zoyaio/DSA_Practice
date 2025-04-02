package graphs.graph_shortest_path;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import graphs.graph_all_paths.AllPathsGraph;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ShortestPathGraphRunner
{
	public static void main( String[] args ) throws IOException
	{
		Scanner file = new Scanner(new File(
				"C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\graphs\\graph_shortest_path\\graph2.dat"));
		int howManyTimes = file.nextInt();
		file.nextLine();
		for(int x=0; x<howManyTimes; x++)
		{
			ShortestPathGraph g = new ShortestPathGraph(file.nextLine());
			String pair = file.nextLine();
			g.check(pair.substring(0,1), pair.substring(1,2));
			System.out.println(g);
		}
	}

}