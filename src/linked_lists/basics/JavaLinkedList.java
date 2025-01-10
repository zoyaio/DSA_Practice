package linked_lists.basics;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.LinkedList;

public class JavaLinkedList
{
	private LinkedList<Integer> list;

	public JavaLinkedList()
	{
		list = new LinkedList<Integer>();
	}

	public JavaLinkedList(int[] nums)
	{
		list = new LinkedList<Integer>();
		for(int num : nums)
		{
			list.add(num);
		}
	}

	public double getSum(  )
	{
		double total=0;
		for (int i = 0; i < list.size(); i++) {
			total += list.get(i);
		}
		return total;
	}

	public double getAvg(  )
	{
		return  getSum()/list.size();
	}

	public int getLargest()
	{
		int largest=Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > largest) { largest = list.get(i);}
		}
		return largest;
	}

	public int getSmallest()
	{
		int smallest = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < smallest) { smallest = list.get(i);}
		}
		return smallest;
	}

	public String toString()
	{
		String output="" + "SUM :: " + getSum() + "\nAVERAGE ::" + getAvg()
				+ "\n" + "SMALLEST:: " + getSmallest() + "\nLARGEST:: " + getLargest();
		return output;
	}
}