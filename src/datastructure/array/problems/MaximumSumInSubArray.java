package datastructure.array.problems;

public class MaximumSumInSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, -4, 3, 2, -10, 9, 1};

        // Brute
        findMaxSumBrute(arr);

        // Optimal (Kadan's Algorithm)
        findMaxSumOptimal(arr);
    }

    private static void findMaxSumBrute(int[] arr) {
        /*
            Thought Process :
            =================
            1. General all subarrays.
            2. Find the maximum sum.
         */
        int sum = 0;
        int maxSum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum = 0;
            for(int j = 0; j < arr.length; j++) {
                sum += arr[j];
                if(sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        System.out.println("Maximum Sum in the array is : " + maxSum);
    }

    private static void findMaxSumOptimal(int[] arr) {
        /*
            Thought Process :
            ================
            1. Iterate and sum every single element of the array.
            2. If the sum reaches -ve number,
               by carrying that -ve sum, we won't get that max sum in remaining part of array.
            3. Because, Even though the remaining part of array's sum is that much large, by carrying
               the -1 number, that largest sum will reduce to -1.
            4. Because of this, we can't get maximum sum of the array.
         */

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        while(i < arr.length) {
            sum += arr[i++];

            maxSum = Math.max(sum, maxSum);

            // NOTE
            if(sum < 0) {
                sum = 0;
            }
        }

        System.out.println("Maximum Sum in the array is : " + maxSum);
    }

}
