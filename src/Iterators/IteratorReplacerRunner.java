package Iterators;//(c) A+ Computer Science
//www.apluscompsci.com

public class IteratorReplacerRunner
{
	public static void main ( String[] args )
	{
		IteratorReplacer test = new IteratorReplacer("a b c a b c","a","+");
		test.replace();
		System.out.println(test);

		test.setTest("a b c d e f g h i j x x x x","x","7");
		test.replace();
		System.out.println(test);

		test.setTest("1 2 3 4 5 6 a b c a b c","b","#");
		test.replace();
		System.out.println(test);
	}
}