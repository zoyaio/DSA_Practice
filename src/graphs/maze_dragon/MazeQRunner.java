package graphs.maze_dragon;//(c) A+ Computer Science
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
				new File("C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\graphs\\maze_dragon\\stronghold2.dat"));
		int numEntries = file.nextInt();
		file.nextLine();
		for (int i =0; i < numEntries; i++)
		{
			int rN = file.nextInt();
			int cN = file.nextInt();
//			file.nextLine();
			char[][] maze = new char[rN][cN];
			file.nextLine();

			for(int r= 0; r < rN; r++)
			{
				char[] ln = file.next().toCharArray();
				//System.out.println(ln);
				for(int c =0; c < cN; c++)
				{
					maze[r][c]=ln[c];
				}
				file.nextLine();
			}

			MazeQ test = new MazeQ(maze);
			
			System.out.println( test );
			
			test.checkForExitPath();
			
			System.out.println( test.found() + ": " + test.getShortestDistance() + "\n" );
		}
	}
}