package palin;//� A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  -

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LongPalindrome
{
	/*
	 *method getAllPalins will return an array list that contains
	 *all of the palindromes contained within word
	 *palindromes must have a minimum length of 2
	*/
	public static ArrayList<Palin> getAllPalins(String word)
	{
		// loop through each char
		// find all the palindromes that originiate from that char
		ArrayList<Palin> allPalins = new ArrayList<>();
		int len = word.length();
		for (int i = 0; i < len-1; i++ ) {
			for (int j = i; j < len; j++) {
				Palin potentialWord = new Palin(word.substring(i, j + 1));
				if (potentialWord.isPalin()) {
					allPalins.add(insertLocation(allPalins, potentialWord), potentialWord);
				}
			}

		}
		return allPalins;

	}


	/*
	*method insertLocation will look at the list and determine where to
	*put the new Palin so that the sorted order is maintained
	*/
	private static int insertLocation( ArrayList<Palin> list, Palin pal )
	{
		// orde ris lexographic .compareTo()
//		int maxInd = 0;
//		int maxVal = 0;
//		for (int i = 0; i < list.size(); i++) {
//			//go through the list, update index if its greater than value until its no longer positive
//			if (list.get(i).getWord().compareTo(pal.getWord()) <= 0) {
//				maxInd = i;
//			}
//		}
		int i = 0;
		int len = list.size();
		while ( i < len && list.get(i).getWord().compareTo(pal.getWord()) <= 0 ) {
			i++;
		}
		return i;
	}

	/*
	 *method getLongestPalin will return the longest
	 *palindrome contained within word
	 *a palindrome must a minimum length of 2
	*/
	public static Palin getLongestPalin(String word)
	{
		ArrayList<Palin> allWords = getAllPalins(word);
		int ind = 0;
		for (int i = 0; i < allWords.size(); i++) {
			if (allWords.get(i).getLength() > allWords.get(ind).getLength()) {
				ind = i;
			}
		}
		return allWords.get(ind);
	}
}