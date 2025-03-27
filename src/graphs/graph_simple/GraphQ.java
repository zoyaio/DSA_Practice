package graphs.graph_simple;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class GraphQ
{
	private HashMap<String, String> map;
	private boolean found;

	public GraphQ(String line)
	{
		map = new HashMap<String, String>();
		String[] list = line.split(" ");
		for(String piece : list)
		{
			String first = piece.substring(0,1);
			String second = piece.substring(1,2);
			
			//add code to build the map / graph
			
		}
		found = false;
	}

	public boolean contains(String letter)
	{
		if(map.get(letter)==null)
	      return false;
	   return true;
	}

	public void check(String first, String second)
	{
        Queue<String> q = new LinkedList<String>();
            
        List<String> used = new LinkedList<String>();
		
		q.add( first );
 
        //loop throug the q if nodes remain to check
        
        	//check for stuff
        	
    }

	public String toString()
	{
		if(found)
		   return "CONNECTS";
		return "DOES NOT CONNECT";
	}
}