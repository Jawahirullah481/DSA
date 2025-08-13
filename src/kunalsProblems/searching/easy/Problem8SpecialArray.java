package kunalsProblems.searching.easy;

import java.util.Arrays;

public class Problem8SpecialArray {
    /*
        LeetCode No : 1608, Problem Link : https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/

        NOTE : you can loop only up to nums.length, because x cannot be greater than n (count of numbers).

        Example :
        ==========
        # x is supposed to be the count of numbers ≥ x.
        # That means x itself can’t be bigger than n because:
        # The count of numbers in the array is at most n.
        # If x > n, then we’re asking for more elements than exist in the whole array — impossible.
     */

    public int specialArray(int[] nums) {

        Arrays.sort(nums);

        for(int i = 0; i <= nums.length; i++) {
            if(noOfGreaterNumbers(nums, i) == i) {
                return i;
            }
        }
        return -1;
    }

    public int noOfGreaterNumbers(int[] nums, int x) {
        int st = 0, end = nums.length - 1;

        while(st <= end) {
            int mid = st + (end - st) / 2;

            if(nums[mid] >= x) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return nums.length - st;
    }
}
