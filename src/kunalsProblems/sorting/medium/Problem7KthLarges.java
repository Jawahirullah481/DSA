package kunalsProblems.sorting.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem7KthLarges {

    /*
        LeetCode No : 215, Problem Link : https://leetcode.com/problems/kth-largest-element-in-an-array/description/

        NOTE :
        ======
        # Solution 1 won't work for the test cases with large elements. Because, it involves shifting operation, it will take large amount of time.
        # Solution 2 is better than Solution 1.
     */

    public int findKthLargestSolution2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int num : nums) {
            queue.offer(num);

            if(queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }

    public int findKthLargestSolution1(int[] nums, int k) {

        int[] arr = new int[k];
        Arrays.fill(arr, Integer.MIN_VALUE);

        for(int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(arr));

            int num = nums[i];

            int j = 0;
            while(j < arr.length && arr[j] >= num) {
                j++;
            }

            if(j < arr.length) {
                for(int a = arr.length - 2; a >= j; a--) {
                    arr[a + 1] = arr[a];
                }
                arr[j] = num;
            }
        }

        return arr[k - 1];
    }
}
