package datastructure.array.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 4, 5, 1, 1, 0, 1};
        int k = 3;

        findLongestSubArrayWithSumK(arr, k);
    }

    private static void findLongestSubArrayWithSumKPositive(int[] arr, int k) {
    }

    private static void findLongestSubArrayWithSumK(int[] arr, int k) {
        int sum = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }

            int rem = sum - k;
            if(map.containsKey((rem))) {
                maxLength = Math.max(maxLength, i - map.get(rem));
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }


        System.out.println("Longest subarray length with sum " + k + " is : " + maxLength);
    }
}
