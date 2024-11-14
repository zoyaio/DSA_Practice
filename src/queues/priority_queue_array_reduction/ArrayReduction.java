package queues.priority_queue_array_reduction;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ArrayReduction
{
	public static int min_cost( Integer[] r )
	{
		//MUST USE A PRIORITY QUEUE
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		pQ.addAll(Arrays.asList(r));
		int newSum;
		int totalSum = 0;

		while (pQ.size() >= 2) {
			newSum = pQ.remove() +  pQ.remove();
			totalSum += newSum;
			pQ.add(newSum);
		}

		return totalSum;
	}
	
	public static void main( String[] args )
	{
		Integer[] s0 = {212};
		System.out.println( ArrayReduction.min_cost(s0));

		Integer[] s1 = {25,10,20};
		System.out.println( ArrayReduction.min_cost(s1));

		Integer[] s2 = {1,2,3};
		System.out.println( ArrayReduction.min_cost(s2));

		Integer[] s3 = {1,2,3,4,7,22,33,54,-66,3,4,5,76,7,999};
		System.out.println( ArrayReduction.min_cost(s3));

		Integer[] s4 = {1,1,1,1,1};
		System.out.println( ArrayReduction.min_cost(s4));

		Integer[] s5 = {1,1};
		System.out.println( ArrayReduction.min_cost(s5));												
	}
}


/* EXPECTED OUTPUT
 0
85
9
947
12
2
*/