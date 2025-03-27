package graphs.graph_all_paths;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

public class AllPathsGraph
{
	private Map<String, Set<String>> map;
	private boolean found;
	private int shortest;
	private ArrayList<String> paths;
	private Set<String> visit;

	public AllPathsGraph(String line)
	{
		//build your map / graph
		//initialize all of your instance variables
	}

	public void direct(String a, String b )
	{
		//check for a direct connnection
		//add that to paths
	}

	public void check(String first, String second, String currPath)
	{
		//go through firsts connections and see if any of those
		//are connected to second
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