package heaps.heap_sort;//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSortRunner
{
	public static void main ( String[] args )
	{
		HeapSort heap = new HeapSort();

		int[] nums = {99,2,8,75,10,7,9,17,5,3,4,1,11,1};
		ArrayList<Integer> numList = new ArrayList<>();
		for (int num : nums) {
			numList.add(num);
		}

		heap.heapSort(numList);

		System.out.println(heap);

		heap = new HeapSort();

		numList.clear();
		int[] stuff = {-3,28,18,5,3,17,29,6,5,3,4,1,11,1};
		for (int num : stuff) {
			numList.add(num);
		}
		heap.heapSort(numList);

		System.out.println(heap);
	}
}