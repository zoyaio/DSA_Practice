package number_systems.ASCII_to_binary;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class Convert
{
	private String sentence;
	private String binary;

	public Convert()
	{

	sentence = "";
	binary = "";

	}

	public Convert(String sentence)
	{
	this.sentence = sentence;
	binary = "";

	}

	public void convert()
	{
		for (int i = 0; i < sentence.length(); i++) {
			char let = sentence.charAt(i);
			int num = let;
			int count = 0;
			int bin = 0;
			while (num > 0) {
				bin += (num % 2) * (Math.pow(10, count)); // remainder
				num = num / 2;
				count++;
			}

			binary += String.format("%08d", bin) + " ";
		}

	}

	public String toString()
	{
		return binary;
	}
}