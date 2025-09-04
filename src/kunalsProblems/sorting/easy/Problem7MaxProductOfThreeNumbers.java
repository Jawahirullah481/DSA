package kunalsProblems.sorting.easy;

import java.util.Arrays;

public class Problem7MaxProductOfThreeNumbers {

    /*
        LeetCode No : 628, Problem Link : https://leetcode.com/problems/maximum-product-of-three-numbers/

        Intution :
        ========
        🔹 First Thoughts

        The maximum product must involve the largest numbers.

        But what if the array has negative numbers?
        Multiplying two negatives gives a positive, which can make a much bigger product.

        Example:
        nums = [-10, -10, 5, 2]

        (-10) * (-10) * 5 = 500

        5 * 2 * -10 = -100
        So the maximum product isn’t just the last three numbers after sorting.

        🔹 Key Insight 💡

        There are only two cases to check:

        Product of the three largest numbers.
        → nums[n-1] * nums[n-2] * nums[n-3]

        Product of the two smallest numbers (possibly negative) × the largest number.
        → nums[0] * nums[1] * nums[n-1]

        The answer is the maximum of these two.
     */

    public int maximumProductBetter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int num1 = nums[0] * nums[1] * nums[n - 1];
        int num2 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        return Math.max(num1, num2);
    }

    public int maximumProductOptimal(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            // track top 3 maximums
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            // track bottom 2 minimums
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

}
