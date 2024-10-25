package maps.students_and_grades;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class StudentsAndGrades
{
	private Map<Integer,Set<String>> map;

	public StudentsAndGrades()
	{
		map = new TreeMap<>();
	}

	public void setStudent(String line)
	{
		String[] split =  line.split(" ");
		int grade = Integer.parseInt(split[1]);
		if (map.get(grade) == null) {
			map.put(grade, new TreeSet<>());
		}
		map.get(grade).add(split[0]);

	}


	public String getNames( Integer grade )
	{
		return map.get(grade).toString();
	}

	public String toString()
	{
		//add the map information to output
		String output="";

		for (Integer person : map.keySet()) {
			output += person + ": " + getNames(person) + "\n";
		}
		return output;
	}
}