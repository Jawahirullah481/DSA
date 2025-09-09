package kunalsProblems.sorting.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem6FindDuplicates {
    /*
        LeetCode No : 442, Problem Link : https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
     */

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int num : nums) {
            int idx = Math.abs(num) - 1;
            if(nums[idx] < 0) {
                list.add(Math.abs(num));
            } else {
                nums[idx] = -nums[idx];
            }
        }

        return list;
    }
}
