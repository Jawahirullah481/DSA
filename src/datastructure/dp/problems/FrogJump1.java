package datastructure.dp.problems;

public class FrogJump1 {
    /*
        In this example, we use top to bottom approach instead of bottom to top approach.
        And also, we use 2 recursion approaches.
            1. storing energy variable (not recommended)
            2. not storing energy variable (recommended)
        This problem is to analyze how different functions work.

        1. Your top to bottom or bottom to top approach is based on your base case.
        2. Based on that also you can change order of for loop
     */

    public static void main(String[] args) {
        System.out.println(frogJump(9, new int[] {7, 4, 4, 2, 6, 6, 3, 4 }));
    }

    public static int frogJump(int n, int heights[]) {
        // return recBottomToTop(0, 0, heights);

        // return recBottomToTop2(0, heights);

        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return memoization(0, heights, dp);

        // return tabulation(heights);

        return optimized(heights);
    }

    private static int recBottomToTop(int index, int energy, int heights[]) {
        if(index >= heights.length) {
            return Integer.MAX_VALUE;
        }

        if(index == heights.length - 1) {
            return energy;
        }

        int oneStep = recBottomToTop(index + 1, energy + Math.abs(heights[index] - heights[index + 1]), heights);
        int twoStep = Integer.MAX_VALUE;
        if(index < heights.length - 2)
            twoStep = recBottomToTop(index + 2, energy + Math.abs(heights[index] - heights[index + 2]), heights);

        return Math.min(oneStep, twoStep);
    }

    private static int recBottomToTop2(int index, int heights[]) {

        if(index == heights.length - 1) {
            return 0;
        }

        int oneStep = Math.abs(heights[index] - heights[index + 1]) + recBottomToTop2(index + 1, heights);
        int twoStep = Integer.MAX_VALUE;
        if(index < heights.length - 2) {
            twoStep = Math.abs(heights[index] - heights[index + 2]) + recBottomToTop2(index + 2, heights);
        }

        return Math.min(oneStep, twoStep);
    }

    private static int memoization(int index, int heights[], int[] dp) {
        if(index == heights.length - 1) {
            return 0;
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        int oneStep = Math.abs(heights[index] - heights[index + 1]) + memoization(index + 1, heights, dp);
        int twoStep = Integer.MAX_VALUE;
        if(index < heights.length - 2) {
            twoStep = Math.abs(heights[index] - heights[index + 2]) + memoization(index + 2, heights, dp);
        }

        dp[index] = Math.min(oneStep, twoStep);

        return dp[index];
    }

    private static int tabulation(int[] heights) {
        int[] dp = new int[heights.length];
        dp[heights.length - 1] = 0;

        for(int index = heights.length - 2; index >= 0; index--) {
            int oneStep = Math.abs(heights[index] - heights[index + 1]) + dp[index + 1];
            int twoStep = Integer.MAX_VALUE;
            if(index < heights.length - 2) {
                twoStep = Math.abs(heights[index] - heights[index + 2]) + dp[index + 2];
            }
            dp[index] = Math.min(oneStep, twoStep);
        }

        return dp[0];
    }

    private static int optimized(int[] heights) {

        int next1 = 0;
        int next2 = 0;

        for(int index = heights.length - 2; index >= 0; index--) {
            int oneStep = Math.abs(heights[index] - heights[index + 1]) + next1;
            int twoStep = Integer.MAX_VALUE;
            if(index < heights.length - 2) {
                twoStep = Math.abs(heights[index] - heights[index + 2]) + next2;
            }
            int curr = Math.min(oneStep, twoStep);
            next2 = next1;
            next1 = curr;
        }

        return next1;
    }
}
