package datastructure.dp.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem35BuySellStock {
    public static void main(String[] args) {
        int solution = 0;
        ArrayList<Integer> prices = (ArrayList<Integer>) Arrays.asList(2, 100, 150, 120);

        // Recursion solution
        solution = maxProfitRecursion(prices, false, 0);

        // Memoization solution
        int[][] dp = new int[prices.size()][2];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        solution = maxProfitMemoization(prices, 0, 0, dp);
    }

    public static int maxProfitRecursion(ArrayList<Integer> prices, boolean bought, int index) {

        if(index == prices.size()) {
            return 0;
        }

        if(bought) {
            return Math.max(prices.get(index), maxProfitRecursion(prices, true, index + 1));
        }

        return Math.max(-prices.get(index) + maxProfitRecursion(prices, true, index + 1), maxProfitRecursion(prices, false, index + 1));

    }

    public static int maxProfitMemoization(ArrayList<Integer> prices, int bought, int index, int[][] dp) {

        if(index == prices.size()) {
            return 0;
        }

        if(dp[index][bought] != -1) {
            return dp[index][bought];
        }

        if(bought == 1) {
            return dp[index][bought] = Math.max(prices.get(index), maxProfitMemoization(prices, 1, index + 1, dp));
        }

        return dp[index][bought] = Math.max(-prices.get(index) + maxProfitMemoization(prices, 1, index + 1, dp), maxProfitMemoization(prices, 0, index + 1, dp));

    }
}
