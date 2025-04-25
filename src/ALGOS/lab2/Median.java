package ALGOS.lab2;

import java.util.Arrays;

public class Median {
    /*
    We are given two sorted lists of size D. Give an algorithm
    for finding the median element in the union of the two lists.
     */
    int[] L1;
    int[] L2;
    public static void main(String[] args) {

        int[] A = {10, 20, 30, 40};
        int[] B = {5, 15, 25, 35};
        System.out.println(findUnionMedian(A, B));

        int[] A1 = {1, 3, 5, 7};
        int[] B1 = {2, 4, 6, 8};
        System.out.println(findUnionMedian(A1, B1));

    }



    public static double findUnionMedian(int[] L1, int[] L2) {

        System.out.println("l1" + Arrays.toString(L1));
        System.out.println("l2"+ Arrays.toString(L2));

        double[] m1 = findMedian(L1);
        double[] m2 = findMedian(L2);



        if (m1[1] == m2[1]) { return m1[1]; }
        if (L1.length == 2 && L2.length ==2) {return (findMax(L1[0], L2[0]) + findMin(L1[1], L2[1]))/2.0;}





        if (m2[1] > m1[1]) {
            System.out.println("hi");
            return findUnionMedian(Arrays.copyOfRange(L1, (int) m1[0] + 1, L1.length), Arrays.copyOfRange(L2, 0,(int) m2[0] + 1));
        }
        else {
            return findUnionMedian(Arrays.copyOfRange(L1, 0,(int) m1[0] + 1),
                    Arrays.copyOfRange(L2, (int) m2[0] +1 , L2.length));
        }
    }

    private static double[] findMedian(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int midPoint = arr.length/2;
        if (arr.length % 2 == 0 ){
            return new double[] {midPoint -1, (arr[midPoint] + arr[midPoint -1])/2.0};
        }
        return new double[] {midPoint, arr[midPoint] * 1.0};
    }

    private static int findMax(int a0, int a1) {
        if (a0 >= a1) {return a0;}
        return a1;
    }
    private static int findMin(int a0, int a1) {
        if (a0 >= a1) {return a1;}
        return a0;
    }

}
