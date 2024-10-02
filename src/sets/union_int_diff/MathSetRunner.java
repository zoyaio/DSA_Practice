package sets.union_int_diff;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import sets.odds_evens.OddEvenSets;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class MathSetRunner
{
	public static void main(String args[]) throws IOException
	{
		Scanner file = new Scanner( new File("C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\sets\\union_int_diff\\mathsetdata.dat"));
		for (int i =0; i< 3; i++) {
			MathSet set = new MathSet(file.nextLine(), file.nextLine());

			Set<Integer> u = set.union();
			System.out.println("union: " + u);
			Set<Integer> iii = set.intersection();
			System.out.println("intersect: " + iii);
			Set<Integer> ab = set.differenceAMinusB();
			System.out.println("a-b: "+ ab);
			Set<Integer> ba = set.differenceBMinusA();
			System.out.println("b-a: " + ba);
			Set<Integer> sd  =set.symmetricDifference();
			System.out.println("sd: " + sd );
			System.out.println("\n\n");


		}
	}
}
