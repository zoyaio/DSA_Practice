package linked_lists.histogram_list2;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

// does it need to be sorted??
public class HistoList
{
	private ListNode front;
	private int size;

	public HistoList( )
	{
		size = 0;
	}


	//ADDS NEW NODE TO THE FRONT OF THE LIST FOR LET IF IT DOES NOT EXIST.
	//IF IT EXISTS, IT BUMPS UP LET'S COUNT BY ONE
	public void add(Object obj)
	{
		if (size == 0) {
			front = new ListNode(new ThingCount(obj, 1), null);
		}
		else {
			int ind = indexOf(obj);
			if (ind == -1) {
				front = new ListNode(new ThingCount(obj, 1), front);
			}
			else {
				ThingCount tempThing = (ThingCount) nodeAt(ind).getValue();  // why do we have to do casting here and not in any other case
				tempThing.setCount(tempThing.getCount() +1);
			}
		}
		size ++;
	}

	//RETURNS THE INDEX POSITION OF LET IN THE LIST
	public int indexOf(Object obj)
	{
		int spot=0;
		ListNode current = front;
		while (current != null) {
			ThingCount tempThing = (ThingCount) current.getValue();
			if (tempThing.getThing().equals(obj)) {
				return spot;
			}
			spot ++;
			current = current.getNext();
		}
		return -1;
	}

	//RETURNS A REFERENCE TO THE NODE AT SPOT
	private ListNode nodeAt(int target)
	{
		int spot=0;
		ListNode current = front;
		while (current != null) {
			if (spot == target) {
				return current;
			}
			spot ++;
			current = current.getNext();
		}
		return null;
	}

	//RETURNS THE LIST AS A BIG STRING
	public String toString()
	{
		String output = "";
		ListNode current = front;
		while (current != null) {
			output += current.getValue().toString() + "   ";
			current = current.getNext();
		}
		return output;
	}
}