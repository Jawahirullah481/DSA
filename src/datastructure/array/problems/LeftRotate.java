package datastructure.array.problems;

import java.util.Arrays;

public class LeftRotate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        // Left rotate by 1 place.
        leftRotateBy1Place(arr);


        int[] arr2 = {1, 2, 3, 4, 5, 6};
        // Left rotate by k place.
        leftRotateByKPlace(arr2, 5);

        int[] arr3 = {1, 2, 3, 4, 5, 6};
        // right rotate by k place.
        rightRotateByKPlace(arr3, 3);
    }

    public static void leftRotateBy1Place(int[] arr) {

        System.out.println("Before Rotate by 1 place : " + Arrays.toString(arr));

        int temp = arr[0];
        for(int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        arr[arr.length - 1] = temp;

        System.out.println("After Rotate by 1 place  : " + Arrays.toString(arr));
    }

    public static void leftRotateByKPlace(int[] arr, int k) {
        /*
            Let's say we rotate by 2 place.

            Before Rot : 1, 2, 3, 4, 5, 6
            After Rot  : 3, 4, 5, 6, 1, 2

            STEP 1 : Rotate(0, k - 1) ->  2, 1, 3, 4, 5, 6
            STEP 2 : Rotate(k, n - 1) ->  2, 1, 6, 5, 4, 3
            STEP 3 : Rotate(0, n - 1) ->  3, 4, 5, 6, 1, 2

         */
        System.out.println("Before Rotate by " + k + " place : " + Arrays.toString(arr));

        k = k % arr.length;

        ArrayUtil.reverse(arr, 0, k - 1);
        ArrayUtil.reverse(arr, k, arr.length - 1);
        ArrayUtil.reverse(arr, 0, arr.length - 1);

        System.out.println("After Rotate by " + k + " place  : " + Arrays.toString(arr));
    }

    public static void rightRotateByKPlace(int[] arr, int k) {
                /*
            Let's say we rotate by 2 place.

            Before Rot : 1, 2, 3, 4, 5, 6
            After Rot  : 3, 4, 5, 6, 1, 2

            STEP 1 : Rotate(0, n - k - 1) ->  4, 3, 2, 1, 5, 6
            STEP 2 : Rotate(n - k, n - 1) ->  4, 3, 2, 1, 6, 5
            STEP 3 : Rotate(0, n - 1)     ->  5, 6, 1, 2, 3, 4

         */
        System.out.println("Before Right Rotate by " + k + " place : " + Arrays.toString(arr));

        k = k % arr.length;

        ArrayUtil.reverse(arr, 0, arr.length - k - 1);
        ArrayUtil.reverse(arr, arr.length - k, arr.length - 1);
        ArrayUtil.reverse(arr, 0, arr.length - 1);

        System.out.println("After Right Rotate by " + k + " place  : " + Arrays.toString(arr));
    }
}
