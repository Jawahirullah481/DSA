package kunalsProblems.sorting.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem21SortArrayInIncreasingFreq {

    /*
        LeetCode No : 1636, Problem Link : https://leetcode.com/problems/sort-array-by-increasing-frequency/description/
     */

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (i, j) -> {

            if(map.get(i) == map.get(j)) return -(i - j);
            return map.get(i) - map.get(j);

        });

        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }
}
