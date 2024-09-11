package sortsearch.gradebook;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.io.File;

public class GradeBookFileRunner
{
   public static void main( String args[] ) throws Exception
   {
		out.println("Welcome to the Class Stats program!");
		
//		Scanner file = new Scanner(System.in);
	   Scanner file = new Scanner(new File("src/sortsearch/gradebook/gradebook.dat"));
	   out.println("enter the class name:");
	   String className = file.nextLine();
	   out.println("enter num students: ");
		int numStudents = file.nextInt();
		file.nextLine();
		
		//make a new class

	   Class cool101 = new Class(className, numStudents);
		//read in the information for each student
	   String name;
	   int numGrades;
	   double[] grades;
		for (int i = 0; i < numStudents; i++) {
			//read in the student name
			System.out.print("Enter student name: ");
			name = file.nextLine();
			//read in the student's grades
			out.print("Enter the number of grades : ");
			numGrades = file.nextInt();
			file.nextLine();
			grades = new double[numGrades];
			for (int j = 0; j < numGrades; j ++) {
				out.print("Enter a grade: ");
				grades[j] = file.nextDouble();
//				file.nextLine();
			}
			file.nextLine();

			//add a new student to the class
			cool101.addStudent(i, new Student(name, grades));
		}
		//print out the class
	   out.println(cool101);

		
		out.println("Failure List = " + cool101.getFailureList(70));
		out.println("Highest Average = " + cool101.getStudentWithHighestAverage());
		out.println("Lowest Average = " + cool101.getStudentWithLowestAverage());

		out.println("Class average = " + cool101.getClassAverage());
	}		
}