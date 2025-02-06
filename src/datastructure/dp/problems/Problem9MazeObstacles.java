package datastructure.dp.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem9MazeObstacles {
    public static void main(String[] args) {
        int n = 3, m = 3;
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

        mat.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        mat.add(new ArrayList<>(Arrays.asList(0, 1, 0)));
        mat.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        int solution = 0;

        // Recursion solution
        solution = mazeObstaclesRecursion(n, m, n - 1, m - 1, mat);


        int[][] dp = new int[n][m];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        solution = mazeObstaclesMemoization(n, m, n - 1, m - 1, mat, dp);

        
    }

    static int mazeObstaclesRecursion(int n, int m, int i, int j, ArrayList<ArrayList<Integer>> mat) {
        if(i == 0 && j == 0 && mat.get(i).get(j) != -1) {
            return 1;
        }

        if(i < 0 || j < 0 || mat.get(i).get(j) == -1) {
            return 0;
        }

        return mazeObstaclesRecursion(n, m, i - 1, j, mat) + mazeObstaclesRecursion(n, m, i, j - 1, mat);
    }

    static int mazeObstaclesMemoization(int n, int m, int i, int j, ArrayList<ArrayList<Integer>> mat, int[][] dp) {
        if(i == 0 && j == 0 && mat.get(i).get(j) != -1) {
            return 1;
        }

        if(i < 0 || j < 0 || mat.get(i).get(j) == -1) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = mazeObstaclesMemoization(n, m, i - 1, j, mat, dp) + mazeObstaclesMemoization(n, m, i, j - 1, mat, dp);
        return dp[i][j];
    }

}
