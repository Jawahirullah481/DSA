package datastructure.array.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    /*
        NOTES :
        =======

        Suppose, If I have an array of 8 elements, [1, 2, 3, 4, 5, 6, 7, 8]. My target sum is 12.
        1. You will start iterating the array and sum every element.
        2. When you reach the element 5, your sum will be 15.
        3. But, your target is 12.
        4. So, if you separate(kalati vidrathu) 3 from 15, you will get 12.
        5. As, I know this is positive array and the sum is never decrease.
        6. So, I want to get the first element, until whom the sum is 3.
        7. So, index 1, the sum is 3.
        8. So, I want to remove (1, 2) from the current array, so that I can get the consecutive sum of 12.
        9. So, the distance is from element 2 - element 5, which is 3.
        10. But, In the future, there may be a larger sequence may come with same sum of 12.
        11. So, you need to check with all the remaining elements also.
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 4, 5, 1, 1, 0, 1};
        int k = 3;

        findLongestSubArrayWithSumK(arr, k);
    }

    private static void findLongestSubArrayWithSumKPositive(int[] arr, int k) {
    }

    private static void findLongestSubArrayWithSumK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // sum 0 at index -1

        int sum = 0, maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

            // Only add sum to map if it's not already present
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }


        System.out.println("Longest subarray length with sum " + k + " is : " + maxLen);
    }
}
