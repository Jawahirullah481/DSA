package kunalsProblems.searching.medium;

public class Problem12SearchInSortedRotatedArray {

    /*
        LeetCode No : 81, Problem Link : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

        Youtube Link : https://youtu.be/w2G2W8l__pc?si=GJpoQfXq7-ngJyK9

        Intution :
        ===========

        1. If nums[mid] == nums[st] == nums[end], then we don't know which half is sorted. So, in that case, we need to shrink the range.
        2. If nums[mid] <= nums[st], left half is sorted. Then search in that range.
        3. If nums[mid] <= target && target <= nums[end], then right half is sorted. Then search in that range.

        NOTE : Try to get the sorted half and search in that half. If You can't find the sorted half, then shrink the range.
     */

    public boolean search(int[] nums, int target) {
        int st = 0, end = nums.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] == target) return true;

            // Skip duplicates
            if (nums[st] == nums[mid] && nums[mid] == nums[end]) {
                st++;
                end--;
                continue;
            }

            // Left half is sorted
            if (nums[st] <= nums[mid]) {
                if (nums[st] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }

}
