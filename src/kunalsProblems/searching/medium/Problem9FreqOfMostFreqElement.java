package kunalsProblems.searching.medium;

import java.util.Arrays;

public class Problem9FreqOfMostFreqElement {

    /*
        LeetCode No : 1838, Problem Link : https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/

        Logic behind operations calculation :
        =====================================

        See /resources/images/leetcode_1838_operations_calc_logic.png

        Intuition:
        # nums[right] * window_size = the total value we want (all elements raised to nums[right]).
        # sum(window) = the total value they currently have.
        # Their difference = how many increments are needed.
     */

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;   // use long for sum
        int left = 0, maxFreq = 0;  // keep these as int

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            long operations = (long) nums[right] * (right - left + 1) - sum;
            while (operations > k) {
                sum -= nums[left];
                left++;
                operations = (long) nums[right] * (right - left + 1) - sum;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }

}
