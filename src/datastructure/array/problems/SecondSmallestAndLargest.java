package datastructure.array.problems;

import java.util.Arrays;

public class SecondSmallestAndLargest {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.giveArray(10);
        find2ndSmallestAnd2ndLargest(arr);
    }

    public static void find2ndSmallestAnd2ndLargest(int[] arr) {
        int firstSmallest = arr[0];
        int secondSmallest = Integer.MAX_VALUE;
        int firstLargest = arr[0];
        int secondLargest = Integer.MIN_VALUE;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < firstSmallest) {
                secondSmallest = firstSmallest;
                firstSmallest = arr[i];
            } else if(arr[i] < secondSmallest) {
                secondSmallest = arr[i];
            }

            if(arr[i] > firstLargest) {
                secondLargest = firstLargest;
                firstSmallest = arr[i];
            } else if(arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        System.out.println("Array is : " + Arrays.toString(arr));
        System.out.println("SecondSmallest : " + secondSmallest + " | SecondLargest : " + secondLargest);

    }
}
