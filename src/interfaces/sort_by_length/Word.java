package interfaces.sort_by_length;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s )
	{
		word = s;
	}

	public int compareTo( Word rhs )
	{
		if (rhs.toString().length() == word.length()) {
			return word.compareTo(rhs.toString());
		}
		return rhs.toString().length() < word.toString().length() ? 1 : -1;
	}

	public String toString()
	{
		return word;
	}
}