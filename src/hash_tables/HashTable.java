package hash_tables;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.LinkedList;

public class HashTable
{
	private LinkedList[] table;

	public HashTable( )
	{
		table = new LinkedList[10];
	}

	public void add(Object obj)
	{
		System.out.println("add");
		int i = obj.hashCode();
		LinkedList linked = table[i];
		if (linked == null) {
			table[i] = new LinkedList();

		}
		// need to get rid of duplicates
		if (!table[i].contains(obj)) {
			table[i].add(obj);
		}




	}

	public String toString()
	{
		String output="HASHTABLE\n";
		for (LinkedList ll : table) {
			String temp = "";
			if (ll != null) {
				temp = ll.toString();
			}
			output += "bucket " + temp + "\n";
		}

		return output;
	}
}