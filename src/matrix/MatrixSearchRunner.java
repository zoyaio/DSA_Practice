package matrix;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.*;
import java.io.*;

public class MatrixSearchRunner 
{
    public static void main(String[] args) throws Exception
    {
        MatrixSearch ms = new MatrixSearch(7, 7, 100);
    	System.out.println( ms );
        System.out.println( "Odd count = " + ms.countOdds() );
        System.out.println( "Even count = " + ms.countEvens() );
        System.out.println( "Prime count = " + ms.countPrimes() );
    }
}
