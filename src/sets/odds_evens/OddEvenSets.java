package sets.odds_evens;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class OddEvenSets
{
	private Set<Integer> odds;
	private Set<Integer> evens;

	public OddEvenSets()
	{
		odds = new HashSet<Integer>();
		evens = new HashSet<>();
	}

	public OddEvenSets(String line)
	{
		this();
		Scanner scan = new Scanner(line);
		while (scan.hasNextInt()) {
			int temp = scan.nextInt();
			if (temp % 2 == 0) {
				evens.add(temp);
			}
			else {
				odds.add(temp);
			}
	}
	}

	public String toString()
	{
		return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
	}
}