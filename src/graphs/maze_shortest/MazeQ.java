package graphs.maze_shortest;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import com.sun.jdi.ClassObjectReference;

import java.util.*;


// creating the graph (nodes): each tuple-index-of-#
// creating graph (edges): check each of its directions has a #
public class MazeQ
{

	private static class CoordinatePair implements Comparable {
		List<Integer> pair;
		int distance;


		CoordinatePair(int r, int c, int currDistance) {
			pair = new ArrayList();
			pair.add(r);
			pair.add(c);
			distance = currDistance + 1;
		}
		@Override
		public int compareTo(Object o) {
			CoordinatePair other = (CoordinatePair) o;
			if (Objects.equals(other.pair.get(0), this.pair.get(0)) && Objects.equals(other.pair.get(1), this.pair.get(1))) {
				return 0;
			}
			return -1;
		}
		@Override
		public boolean equals(Object o) {
			CoordinatePair other = (CoordinatePair) o;
			return (Objects.equals(other.pair.get(0), this.pair.get(0)) && Objects.equals(other.pair.get(1), this.pair.get(1)));
		}
		public int getR() { return pair.get(0);}
		public int getC() { return pair.get(1);}

		public int getDistance() {return distance; }

		public String toString() {
			return pair.toString() + "hi";
		}
	}
   private char[][] maze;
   private boolean exitFound;
   private int shortestDistance;

   private Queue<CoordinatePair> queue;
   private TreeSet<CoordinatePair> visited;


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
		queue = new LinkedList<>();
		visited = new TreeSet<>();
		shortestDistance = -1;
	}

	// creating the graph (nodes): each tuple-index-of-#
	// creating graph (edges): check each of its directions has a #
	// OHH they don't really create a graph structure--they just directly traverse the graph
	private int[][] generateValidNeighbors(int mazeSize, int r, int c) {
		int[][] neighbors; // order of neighbors: up down left right
		neighbors = new int[][]{{r - 1, c}, {r + 1, c}, {r, c - 1}, {r, c + 1}};
		for (int i = 0; i < 4; i++) {
			int rN = neighbors[i][0]; // row index for this neighbor
			int cN = neighbors[i][1];  // col index for this neighbor
			// checks if the neighbor is in size AND is a traversable step
			if (!(rN >= 0 && rN < mazeSize) || !(cN >= 0 && cN < mazeSize) || maze[r][c] == '#') {
				// set both = to -1 (indicating that the neighbor is invalid
				neighbors[i] = new int[]{-1, -1};
			}
		}
		return neighbors;
	}

	public void checkForExitPath(int rr, int cc)
	{
		queue.add(new CoordinatePair(rr, cc, 0));

		while (!queue.isEmpty()) {
			CoordinatePair curr = queue.poll();
//			System.out.println("curr" + curr);
//			System.out.println("queue" + queue);
			int r = curr.getR(); int c = curr.getC();

			if ((r == maze.length-1 && c == maze.length -1) && (maze[r][c] == '.')) {
				exitFound = true;
				shortestDistance = curr.distance;
				return;
			}
			int[][] neighbors = generateValidNeighbors(maze.length, r, c);
			for (int i = 0; i < neighbors.length; i++) {
				CoordinatePair temp = new CoordinatePair(neighbors[i][0],neighbors[i][1], curr.getDistance() );
				if (neighbors[i][0] != -1 && !visited.contains(temp)) {
					queue.add(temp);
					visited.add(temp);
				}
			}
			if (queue.isEmpty()) {
				exitFound = false;
				return;
			}
		}
	}
	
	public boolean found()
	{
		return exitFound;
	}
	public int getShortestDistance(){
		return shortestDistance;
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