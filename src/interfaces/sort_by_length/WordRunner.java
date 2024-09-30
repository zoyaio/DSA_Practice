package interfaces.sort_by_length;//(c) A+ Computer Science
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
		//Scan the file - change with absolute file path
		Scanner file = new Scanner( new File("C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\interfaces\\sort_by_length\\words.dat") );

		List<interfaces.sort_by_length.Word> list = new ArrayList<interfaces.sort_by_length.Word>();

		//Get the file size
		int size = file.nextInt();

		//TODO: Finish this to collect the data and print the results
		for( int i = 0; i < size; i++ )
		{
			String s = file.nextLine();
			System.out.println(s);
			list.add(new interfaces.sort_by_length.Word(s));
		}
		Collections.sort(list);
		for (Word word : list) {
			System.out.println(word.toString());
		}
	}
}