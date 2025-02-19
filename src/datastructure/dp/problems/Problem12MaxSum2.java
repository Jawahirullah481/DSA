package datastructure.dp.problems;

import java.util.Arrays;

public class Problem12MaxSum2 {
    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };

        int solution = 0;

        // Recursion solution
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < matrix[0].length; i++) {
            maxSum = Math.max((int)getMaxSumRecursion(matrix, matrix.length - 1, i), maxSum);
        }
        solution = maxSum;

        // Memoization Solution
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(dp[i], -1);  // Fix: Correctly initialize each row
        }

        maxSum = Integer.MIN_VALUE; // Fix: Handle negative values

        for (int i = 0; i < matrix[0].length; i++) {
            maxSum = Math.max(getMaxSumMemoization(matrix, matrix.length - 1, i, dp), maxSum);
        }

        solution = maxSum;

        // Tabulation solution
        solution = getMaxSumTabulation(matrix, dp);

    }

    public static long getMaxSumRecursion(int[][] matrix, int x, int y) {

        if(y < 0 || y >= matrix[0].length) {
            return Integer.MIN_VALUE;
        }

        if(x == 0) {
            return matrix[x][y];
        }

        long top = matrix[x][y] + getMaxSumRecursion(matrix, x - 1, y);
        long left = matrix[x][y] + getMaxSumRecursion(matrix, x - 1, y - 1);
        long right = matrix[x][y] + getMaxSumRecursion(matrix, x - 1, y + 1);

        return Math.max(top, Math.max(left, right));
    }

    public static int getMaxSumMemoization(int[][] matrix, int x, int y, int[][] dp) {

        if(y < 0 || y >= matrix[0].length) {
            return Integer.MIN_VALUE;
        }

        if(x == 0) {
            return matrix[x][y];
        }

        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        int top = matrix[x][y] + getMaxSumMemoization(matrix, x - 1, y, dp);
        int left = matrix[x][y] + getMaxSumMemoization(matrix, x - 1, y - 1, dp);
        int right = matrix[x][y] + getMaxSumMemoization(matrix, x - 1, y + 1, dp);

        dp[x][y] = Math.max(top, Math.max(left, right));
        return dp[x][y];
    }

    public static int getMaxSumTabulation(int[][] matrix, int[][] dp) {
        int n = matrix.length, m = matrix[0].length;

        for(int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int left = j - 1 >= 0 ? dp[i - 1][j - 1]: Integer.MIN_VALUE;
                int top = dp[i - 1][j];
                int right = j + 1 < m ? dp[i - 1][j + 1]: Integer.MIN_VALUE;

                dp[i][j] = matrix[i][j] + Math.max(left, Math.max(top, right));
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < m; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        return max;

    }
}
