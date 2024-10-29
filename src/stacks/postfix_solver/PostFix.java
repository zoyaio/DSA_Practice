package stacks.postfix_solver;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PostFix
{
	private Stack<Double> stack;
	private String exp;

	private List<String> expressionList;

	public List<Character> ops;

	public PostFix()
	{
		stack = new Stack<>();
		ops = new ArrayList<>();
		ops.add('+');
		ops.add('-');
		ops.add('/');
		ops.add('*');
	}

	public PostFix(String exp)
	{
		this();
		setExpression(exp);
	}

	public void setExpression(String s)
	{
		exp = s;
		expressionList = Arrays.asList(exp.split(" "));
//		solve();

	}

	public double calc(double one, double two, char op)
	{
		System.out.println(one +  " " + op + " " + two );
		switch (op) {
			case '+' -> {
				return one + two;
			}
			case '-' -> {
				return two - one;
			}
			case '*' -> {
				return one * two;
			}
			case '/' -> {
				return two / one;
			}
		}

		return 0.0;
	}

	public void solve()
	{
		while (expressionList.size() > 0) {
			// shrinken
			char current = expressionList.get(0).charAt(0);
			expressionList = expressionList.subList(1, expressionList.size());

			if (ops.contains(current)) {
				stack.add(calc(stack.pop(), stack.pop(), current));

			}
			else {
//				System.out.println("h: " + current);
				stack.push(Double.parseDouble(current + ""));
			}

		}

	}

	public static void main(String[] args) {
		PostFix pp = new PostFix("7 8 + 2 -");
		pp.solve();
	}

	@Override
	public String toString() {
		return exp + " == " + stack.peek();
	}
}



// when u get to the expression, pop the last two and then add the result