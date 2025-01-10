package linkedLists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FillTheSequence {
    public static void addAtPos(ArrayList<Integer> arr, int index) {
        if (arr.size() <= index) {
            while (arr.size() -1 < index) {
                arr.add(0);
            }
        }
        arr.set(index, arr.get(index) +1);

    }
    public static void main(String[] args) throws FileNotFoundException {
        // add at pos
        File file = new File("C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\linkedLists\\sequence.txt");
        Scanner scannie = new Scanner(file);
        int numRows = scannie.nextInt();
        scannie.nextLine();
        for (int r = 0; r < numRows; r++) {
            ArrayList<Integer> arr = new ArrayList<>(); // each integer from dataset corresponds to an index
            String[] nums = scannie.nextLine().split(" ");
            System.out.println(Arrays.toString(nums));
            for (String n : nums) {
                int num = Integer.parseInt(n);
                addAtPos(arr, num);
            }
            int missingPos = 0;
            int duplicatedPos =0;
            for (int i = 0; i <arr.size(); i++) {
                if (arr.get(i) == 0) {missingPos = i;}
                else if (arr.get(i) > 1) {duplicatedPos = i;}
            }
            if (missingPos == 0) {
                missingPos = arr.size();
            }
            System.out.println(duplicatedPos + " " + ": " + missingPos);
        }
        // afterwards--the location that has a 0 = themissing one; the location that has a 2 = the duplicated one

    }
}
