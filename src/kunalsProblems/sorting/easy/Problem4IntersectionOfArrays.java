package kunalsProblems.sorting.easy;

import java.util.*;

public class Problem4IntersectionOfArrays {
    /*
        LeetCode No : 349, Problem Link : https://leetcode.com/problems/intersection-of-two-arrays/
     */

    public int[] intersectionOptimal(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) set1.add(num);

        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) result.add(num);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersectionBetter(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                // avoid duplicates
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
