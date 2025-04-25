package ALGOS.lab1;

public class FileMergerTester {
    public static void main(String[] args) {
        int[][] Fs = new int[][] {{5, 10, 15, 20, 50, 100},{10, 5, 100, 50, 20, 15}};
        for (int[] F : Fs) {
            FileMerger tester = new FileMerger(F);
            System.out.println(tester.merge());
        }
    }
}
