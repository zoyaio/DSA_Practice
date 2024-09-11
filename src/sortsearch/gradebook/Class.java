package sortsearch.gradebook;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;
import java.util.Arrays;

public class Class
{
	private String name;
	private Student[] studentList;
	
	public Class()
	{
		name = "";
		studentList = new Student[0];
	}
	
	public Class(String name, int stuCount)
	{
		this.name = name;
		studentList = new Student[stuCount];
	}
	
	public void addStudent(int stuNum, Student s)
	{
		studentList[stuNum] = s;
	}
	
	public String getClassName()
	{
	   return name;
	}
	
	public double getStudentAverage(int stuNum)
	{
		return studentList[stuNum].getAverage();
	}

	public double getStudentAverage(String stuName)
	{
		int stuNum = 0;
		for (int i = 0; i < studentList.length; i++) {
			stuNum = i;
			if (getStudentName(i).equals(stuName)) {
				break;
			}
		}
		return studentList[stuNum].getAverage();
	}
	
	public String getStudentName(int stuNum)
	{
		return studentList[stuNum].getName();
	}
		
	public double getClassAverage()
	{
		double sum = 0;
		for (int i = 0; i < studentList.length; i++) {
			sum += getStudentAverage(i);
		}
		return sum / studentList.length;
	}

	public String getStudentWithHighestAverage()
	{
		int stuNum = 0;
		double maxAvg = 0;
		for (int i = 0; i < studentList.length; i++) {
			if (getStudentAverage(i) > maxAvg) {
				stuNum = i;
				maxAvg = getStudentAverage(i);
			}
		}
		return getStudentName(stuNum);
	}

	public String getStudentWithLowestAverage()
	{
		int stuNum = 0;
		double minAvg = getStudentAverage(0);
		for (int i = 0; i < studentList.length; i++) {
			if (getStudentAverage(i) < minAvg) {
				stuNum = i;
				minAvg = getStudentAverage(i);
			}
		}
		return getStudentName(stuNum);
	}

	// bro what is this
	public String getFailureList(double failingGrade)
	{
		String ret = "";
		for (int i = 0; i < studentList.length; i++) {
			if (getStudentAverage(i) <= failingGrade) {
				ret += getStudentName(i) + " ";
			}
		}
		return ret;

	}
	
	public String toString()
	{
		String ret = getClassName() + "\n";
		for (Student stu : studentList) {
			ret += stu.toString() + "\n";
		}
		return ret;
	}  	
}