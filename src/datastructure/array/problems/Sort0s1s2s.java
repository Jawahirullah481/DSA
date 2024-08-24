package datastructure.array.problems;

import java.util.Arrays;

public class Sort0s1s2s {

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 1, 2, 0, 0, 2};

        // Sort 0s, 1s and 2s
        int i = sort(arr, 0, 0);
        sort(arr, 1, i);

        System.out.println("After Sorted : " + Arrays.toString(arr));
    }

    public static int sort(int[] arr, int searchNo, int st) {
        int i = st;
        int j = 0;

        while(i < arr.length && j < arr.length) {
            // Iterate i until it finds next non zero(search) number
            while(i < arr.length && arr[i] == searchNo) {
                i++;
            }
            j = i + 1;

            // Iterate j until it finds next search number
            while(j < arr.length && arr[j] != searchNo) {
                j++;
            }

            if(j < arr.length) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        return i;
    }

}
