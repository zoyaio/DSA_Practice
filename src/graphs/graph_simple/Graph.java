package graphs.graph_simple;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.HashSet;
import java.util.HashMap;

public class Graph
{
	private HashMap<String, HashSet<String>> map;
	private HashSet<String> visit;
	private boolean found;

	public Graph(String line)
	{
		//point map at a new hash map
		map = new HashMap<>();
		
		String[] list = line.split(" ");
		for(String piece : list)
		{
			// separates the nodes
			String A = piece.substring(0,1);
			String B = piece.substring(1,2);

			// since they're bi-directional, we add the connection to set of connections for each/both nodes
			addToMap(map, A, B);
			addToMap(map, B, A);
		}
		
		//point visit a new hash set
		visit = new HashSet<>();
		
		found = false;
	}

	private void addToMap(HashMap<String, HashSet<String>> map,
						 String C, String D) {

		if (!map.containsKey(C)) {
			map.put(C, new HashSet<>());
		}
		map.get(C).add(D);
	}

	public boolean contains(String letter)
	{
		if(map.get(letter)==null)
	      return false;
	   return true;
	}

	public void check(String first, String second)
	{
		visit.add(first);

		if (first.equals(second)) {
			found = true;
			return;
		}
		// loops through each of the connections of the map
		for (String nodeToVisit : map.get(first)) {
			if (!visit.contains(nodeToVisit)) {
				visit.add(nodeToVisit);
				check(nodeToVisit, second);
				if (found) {
					return;
				}
			}
		}
		found = false;
	}

	public String toString()
	{
		if(found)
		   return "CONNECTS";
		return "DOES NOT CONNECT";
	}
}

//if first equals second
//done
//else
//get all of first's connections
//loop the list of connections for first
//if current node not yet visited
//add node to visited
//recursive call