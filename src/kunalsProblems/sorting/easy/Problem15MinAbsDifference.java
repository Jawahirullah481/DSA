package kunalsProblems.sorting.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15MinAbsDifference {

    /*
        LeetCode No : 1200, Problem Link : https://leetcode.com/problems/minimum-absolute-difference/
     */

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length - 1; i++) {
            int num1 = arr[i];
            int num2 = arr[i + 1];
            int diff = num2 - num1;

            if(diff < minDiff) {
                ans.clear();
                minDiff = diff;
            }

            if(diff == minDiff) {
                ans.add(Arrays.asList(num1, num2));
            }
        }

        return ans;
    }
}
