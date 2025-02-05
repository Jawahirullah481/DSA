package datastructure.dp.problems;

import java.util.Arrays;
import java.util.List;

public class Problem5MaxSumOfNonAdjElements {
    public static void main(String[] args) {
        int solution = 0;
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Recursion solution
        solution = maxSumRecursion(nums, nums.size() - 1);

        // Memoization solution
        int[] dp = new int[nums.size() - 1];
        Arrays.fill(dp, - 1);
        solution = maxSumMemoization(nums, nums.size() - 1, dp);

        System.out.println(solution);
    }

    public static int maxSumRecursion(List<Integer> nums, int index) {

        if(index < 0) {
            return 0;
        }

        int take = nums.get(index) + maxSumRecursion(nums, index - 2);
        int notTake = 0 + maxSumRecursion(nums, index - 1);

        return Math.max(take, notTake);
    }

    public static int maxSumMemoization(List<Integer> nums, int index, int[] dp) {

        if(index < 0) {
            return 0;
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        int take = nums.get(index) + maxSumMemoization(nums, index - 2, dp);
        int notTake = 0 + maxSumMemoization(nums, index - 1, dp);

        dp[index] = Math.max(take, notTake);
        return dp[index];
    }
}
