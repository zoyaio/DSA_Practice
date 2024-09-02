package findmaxprime;//(c) A+ Computer Science
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class MatrixSearch2Runner
{
    public static void main(String[] args) throws Exception
    {
        MatrixSearch2 ms = new MatrixSearch2(20, 15, 50);
        System.out.println( ms );
        System.out.println( "Max Prime = " + ms.findMaxPrime() );

        ms = new MatrixSearch2(15, 15, 75);
        System.out.println( ms );
        System.out.println( "Max Prime = " + ms.findMaxPrime() );

        ms = new MatrixSearch2(7, 7, 100);
        System.out.println( ms );
        System.out.println( "Max Prime = " + ms.findMaxPrime() );
    }
}
