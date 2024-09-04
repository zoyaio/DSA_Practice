package merge;//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class - 
//Lab  - 

import palin.Palin;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Arrays;		//use Arrays.toString() to help print out the array

public class MergeSort
{
	private static int passCount;

	public static void mergeSort(Comparable[] list)
	{


		passCount=0;
		mergeSort(list, 0, list.length);
	}

	private static void mergeSort( Comparable[] list, int front, int back)//O( Log N )


	{







	}

	private static void merge(Comparable[] list, int front, int back)  //O(N)
	{

		int i = 0;
		int len = list.length;
		for (Comparable currVal : list) {

			while (i < len && list[i].compareTo(currVal) <= 0 ) {
				i++;
			}
			list[i] = currVal;
		}
		return front;
	}






















	}
}