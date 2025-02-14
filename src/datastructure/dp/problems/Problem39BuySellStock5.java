package datastructure.dp.problems;

import java.util.Arrays;

public class Problem39BuySellStock5 {
    // NOTE : In this problem, everything is similar. Except once you sell the stock, you can't buy stock on immediate next day
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5, 6, 7};

        int solution = 0;

        // Memoization solution
        int[][] dp = new int[prices.length][2];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        solution = maxProfitMemoization(prices.length, prices, 0, 0, dp);
    }

    public static int maxProfitMemoization(int n, int[] values, int index, int bought, int[][] dp) {

        if(index >= values.length) {
            return 0;
        }

        if(dp[index][bought] != -1) {
            return dp[index][bought];
        }

        if(bought == 1) {
            int sell = values[index] + maxProfitMemoization(n, values, index + 2, 0, dp);
            int notSell = maxProfitMemoization(n, values, index + 1, bought, dp);

            return dp[index][bought] = Math.max(sell, notSell);
        }

        int buy = -values[index] + maxProfitMemoization(n, values, index + 1, 1, dp);
        int notBuy = maxProfitMemoization(n, values, index + 1, bought, dp);

        return dp[index][bought] = Math.max(buy, notBuy);
    }
}
