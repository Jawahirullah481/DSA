package datastructure.dp.problems;

import java.util.Arrays;

public class Problem37BuySellStock3 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5, 6, 7};

        int solution = 0;

        // Recursion solution
        solution = maxProfitRecursion(prices.length, prices, 0, false, 2);

        // Memoization solution
        int[][][] dp = new int[prices.length][2][3];
        for(int[][] matrix : dp) {
            for(int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }
        solution = maxProfitMemoization(prices.length, prices, 0, 0, 2, dp);
    }


    public static int maxProfitRecursion(int n, int[] values, int index, boolean bought, int transaction) {

        if(index == values.length || transaction == 0) {
            return 0;
        }

        if(bought) {
            int sell = values[index] + maxProfitRecursion(n, values, index + 1, false, transaction - 1);
            int notSell = maxProfitRecursion(n, values, index + 1, bought, transaction);

            return Math.max(sell, notSell);
        }

        int buy = -values[index] + maxProfitRecursion(n, values, index + 1, true, transaction);
        int notBuy = maxProfitRecursion(n, values, index + 1, bought, transaction);

        return Math.max(buy, notBuy);
    }

    public static int maxProfitMemoization(int n, int[] values, int index, int bought, int transaction, int[][][] dp) {

        if(index == values.length || transaction == 0) {
            return 0;
        }

        if(dp[index][bought][transaction] != -1) {
            return dp[index][bought][transaction];
        }

        if(bought == 1) {
            int sell = values[index] + maxProfitMemoization(n, values, index + 1, 0, transaction - 1, dp);
            int notSell = maxProfitMemoization(n, values, index + 1, bought, transaction, dp);

            return dp[index][bought][transaction] = Math.max(sell, notSell);
        }

        int buy = -values[index] + maxProfitMemoization(n, values, index + 1, 1, transaction, dp);
        int notBuy = maxProfitMemoization(n, values, index + 1, bought, transaction, dp);

        return dp[index][bought][transaction] = Math.max(buy, notBuy);
    }
}
