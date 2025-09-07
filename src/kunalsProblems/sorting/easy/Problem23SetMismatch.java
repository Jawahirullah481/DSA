package kunalsProblems.sorting.easy;

public class Problem23SetMismatch {

    /*
        LeetCode No : 645, Problem Link : https://leetcode.com/problems/set-mismatch/description/

        Intuition :
        ===========
        # In this problem, I have used the encoding/decoding technique to mark the number is available in the array.
        # Check common_theories' 2nd point to know more.
     */

    class Solution {
        public int[] findErrorNums(int[] nums) {
            int dup = -1, missing = -1;

            // Step 1: Find duplicate using negative marking
            for (int num : nums) {
                int idx = Math.abs(num) - 1;
                if (nums[idx] < 0) {
                    dup = Math.abs(num); // seen before → duplicate
                } else {
                    nums[idx] *= -1; // mark visited
                }
            }

            // Step 2: Find missing (index that stayed positive)
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    missing = i + 1;
                    break;
                }
            }

            return new int[]{dup, missing};
        }
    }

}
