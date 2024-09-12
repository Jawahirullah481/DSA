package datastructure.dp.problems;

public class FrogJump2 {

    public static void main(String[] args) {
        System.out.println(frogJump(5, new int[] {10, 30, 40, 50, 20}, 3));
        System.out.println(frogJump(3, new int[] {10, 20, 10}, 1));
        System.out.println(frogJump(2, new int[] {10, 10}, 100));
        System.out.println(frogJump(10, new int[] {40, 10, 20, 70, 80, 10, 20, 70, 80, 60}, 4));
    }

    public static int frogJump(int n, int heights[], int k) {
         return recBottomToTop(0, 0, heights, k);

        // return recBottomToTop2(0, heights);

        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return memoization(0, heights, dp);

        // return tabulation(heights);

        // return optimized(heights);
    }

    private static int recBottomToTop(int index, int energy, int[] heights, int k) {
        if(index >= heights.length) {
            return Integer.MAX_VALUE;
        }

        if(index == heights.length - 1) {
            return energy;
        }

//        int oneStep = recBottomToTop(index + 1, energy + Math.abs(heights[index] - heights[index + 1]), heights, k);
//        int twoStep = Integer.MAX_VALUE;
//        if(index < heights.length - 2)
//            twoStep = recBottomToTop(index + 2, energy + Math.abs(heights[index] - heights[index + 2]), heights, k);

        int minStep = Integer.MAX_VALUE;

        for(int i = 1; i <= k; i++) {
            int nextStep = Integer.MAX_VALUE;
            if(index < heights.length - i) {
                nextStep = recBottomToTop(index + i, energy + Math.abs(heights[index] - heights[index + i]), heights, k);
            }
            minStep = Math.min(minStep, nextStep);
        }

        return minStep;
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
