package linked_lists.parameters;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.List;

public class ListFunHouse
{
	//this method will print the entire list on the screen
   public static void print(ListNode list)
   {
	   ListNode x = list;
	   while (x != null) {
		   System.out.println(x.getValue());
		   x = x.getNext();
	   }
   }		
	
	//this method will return the number of nodes present in list
	public static int nodeCount(ListNode list)
	{
   		int count=0;
		ListNode x = list;
		while (x != null) {
			count ++;
			x = x.getNext();
		}
		return count;
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node to the list.  Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list)
	{
		ListNode x = list;
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
	public static void doubleLast(ListNode list)
	{

//		ListNode prev = new ListNode(list.getValue(), list);
//		list = new ListNode(list.getValue(), list);

		list.setNext(new ListNode(list.getValue(), list.getNext()));
	}

		
	//method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list)
	{
		ListNode x = list;
		while (x!= null) {
			ListNode temp = x.getNext();
			x.setNext(temp.getNext());
			x = temp.getNext();
		}

	}

	//this method will set the value of every xth node in the list
	public static void setXthNode(ListNode list, int x, Comparable value)
	{

		int count=0;

		ListNode z = list;
		while (z!= null) {
			if (count % x == 0){
				list.setValue(z);
			}
//
			z = z.getNext();
			count ++;

		}


	}	

	//this method will remove every xth node in the list
	public static void removeXthNode(ListNode list, int x)
	{
		int count=1;
	}		
}