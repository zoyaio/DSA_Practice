package sets.uniques_dups;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UniquesDupes
{
	public static Set<String> getUniques(String input)
	{
		Set<String> uniques = new TreeSet<String>();

		//add code

		return uniques;
	}

	public static Set<String> getDupes(String input)
	{
		//add code
		
		return null;
	}

	public static Set[] getBoth(String input) {
		Scanner scannie = new Scanner(input);
		Set<String> uniques = new TreeSet<String>();
		Set<String> dupes = new TreeSet<String>();
		while (scannie.hasNext()) {
			String i = scannie.next();
			boolean success = uniques.add(i);
			if (!success) {
				dupes.add(i);
			}

		}
		return new Set[]{uniques, dupes}; // why an error when I specify the type

	}
}