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
		for (int i = 1; i < len-1; i++ ) {
			// get string with that index as the center
			int padLength = i;
			if (i >= (int) Math.round(len/2.0)) {
				padLength = len-i-1;
			}
			// passes in lists of odd length
			ArrayList<Palin> res = getAllPalinsFromChar(word.substring(i-padLength,i + padLength + 1));
//			ArrayList<Palin> res2 = getAllPalinsFromChar(word.substring(i-padLength,i+ padLength));
		}
		return allPalins;

	}

	public static ArrayList<Palin> getAllPalinsFromChar(String word) {

		if (word.length() < 2) {
			return new ArrayList<Palin>();
		}

		ArrayList<Palin> arr = LongPalindrome.getAllPalinsFromChar(word.substring(1, word.length() - 1));
		Palin wordPal = new Palin(word);
		if (wordPal.isPalin()) {
			arr.add(wordPal);
		}
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(LongPalindrome.getAllPalinsFromChar("aboba"));
	}

	/*
	*method insertLocation will look at the list and determine where to
	*put the new Palin so that the sorted order is maintained
	*/
	private static int insertLocation( ArrayList<Palin> list, Palin pal )
	{
		return 0;
	}

	/*
	 *method getLongestPalin will return the longest
	 *palindrome contained within word
	 *a palindrome must a minimum length of 2
	*/
	public static Palin getLongestPalin(String word)
	{
		return null;
	}
}