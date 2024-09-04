package matrix;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.util.Random;

public class MatrixSearch
{
    private int[][] mat;
	private int rows;
	private int cols;

		/*
		 *pre - mat is null
		 *post - mat will be rows X cols
		 *post - mat will contain integers that are <= upper and >= 1
		 */
    public MatrixSearch( int rows, int cols, int upper )
    {
		mat = new int[rows][cols];
		this.rows = rows;
		this.cols = cols;
		Random rand = new Random();
		for (int i = 0; i < rows; i++) {
			for (int j= 0; j < cols; j++) {
				mat[i][j] = rand.nextInt(upper) ;
			}
		}
    }


		/*
		 *pre - mat is not null
		 *post - count of odd numbers will be returned
		 *post - no values in mat will have been changed
		 */
    public int countOdds( )
    {
		int oddCount = 0;
		for (int i = 0; i < rows; i++) {
			for (int j= 0; j < cols; j++) {
				if (mat[i][j] %2 ==1) {
					oddCount++;
				}
			}
		}

		return oddCount;
    }


		/*
		 *pre - mat is not null
		 *post - count of even numbers will be returned
		 *post - no values in mat will have been changed
		 */
    public int countEvens( )
    {
		return rows * cols - this.countOdds();
    }


		/*
		 *pre - mat is not null
		 *post - count of prime numbers will be returned
		 *post - no values in mat will have been changed
		 */
    public int countPrimes( )
    {
		int oddCount = 0;
		for (int i = 0; i < rows; i++) {
			for (int j= 0; j < cols; j++) {
				if (isPrime(mat[i][j])) {
					oddCount++;
				}
			}
		}

		return oddCount;
    }

		/*
		 *pre - num has a value
		 *post - false is returned if num is divisble by any number between 2 and itself
		 *post - true is returned if num is not divisble by any number between 2 and itself
		 */
    public boolean isPrime( int num )
    {
		for (int val = 2; val < num; val++) {
			if (num % val == 0) {
				return false;
			}
		}
		return true;
    }

		/*
		 *pre - mat is not null
		 *post - all values from mat are concatenated to a string and returned
		 */
    public String toString()
    {
		String out = "";
		for (int i = 0; i < rows; i++) {
			for (int j= 0; j < cols; j++) {
				out += Integer.toString(mat[i][j]) + " ";
			}
		}

		return out;

    }
}
