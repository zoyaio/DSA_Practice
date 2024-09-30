package sets.uniques_dups;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import sets.odds_evens.OddEvenSets;

import java.io.File;
import java.util.Scanner;
import java.util.Set;

public class DupRunner
{
	public static void main( String args[] )
	{
		String[] testcases = {"a b c d e f g h a b c d e f g h i j k","one two three one two three six seven one two", "1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6"};
		for (String test : testcases) {
			Set[] output = UniquesDupes.getBoth(test);
			System.out.println("Original List: " + test);
			System.out.println("Uniques Set: " + output[0].toString());
			System.out.println("Dups Set: " + output[1].toString());
		}
//		System.out.println("6".compareTo("A"));
	}
}