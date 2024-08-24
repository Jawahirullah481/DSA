package datastructure.array.problems;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class FindLengthOfUniqueElements {

    public static void main(String[] args) {

        // Find the length of unique elements in sorted array

        // Brute (Space Complexity : O(N)
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 5, 5};
        findLengthBrute(arr);
        // Optimal
        findLengthOptimal(arr);


        // Move unique elements to front
        moveUniqueElementsToFront(arr);

    }

    public static void findLengthBrute(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        System.out.println("No of Unique elements is : " + set.size());
    }


    private static void findLengthOptimal(int[] arr) {
        /*
            Thought Process :
            =================

            1. pointer1 will always point the unique number.
            2. pointer2 will iterate until it find the number which is not equal to pointer1.
            3. Once, pointer2 find the number which is different from pointer1, then unique will be increased.
            4. then my pointer1 will point the new unique number which is pointer2.
            5. Then the loop continues.
         */
        int pointer1 = 0;
        int pointer2 = 0;
        int unique = 1;

        while(pointer2 < arr.length) {
            while(pointer2 < arr.length && arr[pointer2] == arr[pointer1]) {
                pointer2++;
            }
            if(pointer2 < arr.length) {
                unique++;
                pointer1 = pointer2;
            }
        }

        System.out.println("No of unique elements is : " + unique);
    }

    public static void moveUniqueElementsToFront(int[] arr) {
        /*
            Thought Process :
            =================

            1. Make the firstPointer point the unique element.
            2. Iterate secondPointer until it's find another unique element.
            3. As I know firstPointer points the unique element, If I want to put another unique element
               I need to put it next to firstPointer.
            4. So, put next unique element(pointer2) next to firstPointer.
            5. Now new unique element is the element which is put next to firstPointer.
            6. So, increment firstPointer.
            7. Then continue.

         */
        int firstPointer = 0;
        int secondPointer = 1;

        while(secondPointer < arr.length) {
            while(secondPointer < arr.length && arr[secondPointer] == arr[firstPointer]) {
                secondPointer++;
            }
            if(secondPointer < arr.length) {
                // NOTE : Here, I don't swap elements. Because, it may cause inconsistency
                arr[firstPointer + 1] = arr[secondPointer];
                firstPointer++;
            }
        }

        System.out.println("Number of unique elements is : " + (firstPointer + 1));
        System.out.println("After moved : " + Arrays.toString(arr));
    }
}
