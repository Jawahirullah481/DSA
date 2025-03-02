package datastructure.dp.problems;

import java.util.Arrays;

public class Problem21TargetSum {
    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 3};
        int target = 1;
        int n = arr.length;

        int solution = 0;

        // Recursion Solution
        solution = targetSumRecursion(n, target, arr, n - 1);

        int totSum = 0;

        // Calculate the total sum of elements in the array
        for (int i = 0; i < arr.length; i++) {
            totSum += arr[i];
        }

        // Checking for edge cases
        if (totSum - target < 0)
            solution = 0;
        if ((totSum - target) % 2 == 1)
            solution = 0;

        // Calculate the second sum based on the total sum and the target
        int s2 = (totSum - target) / 2;

        // Tabulation Solution

        // Create a 2D array to store results of subproblems
        int dp[][] = new int[n][s2 + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int row[] : dp)
            Arrays.fill(row, -1);

        solution = targetSumTabulation(n , s2, arr, dp);
    }

    public static int targetSumRecursion(int n, int target, int [] arr, int index) {

        if(index < 0) {
            return target == 0 ? 1 : 0;
        }

        int plus = targetSumRecursion(n, target + arr[index], arr, index - 1);
        int minus = targetSumRecursion(n, target - arr[index], arr, index - 1);

        return plus + minus;
    }

    public static int targetSumTabulation(int n, int target, int[] arr, int[][] dp) {

        for(int tarInd = 0; tarInd <= target; tarInd++) {
            if(tarInd == 0 && arr[0] == 0) {
                dp[0][0] = 2;
            } else if(tarInd == 0 || arr[0] == tarInd) {
                dp[0][tarInd] = 1;
            } else {
                dp[0][tarInd] = 0;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= target; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if(j >= arr[i]) {
                    take = dp[i - 1][j - arr[i]];
                }

                dp[i][j] = notTake + take;
            }
        }

        return dp[n - 1][target];

    }
}
