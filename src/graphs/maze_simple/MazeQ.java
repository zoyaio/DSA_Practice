package graphs.maze_simple;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Queue;
import java.util.LinkedList;


// creating the graph (nodes): each tuple-index-of-#
// creating graph (edges): check each of its directions has a #
public class MazeQ
{
   private char[][] maze;
   private boolean exitFound;

	public MazeQ()
	{
		exitFound = false;
		maze = new char[0][0];
	}
	
	public MazeQ(char[][] m)
	{
		exitFound=false;
		maze = new char[m.length][m[0].length];
		for(int r= 0; r<maze.length; r++)
		{
			for(int c =0; c<maze[r].length; c++)
			{
				maze[r][c]=m[r][c];
			}
		}
	}

	public void checkForExitPath(int rr, int cc)
	{
		Queue<String> q = new LinkedList<String>();
		LinkedList<String> v = new LinkedList<String>();
		
		//your code goes here
		//BFS approach with a queue
		
		//you will need a loop to process the nodes 
		//you will add the nodes to the queue
	}
	
	public boolean found()
	{
		return exitFound;
	}

	public String toString()
	{
		String output="";
		for(int r= 0; r<maze.length; r++)
		{
			for(int c =0; c<maze[r].length; c++)
			{
				output+=maze[r][c]+" ";
			}
			output+="\n";
		}
		return output;
	}
}