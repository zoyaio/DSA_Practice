package ALGOS.DP;

public class ContigSum {

    // this could be consididered a greedy algo too
    public static int maxSubArray(int[] A) {
        // across all local contig sums
        int maxSum = A[0]; // the sum ending at window i = 1 is just A[0]
        int sum = 0; // current running sum, init

        for (int i = 0; i < A.length; i++) {
            // whether the contig sum from somewhere in teh past up to i
            // (the MAX) will be bigger + the next element OR if just the next element
            sum = Math.max(sum + A[i], A[i]);
            maxSum = Math.max(maxSum, sum); // whether the old global max or this is greater
        }
        return maxSum;
    }

}
