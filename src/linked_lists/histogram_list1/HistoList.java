package linked_lists.histogram_list1;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import linked_lists.parameters.ListNode;

public class HistoList
{
   private HistoNode front;

	public HistoList( )
	{
		front = null;
	}

	//addLetter will add a new node to the front for let if let does not exist
	//addLetter will bump up the count if let already exists
	public void addLetter(char let)
	{
		// if indexOf = -1 {add it}
		// if not get nodeAt.getValue.setValue

		int loc = indexOf(let);
		if (loc == -1) {
			front = new HistoNode(let, 1, front);
		}
		else {
			HistoNode x = nodeAt(loc);
			x.setLetterCount(x.getLetterCount() + 1);
		}
	}

	//returns the index pos of let in the list if let exists
	// BHOW DOES INDEXING WORK IN LINKEDLISTS--im gonna assume that 0 = end of list
	public int indexOf(char let)
	{
		int index = 0;
		HistoNode x = front;
		while (x != null){
			if (x.getLetter() == let) {
				return index;
			}
			index ++;
			x = x.getNext();
		}

		return -1;
	}

	//returns a reference to the node at spot
	private HistoNode nodeAt(int spot)
	{
//		HistoNode current=null;


		int index = 0;
		HistoNode x = front;
		while (x != null){
			if (spot == index ) {
				return x;
			}
			index ++;
			x = x.getNext();
		}

		return null;
	}

	//returns a string will all values from list
	public String toString()
	{
		String output = "";

		HistoNode x = front;
		while (x != null){
			output += x.getLetter() + " - " + x.getLetterCount() + "    ";
			x = x.getNext();
		}


		return output;
	}
}