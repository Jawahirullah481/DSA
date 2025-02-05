package datastructure.dp.problems;

import java.util.Arrays;

public class Problem3FrogJump {
    public static void main(String[] args) {
        int n = 5;
        int[] heights = {1, 2, 3, 4, 5};

        int solution = 0;

        // Recursion solution
        solution = minimumEnergyRecursion(n - 1, heights);

        // Memoization Solution
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        solution = minimumEnergyMemoization(n - 1, heights, dp);

        System.out.println(solution);
    }

    public static int minimumEnergyRecursion(int index, int[] heights) {

        // I am already reached the 0th stair. No need to move anywhere. so no energy required.
        if(index == 0) {
            return 0;
        }

        if(index < 0) {
            return Integer.MAX_VALUE;
        }

        // If take one step
        int oneStep = Math.abs(heights[index] - heights[index - 1]) + minimumEnergyRecursion(index - 1, heights);
        int twoStep = Integer.MAX_VALUE;

        // If take two step
        if(index > 1) {
            twoStep = Math.abs(heights[index] - heights[index - 2]) + minimumEnergyRecursion(index - 2, heights);
        }

        return Math.min(oneStep, twoStep);
    }

    public static int minimumEnergyMemoization(int index, int[] heights, int[] dp) {

        // I am already reached the 0th stair. No need to move anywhere. so no energy required.
        if(index == 0) {
            dp[index] = 0;
            return dp[index];
        }

        if(index < 0) {
            dp[index] = Integer.MAX_VALUE;
            return dp[index];
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        // If take one step
        int oneStep = Math.abs(heights[index] - heights[index - 1]) + minimumEnergyMemoization(index - 1, heights, dp);
        int twoStep = Integer.MAX_VALUE;

        // If take two step
        if(index > 1) {
            twoStep = Math.abs(heights[index] - heights[index - 2]) + minimumEnergyMemoization(index - 2, heights, dp);
        }

        dp[index] = Math.min(oneStep, twoStep);
        return dp[index];
    }
}
