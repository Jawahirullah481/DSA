package datastructure.dp.problems;

import java.util.Arrays;

public class Problem16PartitionMinDifference {
    public static void main(String[] args) {

        int[] arr = {1, 6, 11, 5};
        int n = arr.length;

        int solution = 0;

        int total = 0;

        for(int i : arr) {
            total += i;
        }
        // Recursion solution
        solution = minDifferenceRecursion(arr, n, 0, total, n - 1);

        // Memoization Solution
        int[][] dp = new int[n][total + 1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        solution = minDifferenceMemoization(arr, n, 0, total, n - 1, dp);

        // Tabulation solution
        solution = minDifferenceTabulation(arr, n, total);
    }

    public static int minDifferenceRecursion(int[] arr, int n, int sum, int total, int index) {
        if(index < 0) {
            int num1 = sum;
            int num2 = total - sum;
            return Math.abs(num1 - num2);
        }

        int take = minDifferenceRecursion(arr, n, sum + arr[index], total, index - 1);
        int notTake = minDifferenceRecursion(arr, n, sum, total, index - 1);

        return Math.min(take, notTake);
    }

    public static int minDifferenceMemoization(int[] arr, int n, int sum, int total, int index, int[][] dp) {
        if(index < 0) {
            int num1 = sum;
            int num2 = total - sum;
            return Math.abs(num1 - num2);
        }

        if(dp[index][sum] != -1) {
            return dp[index][sum];
        }

        int take = minDifferenceMemoization(arr, n, sum + arr[index], total, index - 1, dp);
        int notTake = minDifferenceMemoization(arr, n, sum, total, index - 1, dp);

        dp[index][sum] = Math.min(take, notTake);
        return dp[index][sum];
    }

    public static int minDifferenceTabulation(int[] arr, int n, int sum) {
        boolean[][] dp = new boolean[n][sum + 1];

        for(int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if(arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < sum + 1; j++) {
                boolean take = j - arr[i] >= 0 ? dp[i - 1][j - arr[i]] : false;
                boolean notTake = dp[i - 1][j];

                dp[i][j] = take || notTake;
            }
        }

        int minDifference = Integer.MAX_VALUE;

        for(int i = 0; i <= sum / 2; i++) {
            if(dp[n - 1][i]) {
                int num1 = i;
                int num2 = sum - num1;
                minDifference = Math.min(minDifference, Math.abs(num1 - num2));
            }
        }

        return minDifference;

    }
}
