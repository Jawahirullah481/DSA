package datastructure.array.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {9, 1, 4, 7, 3,-1, 0, 5, 8,-1, 6};

        // Solution 1
        findLongestConsSeq(arr);

        // Solution 2
        findLongestConsSeq2(arr);
    }

    public static void findLongestConsSeq(int[] arr1) {
        int[] arr = Arrays.copyOf(arr1, arr1.length);
        Arrays.sort(arr);

        int max = 1;
        int count = 1;
        int i = 0;
        int prev = 0;

        while(i < arr.length) {
            while(i < arr.length && arr[i] == arr[prev]) {
                i++;
            }
            if(i >= arr.length) {
                break;
            }

            if(arr[i] == arr[prev] + 1) {
                count++;
            } else {
                if(count > max) {
                    max = count;
                }
                count = 1;
            }
            prev = i;
        }

        if(count > max) {
            max = count;
        }

        System.out.println("Longest cons sequence is : " + max);
    }

    private static void findLongestConsSeq2(int[] arr) {

        // -1,-1, 0, 1, 3, 4, 5, 6, 7, 8, 9
        // -1, 0, 1, 3, 4, 5, 6, 7, 8, 9
        Set<Integer> set = new HashSet<>();
        for(int i : arr) {
            set.add(i);
        }

        int count = 1;
        int maxCount = 1;

        for(int i : set) {
            if(!set.contains(i - 1)) {
                count = 1;
                int x = i;
                while(set.contains(x + 1)) {
                    x++;
                    count++;
                }
                if(count > maxCount) {
                    maxCount = count;
                }
            }
        }
        System.out.println("Longest cons sequence is : " + maxCount);
    }

}
