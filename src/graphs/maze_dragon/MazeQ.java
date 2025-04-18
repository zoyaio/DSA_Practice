package graphs.maze_dragon;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import number_systems.ASCII_to_binary.ConvertRunner;

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
//			System.out.print("comparing: " + this.toString() + "and other:" + o);
			if (Objects.equals(other.pair.get(0), this.pair.get(0)) && Objects.equals(other.pair.get(1), this.pair.get(1))) {
//				System.out.println(" --> true");
				return 0;
			}
//			System.out.println(" -->  false");
			return -1;
		}
		@Override
		public int hashCode() {
			return getR() * 1000 + getC();
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
			return pair.toString() ;
		}
	}

	Set<Character> monsterChars = new TreeSet<>(); // should be static bbut im lazy

   private char[][] maze;
   private boolean exitFound;
   private int shortestDistance;

   private Queue<CoordinatePair> queue;
   private HashSet<CoordinatePair> visited;


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
		visited = new HashSet<>();
		shortestDistance = -1;

		Collections.addAll(monsterChars,'S', 'Z', 'E', 'L', 'C', 'F' );
	}

	// creating the graph (nodes): each tuple-index-of-#
	// creating graph (edges): check each of its directions has a #
	// OHH they don't really create a graph structure--they just directly traverse the graph
	private int[][] generateValidNeighbors(int r, int c) {
		int[][] neighbors; // order of neighbors: up down left right
		neighbors = new int[][]{{r - 1, c}, {r + 1, c}, {r, c - 1}, {r, c + 1}};
		for (int i = 0; i < 4; i++) {
			int rN = neighbors[i][0]; // row index for this neighbor
			int cN = neighbors[i][1];  // col index for this neighbor
			// checks if the neighbor is in size AND is a traversable step
			if (!(rN >= 0 && rN < maze.length) || !(cN >= 0 && cN < maze[0].length) || !(maze[rN][cN] == '.'|| maze[rN][cN] == 'P') ) {
				// set both = to -1 (indicating that the neighbor is invalid
				neighbors[i] = new int[]{-1, -1};
			}
		}
		return neighbors;
	}

	private ArrayList<CoordinatePair> generateValidSpace(int rN, int cN, int depth) {
//		System.out.println("\n\n" + rN + " " + cN);
		ArrayList<CoordinatePair> ret = new ArrayList<>();
		for (int r = rN - depth; r < rN + depth+1; r++) {
			for (int c = cN - depth; c < cN + depth +1; c++) {
//				System.out.println("coord: " + r + " "+ c);
				if ((r >= 0 && r < maze.length) && (c >= 0 && c < maze[0].length)) {
					ret.add(new CoordinatePair(r, c, -1));
				}
//
			}

		}
		return ret;
	}


	// return false if no portal is found
	public boolean findDangerousTiles() {
		boolean portalFound = false;
		for (int r = 0; r < maze.length; r ++) {
			for (int c = 0; c < maze[1].length; c++) {
				char block = maze[r][c];
				if (block == 'P') {
					portalFound = true;
				}

				if (monsterChars.contains(block)) {
//					System.out.println("monster! " + r + " " + c);
//					System.out.println(generateValidSpace(r, c, 1));
					visited.addAll(generateValidSpace(r, c, 1)); // are there unequal mazes now
				}
				else if (block == 'R' || block == 'K') {
					visited.addAll( generateValidSpace(r, c, 3));  // are there unequal mazes now

				}

			}
		}
		return portalFound;

	}

	public CoordinatePair findSteve() {
		for (int r = 0; r < maze.length; r++) {
			for (int c = 0; c < maze[0].length; c++) {
				if (maze[r][c] == 'T') {
//					System.out.println("T pos: " + r+" " + c);
					return new CoordinatePair(r, c, 0);
				}
			}
		}
		return new CoordinatePair(0,0,0);
	}

 	public void checkForExitPath() {
		if (!findDangerousTiles()) {
			exitFound = false;
		}
		else{

//			System.out.println("dangerous tiles: " + visited);
			// find steve pos
			CoordinatePair stevePos = findSteve(); // works!!
			// check for exit path
			checkForExitPath(stevePos.getR(), stevePos.getC());

		}
	}
	public void checkForExitPath(int rr, int cc)
	{
		queue.add(new CoordinatePair(rr, cc, 0));

		while (!queue.isEmpty()) {
//			System.out.println("Queue: " + queue);
			CoordinatePair curr = queue.poll();
//			System.out.println("\nCURR" + curr);
//			System.out.println("visited "+ visited);
			int r = curr.getR(); int c = curr.getC();

			// checks if have reached end of maze
			if (maze[r][c] == 'P') {
				exitFound = true;
				shortestDistance = curr.distance -1 ;
				return;
			}
			int[][] neighbors = generateValidNeighbors(r, c);

			// loops through each neighbor and adds to queue if valid
			for (int i = 0; i < neighbors.length; i++) {
//				System.out.println(Arrays.toString(neighbors[i]));
				CoordinatePair temp = new CoordinatePair(neighbors[i][0],neighbors[i][1], curr.getDistance() );
//				System.out.println("tocheck: " +temp);
				if (neighbors[i][0] != -1 && !visited.contains(temp)) {
//					System.out.println("ignroe here");
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