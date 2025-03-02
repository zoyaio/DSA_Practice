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
		Number num = (Number) obj;
		return theValue == num.getValue() && hashCode() == num.hashCode();
	} 
	
	public int hashCode()
	{
		return theValue % 10;
	}

	public String toString()
	{
		return ""+ theValue;
	}	
}