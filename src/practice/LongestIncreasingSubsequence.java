package practice;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        //return recursiveLength(nums, 0, -1);
        int[][] dp = new int[nums.length][nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int result = memoizationLength(nums, 0, -1, dp);
        return result;
    }

    private int recursiveLength(int[] nums, int index, int last) {
        // Logic :
        /*
            1. First I get 10. then find remaining answers.
            2. I will check if 10 is greater than last.
            3. if so, then take 10 and also add length(next of 10, 10);
            4. else, skip 10 and add length(next of 10, last)
        */

        if (index >= nums.length) {
            return 0;
        }

        int curr = nums[index];
        int max = 0;

        if (curr > last) {
            max = 1 + Math.max(max, recursiveLength(nums, index + 1, curr));
        }
        max = Math.max(max, recursiveLength(nums, index + 1, last));

        return max;
    }

    private int memoizationLength(int[] nums, int index, int last, int[][] dp) {
        // Logic :
        /*
            1. First I get 10. then find remaining answers.
            2. I will check if 10 is greater than last.
            3. if so, then take 10 and also add length(next of 10, 10);
            4. else, skip 10 and add length(next of 10, last)
        */

        if (index >= nums.length) {
            return 0;
        }

        if(dp[index][last + 1] != -1) {
            return dp[index][last + 1];
        }

        int curr = nums[index];
        int max = 0;

        if (last == -1 || curr > nums[last]) {
            max = 1 + memoizationLength(nums, index + 1, index, dp);
        }
        max = Math.max(max, memoizationLength(nums, index + 1, last, dp));
        dp[index][last + 1] = max;
        return dp[index][last + 1];
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence ls = new LongestIncreasingSubsequence();
        System.out.println("Max inc seq : " + ls.lengthOfLIS(arr));
    }
}
