package sets.union_int_diff;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import sets.odds_evens.OddEvenSets;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MathSetRunner
{
	public static void main(String args[]) throws IOException
	{
		Scanner file = new Scanner( new File("C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\sets\\union_int_diff\\mathsetdata.dat"));
		while (file.hasNextLine()) {
			MathSet set = new MathSet(file.nextLine(), file.nextLine());
			System.out.println(set);
		}
	}
}
