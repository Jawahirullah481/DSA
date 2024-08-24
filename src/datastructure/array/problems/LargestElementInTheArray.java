package datastructure.array.problems;

import java.util.Arrays;

public class LargestElementInTheArray {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 9, 1, 2, 7};

        // Brute force approach
        findLargestBrute(arr);

        // Better & Optimal approach
        findLargestBetter(arr);
    }

    public static void findLargestBrute(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        newArr = ArrayUtil.sort(newArr);
        System.out.println("Largest element is : " + newArr[newArr.length - 1]);
    }

    public static void findLargestBetter(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Largest element is : " + max);
    }

}
