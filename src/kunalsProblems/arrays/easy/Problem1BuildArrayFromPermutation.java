package kunalsProblems.arrays.easy;

public class Problem1BuildArrayFromPermutation {
    /*
        LeetCode Problem : 1920, Link : https://leetcode.com/problems/build-array-from-permutation/description/

        Description :
        ===========

        ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
            = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]

     */

    public static void main(String[] args) {
        
        int[] arr = {0, 2, 1, 5, 3, 4};
        buildArrayBrute(arr);

        int[] arr1 = {0, 2, 1, 5, 3, 4};
        buildArrayOptimal(arr1);
    }

    public static int[] buildArrayBrute(int[] nums) {
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }

    public static int[] buildArrayOptimal(int[] nums) {

        /*

            ✅ What You’ve Learned:
            Yes — by encoding two numbers into one using math, and later decoding them back, you can manipulate arrays in-place without needing extra space.

            🧠 General Idea
            Let’s say:

            You want to store two values a and b in a single integer x.
            a and b must both be less than some known maximum N.

            You can encode as:
            x = a + N * b;

            You can decode as:
            a = x % N;
            b = x / N;

             What the Optimal Solution is doing ?

             Suppose, we have an array as [5, 0, 1, 2, 3, 4].

             Encrypt = (old_number) + (new_number * N)

             How can we retrieve by encrypting like this.

             1. To get Old Number : nums[i] % N;
             2. To get New Number : nums[i] / N;

             Why it is working ?

             Let's take the 1st index.

             1. nums[1] = 5.
             2. nums[1] = nums[1] + (nums[nums[1]] % N) * N
             => nums[1] = 5 + (nums[5] % 6) * 6
             => nums[1] = 5 + (4 % 6) * 6
             => nums[1] = 5 + 24
             => nums[1] = 29.

             Important Note : 29 consists of both the old number and new number in the below format.

             New number was multiplied with N. And old number was added.

             so, 29 => 24 + 5.
             -- 1. When we %, 29 % 6 => 5 (which is an extra number which was added after multiplication).
             -- 2. When we /, 29 / 6 => 4 (which is a number which was multiplied).

             =====================================================================================
        */

        int n = nums.length;

        // --1. Encode the index which withholds, both the current number and next number.
        for(int i = 0; i < n; i++) {
            nums[i] = nums[i] + (nums[nums[i]] % n) * n;
        }

        // --2. Decode the index.
        for(int i = 0; i < n; i++) {
            int oldNumber = nums[i] % n;
            int newNumber = nums[i] / n;

            nums[i] = newNumber;
        }

        return nums;

    }
}
