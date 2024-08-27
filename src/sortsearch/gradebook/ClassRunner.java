package sortsearch.gradebook;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class ClassRunner
{
   public static void main( String args[] )
   {
		java.lang.Class test = new java.lang.Class("Comp Sci 1",4);
		
		double[] stu1 = {100,90,80,60};
		test.addStudent(0,new Student("Jimmy",stu1));
		
		double[] stu2 = {100,100,80,70};
		test.addStudent(1,new Student("Sandy",stu2));
		
		double[] stu3 = {50,50,70,68,23};
		test.addStudent(2,new Student("Fred",stu3));	

		double[] stu4 = {100};
		test.addStudent(3,new Student("Sam",stu4));		
					
		out.println(test);
		
		out.println(String.format(test.getStudentName(0) + "\'s average = %.2f",test.getStudentAverage(0)));	
		out.println(String.format(test.getStudentName(1) + "\'s average = %.2f",test.getStudentAverage(1)));	
		out.println(String.format(test.getStudentName(2) + "\'s average %.2f",test.getStudentAverage(2)));	
		out.println(String.format(test.getStudentName(3) + "\'s average %.2f",test.getStudentAverage(3)));				
		
		out.println(String.format("Sandy" + "\'s average %.2f",test.getStudentAverage("Sandy")));	

		out.println("Failure List = " + test.getFailureList(70));	
		out.println("Highest Average = " + test.getStudentWithHighestAverage());
		out.println("Lowest Average = " + test.getStudentWithLowestAverage());
								
		out.println(String.format("Class Average = %.2f",test.getClassAverage()));									
	}		
}