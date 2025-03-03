package datastructure.dp.problems;

import java.util.Arrays;

public class Problem40BuySellStock6 {

    // NOTE : In this problem, everything are similar to previous problem. The difference is for every transaction some fee is taken.
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5, 6, 7};
        int fee = 5;

        int solution = 0;

        // Memoization solution
        int[][] dp = new int[prices.length][2];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        solution = maxProfitMemoization(prices.length, prices, 0, 0, dp, fee);

        // Tabulation
        int[][] dp1 = new int[prices.length][2];
        solution = maxProfitTabulation(prices.length, prices, dp, fee);
    }

    public static int maxProfitMemoization(int n, int[] values, int index, int bought, int[][] dp, int fee) {

        if(index >= values.length) {
            return 0;
        }

        if(dp[index][bought] != -1) {
            return dp[index][bought];
        }

        if(bought == 1) {
            int sell = values[index] - fee + maxProfitMemoization(n, values, index + 1, 0, dp, fee);
            int notSell = maxProfitMemoization(n, values, index + 1, bought, dp, fee);

            return dp[index][bought] = Math.max(sell, notSell);
        }

        int buy = -values[index] + maxProfitMemoization(n, values, index + 1, 1, dp, fee);
        int notBuy = maxProfitMemoization(n, values, index + 1, bought, dp, fee);

        return dp[index][bought] = Math.max(buy, notBuy);
    }

    public static int maxProfitTabulation(int n, int[] values, int[][] dp, int fee) {
        if(fee <= values[n - 1]) {
            dp[n - 1][1] = values[n - 1] - fee;
        }

        for(int day = n - 2; day >= 0; day--) {
            for(int hasBought = 0; hasBought <= 1; hasBought++) {
                if(hasBought == 1) {
                    int sell = values[day] - fee + dp[day + 1][0];
                    int notSell = dp[day + 1][1];

                    dp[day][hasBought] = Math.max(sell, notSell);
                } else {
                    int buy = -values[day] + dp[day + 1][1];
                    int notBuy = dp[day + 1][0];

                    dp[day][hasBought] = Math.max(buy, notBuy);
                }
            }
        }

        return dp[0][0];
    }
}
