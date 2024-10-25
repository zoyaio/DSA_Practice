package maps.roman_numbersII;
//www.apluscompsci.com
//Name -

import java.util.Map;
import java.util.TreeMap;

public class RomansII
{
	private Map<String, Integer> m;
	
	public RomansII ()
	{
		//TODO 1: Copy your constructor from the last lab.

		m = new TreeMap<>();
		m.put("I", 1);
		m.put("V", 5);
		m.put("X", 10);
		m.put("L", 50);
		m.put("C", 100);
		m.put("D", 500);
		m.put("M", 1000);
	}


	public int getNumber( String s )
	{
		/*
		 * TODO 2: Implement this method correctly so that it will
		 *  return the sum of all of the roman numerals on a single line.
		 */
		int sum =0;
		for (String roman : s.split(" ")) {
			sum += m.get(roman);
		}
		return sum;
	}

}