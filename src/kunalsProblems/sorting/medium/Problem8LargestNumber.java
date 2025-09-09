package kunalsProblems.sorting.medium;

import java.util.Arrays;

public class Problem8LargestNumber {
    /*
        LeetCode No : 179, Problem Link : https://leetcode.com/problems/largest-number/description/
     */

    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArr, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));

        StringBuilder sb = new StringBuilder();
        for(String str : strArr) {
            sb.append(str);
        }

        if(sb.charAt(0) == '0') return "0";

        return sb.toString();
    }
}
