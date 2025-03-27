package graphs.graph_simple2;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.*;

public class BiDirectionalGraph
{
	private TreeMap<String, HashSet<String>> map;
	private boolean found;
	HashSet<String> visit;

	public BiDirectionalGraph(String line)
	{
		//point map at a new hash map
		map = new TreeMap<>();

		String[] list = line.split(" ");

		for (int i = 0; i < list.length; i +=2) {
			addToMap(map, list[i], list[i+1]);
			addToMap(map, list[i+1], list[i]);
		}

		//point visit a new hash set
		visit = new HashSet<>();
		found = false;
	}

	private void addToMap(Map<String, HashSet<String>> map,
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
			return "YAY";
		return "NAY";
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