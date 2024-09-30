package interfaces.sort_by_vowels;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner( new File( "C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\interfaces\\sort_by_vowels\\word.dat" ) );
		List<interfaces.sort_by_vowels.Word> list = new ArrayList<interfaces.sort_by_vowels.Word>();
		
		int size = file.nextInt();

		for( int i = 0; i < size; i++ )
		{
			String s = file.nextLine();
			System.out.println(s);
			list.add(new interfaces.sort_by_vowels.Word(s));
		}
		Collections.sort(list);
		for (interfaces.sort_by_vowels.Word word : list) {
			System.out.println(word.toString());
		}



	}
}