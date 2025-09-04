package kunalsProblems.sorting.easy;

public class Problem1MergeSortedArray {

    /*
        LeetCode No : 88, Problem Link : https://leetcode.com/problems/merge-sorted-array/

        Intuition :
        ===========

        Problem restated
        ----------------
        We have:
        * nums1 of size m + n, where first m elements are sorted, and last n slots are empty (to fit nums2).
        * nums2 of size n, sorted.
        * Goal: merge nums2 into nums1 in sorted order, in-place.

        Naive thought process (first ideas)
        -----------------------------------
        1. If we directly start merging from the front, we would overwrite elements in nums1.
           Example:
           nums1 = [1,2,3,0,0,0], nums2 = [2,5,6]
           If we insert 2 from nums2 in front, we’ll lose the original 2 and 3 unless we shift them → costly (O(m*n)).

        2. Another idea: Copy nums2 into the extra slots of nums1 and sort the whole array.
           This works but takes O((m+n) log(m+n)), not optimal.

        Key insight 💡
        -------------
        * Both arrays are sorted.
        * The largest elements are at the end of each array.
        * nums1 has extra space at the end.
        👉 So if we start placing numbers from the back, we never overwrite useful data.

     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while(j >= 0) {
            if(i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

    }
}
