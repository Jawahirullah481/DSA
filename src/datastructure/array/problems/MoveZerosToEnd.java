package datastructure.array.problems;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        // Move Zeros to end

        // Brute force (Space : O(N), Time : 2N)
        moveZerosToEndBrute(arr);

        // Optimal (Space : O(1), Time : O(1))
        moveZerosToEndOptimal(arr);
    }

    private static void moveZerosToEndBrute(int[] arr) {
        System.out.println("Before Moving : " + Arrays.toString(arr));
        int[] newArr = new int[arr.length];
        int i = 0;
        for(int j = 0; j < arr.length; j++) {
            if(arr[j] != 0) {
                newArr[i] = arr[j];
                i++;
            }
        }

        System.out.println("After Moved : " + Arrays.toString(newArr));
    }

    private static void moveZerosToEndOptimal(int[] arr) {

        /*
            1. Iterate pointer1 until it find 0.
            2. Iterate pointer2 until it find non zer.
            3. Now pointer1 is before pointer2.
            4. Swap 2 values. Now 0 goes back. and non zero value comes before.

         */

        System.out.println("Before Moving : " + Arrays.toString(arr));

        int pointer1 = 0;
        int pointer2 = 1;

        while(pointer1 < arr.length && pointer2 < arr.length) {
            // I wanna iterate pointer1 until I found the 0
            while(pointer1 < arr.length && arr[pointer1] != 0) {
                pointer1++;
            }
            pointer2 = pointer1 + 1;
            // I wanna iterate pionter2 until I found non zero value to be swapped
            while(pointer2 < arr.length && arr[pointer2] == 0) {
                pointer2++;
            }

            if(pointer1 < arr.length && pointer2 < arr.length) {
                int temp = arr[pointer2];
                arr[pointer2] = arr[pointer1];
                arr[pointer1] = temp;
                pointer1++;
                pointer2++;
            }
        }
        System.out.println("After Moved : " + Arrays.toString(arr));
    }
}
