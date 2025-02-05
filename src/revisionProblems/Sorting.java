package revisionProblems;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {

        // NOTE : In every sorting algorithm, we are iterating only till < n - 1; not < n;
        // Because, As comparisions are made between 2 different elements.
        // If you put < n, then number is compared with itself which is pointless.

        int[] arr = {5, 3, 1, 4, 2};
        bubbleSortMin(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {5, 3, 1, 4, 2};
        bubbleSortMax(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {5, 3, 1, 4, 2};
        selectionSort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {5, 3, 1, 4, 2};
        insertionSort(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = {5, 3, 1, 4, 2};
        circularSort(arr5);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = {5, 3, 1, 4, 2};
        arr6 = mergeSort(arr6);
        System.out.println(Arrays.toString(arr6));

        int[] arr7 = {5, 3, 1, 4, 2};
        arr7 = mergeSortInPlace(arr7);
        System.out.println(Arrays.toString(arr7));
    }

    private static int[] mergeSortInPlace(int[] arr7) {
        return null;
    }


    static void bubbleSortMin(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    static void bubbleSortMax(int[] arr) {
        // {5, 3, 1, 4, 2}
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /*
        Selection Sort :
        ===============
        selecting the nth minimum element in an array. And placing it in nth position.
        Ex :
        1. At 1st iteration, pick 1st minimum element and place it in 0th position.
        2. At 2nd iteration, pick 2nd minimum element and place it in 1st position.
        3. At 3rd iteration, pick 3rd minimum element and place it in 2nd position.
        and so on..

        The position of nth minimum element is hold by value of i.
     */
    static void selectionSort(int[] arr) {
        // {5, 3, 1, 4, 2}
        int n = arr.length;
        int min;
        for(int i = 0; i < n - 1; i++) {
            min = i;
            for(int j = i; j < n; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    /*
        Insertion Sort :
        ================
        inserting the element in sorted array.
        1. Get 1st element and try to insert it inside sorted array from 0 till 0.
        2. Get 2nd element and try to insert it inside sorted array from 0 till 1.
        3. Get 3rd element and try to insert it inside sorted array from 0 till 2.
        4. Get 4th element and try to insert it inside sorted array from 0 till 3.
     */

    static void insertionSort(int[] arr) {
        // {5, 3, 1, 4, 2}
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j > 0; j--) {
                if(arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    static void circularSort(int[] arr) {
        // {5, 3, 1, 4, 2}
        int n = arr.length;
        for(int i = 0; i < n - 1; ) {
            int value = arr[i];
            if(value != i + 1) {
                int temp = arr[value - 1];
                arr[value - 1] = value;
                arr[i] = temp;
            } else {
                i++;
            }
        }
    }

    static int[] mergeSort(int[] arr) {

        /*

            1. In merge sort algorithm, we are merging 2 sorted arrays into a single array.
            2. But, initially array itself is not sorted. Then how do you get sorted array.
            3. For this, You split array into half and sort it and merge this.
            4. How the array is sorted if you split it into a half.
            5. You have to repeat the splitting until there is only 1 element in an array.
            6. In the final end, you have 2 arrays of only 1 element in each and you use merge sort for this.
            7. You do this process again and again until the whole array is sorted.

         */
        if(arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] leftHalf = Arrays.copyOfRange(arr, 0, mid);
        int[] rightHalf = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(leftHalf), mergeSort(rightHalf));
    }

    static int[] merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] sorted = new int[arr1.length + arr2.length];

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                sorted[k] = arr1[i];
                i++;
            } else {
                sorted[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i < arr1.length) {
            sorted[k++] = arr1[i++];
        }

        while(j < arr2.length) {
            sorted[k++] = arr2[j++];
        }

        return sorted;
    }



}
