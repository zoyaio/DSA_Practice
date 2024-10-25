package stacks.make_a_stack;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

//ArrayList of ints
//or
//array of ints

import java.util.ArrayList;

public class IntStack
{

	//option 2
	private ArrayList<Integer> listOfInts;

	public IntStack()
	{
		listOfInts = new ArrayList<>();
	}

	public void push(int item)
	{
		listOfInts.add(item);

	}

	public int pop()
	{

		int ret = peek();
		listOfInts.remove(listOfInts.size()-1);
		return ret;
	}

	public boolean isEmpty()
	{
		return listOfInts.size() == 0;
	}

	public int peek()
	{
		return listOfInts.get(listOfInts.size()-1);
	}

	public String toString()
	{
		return listOfInts.toString();
	}
}