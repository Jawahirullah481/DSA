package datastructure.dp.problems;

import java.util.Arrays;

public class Problem7NinjaTraining {
    public static void main(String[] args) {
        int n = 3;
        int[][] points = { {10, 40, 70}, {20, 50, 80}, {30, 60, 90} };

        int solution = 0;

        // Recursion solution
        for(int task = 0; task <= 2; task++) {
            solution = Math.max(solution, ninjaRecursion(n - 1, task, points));
        }

        // Memoization solution
        int[][] dp = new int[n][3];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int task = 0; task <= 2; task++) {
            solution = Math.max(solution, ninjaMemoization(n - 1, task, points, dp));
        }

    }

    public static int ninjaRecursion(int day, int task, int points[][]) {

        if(day < 0) {
            return 0;
        }

        int maxPoints = Integer.MIN_VALUE;

        for(int i = 0; i <= 2; i++) {
            if(i != task) {
                maxPoints = Math.max(maxPoints, points[day][task] + ninjaRecursion(day - 1, i, points));
            }
        }

        return maxPoints;
    }

    public static int ninjaMemoization(int day, int task, int points[][], int[][] dp) {

        if(day < 0) {
            return 0;
        }

        if(dp[day][task] != -1) {
            return dp[day][task];
        }

        int maxPoints = Integer.MIN_VALUE;

        for(int i = 0; i <= 2; i++) {
            if(i != task) {
                maxPoints = Math.max(maxPoints, points[day][task] + ninjaMemoization(day - 1, i, points, dp));
            }
        }

        dp[day][task] = maxPoints;

        return maxPoints;
    }
}
