package kunalsProblems.sorting.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem22FindDisappearedNumbers {

    /*
        LeetCode No : 448, Problem Link : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

        Intuition :
        ===========
        # In this problem, I have used the encoding/decoding technique to mark the number is available in the array.
        # Check common_theories' 2nd point to know more.
     */

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int num : nums) {
            int idx = Math.abs(num) - 1;

            if(nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }
}
