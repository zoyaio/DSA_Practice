package queues.make_a_queue;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

//ArrayList of ints
//or
//array of ints

import java.util.ArrayList;

public class IntQueue
{
	//pick your storage for the queue
	//you can use an array or an ArrayList

	//option 1
	private int[] rayOfInts;
	private int numInts;

	//option 2
	private ArrayList<Integer> listOfInts;

	public IntQueue()
	{
		listOfInts = new ArrayList<>();
	}

	public void add(int item)
	{
		listOfInts.add(item);
	}

	public int remove()
	{

		int rem = listOfInts.get(0);
		listOfInts.remove(0);
		return rem;
	}

	public boolean isEmpty()
	{
		return listOfInts.size() == 0;
	}

	public int peek()
	{
		return listOfInts.get(0);
	}

	public String toString()
	{
		return listOfInts.toString();
	}
}