package stacks.syntax_checker;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class SyntaxChecker
{
	private String exp;
	public Stack<Character> symbols;

	private Map<Character, Character> openToClose;

	public SyntaxChecker()
	{
		symbols = new Stack<>();
		openToClose = new TreeMap<>();
		openToClose.put('{', '}');
		openToClose.put('(', ')');
		openToClose.put('[', ']');
		openToClose.put('<', '>');
	}

	public SyntaxChecker(String s)
	{
		this();

		setExpression(s);

	}
	
	public void setExpression(String s)
	{
		exp = s;
		for (int i = (s.length() - 1); i >= 0; i --) {
			symbols.add(s.charAt(i));
		}

		System.out.println(symbols.size());


	}

	public boolean checkExpression()
	{
		System.out.println(symbols.size());
		while (!symbols.empty()) {
			System.out.println("hi");
			char symb = symbols.pop();
			// so the problem is that its calling this on the closing symbol? i think
			System.out.println("symb " + symb);
			if (openToClose.containsKey(symb)) {
				if (!checkExpression(symb)){
					return false;
				}
			}
			if (openToClose.containsValue(symb)) {

				return false;
			}
		}
		System.out.println("out");
		return true;
	}
	//problem: it should only be skipping like it is rn if its an opening syntax

	public boolean checkExpression(char sym) {
		// looking for the closing expression.

		char currSym;
		try{

			currSym = symbols.pop();
			System.out.println("hi2 " + currSym );
		}
		catch (Exception e) {
			System.out.println("Sad");
			return false;
		}
		// keep parsing input one by one
		// if an opening symbol is read, recall the fucntion
		// basecase: closing symbol is read
		// --> if it matches the symbol to look for then return true, if not return false = valid
		if (isSymbol(currSym)) {
			// if its an open symbol
			if (openToClose.containsKey(currSym)){
				System.out.println("yasssa: " + sym);
				boolean c = checkExpression(currSym);
				if (!c) {
					return false;
				}
				else {
					return checkClosed(symbols.pop(), sym);
				}

			}
			// if it's a close symbol
			else {
				return checkClosed(currSym, sym);
			}
		}
		else{
			return checkExpression(sym);
		}


	}

	boolean checkClosed(char currSym, char sym) {
		System.out.println("current state " + symbols);
		char symbolToLookFor;
		try {
			symbolToLookFor = openToClose.get(sym);
		}
		catch (Exception e) {
			System.out.println("toLook: " + sym);
			symbolToLookFor = '*';
		}
		// if it's the right close symbol
		// if it's wrong
		System.out.println("Verdit " + (currSym == symbolToLookFor) + currSym + symbolToLookFor);
		return currSym == symbolToLookFor;
	}

	boolean isSymbol(char symb) {
		return (openToClose.containsKey(symb) || openToClose.containsValue(symb));
	}

	public static void main(String[] args) {
		SyntaxChecker s = new SyntaxChecker("car(zyx(h)(j))");
		System.out.println(s.checkExpression());
	}



	@Override
	public String toString() {
		return exp + " is " + checkExpression();
	}
}

// when read in a closing bracket,
// keep popping elements out of it until it reaches a closing bracket (lookoing ofr the same symbol
