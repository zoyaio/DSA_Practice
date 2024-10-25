package number_systems.base_conversion;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import static java.lang.System.*;

public class BaseRunner
{
	public static void main ( String[] args )
	{
		BaseConversion test = new BaseConversion("10",10);
		System.out.println(test + " == " +test.getNum(2)+"\n\n");

		test.setNumBase("AB",16);
		System.out.println(test + " == " +test.getNum(10)+"\n\n");

		test.setNumBase("345",6);
		System.out.println(test + " == " +test.getNum(4)+"\n\n");

		test.setNumBase("25",10);
		System.out.println(test + " == " +test.getNum(2)+"\n\n");

		test.setNumBase("127",10);
		System.out.println(test + " == " +test.getNum(16)+"\n\n");

		test.setNumBase("1024",7);
		System.out.println(test + " == " +test.getNum(16)+"\n\n");

		test.setNumBase("97342",10);
		System.out.println(test + " == " +test.getNum(16)+"\n\n");

		test.setNumBase("1010010010001001",2);
		System.out.println(test + " == " +test.getNum(16)+"\n\n");
	}
}