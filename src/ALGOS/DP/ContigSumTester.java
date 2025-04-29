package ALGOS.DP;

public class ContigSumTester {
    public static void main(String[] args) {
        int[] A1 = new int[] {-2, 11, -4, 13, -5, 2};
        int[] A2 = new int[] {1,-3, 4, -2, -1, 6};
        System.out.println(ContigSum.maxSubArray(A1));
        System.out.println(ContigSum.maxSubArray(A2));
    }
}
