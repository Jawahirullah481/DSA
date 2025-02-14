package datastructure.dp.problems;

import java.util.Arrays;

public class Problem36BuySelllStock2 {
    public static void main(String[] args) {
        long[] values = {1, 2, 3, 4, 5, 6, 7};
        int n = 7;
        long solution = 0;

        // Recursion solution
        solution = maxProfitRecursion(n, values, 0, false);

        // Memoization solution
        long[][] dp = new long[values.length][2];
        for(long[] row : dp) {
            Arrays.fill(row, -1);
        }

        solution = maxProfitMemoization(n, values, 0, 0, dp);
    }

    public static long maxProfitRecursion(int n, long[] values, int index, boolean bought) {

        if(index == values.length) {
            return 0;
        }

        if(bought) {
            long sell = values[index] + maxProfitRecursion(n, values, index + 1, false);
            long notSell = maxProfitRecursion(n, values, index + 1, bought);

            return Math.max(sell, notSell);
        }

        long buy = -values[index] + maxProfitRecursion(n, values, index + 1, true);
        long notBuy = maxProfitRecursion(n, values, index + 1, bought);

        return Math.max(buy, notBuy);
    }

    public static long maxProfitMemoization(int n, long[] values, int index, int bought, long[][] dp) {

        if(index == values.length) {
            return 0;
        }

        if(dp[index][bought] != -1) {
            return dp[index][bought];
        }

        if(bought == 1) {
            long sell = values[index] + maxProfitMemoization(n, values, index + 1, 0, dp);
            long notSell = maxProfitMemoization(n, values, index + 1, bought, dp);

            return dp[index][bought] = Math.max(sell, notSell);
        }

        long buy = -values[index] + maxProfitMemoization(n, values, index + 1, 1, dp);
        long notBuy = maxProfitMemoization(n, values, index + 1, bought, dp);

        return dp[index][bought] = Math.max(buy, notBuy);
    }
}
