package heaps.basics;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.List;
import java.util.ArrayList;
import static java.lang.System.*;

public class Heap
{
	private List<Integer> list;

	public Heap()
	{
		list = new ArrayList<Integer>();
	}

	public void add(int value)
	{
		list.add(value);
		swapUp(list.size()-1); // keep recalling nad hceckngi parent
	}

	int computeParentIndex(int childI) {

	if (childI % 2 == 1) {
		return (childI - 1)/2;
	}
	else {
		return (childI - 2 )/2;
	}
	}
	int computeCorrectChildIndex(int parentI) {
		int leftChildi = computeLeftChild(parentI);
		if (leftChildi > list.size() - 1) {
			return leftChildi;
		}
		else {
			return computeRightChild(parentI);
		}
	}

	int computeLeftChild(int parentI) {
		return parentI * 2 + 1;
	}
	int computeRightChild(int parentI) {
		return parentI * 2 + 2;
	}

   public void swapUp(int bot)
   {
	   int parentIndex = bot == 0 ? 0 : computeParentIndex(bot);	   // bot = i* 2 + 2 --> (bot - 2)/2 =  i

//	   out.println(parentIndex);
	   if (list.get(parentIndex) >= list.get(bot)) {
		   return;
	   }
	   swap(parentIndex, bot);
	   swapUp(parentIndex);
	}

	public void remove( )
	{
		list.set(0,list.get(list.size()-1));
		list.remove(list.size()-1);
		swapDown(0);
	}

	public void swapDown(int top)
	{
		// check between left and rigth which one is bigger
		// compare that to teh top
		int leftI = computeLeftChild(top);
		int rightI = computeRightChild(top);
		if (leftI > list.size() -1 ) {
			return;
		}
		int maxIndex;
		if (rightI > list.size() -1) {
			maxIndex = leftI;
		}
		else {
			maxIndex = list.get(leftI) >= list.get(rightI) ? leftI : rightI;
		}
		// if left index out of range, then rihgt will be as well

		if (list.get(maxIndex) <= list.get(top)) {
			return;
		}
		// swap
		swap(top, maxIndex);
		swapDown(maxIndex);

	}
	
	private void swap(int start, int finish)
	{
		int temp = list.get(start);
		list.set(start, list.get(finish));
		list.set(finish, temp);

	}

	public static int log2(int n){
		if(n <= 0) throw new IllegalArgumentException();
		return 31 - Integer.numberOfLeadingZeros(n);
	}

	public void print()
	{
		out.println("\n\nPRINTING THE HEAP!\n\n");
		int prev = 0;
		out.print(list.get(0));
		for (int i = 1; i < list.size(); i ++) {
			if (prev != log2(i + 1)){
				prev ++;
				out.println();
			}
			out.print(list.get(i) + " ");
		}
		out.println();
//		out.println(list.toString());

//		2 ^ n = i

	}

	public String toString()
	{
		return list.toString();
	}
}