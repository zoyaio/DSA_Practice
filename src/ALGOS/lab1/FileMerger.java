package ALGOS.lab1;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FileMerger {
    PriorityQueue<Integer> pq;
    public FileMerger(int[] F){
        pq = new PriorityQueue<>();
        for (int f : F) {
            pq.add(f);
        }

    }

    public int merge() {
        if (pq.size() <= 1) {
            // when you're at one element, you don't need to merge anymore
            return 0;
        }
        int fileOne = pq.poll();
        int fileTwo = pq.poll();
        int subCost = fileOne + fileTwo;
        pq.add(subCost);
        return merge() + subCost;
    }
}
