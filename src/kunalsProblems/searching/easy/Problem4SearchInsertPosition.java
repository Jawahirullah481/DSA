package kunalsProblems.searching.easy;

public class Problem4SearchInsertPosition {

    /*
        LeetCode No : 35, Problem Link : https://leetcode.com/problems/search-insert-position/description/

        Intuition :
        ===========

        # If a number is missing, then that place was occupied by the first bigger number than this.
        # So, if the number if found, we return that index.
        # If the number is not found, we return the position of next bigger number.
     */

    public int searchInsert(int[] nums, int target) {
        int st = 0, end = nums.length - 1;

        while(st <= end) {
            int mid = st + (end - st) / 2;

            if(nums[mid] == target) return mid;

            if(nums[mid] < target) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return st;
    }
}
