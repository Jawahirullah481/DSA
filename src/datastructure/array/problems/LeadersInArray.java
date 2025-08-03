package datastructure.array.problems;

import java.util.Arrays;

public class    LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        leadersInArray(arr);
    }

    private static void leadersInArray(int[] arr) {
        /*
            Problem statement : Replace every element with greatest element to its right.

            Thought Process :
            =================
            1. Always set n-1 element to -1.
            2. Take max variable to keep track of maximum number.
            3. Iterate from n - 2 till 0.
            4. Check if curr el is greater than max.
            5. If so, then set curr with max. and max to what we had in curr.
            6. If not, then simply replace curr with max.
         */

        int n = arr.length;
        int max = arr[n - 1];
        arr[n - 1] = -1;

        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] > max) {
                int temp = max;
                max = arr[i];
                arr[i] = temp;
            } else {
                arr[i] = max;
            }
        }

        System.out.println("After update : " + Arrays.toString(arr));

    }
}
