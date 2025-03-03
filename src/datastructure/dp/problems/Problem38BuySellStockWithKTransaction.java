package datastructure.dp.problems;

import java.util.Arrays;

public class Problem38BuySellStockWithKTransaction {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5, 6, 7};
        int k = 5;

        int solution = 0;

        int[][][] dp = new int[prices.length][2][3];
        for(int[][] matrix : dp) {
            for(int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }
        solution = maxProfitMemoization(prices.length, prices, 0, 0, k, dp);

        // Tabulation solution
        int[][][] dp1 = new int[prices.length][2][3];
        solution = maxProfitTabulation(prices.length, prices, k, dp1);
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

    public static int maxProfitTabulation(int n, int[] values, int maxTrans, int[][][] dp) {

        for(int transaction = 0; transaction <= maxTrans - 1; transaction++) {
            dp[n - 1][1][transaction] = values[n - 1];
        }

        for(int day = n - 2; day >= 0; day--) {
            for(int hasBought = 0; hasBought <= 1; hasBought++) {
                for(int transaction = 0; transaction <= maxTrans - 1; transaction++) {
                    if(hasBought == 1) {
                        int sell = values[day] + dp[day + 1][0][transaction + 1];
                        int notSell = dp[day + 1][1][transaction];

                        dp[day][hasBought][transaction] = Math.max(sell, notSell);
                    } else {
                        int buy = -values[day] + dp[day + 1][1][transaction];
                        int notBuy = dp[day + 1][0][transaction];

                        dp[day][hasBought][transaction] = Math.max(buy, notBuy);
                    }
                }
            }
        }

        return dp[0][0][0];
    }
}
