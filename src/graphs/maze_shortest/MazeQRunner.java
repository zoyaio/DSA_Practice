package graphs.maze_shortest;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MazeQRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(
				new File("C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\graphs\\maze_shortest\\maze_short.dat"));
		while(file.hasNext())
		{
			int rc = file.nextInt();
			char[][] maze = new char[rc][rc];
			file.nextLine();

			for(int r= 0; r < rc; r++)
			{
				char[] ln = file.next().toCharArray();
				//System.out.println(ln);
				for(int c =0; c < rc; c++)
				{
					maze[r][c]=ln[c];
				}
				file.nextLine();
			}

			MazeQ test = new MazeQ(maze);
			
			System.out.println( test );
			
			test.checkForExitPath(0,0);
			
			System.out.println( test.found() + ": " + test.getShortestDistance() + "\n" );
		}
	}
}