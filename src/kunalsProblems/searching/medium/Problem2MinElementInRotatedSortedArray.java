package kunalsProblems.searching.medium;

public class Problem2MinElementInRotatedSortedArray {

    /*
        LeetCode No : 153, Problem Link : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/git
     */

    public int findMin(int[] nums) {
        int pivot = nums[0] <= nums[nums.length - 1] ? nums.length - 1 : findPivot(nums);

        return nums[(pivot + 1) % nums.length];
    }

    public int findPivot(int[] nums) {
        int st = 0, end = nums.length - 1;

        while(st <= end) {
            int mid = st + (end - st) / 2;

            if(nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if(nums[mid] >= nums[0]) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

}
