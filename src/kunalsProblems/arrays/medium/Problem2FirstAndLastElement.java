package kunalsProblems.arrays.medium;

public class Problem2FirstAndLastElement {

    /*
        LeetCode : 34, Problem Link : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     */

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirst(nums, target);
        ans[1] = findLast(nums, target);
        return ans;
    }

    private int findFirst(int[] nums, int target) {
        int st = 0, end = nums.length - 1, ans = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1;  // keep looking on the left
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }

    private int findLast(int[] nums, int target) {
        int st = 0, end = nums.length - 1, ans = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] == target) {
                ans = mid;
                st = mid + 1;  // keep looking on the right
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }
}
