package datastructure.dp.problems;

import java.util.Arrays;

public class Problem14SubsetSumEqualsK {
    public static void main(String[] args) {
        boolean solution = false;

        int[] arr = {2, 3, 7, 8, 10};
        int k = 11, n = arr.length;

        // Recursion solution
        solution = subsetSumRecursion(n, k, arr, n - 1);

        // Memoization solution
        int[][] dp = new int[n][k + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        solution = subsetSumMemoization(n, k, arr, n - 1, dp);

        // Tabulation solution
        solution = subsetSumTabulation(n, k, arr);
    }

    public static boolean subsetSumRecursion(int n, int k, int[] arr, int index) {

        if(k == 0) {
            return true;
        }

        if(index == 0) {
            return k == arr[index];
        }

        boolean take = subsetSumRecursion(n, k - arr[index], arr, index - 1);
        boolean notTake = subsetSumRecursion(n, k, arr, index - 1);

        return take || notTake;
    }

    public static boolean subsetSumMemoization(int n, int k, int[] arr, int index, int[][] dp) {

        if(k < 0) {
            // NOTE : this base case
            return false;
        }

        if(k == 0) {
            dp[index][k] = 1;
            return true;
        }

        if(index == 0) {
            return k == arr[index];
        }

        if(dp[index][k] != -1) {
            return dp[index][k] == 1;
        }

        boolean take = subsetSumMemoization(n, k - arr[index], arr, index - 1, dp);
        boolean notTake = subsetSumMemoization(n, k, arr, index - 1, dp);

        dp[index][k] = (take || notTake) ? 1 : 0;

        return take || notTake;
    }


    public static boolean subsetSumTabulation(int n, int k, int arr[]) {
        boolean[][] dp = new boolean[n][k + 1];

        for(int i = 0; i < n; i++) dp[i][0] = true;

        if(arr[0] <= k)
            dp[0][arr[0]] = true;

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < k + 1; j++) {
                boolean take = j - arr[i] >= 0 ? dp[i - 1][j - arr[i]] : false;
                boolean notTake = dp[i - 1][j];

                dp[i][j] = take || notTake;
            }
        }

        return dp[n - 1][k];
    }
}
