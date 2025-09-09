package kunalsProblems.sorting.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3FourSum {

    /*
        LeetCode No : 18, Problem Link : https://leetcode.com/problems/4sum/description/

        Youtube Link : https://youtu.be/eD95WRfh81c?si=7bqgsWHL67uIEDOi
     */

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < nums.length - 3; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;

                int st = j + 1, end = nums.length - 1;
                while(st < end) {
                    long sum = (long)nums[i] + nums[j] + nums[st] + nums[end];

                    if(sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[st], nums[end]));

                        while(st < end && nums[st] == nums[st + 1]) st++;
                        while(st < end && nums[end] == nums[end - 1]) end--;

                        st++; end--;
                    } else if (sum < target) {
                        st++;
                    } else {
                        end--;
                    }
                }
            }
        }

        return list;
    }
}
