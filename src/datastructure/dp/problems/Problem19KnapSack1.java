package datastructure.dp.problems;

import java.util.Arrays;

public class Problem19KnapSack1 {
    public static void main(String[] args) {

        int[] weight = {2, 3, 4, 5};
        int[] value = {3, 4, 5, 6};
        int n = 4;
        int maxWeight = 5;

        int solution = 0;

        // Recursion solution
        solution = sackRecursion(weight, value, n, maxWeight, 0, n - 1);;

        // Memoization solution
        int[][] dp = new int[n][maxWeight + 1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        solution = sackMemoization(weight, value, n, maxWeight, 0, n - 1, dp);

        // Tabulation solution
        solution = knapsackTabulation(weight, value, n, maxWeight, dp);

    }

    public static int sackRecursion(int[] weights, int[] value, int n, int maxWeight, int weight, int index) {

        if(weight > maxWeight) {
            return Integer.MIN_VALUE;
        }

        if(index < 0) {
            return 0;
        }

        int take = value[index] + sackRecursion(weights, value, n, maxWeight, weight + weights[index], index - 1);
        int notTake = sackRecursion(weights, value, n, maxWeight, weight, index - 1);

        return Math.max(take, notTake);
    }

    public static int sackMemoization(int[] weights, int[] value, int n, int maxWeight, int weight, int index, int[][] dp) {

        if(weight > maxWeight) {
            return Integer.MIN_VALUE;
        }

        if(index < 0) {
            return 0;
        }

        if(dp[index][weight] != -1) {
            return dp[index][weight];
        }

        int take = value[index] + sackMemoization(weights, value, n, maxWeight, weight + weights[index], index - 1, dp);
        int notTake = sackMemoization(weights, value, n, maxWeight, weight, index - 1, dp);

        return dp[index][weight] = Math.max(take, notTake);
    }

    public static int knapsackTabulation(int[] weight, int[] value, int n, int maxWeight, int [][] dp) {
        if(weight[0] <= maxWeight) {
            for(int i = weight[0]; i <= maxWeight; i++) {
                dp[0][i] = value[0];
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= maxWeight; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                if(weight[i] <= j) {
                    take = value[i] + dp[i - 1][j - weight[i]];
                }

                dp[i][j] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][maxWeight];
    }
}
