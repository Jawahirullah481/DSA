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

        // Tabulation
        solution = maxProfitTabulation(prices.length, prices, dp);
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

    public static int maxProfitTabulation(int n, int[] values, int[][] dp) {
        if(n <= 1) return 0;

        dp[n - 1][1] = values[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j <= 1; j++) {
                if(j == 1) {
                    int sell = values[i];
                    if(i + 2 <= n - 1)
                        sell += dp[i + 2][0];

                    int notSell = dp[i + 1][1];

                    dp[i][j] = Math.max(sell, notSell);
                } else {
                    int buy = -values[i] + dp[i + 1][1];
                    int notBuy = dp[i + 1][0];

                    dp[i][j] = Math.max(buy, notBuy);
                }
            }
        }

        return dp[0][0];
    }
}
