package interfaces.sort_by_vowels;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s)
	{
		word = s;

	}

	private int numVowels(String s)
	{
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		for (int i = 0; i < s.length(); i++) {
			if( vowels.contains(("" + s.charAt(i))) ){
				vowelCount ++;
			}
		}

		return vowelCount;
	}

	public int compareTo(Word rhs)
	{
		int rhsNum = numVowels(rhs.toString());
		int num = numVowels(word);
		if (rhsNum == num) {
			return word.compareTo(rhs.toString());
		}
		return rhsNum < num ? 1 : -1;
	}

	public String toString()
	{
		return word;
	}
}