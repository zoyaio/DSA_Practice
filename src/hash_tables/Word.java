package hash_tables;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word
{
	private String theValue;
	private static List<String> vowels = Arrays.asList("aeiouy".split(""));


	
	//write a constructor method
	
	public Word(String input) {
		theValue = input;
	}
	
	//write the getValue method
	
	public String getValue() {
		return theValue;
	}
	
	//write the equals method

	@Override
	public boolean equals(Object obj) {
		return theValue.equals(((Word) obj).getValue());
	}


	//write the hashCode method
	
	public int hashCode() {
		int vowel = 0;
		int letterCount =0;
		for (int i = 0; i < theValue.length(); i++) {
			if (vowels.contains(Character.toString(theValue.charAt(i))) ) {
				vowel ++;

			}
			if (Character.isLetter(theValue.charAt(i)))  {
				letterCount ++;
			}
		}
		System.out.println("v" +vowel);
		System.out.println("lc " +letterCount );
		return vowel * letterCount % 10;

	}
	
	//write the toString method
	public String toString() {
		return theValue;
	}
	
}