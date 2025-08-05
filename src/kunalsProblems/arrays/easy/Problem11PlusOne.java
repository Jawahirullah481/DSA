package kunalsProblems.arrays.easy;

import java.util.Arrays;

public class Problem11PlusOne {

    /*
        LeetCode No : 66, Problem Link : https://leetcode.com/problems/plus-one/

        NOTE :
        ======
        Important : When carry exists, no need to remove 1st element of array. Just return immediately.
        Otherwise, trim the 1st element of the array.

     */

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        int[] res = plusOne(digits);

        System.out.println(Arrays.toString(res));
    }

    public static int[] plusOne(int[] digits) {
            int n = digits.length;
            int[] res = new int[n + 1]; // Extra space in case carry remains

            int carry = 1;  // We want to add 1
            for (int i = n - 1; i >= 0; i--) {
                int sum = digits[i] + carry;
                res[i + 1] = sum % 10;
                carry = sum / 10;
            }

            if (carry != 0) {
                res[0] = carry;
                return res; // Important : When carry exists, no need to remove 1st element of array. Just return immediately
            }

            // Skip the first zero if no carry
            return Arrays.copyOfRange(res, 1, n + 1);
        }
}
