package iterators;//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class IteratorReplacer
{
	private ArrayList<String> list;
	private String toRemove, replaceWith;

	public IteratorReplacer(String line, String rem, String rep)
	{
		toRemove = rem;
		list = new ArrayList(Arrays.asList(line.split(" ")));
		replaceWith = rep;
	}

	public void setTest(String line, String rem, String rep)
	{
		toRemove = rem;
		list = new ArrayList(Arrays.asList(line.split(" ")));
		replaceWith = rep;
	}

	public void replace()
	{
		ListIterator<String> it = list.listIterator();
		String currString = "";
		while (it.hasNext()) {
			currString = it.next();
			if (currString.equals(toRemove)) {
				it.set(replaceWith);
			}
		}
	}

	public String toString()
	{
		return list.toString()+"\n\n";
	}
}