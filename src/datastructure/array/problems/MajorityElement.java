package datastructure.array.problems;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3};

        // Brute
        findMajorityElementBrute(arr);

        // Optimal
        findMajorityElementOptimal(arr);
    }

    private static void findMajorityElementOptimal(int[] arr) {
        /*
            This is simple approach. Keep track of each number and its count.
            And iterate map until its find key which has count >= half
         */

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                int val = map.get(arr[i]);
                map.replace(arr[i], val + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int half = (int)(Math.ceil(arr.length / 2.0));
        for(Integer i : map.keySet()) {
            int count = map.get(i);
            if(count >= half) {
                System.out.println("Majority element is : " + i);
            }
        }
    }

    private static void findMajorityElementBrute(int[] arr) {
        /*
            Thought process :
            =================
            The thought process behind this is
            1. Whenever the currNo and different no is meet, both will be cancelled out.
            2. At last the majority element will stand out.

            Suppose, we have following array,
            [1, 1, 1, 1, 2, 2, 2, 2, 1].

            For, each 1, the number 2 gets cancelled.
            So, when 4 1s and 4 2s are completed, the count will be 0.
            So, at last 1 is available. so 1 is the majority element.

         */
        int count = 0, candidate = 0;

        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        System.out.println("Majority element is : " + candidate);
    }
}
