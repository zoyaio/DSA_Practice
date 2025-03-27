package graphs.maze_simple;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.lang.reflect.Array;
import java.util.*;

public class Maze
{
	private static class CoordinatePair implements Comparable {
		List<Integer> pair;
		CoordinatePair(int[] arr) {
			pair = new ArrayList();
			pair.add(arr[0]);
			pair.add(arr[1]);
		}

		@Override
		public int compareTo(Object o) {
			CoordinatePair other = (CoordinatePair) o;
			if (Objects.equals(other.pair.get(0), this.pair.get(0)) && Objects.equals(other.pair.get(1), this.pair.get(1))) {
				return 0;
			}
			return -1;
		}
	}
   private char[][] maze;
   private TreeSet<CoordinatePair> visited;
   private boolean exitFound;

	public Maze()
	{
		exitFound = false;
		maze = new char[0][0];
	}

	public Maze(char[][] m)
	{
		visited = new TreeSet<>();
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

	// creating the graph (nodes): each tuple-index-of-#
	// creating graph (edges): check each of its directions has a #
	// OHH they don't really create a graph structure--they just directly traverse the graph
	private int[][] generateValidNeighbors(int mazeSize, int r, int c) {
		int[][] neighbors; // order of neighbors: up down left right
		neighbors = new int[][]{{r -1, c}, {r + 1, c}, {r, c-1}, {r, c + 1}};
		for (int i = 0; i < 4; i ++) {
			int rN = neighbors[i][0]; // row index for this neighbor
			int cN = neighbors[i][1];  // col index for this neighbor
			// checks if the neighbor is in size AND is a traversable step
			if (!(rN >= 0  && rN < mazeSize) || !(cN >= 0 && cN < mazeSize) || maze[r][c] == '#') {
				// set both = to -1 (indicating that the neighbor is invalid
				neighbors[i] = new int[]{-1, -1};
			}
		}
		return neighbors;
	}
	// basecase: if reached end of maze or no directions left
	public void checkForExitPath(int r, int c)
	{
		CoordinatePair coordPair = new CoordinatePair(new int[] {r,c});

		if (exitFound || visited.contains(coordPair) ) {
			return;
		}
		else {
			visited.add(coordPair);

		}
		if ((r == maze.length-1 && c == maze.length -1) && (maze[r][c] == '.')) {
			exitFound = true;
			return;
	}
		int[][] neighbors = generateValidNeighbors(maze.length, r, c);
		int validCount = 0;
		if (neighbors[0][0] != -1) {
			checkForExitPath(neighbors[0][0], neighbors[0][1]);
			validCount ++;
		}
		if (neighbors[1][0] != -1) {
			checkForExitPath(neighbors[1][0], neighbors[1][1]);
			validCount ++;
		}
		if (neighbors[2][0] != -1) {
			checkForExitPath(neighbors[2][0], neighbors[2][1]);
			validCount ++;
		}
		if (neighbors[3][0] != -1) {
			checkForExitPath(neighbors[3][0], neighbors[3][1]);
			validCount ++;
		}

		if (validCount == 0) {
			return;
		}


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