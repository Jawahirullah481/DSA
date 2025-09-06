package kunalsProblems.sorting.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem16RankInArray {

    /*
        LeetCode No : 1331, Problem Link : https://leetcode.com/problems/rank-transform-of-an-array/
     */

    public int[] arrayRankTransform(int[] arr) {
        int[] copy = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(copy); // O(n)

        Map<Integer, Integer> map = new HashMap<>(); // O(n)
        int rank = 1;
        for(int i = 0; i < copy.length; i++) { // O(n)
            int num = copy[i];
            if(!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        for(int i = 0; i < arr.length; i++) { // O(n)
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
