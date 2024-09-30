package sets.union_int_diff;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.beans.Introspector;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MathSet
{
	private Set<Integer> one;
	private Set<Integer> two;

	public MathSet()
	{
		one = new TreeSet<>();
		two = new TreeSet<>();
	}

	public MathSet(String o, String t)
	{
		this();
		Scanner scan = new Scanner(o);
		while (scan.hasNextInt()) {
			one.add(scan.nextInt());
		}
		scan = new Scanner(t);
		while (scan.hasNextInt()) {
			two.add(scan.nextInt());
		}
	}

	public Set<Integer> union()
	{
		Set<Integer> temp = new TreeSet<>();
		for (Integer i : one ) {
			temp.add(i);
		}
		for (Integer i : two ) {
			temp.add(i);
		}

		return temp;

	}
	private void attemptAdd(Integer item,Set<Integer> set) {
		// adds it, then removes it if it already exists
		if (!set.add(item)) {
			set.remove(item);
		}
	}

	public Set<Integer> intersection()
	{
		Set<Integer> intersec = new TreeSet<>();
		for (Integer i : one ) {
			if (two.contains(i)) {
				intersec.add(i);
			}
		}
		for (Integer i : two ) {
			if (one.contains(i)) {
				intersec.add(i);
			}
		}

		return intersec;

	}

	public Set<Integer> differenceAMinusB()
	{
		Set<Integer> diff = new TreeSet<>();
		// if trying to add that element from a into b yields true, it means its unqiue
		for (Integer i : one ) {
			if (!two.contains(i)) {
				diff.add(i);
			}
		}
		return diff;


	}

	public Set<Integer> differenceBMinusA()
	{
		Set<Integer> diff = new TreeSet<>();
		// if trying to add that element from a into b yields true, it means its unqiue
		for (Integer i : two ) {
			if (!one.contains(i)) {
				diff.add(i);
			}
		}
		return diff;
	}
	
	public Set<Integer> symmetricDifference()
	{
		Set<Integer> intersec = new TreeSet<>();
		for (Integer i : one ) {
			attemptAdd(i, intersec);
		}
		for (Integer i : two ) {
			attemptAdd(i, intersec);
		}

		return intersec;
	}	
	
	public String toString()
	{
		return "Set one " + one + "\n" +	"Set two " + two +  "\n";
	}
}