package graphs.graph_simple2;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import graphs.graph_simple.Graph;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class BiDirectionalGraphRunner
{
	public static void main( String[] args ) throws IOException
	{
		Scanner file = new Scanner(new File("C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\graphs\\graph_simple2\\bidgraph.dat"));
		int howManyTimes = file.nextInt();
		file.nextLine();

		for(int x=0; x<howManyTimes; x++)
		{
			String input = file.nextLine();
			BiDirectionalGraph test = new BiDirectionalGraph(input);
			input=file.nextLine();
			String[] inputSplit = input.split(" ");
			String start = inputSplit[0];
			String stop = inputSplit[1];

			if(test.contains(start)&&test.contains(stop))
				test.check(start,stop);

			out.println(start + " CONNECTS TO " + stop + " == " + test);
		}
	}
	}
