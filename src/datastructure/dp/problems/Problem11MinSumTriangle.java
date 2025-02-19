package datastructure.dp.problems;

import java.util.Arrays;

public class Problem11MinSumTriangle {
    public static void main(String[] args) {

        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};

        int solution = 0;

        // Recursion
        solution = minSumTriangleRecursion(triangle, 0, 0);

        // Memoization
        int n = triangle.length;
        int[][] dp = new int[n][triangle[n - 1].length];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp, -1);
        }

        solution = minSumTriangleMemoization(triangle, 0, 0, dp);
        
        // Tabulation
        solution = minSumTriangleTabulation(triangle, dp);
    }

    public static int minSumTriangleRecursion(int[][] triangle, int row, int col) {
        if(row == triangle.length - 1) {
            return triangle[row][col];
        }

        int bottom = triangle[row][col] + minSumTriangleRecursion(triangle, row + 1, col);
        int diagonal = triangle[row][col] + minSumTriangleRecursion(triangle, row + 1, col + 1);

        return Math.min(bottom, diagonal);
    }

    public static int minSumTriangleMemoization(int[][] triangle, int row, int col, int[][] dp) {
        if(row == triangle.length - 1) {
            return triangle[row][col];
        }

        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        int bottom = triangle[row][col] + minSumTriangleMemoization(triangle, row + 1, col, dp);
        int diagonal = triangle[row][col] + minSumTriangleMemoization(triangle, row + 1, col + 1, dp);

        dp[row][col] = Math.min(bottom, diagonal);
        return dp[row][col];
    }

    public static int minSumTriangleTabulation(int[][] triangle, int[][] dp) {

        int n = triangle.length;

        for(int i = 0; i < triangle[n - 1].length; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                int bottom = triangle[i][j] + dp[i + 1][j];
                int diagonal = triangle[i][j] + dp[i + 1][j + 1];

                dp[i][j] = Math.min(bottom, diagonal);
            }
        }

        return dp[0][0];
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
