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
}
