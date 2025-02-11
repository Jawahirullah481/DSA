package datastructure.dp.problems;

import java.util.Arrays;

public class Problem13ChocolatePickup {
    public static void main(String[] args) {

        int solution = 0;

        int[][] grid = { {2, 3, 1, 2}, {3, 4, 2, 2}, {5, 6, 3, 5}, {1, 2, 7, 6} };

        int r = grid.length;
        int c = grid[0].length;

        // Recursion solution
        solution = maxChocolatesRecursion(r, c, grid, 0, 0, c - 1);

        // Memoization Solution
        int[][][] dp = new int[r][c][c];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        solution = maxChocolatesMemoization(r, c, grid, 0, 0, c - 1, dp);
    }

    public static int maxChocolatesRecursion(int r, int c, int[][] grid, int currentRow, int alice, int bob) {

        if(alice < 0 || alice >= c || bob < 0 || bob >= c) {
            return Integer.MIN_VALUE;
        }

        int total = 0;
        if(alice == bob) {
            total = grid[currentRow][alice];
        } else {
            total = grid[currentRow][alice] + grid[currentRow][bob];
        }

        if(currentRow == r - 1) {
            return total;
        }

        int sum = 0;

        for(int aliceCell = -1; aliceCell <= 1; aliceCell++) {
            for(int bobCell = -1; bobCell <= 1; bobCell++) {
                int maxCount = total + maxChocolatesRecursion(r, c, grid, currentRow + 1, alice + aliceCell, bob + bobCell);
                sum = Math.max(maxCount, sum);
            }
        }

        return sum;
    }

    public static int maxChocolatesMemoization(int r, int c, int[][] grid, int currentRow, int alice, int bob, int[][][] dp) {

        if(alice < 0 || alice >= c || bob < 0 || bob >= c) {
            return Integer.MIN_VALUE;
        }

        if(dp[currentRow][alice][bob] != -1) {
            return dp[currentRow][alice][bob];
        }

        int total = 0;
        if(alice == bob) {
            total = grid[currentRow][alice];
        } else {
            total = grid[currentRow][alice] + grid[currentRow][bob];
        }

        if(currentRow == r - 1) {
            dp[currentRow][alice][bob] = total;
            return dp[currentRow][alice][bob];
        }

        int sum = 0;

        for(int aliceCell = -1; aliceCell <= 1; aliceCell++) {
            for(int bobCell = -1; bobCell <= 1; bobCell++) {
                int maxCount = total + maxChocolatesMemoization(r, c, grid, currentRow + 1, alice + aliceCell, bob + bobCell, dp);
                sum = Math.max(maxCount, sum);
            }
        }

        dp[currentRow][alice][bob] = sum;
        return dp[currentRow][alice][bob];
    }
}
