package heaps;

import heaps.basics.Heap;

import java.util.*;

public class heapApplications {

    public static void main(String[] args) {
        testPracticeOne();
        System.out.println();
        testPracticeTwo();
    }

    // Java program to find k most frequent element
    // using hash map and sorting
    public static void testPracticeOne(){
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;
        ArrayList<Integer> res = topKFrequent(arr, k);

        for (int val : res)
            System.out.print(val + " ");
    }

    // Comparison function to sort the frequency array
    static class Compare implements Comparator<int[]> {
        public int compare(int[] p1, int[] p2) {

            // Prioritise element's value in case their frequency was same
            if (p1[0] == p2[0])
                return Integer.compare(p1[1], p2[1]) * -1;

            // Sort on the basis of increasing order
            // of frequencies (for min heap behavior)
            return Integer.compare(p1[0], p2[0]) * -1;
        }
    }

    // Function to find k numbers with most occurrences
    static ArrayList<Integer> topKFrequent(int[] arr, int k) {
        // HashMap 'mp' implemented as frequency hash table
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (Integer a : arr) {
            Integer currVal = mp.getOrDefault(a, 0);
            mp.put(a, currVal + 1);

        }
        System.out.println(mp);
        // Priority queue (Min-Heap) with custom comparator
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Compare());
        // populate priority queue with top k frequencies
        for (Map.Entry<Integer, Integer> pair : mp.entrySet()) {
            pq.add(new int[] {pair.getValue(), pair.getKey()});
        }

        // store the result as an ArrayList<Integer>, getting only the top k elements
        ArrayList<Integer> sortedK = new ArrayList<>();
        for (int i = 0; i < k; i ++){
            sortedK.add(pq.peek()[1]);
            pq.remove();
        }
        // return
        return sortedK;
    }

    public static void testPracticeTwo()
    {
        int[][] arr = { { 2, 6, 12 },
                { 1, 9 },
                { 23, 34, 90, 2000 } };
        System.out.println(
                mergeKArrays(arr, arr.length)
                        .toString());
    }

    private static class HeapNode
            implements Comparable<HeapNode> {
        int x;
        int y;
        int value;

        HeapNode(int x, int y, int value)
        {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override public int compareTo(HeapNode hn)
        {
            if (this.value <= hn.value) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }

    // Function to merge k sorted arrays.
    public static ArrayList<Integer>
    mergeKArrays(int[][] arr, int K)
    {
        // Create a result ArrayList<Integer> and Min-Heap
        // arraylist of integers
        ArrayList<Integer> result = new ArrayList<>(); // LEAST TO GREATEST
        // minheap PriorityQueue<HeapNode>
        PriorityQueue<HeapNode> minheap = new PriorityQueue<>();
        // Initially add only first column of elements. First
        // element of every array (to the minheap)
        for (int i = 0; i < K; i ++ ) {
            for (int j = 0; j < arr[i].length; j++) {
                minheap.add(new HeapNode(i, j, arr[i][j]));
            }

        }

        // Iterate until the heap is empty
        while (!minheap.isEmpty()) {
            result.add(minheap.peek().value);
            minheap.remove();
        }

        return result;
    }
}