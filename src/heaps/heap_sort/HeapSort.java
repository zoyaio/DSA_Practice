package heaps.heap_sort;//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.List;
import java.util.ArrayList;

import static heaps.basics.Heap.log2;
import static java.lang.System.out;

public class HeapSort
{
	private List<Integer> list;

	public HeapSort()
	{
		list = new ArrayList<Integer>();
	}

	int computeLeftChild(int parentI) {
		return parentI * 2 + 1;
	}
	int computeRightChild(int parentI) {
		return parentI * 2 + 2;
	}

   public void swapUp(int index)
   {

	}

	public void print(List<Integer> list)
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

	}


	public void heapify(ArrayList<Integer> arr) {
		// first find the max of the list
		// then swap up repeatedly
		for (int i = arr.size(); i >= 0; i --) {
			swapDown(arr,i);
		}
		print(arr);


	}

   public void heapSort(ArrayList<Integer> nums)
   {
	   list.clear();
	   // TODO: turn into maxheap
		heapify(nums);

	   // call heapsorthelper
	   heapSortHelper(nums);

   }

	public void heapSortHelper(ArrayList<Integer> nums) {
		if (nums.size() ==1) {
			list.add(nums.get(0));
			return;
		}
		// remove top node and add it to the list (next greatest element)
		list.add(nums.get(0));
		// put bottom node at top
		nums.set(0, nums.get(nums.size() -1));
		nums.remove(nums.size() -1);

		// now reswap the list so that u find the next max in heap
		swapDown(nums,0);

		heapSortHelper(nums);


	}


	private void swap(List<Integer> list, int start, int finish)
	{
		int temp = list.get(start);
		list.set(start, list.get(finish));
		list.set(finish, temp);

	}



	public void swapDown(List<Integer> list, int top)
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
		swap(list, top, maxIndex);
		swapDown(list, maxIndex);

	}



	public String toString()
	{
		return list.toString();
	}
}