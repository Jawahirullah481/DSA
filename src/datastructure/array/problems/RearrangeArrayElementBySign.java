package datastructure.array.problems;

import java.util.Arrays;

public class RearrangeArrayElementBySign {
    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -4, 5, 6, 7, 8};

        // Answer 1
        solution1(arr);

        // Answer 2
        solution2(arr);
    }

    public static void solution1(int[] arr1) {
        /*
            Thought Process :
            ==================
            1. The problem states, there are equal no.of +ve and -ve elements
            2. So Create 2 arrays to hold pos and neg separately.
            3. Finally, iterate 2 arrays and store +ve and -ve alternatively in new arr
         */

        int[] arr = Arrays.copyOf(arr1, arr1.length);

        int[] pos = new int[arr.length / 2];
        int[] neg = new int[arr.length / 2];
        int p = 0, n = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                pos[p++] = arr[i];
            } else {
                neg[n++] = arr[i];
            }
        }

        for(int i = 0; i < pos.length; i++) {
            arr[2 * i] = pos[i];
            arr[2 * i + 1] = neg[i];
        }

        System.out.println("After rearrange : " + Arrays.toString(arr));
    }

    public static void solution2(int[] arr) {
        /*
            Though Process :
            ================
            1. This is 2 pointer approach.
            2. Iterate i until it finds next 1st +ve number.
            3. After found, add it into res arr.
            4. Iterate j until it finds next 1st -ve number.
            4. After found, add it into res arr.
         */
        int[] res = new int[arr.length];
        int i = 0; int j = 0;
        int k = 0;

        while(i < arr.length || j < arr.length) {
            while(i < arr.length && arr[i] < 0) {
                i++;
            }

            if(i < arr.length)
                res[k++] = arr[i++];

            while(j < arr.length && arr[j] > 0) {
                j++;
            }

            if(j < arr.length)
                res[k++] = arr[j++];
        }

        System.out.println("After rearrange : " + Arrays.toString(res));
    }
}
