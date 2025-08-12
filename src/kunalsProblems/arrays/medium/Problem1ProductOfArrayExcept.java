package kunalsProblems.arrays.medium;

public class Problem1ProductOfArrayExcept {
    /*
        LeetCode No : 238, Problem Link : https://leetcode.com/problems/product-of-array-except-self/description/

        Problem Description :
        ======================
        Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
        You must write an algorithm that runs in O(n) time and without using the division operation.

        🔁 First Pass: Left Product
        1. Iterate from left to right.
        2. For each index i, store the product of all elements before i.
        3. Use an output array res[] to store this.
        4. At the end of this pass:
        5. res[i] = nums[0] * nums[1] * ... * nums[i - 1]

        🔁 Second Pass: Right Product (in-place)
        1. Iterate from right to left.
        2. Keep a variable rightProduct initialized as 1.
        3. For each index i, multiply res[i] by rightProduct (i.e., product of all elements after i).
        4. Update rightProduct *= nums[i] after each step.
        5. Final res[i] = (product of nums[0] to nums[i-1]) * (product of nums[i+1] to nums[n-1])

     */

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int left = 1;
        for(int i = 0; i < nums.length; i++) {
            res[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }
}
