package number_systems.binary_sorter;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class Number implements Comparable<Number>
{

	//add in instance variables
	String num;
	int base ;
	String numBinary = "";
	int numOnes;
	int numBase10;

	int numOGbase;
	//add in a constructor or two

	public Number (String num, int base) {
		this.num = num;
		this.base = base;

		numBase10 = Integer.parseInt(num, base);

		numBinary = Integer.toString(numBase10, 2);
		numOnes = numBinary.length() - numBinary.replace("1", "").length();

		numOGbase = Integer.parseInt(num);
	}

	public int compareTo(Number param)
	{
		// num1s = string.counts(1)
		// if this > param num1s {return pos}
		if (this.getNumOnes() > param.getNumOnes()) {
			return 1;
		}
		// if this < param num1s {return neg}
		else if (this.getNumOnes() < param.getNumOnes()) {
			return -1;
		}
		// else:
		else {
			// sort by base 10 val
			int res = Integer.compare(numBase10, param.numBase10);
			if (res == 0) {
				// sort by value in og base
				res = Integer.compare(numOGbase, param.numOGbase);
			}

			return res;
		}

	}
	public int getNumOnes() {
		return numOnes;
	}
	public String toString( )
	{
//	  return original, base 10, binary;
		return "og: " + num + " base10: " + numBase10 + " binary: " + numBinary;
	}

}