package sortsearch.gradebook;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Grades
{
	private Grade[] grades;
	
	public Grades( double[] list )
	{
		this.grades = new Grade[list.length];
		for (int i = 0; i < list.length; i++) {
			grades[i] = new Grade(list[i]);
		}
	}
	
	public void setGrade(int pos, double grade)
	{
		grades[pos] = new Grade(grade);
	}
	
	public double getSum()
	{
		double sum = 0;
		for (Grade g : grades) {
			sum += g.getNumericGrade();
		}
		return sum;
	}
	
	public double getLowGrade()
	{

		double lowest = grades[0].getNumericGrade();
		for (Grade g : grades) {
			double curr = g.getNumericGrade();
			if (curr < lowest) {
				lowest = curr;
			}
		}
		return lowest;
	}
	
	public double getHighGrade()
	{
		double highest = grades[0].getNumericGrade();
		for (Grade g : grades) {
			double curr = g.getNumericGrade();
			if (curr > highest) {
				highest = curr;
			}
		}
		return highest;
	}
	
	public int getNumGrades()
	{

		return grades.length;
	}
	
	public String toString()
	{
		String ret = "";

			for (Grade g : grades) {
				ret += g.toString() + " ";
			}

		return ret;
	}	
}