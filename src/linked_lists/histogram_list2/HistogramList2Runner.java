package linked_lists.histogram_list2;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class HistogramList2Runner
{
	public static void main(String[] args)
	{
		HistoList test = new HistoList();
		String testString = "ABCDEFABCDEFFEDCBAAAAABBBBBCCCDAAAAAAAEEFFF";
		for(char c : testString.toCharArray())
		{
			test.add(c);
		}
		System.out.println(test);


		//add more test cases
		
		
		//demonstrate bad data check
		test = new HistoList();
		test.add("dog");
		test.add(33);
		test.add(3.4);
		System.out.println(test);
	}
}