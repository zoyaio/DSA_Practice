package stacks.basics;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
// why does the toStrng not work?
import java.util.Stack;

public class StackTest
{
	private Stack<String> stack;

	public StackTest()
	{
		stack = new Stack<String>();
		setStack("");
	}

	public StackTest(String line)
	{
		stack = new Stack<String>();
		setStack(line);
	}

	public void setStack(String line)
	{

		String[] chars = line.split(" ");
		for (String c : chars) {
			stack.push(c);
		}
		System.out.println(stack.toString());
	}

	public void popEmAll()
	{
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	//add a toString
}