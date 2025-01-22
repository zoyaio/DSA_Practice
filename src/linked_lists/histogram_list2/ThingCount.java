package linked_lists.histogram_list2;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class ThingCount implements Comparable
{
	private int count;
	private Object thing;
	
	public ThingCount()
	{
	}
	
	public ThingCount(Object thang, int cnt)
	{
		count = cnt;
		thing = thang;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void setCount(int cnt)
	{
		count = cnt;
	}

	public void setThing(Object obj)
	{
		thing = obj;
	}	
	
	public Object getThing()
	{
		return thing;
	}
	
	public boolean equals(Object obj)
	{
		ThingCount other = (ThingCount)obj;
		return other.getThing().equals(this.getThing()) && other.getCount() == this.getCount();
	}

	// wait everything should alreayd be comparable;
	public int compareTo(Object obj)
	{
		Comparable otherThing = (Comparable) ((ThingCount) obj).getThing() ;

		Comparable thisThing = (Comparable) this.getThing();

		return thisThing.compareTo(otherThing);

	}
	
	public String toString()
	{
		return ""+ getThing() + " - " + getCount();
	}


}
