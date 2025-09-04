package kunalsProblems.sorting.easy;

import java.util.Arrays;

public class Problem3MissingNumber {

    /*
        LeetCode No : 268, Problem Link :  https://leetcode.com/problems/missing-number/

        Intuition Behind Optimal Solutions for LeetCode 268: Missing Number
        ------------------------------------------------------------------

        1. Sum Formula Method
        ---------------------

        * Key Idea 💡
          We know the numbers are supposed to be from 0 to n.

        * The sum of the first n natural numbers is:
          expectedSum = n(n + 1) / 2

        * If we subtract the actual sum of the array, the difference will be the missing number.

        Example
        -------

        * nums = [3, 0, 1], n = 3
        * expectedSum = 3 × 4 / 2 = 6
        * actualSum = 3 + 0 + 1 = 4
        * missing = 6 − 4 = 2

        Why It Works
        ------------

        * The array is a complete set of numbers from 0..n but with one missing.
        * So total sum must equal the formula sum.
        * Whatever is missing will appear as the difference.

        ✅ Intuition: "Compare what you should have vs. what you actually have — the gap is the missing number."

     */

    public int missingNumberOptimal(int[] nums) {
        int n = nums.length;
        int expected = n * (n + 1) / 2;
        int actual = 0;
        for (int num : nums) actual += num;
        return expected - actual;
    }

    public int missingNumberBetter(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }
}
