package kunalsProblems.searching.medium;

public class Problem1SingleElementInArray {

    /*
        LeetCode No : 540, Problem Link : https://leetcode.com/problems/single-element-in-a-sorted-array/description/

        NOTE :
        ======
        In this problem, we are taking the first element and modulo it by 2 to shrink the range. Why?
        Because, if no number are missing, then there are even number of elements before the current number.
        But, if any number got missed, then odd number of elements only available prior to current element.
     */

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        if (n == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            int firstElement = nums[mid] == nums[mid - 1] ? mid - 1 : mid;
            if (firstElement % 2 == 0) {
                start = firstElement + 2;
            } else {
                end = firstElement - 1;
            }
        }

        return nums[start];
    }
}
