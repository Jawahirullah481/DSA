package kunalsProblems.searching.medium;

import java.util.Arrays;

public class Problem7MinAbsoluteDifference {

    /*
        LeetCode No : 1818, Problem Link : https://leetcode.com/problems/minimum-absolute-sum-difference/

        Intuition :
        ===========

        1. For every nums2[i] we need the element in nums1[i] who is absolutely nearest to nums2[i].
        2. To do this quickly, we create sorted array and do binary search.
        3. Arrays.binarySearch() will return the index where the target is available. If not available, it returns the ceil of target.
        4. If target is not available, ceil may be closure to the target or floor may be closer to the target.
        5. So, we check for both of them.

        Example :
        =========
        nums1[0] = 10, nums2[0] = 5.
        * Old Diff is 10 - 5 which is 5.

        Suppose, if nums1[3] has 4, which is closer to 5 after doing binary search.
        * new Diff is 4 - 5 which is 1.

        So, Actual Difference from Old Diff and New Diff is 5 - 1 which is 4.
        Means, by replacing nums1[0] with nums1[3], we can reduce the totalSum by 4.

        Do this for all the elements in nums2.
        * Which element has highest difference from old Diff and new Diff, then that is the element we have to take.
        * Because, only max difference reduction element can reduce the maximum of totalSum.
     */

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = 1_000_000_007;
        int n = nums1.length;

        // Step 1: Sort a copy of nums1 for binary search
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        // Step 2: Calculate total sum
        long totalSum = 0;
        int maxReduction = 0;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            totalSum += diff;

            // Step 3: Binary search in sorted nums1
            int idx = Arrays.binarySearch(sorted, nums2[i]);
            if (idx < 0) idx = -idx - 1;  // insertion point

            // check closest candidates
            if (idx < n) {
                maxReduction = Math.max(maxReduction, diff - Math.abs(sorted[idx] - nums2[i]));
            }
            if (idx > 0) {
                maxReduction = Math.max(maxReduction, diff - Math.abs(sorted[idx - 1] - nums2[i]));
            }
        }

        return (int)((totalSum - maxReduction + MOD) % MOD);
    }

}
