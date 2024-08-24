package datastructure.array.problems;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtil {

    public static int[] giveArray(int size) {
        int[] arr = new int[size];
        Random random = new Random(20);
        for(int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }

        return arr;
    }

    public static void reverse(int[] arr, int st, int end) {
        while(st < end) {
            int temp = arr[end];
            arr[end] = arr[st];
            arr[st] = temp;
            st++;
            end--;
        }
    }

    public static int[] sort(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(sort(leftArr), sort(rightArr));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] output = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                output[k] = arr1[i];
                i++;
            } else {
                output[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i < arr1.length) {
            output[k] = arr1[i];
            k++;i++;
        }

        while(j < arr2.length) {
            output[k] = arr2[j];
            k++;j++;
        }

        return output;
    }

    public static void print2DArray(int[][] arr) {
        for(int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

}
