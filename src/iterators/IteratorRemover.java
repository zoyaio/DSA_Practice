package iterators;//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorRemover
{
	private ArrayList<String> list;
	private String toRemove;

	public IteratorRemover(String line, String rem)
	{
		toRemove = rem;
		list = new ArrayList(Arrays.asList(line.split(" ")));
	}

	public void setTest(String line, String rem)
	{
		toRemove = rem;
		list = new ArrayList(Arrays.asList(line.split(" ")));
	}

	public void remove()
	{
		Iterator<String> it = list.iterator();
		String currString = "";
		while (it.hasNext()) {
			currString = it.next();
			if (currString.equals(toRemove)) {
				it.remove();
			}
		}
	}

	public String toString()
	{
		return list.toString()+"\n\n";
	}
}