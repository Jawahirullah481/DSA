package practice;

import java.util.Arrays;

public class Zoho1 {
    public static void main(String[] args) {
        int[] arr = {0, 2, 2, 2, 0, 6, 6, 0, 0, 8};
        changeArray(arr);
        System.out.println(Arrays.toString(arr));
        arr = rearrangeArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void changeArray(int[] arr) {
        for(int i = 0; i < arr.length - 2; i++) {
            if(arr[i] == arr[i + 1]) {
                arr[i] = arr[i] * 2;
                arr[i + 1] = 0;
            }
        }
    }

    public static int[] rearrangeArray(int[] arr) {
        int[] duplicate = new int[arr.length];
        for(int i = 0, j = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                continue;
            } else {
                duplicate[j++] = arr[i];
            }
        }

        return duplicate;
    }
}

/*

Input : arr[] = {2, 2, 0, 4, 0, 8}
Output : 4 4 8 0 0 0

Input : arr[] = {0, 2, 2, 2, 0, 6, 6, 0, 0, 8}
Output : 4 2 12 8 0 0 0 0 0 0

  1. for(0 -> n-2)
  2. check if i == i+1

 */
