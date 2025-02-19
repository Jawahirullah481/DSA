package datastructure.dp.problems;

import java.util.Arrays;

public class Problem2CountWaysToReachNthStair {

    /*
        Here, we are using array size as n + 1. Because, it is easy to store
        f(n) solution into nth index instead of n - 1 index.
        Which increase readability.
     */

    public static void main(String[] args) {
        int stairs = 3;
        int solution = 0;

        // Recursion Solution
        solution = countWaysRecursion(stairs);

        // Memoization Solution
        int[] dp = new int[stairs + 1];
        Arrays.fill(dp, -1);
        solution = countWaysMemoization(stairs, dp);

        // Tabulation solution
        solution = countWaysTabulation(stairs, dp);

        System.out.println(solution);
    }

    public static int countWaysRecursion(int stairIndex) {
        if(stairIndex == 0) {
            return 1;
        }

        if(stairIndex < 0) {
            return 0;
        }

        return countWaysRecursion(stairIndex - 1) + countWaysRecursion(stairIndex - 2);
    }

    public static int countWaysMemoization(int stairIndex, int[] dp) {
        if(stairIndex == 0) {
            dp[stairIndex] = 1;
            return dp[stairIndex];
        }

        if(stairIndex < 0) {
            return 0;
        }

        if(dp[stairIndex] != -1) {
            return dp[stairIndex];
        }

        dp[stairIndex] = countWaysMemoization(stairIndex - 1, dp) + countWaysMemoization(stairIndex - 2, dp);
        return dp[stairIndex];
    }

    public static int countWaysTabulation(int stairs, int[] dp) {

        if(stairs <= 1) {
            return 1;
        }

        dp[0] = 1; dp[1] = 1;


        for(int stair = 2; stair <= stairs; stair++) {
            int oneStep = dp[stair - 1];
            int twoStep = dp[stair - 2];

            dp[stair] = oneStep + twoStep;
        }

        return dp[stairs];
    }
}
