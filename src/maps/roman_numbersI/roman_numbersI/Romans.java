package maps.roman_numbersI.roman_numbersI;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Map;
import java.util.TreeMap;

public class Romans
{
	private Map<String, Integer> m;
	
	public Romans()
	{
		m = new TreeMap<String, Integer>();
		
		/*
			Symbol	I	V	X		L		C		D		M
			Value		1	5	10		50		100	500	1000
		*/
		m.put("I", 1);
		m.put("V", 5);
		m.put("X", 10);
		m.put("L", 50);
		m.put("C", 100);
		m.put("D", 500);
		m.put("M", 1000);
		

		//TODO 1: Add the key, value pairs based on the table above.

	}


	public int getNumber( String s )
	{
		//TODO 2: Implement this method correctly.
		return m.get(s);
	}

}