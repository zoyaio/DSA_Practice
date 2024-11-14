package queues.basics;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalinList
{
	private Queue<String> queue;
	private Stack<String> stack;

	String[] palin;

	public PalinList()
	{

		setList("");
	}

	public PalinList(String list)
	{
		setList(list);
	}

	public void setList(String list)
	{
		queue = new LinkedList<>();
		stack = new Stack<>();
		palin = list.split(" ");
		for (String token : palin) {
			queue.add(token);
			stack.add(token);
		}
	}

	public boolean isPalin()
	{

		String q = queue.remove();
		String s = stack.pop();


			while (s.equals(q)) {
				try {
					q = queue.remove();
					s = stack.pop();
				}
				catch (Exception e) {
					break;
				}
			}

		if (stack.size() >= 2 || queue.size() >= 2) {
			return false;
		}
		return true;


	}


	//write a toString method

	@Override
	public String toString() {
		return Arrays.toString(palin);
	}
}

// keep traversing until they equal each other