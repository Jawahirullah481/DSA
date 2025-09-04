package kunalsProblems.sorting.easy;

import java.util.Arrays;

public class Problem6ArrayPartition {
    /*
        LeetCode No : 561, Problem Link : https://leetcode.com/problems/array-partition/
     */

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        for(int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}
