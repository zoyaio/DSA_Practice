package graphs.graph_shortest_path;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.*;

public class ShortestPathGraph
{

	private Map<String, Set<String>> map;
	private Set<String> visited;
	private boolean found;
	private int shortest;

	public ShortestPathGraph(String line)
	{
		map = new TreeMap<>();


		//build your map / graph
		String[] edges = line.split(" ");
		for (String pair : edges) {
			String A = pair.substring(0,1);
			String B = pair.substring(1);
			if (!map.containsKey(A)) {
				map.put(A, new TreeSet<String>() );
			}
			if (!map.containsKey(B)) {
				map.put(B, new TreeSet<String>() );
			}
			map.get(A).add(B);
			map.get(B).add(A);

		}
		//initialize all of your instance variables
		found = false;
		shortest = 0;
		visited = new TreeSet<>();

	}

	public static class Pair {
		public String node;
		public ArrayList<String> pathBehind;

		public Pair() {
			pathBehind = new ArrayList<>();
		}
		public Pair (String node, ArrayList<String> pathBehind) {
			this.node = node;
			this.pathBehind = new ArrayList<>(pathBehind);
			this.pathBehind.add(node);
		}
	}


	public void check(String first, String second)
	{
		// init queue
		Queue<Pair> queue = new LinkedList<>();
		// add first
		queue.add(new Pair(first, new ArrayList<>()));
		visited.add(first);
//		System.out.println("path to be found: " + first +  " " + second);

		// while queue isnt empty
		while (!queue.isEmpty()) {
			// dequeue first element
			Pair curr = queue.peek();
			queue.remove();
			// check if it matches
			if (curr.node.equals(second)) {
				found = true;
				shortest = curr.pathBehind.size() -1;
//				System.out.println("path found: " + curr.pathBehind);
				return;
			}
			// loop through all neighbors of element
			for (String neighbor : map.get(curr.node) ) {
				// if not in visited, add them to queue
				if (!visited.contains(neighbor)) {
					queue.add(new Pair(neighbor, curr.pathBehind) );
					visited.add(neighbor);
				}
			}
		}

	}


	public String toString()
	{
		return found ? shortest + "" : "no path\n";
	}
}