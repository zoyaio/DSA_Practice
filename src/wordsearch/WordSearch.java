package wordsearch;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.*;
import java.util.Arrays;

public class WordSearch
{
    private String[][] m;
	int size;

    public WordSearch( int size, String str )
    {
		this.size = size;
		m = new String[size][size];
		for (int row = 0; row < size; row ++) {
			for (int col =0; col < size; col++){
				int ind = row * (size) + col;
				m[row][col] = str.substring(ind, ind +1);
			}
		}
    }

    public boolean isFound( String word )
    {
		for (int row = 0; row < size; row ++) {
			for (int col =0; col < size; col++){

				if (
						checkRight(word, row, col) || checkLeft(word, row, col) || checkUp(word, row, col)
								|| checkDown(word, row, col) || checkDiagUpRight(word, row, col) ||
								checkDiagUpLeft(word, row, col) || checkDiagDownLeft(word, row, col) ||
								checkDiagDownRight(word, row, col)
				) {

					return true;

				}
			}
		}
		return false;

    }

	public boolean checkRight(String w, int r, int c)
   {
		try {
			int len = w.length();
			if (String.join("",Arrays.copyOfRange(m[r], c, c+len)).equals(w)){
				return true;
			}
			return false;
		}
		catch (RuntimeException e) {
			return false;
		}
	}

	public boolean checkLeft(String w, int r, int c)
	{
		try {
			int len = w.length();
			String testWord = String.join("",Arrays.copyOfRange(m[r], c-len +1, c+1));

			if (new StringBuffer(testWord).reverse().toString().equals(w)){
				return true;
			}
			return false;
		}
		catch (RuntimeException e) {
			return false;
		}
	}

	public boolean checkUp(String w, int r, int c)
	{
		try {
			String out ="";
			for (int d = 0; d < w.length(); d++) {
				out += m[r-d][c];
			}
			if (out.equals(w)){
				return true;
			}
			return false;
		}
		catch (RuntimeException e) {
			return false;
		}
	}

	public boolean checkDown(String w, int r, int c)
   {
	   try {
		   String out ="";
		   for (int d = 0; d < w.length(); d++) {
			   out += m[r+d][c];
		   }
		   if (out.equals(w)){
			   return true;
		   }
		   return false;
	   }
	   catch (RuntimeException e) {
		   return false;
	   }
	}

	public boolean checkDiagUpRight(String w, int r, int c)
	{
		try {
			String out ="";
			for (int d = 0; d < w.length(); d++) {
				out += m[r-d][c+d];
			}
			if (out.equals(w)){
				return true;
			}
			return false;
		}
		catch (RuntimeException e) {
			return false;
		}
	}

	public boolean checkDiagUpLeft(String w, int r, int c)
	{
		try {
			String out ="";
			for (int d = 0; d < w.length(); d++) {
				out += m[r-d][c-d];
			}
			if (out.equals(w)){
				return true;
			}
			return false;
		}
		catch (RuntimeException e) {
			return false;
		}
	}

	public boolean checkDiagDownLeft(String w, int r, int c)
   {
	   try {
		   String out ="";
		   for (int d = 0; d < w.length(); d++) {
			   out += m[r+d][c-d];
		   }
		   if (out.equals(w)){
			   return true;
		   }
		   return false;
	   }
	   catch (RuntimeException e) {
		   return false;
	   }
	}

	public boolean checkDiagDownRight(String w, int r, int c)
	{
		try {
			String out ="";
			for (int d = 0; d < w.length(); d++) {
				out += m[r+d][c+d];
			}
			if (out.equals(w)){
				return true;
			}
			return false;
		}
		catch (RuntimeException e) {
			return false;
		}
	}

    public String toString()
    {
 		for (String[] row : m){
			 for (String val : row) {
				 System.out.print(val + " ");
			 }
			System.out.println("");
		}
		return "";
    }
}
