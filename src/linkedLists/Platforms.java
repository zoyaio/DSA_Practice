package linkedLists;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.*;
import java.time.LocalTime;

public class Platforms {
    // every single time u parse a new train (enter time), see if u can remove one (departure time)
    static String pathname = "C:\\Users\\zoya\\IdeaProjects\\DSA_Practice_gradebook\\src\\linkedLists\\platforms.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(pathname);
        Scanner scannie = new Scanner(file);
        int numDS = scannie.nextInt();
        scannie.nextLine();
        for (int d = 0; d < numDS; d++){
            String[] arrivalTimesRAW = scannie.nextLine().split(" ");
            String[] departTimesRAW = scannie.nextLine().split(" ");

            System.out.println(Arrays.toString(arrivalTimesRAW));
            System.out.println(Arrays.toString(departTimesRAW));
            // it's because of the dates

            LocalDateTime[] arrivalTimes = new LocalDateTime[arrivalTimesRAW.length];
            LocalDateTime[] departureTimes = new LocalDateTime[departTimesRAW.length];
            Queue<Integer> trainsAtStation = new LinkedList<>();
//            ArrayList<Integer> trainsAtStation = new ArrayList<>();
            int maxSize = 0;
            for (int i = 0; i < arrivalTimes.length; i++) {
                String[] splitInfo = arrivalTimesRAW[i].split(":");
                String[] splitInfoDept = departTimesRAW[i].split(":");
                int year = 2025; int month = 1; int dateArrive = 1; int dateDepart = 1;

                int hourArrive = Integer.parseInt(splitInfo[0]);
                if (hourArrive <5 ) {
                    dateArrive ++;
                }
                int minuteArrive = Integer.parseInt(splitInfo[1]);

                int hourDept = Integer.parseInt(splitInfoDept[0]);
                if (hourDept < 5) {
                    dateDepart ++;
                }
                int minDept = Integer.parseInt(splitInfoDept[1]);

                arrivalTimes[i] = LocalDateTime.of(year, month, dateArrive, hourArrive, minuteArrive);
                departureTimes[i] = LocalDateTime.of(year, month, dateDepart, hourDept, minDept );

                // compareto returns a negative number if the This is less than the other
                // remove all existing trains in the station--though technically if
                // NOW WE'RE AT THE MOMENT THE ITH TRAIN ARRIVES
                while (!trainsAtStation.isEmpty()) {
                    int earliestTrainIndex = trainsAtStation.peek();
                    // checks if each train already at the station before has departed by the time this one arrives
                    if (!arrivalTimes[i].isBefore(departureTimes[earliestTrainIndex]))
                    {
                        trainsAtStation.remove();
                    }
                    else {
                        break;
                    }
                }
                // add this train to station
                trainsAtStation.add(i);

                int currSize = trainsAtStation.size();
                if (currSize > maxSize) {
                    maxSize = currSize;
                }


            }
            System.out.println(maxSize); //if two trains are at teh same time it works


        }
    }}
