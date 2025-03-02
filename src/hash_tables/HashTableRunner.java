package hash_tables;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.io.File;
import java.util.Scanner;

public class HashTableRunner
{
  public static void main ( String[] args )
  {
		try{
			//make a new table			
			HashTable shredded = new HashTable();
			//read from the file			
			Scanner scannie = new Scanner(new File("C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\hash_tables\\words.dat"));
			//load stuff into the table
			int numEntries = scannie.nextInt();
			scannie.nextLine();
			for (int i = 0; i < numEntries -1; i++) {
				String value = scannie.next();
				shredded.add(new Word(value));
				scannie.nextLine();
			}

			//print out the table
			System.out.println(shredded.toString());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
  }
}