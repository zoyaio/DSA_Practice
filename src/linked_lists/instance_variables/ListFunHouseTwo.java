package linked_lists.instance_variables;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class ListFunHouseTwo
{
	private ListNode theList;
	
	public ListFunHouseTwo()
	{
		theList = new ListNode(0, null);
	}
	
	public void add(Comparable data)
	{
		if (theList == null) {
			theList = new ListNode(data, null);
		}
		else {
			theList = new ListNode(data, theList);
		}

	}
	
	//this method will return the number of nodes present in list
	public int nodeCount()
	{
		int count=0;
		ListNode x = theList;
		while (x != null) {
			count ++;
			x = x.getNext();
		}
		return count;
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node at the front of the list.  Once finished, the first node will occur twice.
	public void doubleFirst()
	{
		ListNode x = theList;
		while (x!= null) {
			ListNode temp = x.getNext();
			if (temp == null) {
				x.setNext(new ListNode(x.getValue(), null));
			}
			x = temp;
		}
				
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public void doubleLast()
	{
		theList.setNext(new ListNode(theList.getValue(), theList.getNext()));



	}
	

	//this method will set the value of every xth node in the list
	public void setXthNode(int x, Comparable value)
	{

		int count=1;

		ListNode front = theList;
		while (front!= null) {
			if (count % x == 0){

				front.setValue(value);
			}
			front = front.getNext();
			count ++;

		}

	
	}	

	//this method will remove every xth node in the list
	public void removeXthNode(int x) {

		int count = 1;

		ListNode front = theList;
		ListNode prev = theList;
		while (front != null) {
			if (count % x == 0) {
				prev.setNext(front.getNext());
			}
			prev = front;
			front = front.getNext();
			count++;


		}
	}
	//this method will return a String containing the entire list
   public String toString()
   {
   	String output="";

	ListNode x = theList;
		while (x != null) {
			output += x.getValue() + " ";
			x = x.getNext();
		}


   	return output;
   }			
	
}