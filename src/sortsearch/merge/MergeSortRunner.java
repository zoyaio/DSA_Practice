package sortsearch.merge;//� A+ Computer Science  -  www.apluscompsci.com
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import static java.lang.System.*;
import java.util.Arrays;		//use Arrays.toString() to help print out the array

public class MergeSortRunner
{
	public static void main(String args[])
	{
		//9 5 3 2
		//19 52 3 2 7 21
		//68 66 11 2 42 31

		MergeSort.mergeSort(new Comparable[]{9,5,3,2});
		out.println("\n\n");

		MergeSort.mergeSort(new Comparable[]{19,52,3,2,7,21});
		out.println("\n\n");

		MergeSort.mergeSort(new Comparable[]{68,66,11,2,42,31});
		out.println("\n\n");
	}
}