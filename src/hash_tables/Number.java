package hash_tables;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class Number
{
	private int theValue;
	
	public Number(int value)
	{
		theValue = value;

	}	
	
	public int getValue()
	{
		return theValue;
	}
	
	public boolean equals(Object obj)
	{
		return false;
	} 
	
	public int hashCode()
	{
		return theValue % 10;
	}

	public String toString()
	{
		return hashCode() + ": " + theValue;
	}	
}