package merge;//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class - 
//Lab  - 


public class MergeSort
{
	private static int passCount;

	public static void mergeSort(Comparable[] list)
	{


		passCount=0;
		mergeSort(list, 0, list.length);
	}

	private static void mergeSort( Comparable[] list, int front, int back) {
		for (Comparable item : list) { System.out.print(item);
		System.out.print(" ");}
		System.out.println();

		int mid = (front + back)/2;
		if (mid ==front) { return;
		}
		mergeSort(list, front, mid);
		mergeSort(list, mid, back);
		merge(list, front, back);
	}

	private static void merge(Comparable[] list, int front, int back) 	{
		Comparable[] TEMP = new Comparable[back-front];
		int i = front;
		int j = (front + back)/2;
		int k = 0;
		int mid = j;
		// pick the biggest out of both, scan all of them and mix until u reach the
		// end of one of the halves
		while (i < mid && j < back)  {
			// check this conditional
			if(list[i].compareTo(list[j]) < 0) {
				TEMP[k] = list[i]; // fix
				i++;
			}
			else {
				TEMP[k] = list[j]; //fix
				j++;
			}
			k++;
		}
		// adding all the leftover stuff to the array after you mix both of them
		while (i <mid) {
			TEMP[k] = list[i]; i++; k++; }
		while (j <back) {
			TEMP[k] = list[j];
			j++;
			k++;
		}

		for (int t = 0; t < front-back; t++) {
			list[t] = TEMP[t];
		}
	}



	}
