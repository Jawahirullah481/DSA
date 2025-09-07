package kunalsProblems.sorting.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem20CanMakArithmeticProg {

    /*
        LeetCode No : 1502, Problem Link : https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

        Try to understand and write the intuition for optimal solution when you visit it again.
     */

    public boolean canMakeArithmeticProgressionOptimal(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if ((max - min) % (n - 1) != 0) {
            return false;
        }

        int diff = (max - min) / (n - 1);
        if (diff == 0) return true;  // all elements equal

        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if ((num - min) % diff != 0) return false;
            seen.add(num);
        }

        return seen.size() == n;
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        for(int i = 2; i < arr.length; i++) {
            if(arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }
}
