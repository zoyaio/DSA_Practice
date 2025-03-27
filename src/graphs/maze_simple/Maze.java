package graphs.maze_simple;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Maze
{
   private char[][] maze;
   private boolean exitFound;

	public Maze()
	{
		exitFound = false;
		maze = new char[0][0];
	}

	public Maze(char[][] m)
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

	public void checkForExitPath(int r, int c)
	{
		//your code will go here.
		
		//you will need a base case
		
		//you will need 4 recursive calls
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