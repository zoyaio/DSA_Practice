package queues.priority_queue_basics;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -  

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PQTester
{
	private Queue<String> pQueue;

	public PQTester()
	{
		pQueue = new PriorityQueue<>();
	}

	public PQTester(String list)
	{
		pQueue = new PriorityQueue<>();
		setPQ(list);

	}

	public void setPQ(String list)
	{
		String[] split = list.split(" ");
		pQueue.clear();
		pQueue.addAll(Arrays.asList(split));
	}
	
	public Object getMin()
	{
		return pQueue.peek();
	}
	
	public String getNaturalOrder()
	{
		String output="";
		while (!pQueue.isEmpty()) {
			output += pQueue.remove() +" ";
		}
		return output;		
	}

	//write a toString method
	public String toString() {
		return pQueue.toString();
	}

}