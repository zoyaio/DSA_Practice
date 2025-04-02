package graphs.graph_all_paths;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;

public class AllPathsGraph
{
	private Map<String, Set<String>> map;
	private boolean found;
	private int shortest;
	private ArrayList<String> paths;
	private Set<String> visited;

	public AllPathsGraph(String line)
	{
		map = new HashMap<>();


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
		paths = new ArrayList<>();
		visited = new TreeSet<>();
	}
	public void check (String first, String second) {
		check(first, second, first);
	}
	// visited should only be for the current path aka i need to turn currPath
	// into an array list
	public void check (String first, String second, String currPath) {
		visited.add(first);
		Set<String> potentialPathways = new TreeSet<>();
		for (String neigh : map.get(first)) {
			// base case
			if (neigh.equals(second)) {
				found = true;
				paths.add(currPath + " "+ neigh);
				}
			else {
				potentialPathways.add(neigh);
			}
		}
		for (String neigh : potentialPathways) {
			// recursive call
			if (!visited.contains(neigh)) {
				check(neigh, second, currPath + " " + neigh);
			}
		}
	}




	public String toString()
	{
		if(found) 
		{
			return "" + paths;
		}
		return "no";
	}
}