package datastructure.dp.problems;

import java.util.Arrays;

public class ClimbingStairsLC70 {
    public int climbStairs(int n) {

        // Recursion
        //return climb(0, n);

        // Memoization
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        //return climbMemoization(0, n, dp);

        // Tabulation
        //return climbTabulation(n);

        // Optimized
        return optimized(n);
    }

    private int climb(int step, int n) {
        if(step == n) {
            return 1;
        }
        if(step > n) {
            return 0;
        }

        return climb(step + 1, n) + climb(step + 2, n);
    }

    private int climbMemoization(int step, int n, int[] dp) {

        if(step == n) {
            dp[step] = 1;
            return 1;
        }

        if(step > n) {
            return 0;
        }

        if(dp[step] != -1) {
            return dp[step];
        }

        dp[step] = climbMemoization(step + 1, n, dp) + climbMemoization(step + 2, n, dp);
        return dp[step];
    }

    private int climbTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    private int optimized(int n) {
        int prev1 = 1, prev2 = 1;

        for(int i = 2; i <= n; i++) {
            int curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
