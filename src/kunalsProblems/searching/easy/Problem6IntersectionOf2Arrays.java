package kunalsProblems.searching.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem6IntersectionOf2Arrays {

    /*
        LeetCode No : 349, Problem Link : https://leetcode.com/problems/intersection-of-two-arrays/description/
     */

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int ptr1 = 0, ptr2 = 0;

        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] == nums2[ptr2]) {
                // Add only if it's not a duplicate in the result
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[ptr1]) {
                    list.add(nums1[ptr1]);
                }
                ptr1++;
                ptr2++;
            } else if (nums1[ptr1] < nums2[ptr2]) {
                ptr1++;
            } else {
                ptr2++;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
