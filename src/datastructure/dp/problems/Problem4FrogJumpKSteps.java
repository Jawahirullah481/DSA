package datastructure.dp.problems;

import java.util.Arrays;

public class Problem4FrogJumpKSteps {
    public static void main(String[] args) {
        int n = 5;
        int[] heights = {1, 2, 3, 4, 5};
        int k = 3;

        int solution = 0;

        // Recursion solution
        solution = minimumEnergyRecursion(n - 1, heights, k);

        // Memoization Solution
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        solution = minimumEnergyMemoization(n - 1, heights, k, dp);

        // Tabulation solution
        solution = frogTabulation(n, heights, dp, k);

        System.out.println(solution);
    }

    public static int minimumEnergyRecursion(int index, int[] heights, int k) {

        if(index == 0) {
            return 0;
        }

        if(index < 0) {
            return Integer.MAX_VALUE;
        }

        int minSteps = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++) {
            if(index - i >= 0) {
                int steps = Math.abs(heights[index] - heights[index - i]) + minimumEnergyRecursion(index - i, heights, k);
                minSteps = Math.min(minSteps, steps);
            }
        }

        return minSteps;
    }

    public static int minimumEnergyMemoization(int index, int[] heights, int k, int[] dp) {

        if(index == 0) {
            dp[index] = 0;
            return dp[index];
        }

        if(index < 0) {
            return Integer.MAX_VALUE;
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        int minSteps = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++) {
            if(index - i >= 0) {
                int steps = Math.abs(heights[index] - heights[index - i]) + minimumEnergyMemoization(index - i, heights, k, dp);
                minSteps = Math.min(minSteps, steps);
            }
        }

        dp[index] = minSteps;
        return dp[index];
    }

    public static int frogTabulation(int n, int heights[], int[] dp, int k) {
        dp[0] = 0;

        for(int ind = 1; ind < n; ind++) {
            int minSteps = Integer.MAX_VALUE;
            for(int i = 1; i <= k; i++) {
                if(ind - i >= 0) {
                    int steps = Math.abs(heights[ind] - heights[ind - i]) + dp[ind - i];
                    minSteps = Math.min(minSteps, steps);
                }
            }

            dp[ind] = minSteps;
        }

        return dp[n -1];
    }
}
