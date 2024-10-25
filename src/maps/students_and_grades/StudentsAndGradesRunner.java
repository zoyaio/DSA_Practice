package maps.students_and_grades;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class StudentsAndGradesRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\maps\\students_and_grades\\students.dat"));

		StudentsAndGrades test = new StudentsAndGrades();

		int num = file.nextInt();
		file.nextLine();
		for(int x = 0; x < num; x++)
		{
			test.setStudent(file.nextLine());
		}

		out.println(test);

		//String person = file.next();
		//out.println(person+" is related to "+test.getNames(person));
	}
}