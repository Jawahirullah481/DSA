package kunalsProblems.sorting.easy;

import java.util.Arrays;

public class Problem23SetMismatch {

    /*
        LeetCode No : 645, Problem Link : https://leetcode.com/problems/set-mismatch/description/

        Intuition :
        ===========
        # In this problem, I have used the encoding/decoding technique to mark the number is available in the array.
        # Check common_theories' 2nd point to know more.
     */

    public int[] findErrorNumsOptimal(int[] nums) {
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

    public int[] findErrorNumsSorting(int[] nums) {

        /*
            ⚡ Careful walkthrough of the example
            -----------------------------------

            * nums = [2, 3, 4, 5, 5]
              (after sorting — but this one is already sorted)

            Expected Correct Array
            ----------------------
            * For n = 5, the array should be:
              [1, 2, 3, 4, 5]

            Code Logic (with dup and missing)
            --------------------------------
            * for (int i = 0; i < nums.length; i++) {
                  if (i > 0 && nums[i] == nums[i - 1]) {
                      dup = nums[i];  // duplicate found
                  }
                  if (nums[i] != i + 1 && missing == -1) {
                      missing = i + 1;  // missing found
                  }
              }

            Step-by-step Trace
            ------------------
            * i = 0 → nums[0] = 2, expected = 1
              * Not equal → missing = 1 ✅

            * i = 1 → nums[1] = 3, expected = 2
              * Not equal but missing already set → do nothing

            * i = 2 → nums[2] = 4, expected = 3
              * Again mismatch, but we ignore because missing is already found

            * i = 3 → nums[3] = 5, expected = 4
              * Same case, ignored

            * i = 4 → nums[4] = 5, expected = 5
              * Now nums[4] == nums[3] → duplicate = 5

            Final Result
            ------------
            * Duplicate = 5
            * Missing = 1

            Answer: [5, 1] ✅

            Why we need the `missing` variable
            ---------------------------------
            * Multiple indices won’t match their expected value once a number is duplicated and one is missing.
            * If we naively set `missing = i + 1` every time a mismatch happens, we’d overwrite it with wrong values (like 2, 3, 4).
            * That’s why we only set `missing` once (first mismatch), which correctly gives 1.

            👉 Without the missing guard (`missing == -1`), this example would wrongly say missing = 4 instead of 1.

         */
        Arrays.sort(nums);
        int dup = -1, missing = -1;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                dup = nums[i];  // duplicate found
            }
            if (nums[i] != i + 1 && missing == -1) {
                missing = i + 1;  // missing found
            }
        }

        // Edge case: if missing not found inside loop, it must be n
        if (missing == -1) {
            missing = nums.length;
        }

        return new int[]{dup, missing};
    }

}
