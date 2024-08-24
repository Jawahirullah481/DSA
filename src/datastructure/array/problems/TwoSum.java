package datastructure.array.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;

        // Brute
        twoSumBrute(arr, target);

        // Optimal
        twoSumOptimal(arr, target);
    }

    public static void twoSumBrute(int[] arr, int target) {
        /*
            Thought process :
            ================

            1. Get the number.
            2. Check if the pair(remaining to get target) is in map.
            3. If so, then those 2 are 2 sums.
            4. iterate until you find the pair.
            5. If you don't find the pair, then return -1, -1;

         */
        Map<Integer, Integer> map = new HashMap<>();
        int ind1 = -1, ind2 = -1;
        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int rem = target - num;
            if(map.containsKey(rem)) {
                ind1 = map.get(rem);
                ind2 = i;
                break;
            } else {
                map.put(num, i);
            }
        }

        System.out.println("Target is made by " + arr[ind1] + " and " + arr[ind2]);

    }

    public static void twoSumOptimal(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        int ind1 = -1;
        int ind2 = -1;

        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == target) {
                ind1 = left;
                ind2 = right;
            } else if(sum > target) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println("Target is made by " + arr[left] + " and " + arr[right]);
    }
}
