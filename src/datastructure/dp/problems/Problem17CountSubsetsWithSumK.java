package datastructure.dp.problems;

import java.util.Arrays;

public class Problem17CountSubsetsWithSumK {
    public static void main(String[] args) {
        int[] num = {0, 1, 3};
        int tar = 4;

        int solution = 0;

        // Recursion solution
        solution = findWaysRecursion(num, tar, num.length - 1);

        // Memoization solution
        int[][] dp = new int[num.length][tar + 1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        solution = findWaysMemoization(num, tar, num.length - 1, dp);

    }

    public static int findWaysRecursion(int[] num, int target, int index) {

        if(index < 0) {
            return target == 0 ? 1 : 0;
        }

        int take = 0;
        if(num[index] <= target) {
            take = findWaysRecursion(num, target - num[index], index - 1);
        }
        int notTake = findWaysRecursion(num, target, index - 1);

        return take + notTake;
    }

    public static int findWaysMemoization(int[] num, int target, int index, int[][] dp) {

        if(index < 0) {
            return target == 0 ? 1 : 0;
        }

        if(dp[index][target] != -1) {
            return dp[index][target];
        }

        int take = 0;
        if(num[index] <= target) {
            take = findWaysMemoization(num, target - num[index], index - 1, dp);
        }
        int notTake = findWaysMemoization(num, target, index - 1, dp);

        dp[index][target] = take + notTake;
        return dp[index][target];
    }
}
