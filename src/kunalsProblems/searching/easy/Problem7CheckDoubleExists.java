package kunalsProblems.searching.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem7CheckDoubleExists {

    /*
        LeetCode No : 1346, Problem Link : https://leetcode.com/problems/check-if-n-and-its-double-exist/
     */

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {

            if(set.contains(arr[i] * 2)) {
                return true;
            }

            if(arr[i] % 2 == 0 && set.contains(arr[i] / 2)) {
                return true;
            }

            set.add(arr[i]);
        }

        return false;
    }
}
