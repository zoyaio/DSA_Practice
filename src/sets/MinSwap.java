package sets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MinSwap {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("minimumSwaps.dat"));
        int lim = scan.nextInt();
        scan.nextLine();
        for (int o = 0; o < lim; o++) {
            int numElem = scan.nextInt();
            scan.nextLine();
            int[] data = new int[numElem];
            for (int r = 0; r < numElem; r++) {
                data[r] = scan.nextInt();
            }
            System.out.println("unsorted: " + Arrays.toString(data));
            System.out.println(selectionSort(data));
        }
    }


    static int selectionSort(int[] data) {

        int count = 0;

        int minIndex = 0;
        for (int i = 0; i <data.length; i++) {
            minIndex = i;
            for (int j = i; j < data.length; j++ ) {
                if (data[minIndex] >= data[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
                count ++;
            }

        }
        System.out.println(Arrays.toString(data));

        return count;
    }
}
