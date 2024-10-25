package number_systems.binary_sorter;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class NumberRunner
{
	public static void main ( String[] args ) throws IOException
	{
		ArrayList<Number> numList = new ArrayList<Number>();

		Scanner file = new Scanner(new File("C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\number_systems\\binary_sorter\\number.dat"));

		int runs = file.nextInt();
		file.nextLine();
		for(int i=0; i<runs;i++)
		{
			String num = file.next();
			int base = file.nextInt();
			numList.add(new Number(num,base));
		}

		Collections.sort(numList);

		for(Number n : numList)
		{
			out.println(n);
		}
	}
}