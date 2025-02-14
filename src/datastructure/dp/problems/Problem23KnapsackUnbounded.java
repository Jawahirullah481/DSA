package datastructure.dp.problems;

import java.util.Arrays;

public class Problem23KnapsackUnbounded {
    public static void main(String[] args) {

        int n = 3;  // Number of items
        int w = 5;  // Maximum knapsack weight
        int[] profit = {10, 30, 20};  // Profit for each item
        int[] weight = {2, 3, 4};     // Weight of each item

        int solution = 0;

        // Recursion solution
        solution = knapsackRecursion(n, w, profit, weight, n - 1, 0);

        // Memoization solution
        int[][] dp = new int[n][w + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        solution = knapsackMemoization(n, w, profit, weight, n - 1, 0, dp);
    }

    /*
        NOTE : Here, I don't take current profit as an argument and calculating in argument. it works in recursion solution.
        But, it doesn't work in memoization solution.
     */
    public static int knapsackRecursion(int n, int w, int[] profit, int[] weight, int index, int myWeight) {

        if(myWeight > w) {
            return 0;
        }

        if(index < 0) {
            return 0;
        }


        int notTake = knapsackRecursion(n, w, profit, weight, index - 1, myWeight);
        int take = 0;
        if(myWeight + weight[index] <= w) {
            take = profit[index] + knapsackRecursion(n, w, profit, weight, index, myWeight + weight[index]);
        }

        return Math.max(notTake, take);
    }

    public static int knapsackMemoization(int n, int w, int[] profit, int[] weight, int index, int myWeight, int[][] dp) {

        if(myWeight > w) {
            return 0;
        }

        if(index < 0) {
            return 0;
        }

        if(dp[index][myWeight] != -1) {
            return dp[index][myWeight];
        }


        int notTake = knapsackMemoization(n, w, profit, weight, index - 1, myWeight, dp);
        int take = 0;
        if(myWeight + weight[index] <= w) {
            take = profit[index] + knapsackMemoization(n, w, profit, weight, index, myWeight + weight[index], dp);
        }

        return dp[index][myWeight] = Math.max(notTake, take);
    }

    /* ------------------------- PASSED RECURSION WITH MYPROFIT ------------------------ */


    public static int knapsackRecursion(int n, int w, int[] profit, int[] weight, int index, int myWeight, int[][] dp) {

        if(myWeight > w) {
            return 0;
        }

        if(index < 0) {
            return 0;
        }

        if(dp[index][myWeight] != -1) {
            return dp[index][myWeight];
        }


        int notTake = knapsackRecursion(n, w, profit, weight, index - 1, myWeight, dp);
        int take = 0;
        if(myWeight + weight[index] <= w) {
            take = profit[index] + knapsackRecursion(n, w, profit, weight, index, myWeight + weight[index], dp);
        }

        return dp[index][myWeight] = Math.max(notTake, take);
    }

    /* -------------------------------- FAILED MEMOIZATION WITH MYPROFIT---------------------- */
    public static int knapsackMemoization1(int n, int w, int[] profit, int[] weight, int index, int myWeight, int myProfit, int[][] dp) {

        if(myWeight > w) {
            return 0;
        }

        if(index < 0) {
            return myProfit;
        }

        if(dp[index][myWeight] != -1) {
            return dp[index][myWeight];
        }


        int notTake = knapsackMemoization1(n, w, profit, weight, index - 1, myWeight, myProfit, dp);
        int take = 0;
        if(myWeight + weight[index] <= w) {
            take = knapsackMemoization1(n, w, profit, weight, index, myWeight + weight[index], myProfit + profit[index], dp);
        }

        return dp[index][myWeight] = Math.max(notTake, take);
    }

    /*---------------------- CORRECT MEMOIZATION WITH MYPROFIT AS STATE(PARAM) ----------------*/

    public static int knapsackMemoizationFixed(int n, int w, int[] profit, int[] weight, int index, int myWeight, int myProfit, int[][][] dp) {

        if (myWeight > w) {
            return 0;
        }

        if (index < 0) {
            return myProfit;
        }

        if (dp[index][myWeight][myProfit] != -1) {
            return dp[index][myWeight][myProfit];
        }

        int notTake = knapsackMemoizationFixed(n, w, profit, weight, index - 1, myWeight, myProfit, dp);
        int take = 0;
        if (myWeight + weight[index] <= w) {
            take = knapsackMemoizationFixed(n, w, profit, weight, index, myWeight + weight[index], myProfit + profit[index], dp);
        }

        return dp[index][myWeight][myProfit] = Math.max(notTake, take);
    }

}
