package datastructure.dp.problems;

public class Problem21TargetSum {
    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 3};
        int target = 1;
        int n = arr.length;

        int solution = 0;

        // Recursion Solution
        solution = targetSumRecursion(n, target, arr, n - 1);

        // Memoization Solution

    }

    public static int targetSumRecursion(int n, int target, int [] arr, int index) {

        if(index < 0) {
            return target == 0 ? 1 : 0;
        }

        int plus = targetSumRecursion(n, target + arr[index], arr, index - 1);
        int minus = targetSumRecursion(n, target - arr[index], arr, index - 1);

        return plus + minus;
    }
}
