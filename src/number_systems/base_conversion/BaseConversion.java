package number_systems.base_conversion;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Map;
import java.util.TreeMap;

public class BaseConversion
{
	private String number;
	private int base;
	public static Map<Integer, String> CHAR = new TreeMap<Integer, String>();

	public BaseConversion(String num, int b)
	{

		number = num;
		base =b;

		CHAR.put(10, "A");
		CHAR.put(11, "B");
		CHAR.put(12, "C");
		CHAR.put(13, "D");
		CHAR.put(14, "E");
		CHAR.put(15, "F");

	}

	public void setNumBase(String numInp, int b)
	{
		number = numInp;
		base = b;

	}


	private int convertToTen( )
	{
//		int q=number.length();
		int base10= Integer.parseInt(number,base );

		return base10;
	}

	public String getNum(int newBase)
	{

		int num = convertToTen(); // when i convert the string with letters to numbers there are problems
		// i think i need to conver to base 10 before i do any of htis
		String bin = "";
		while (num > 0) {
			int rem = (num % newBase);
			if (rem > 9) {
				bin += CHAR.get(rem);
			}
			else {
				bin += rem; // remainder
			}
			num = num / newBase;
			// need to mpa values if output greater than 9
		}
		StringBuilder input1 = new StringBuilder();

		// append a string into StringBuilder input1
		input1.append(bin);

		// reverse StringBuilder input1
		input1.reverse();
		return input1+"-"+newBase;
	}

	public String toString()
	{
		return number+"-"+base;
	}
}