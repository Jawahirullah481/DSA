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
         */
        int currNo = arr[0];
        int currNoCount = 1;
        int i = 1;

        while(i < arr.length) {
            while(i < arr.length && currNoCount != 0) {
                if(arr[i] == currNo) {
                    currNoCount++;
                } else {
                    currNoCount--;
                }
                i++;
            }

            if(i < arr.length) {
                currNo = arr[i];
                i++;
                currNoCount = 1;
            }
        }

        System.out.println("Majority element is : " + currNo);
    }
}
