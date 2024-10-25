package sets;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class SumFour {

    public static void main(String[] arg) throws FileNotFoundException {
        Scanner scannie = new Scanner(new File("src/sets/sum4.dat"));
        int numLines = scannie.nextInt();
        scannie.nextLine();

        for (int i = 0; i < numLines; i++) {
            String[] lineSplit = scannie.nextLine().split(" ");
            System.out.println(Arrays.toString(lineSplit));
            ArrayList<Integer>[] arr = new ArrayList[lineSplit.length];

            for (int j = 0; j < lineSplit.length; j++) {
                String potentialArr = lineSplit[j];
                Scanner miniParser = new Scanner(potentialArr.substring(1, potentialArr.length() - 1));
                miniParser.useDelimiter(",");
                ArrayList<Integer> mini = new ArrayList<>();

                while (miniParser.hasNextInt()) {
                    int minPar = miniParser.nextInt();
                    mini.add(minPar);
                }
                arr[j] = mini;

            }

            Map<ArrayList<Integer>, Integer> perms = new HashMap<>();
            for (int a = 0; a < arr[0].size(); a++) {
                for(int b = 0; b < arr[1].size(); b++) {
                    for(int c = 0; c < arr[2].size(); c++) {
                        for(int d = 0; d < arr[3].size(); d++) {
                            ArrayList<Integer> temp = new ArrayList<>();
                            temp.add(a);
                            temp.add(b);
                            temp.add(c);
                            temp.add(d);
                            // map the tuple to the sum
                            // loop through and select all whos sum is 0
                            perms.put(temp, arr[0].get(a) + arr[1].get(b) + arr[2].get(c) + arr[3].get(d));

                        }
                    }
                }
            }
            int count = 0;
            for (Map.Entry<ArrayList<Integer>, Integer> tup : perms.entrySet()) {
                if (tup.getValue() == 0) { count ++; }
            }
            System.out.println(count);


        }


// but wouldnt it just be easier to just make a set with everything that is like zero
        }

        // for each a u call everythign below to get all permutations

        // theres x numbers, that each have y posibilities

        // condition--if its not already a key
        // for each array in arrays


    }

