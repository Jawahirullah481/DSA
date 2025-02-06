package datastructure.dp.problems;

import java.util.Arrays;

public class Problem10MaxSum {
    public static void main(String[] args) {

        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int solution = 0;

        // Recursion
        solution = (int)minSumRecursion(grid.length - 1, grid[0].length - 1, grid);

        // Memoization
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        solution = (int)minSumMemoization(grid.length - 1, grid[0].length - 1, grid, dp);
    }

    public static long minSumRecursion(int i, int j, int[][] grid) {

        if(i == 0 && j == 0) {
            return grid[i][j];
        }

        if(i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        long top = grid[i][j] + minSumRecursion(i - 1, j, grid);
        long left = grid[i][j] + minSumRecursion(i, j - 1, grid);

        return Math.min(top, left);
    }

    public static long minSumMemoization(int i, int j, int[][] grid, int[][] dp) {

        if(i == 0 && j == 0) {
            return grid[i][j];
        }

        if(i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        long top = grid[i][j] + minSumMemoization(i - 1, j, grid, dp);
        long left = grid[i][j] + minSumMemoization(i, j - 1, grid, dp);

        dp[i][j] = (int)Math.min(top, left);
        return dp[i][j];
    }
}
