package graphs.graph_all_paths;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;

public class AllPathsGraph
{
	private Map<String, Set<String>> map;
	private boolean found;
	private int shortest;
	private ArrayList<ArrayList<String>> paths;
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
		ArrayList<String> arr = new ArrayList<>();
		arr.add(first);
		check(first, second, arr);
	}
	// visited should only be for the current path aka i need to turn currPath
	// into an array list
	public void check (String first, String second, ArrayList<String> currPath) {
		Map<String, ArrayList<String>> potentialPathways2 = new TreeMap();

		for (String neigh : map.get(first)) {
			ArrayList<String> arr = new ArrayList<>(currPath);
			// base case
			if (neigh.equals(second)) {
				found = true;
				arr.add(neigh);
				paths.add(arr);
				}
			// if it's not a full path yet, add it to the potential pathways to explore
			else {
				potentialPathways2.put(neigh, arr);
			}
		}
		for (Map.Entry<String, ArrayList<String>> entry : potentialPathways2.entrySet()) {
			// init variables
			ArrayList<String> pathway = entry.getValue();
			String neigh = entry.getKey();
			// if this node hasn't already been visited on this path
			if (!pathway.contains(neigh)) {
				// adds it to the history
				pathway.add(neigh);
				// recursive call
				check(neigh, second, pathway);
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