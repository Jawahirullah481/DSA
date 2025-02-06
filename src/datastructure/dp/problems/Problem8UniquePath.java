package datastructure.dp.problems;

import java.util.Arrays;

public class Problem8UniquePath {
    public static void main(String[] args) {
        int m = 3, n = 4;

        int solution = 0;
        
        // Recursion solution
        solution = uniquePathsRecursion(m, n, m - 1, n - 1);

        // Memoization solution
        int[][] dp = new int[m][n];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        solution = uniquePathsMemoization(m, n, m - 1, n - 1, dp);
    }

    public static int uniquePathsRecursion(int m, int n, int i, int j) {

        if(i == 0 && j == 0) {
            return 1;
        }

        if(i < 0 || j < 0) {
            return 0;
        }

        int right = uniquePathsRecursion(m, n, i, j - 1);
        int bottom = uniquePathsRecursion(m, n, i - 1, j);

        return right + bottom;
    }

    public static int uniquePathsMemoization(int m, int n, int i, int j, int[][] dp) {

        if(i == 0 && j == 0) {
            return 1;
        }

        if(i < 0 || j < 0) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = uniquePathsMemoization(m, n, i, j - 1, dp);
        int bottom = uniquePathsMemoization(m, n, i - 1, j, dp);

        dp[i][j] = right + bottom;
        return dp[i][j];
    }
}
