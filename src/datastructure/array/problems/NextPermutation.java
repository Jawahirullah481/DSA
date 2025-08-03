package datastructure.array.problems;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 5, 4, 3};
        findNextPermutation(arr);
    }

    private static void findNextPermutation(int[] arr1) {
        /*
            Thought Process :
            =================
            1. Iterate the arr form the end until it meets a dip(until it starts decrease)
            2. Once you find the dip, then replace the element with the next biggest element.
            3. Then sort the rest of the remaining elements.
            4. If you don't find any dip, that means array is in desc order.
            5. There is not next permutation lexicographically. So, return the ascending order.

            Example :
            =========

            num = 2 9 3 2 (Taj's last 4 number)
            next permutation = 3 2 2 9, Because, After the number 2932 ,the next greater number is 3229

            I found a dip at  2 <- 9.

            Question : Why I am looking for a dip ?
            Answer : Because, 3 > 2 and 9 > 3. They are already in descending order. I cannot get next permutation by only using these 3 digits.
                     So, I need to include the prev digit to find next permutation.

            So,
            STEP 1 : What is the next greater number after 2. ==> 3.
            STEP 2 : SWAP 2 and 3 ==> 3 9 2 2
            STEP 3 : SORT rest of the numbers ==> 3 2 2 9

         */

        int[] arr = Arrays.copyOf(arr1, arr1.length);

        int st = -1;
        for(int i = arr.length - 1;i > 0; i--) {
            if(arr[i] > arr[i - 1]) {
                // I found the dip. So, Preseve the index.
                st = i;

                // Next find the next biggest number.
                int nextMax = arr[i];
                int nextMaxInd = i;

                for(int j = i; j < arr.length; j++) {
                    if(arr[j] > arr[i - 1] && arr[j] < nextMax) {
                        nextMax = arr[j];
                        nextMaxInd = j;
                    }
                }

                int temp = arr[i - 1];
                arr[i - 1] = arr[nextMaxInd];
                arr[nextMaxInd] = temp;
                break;
            }
        }
        // Sort remaining part of array
        if(st == -1) {
            sort(arr, 0, arr.length);
        } else {
            sort(arr, st, arr.length);
        }


        System.out.println("Next Permutation of " + Arrays.toString(arr1) + " is : " + Arrays.toString(arr));
    }

    public static void sort(int[] arr, int st, int end) {
        for(int i = st; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
