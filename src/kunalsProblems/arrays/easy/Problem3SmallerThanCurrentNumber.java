package kunalsProblems.arrays.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem3SmallerThanCurrentNumber {

    /*
        LeetCode No : 1365
     */

    public static void main(String[] args) {
        int[] arr = {8,1,2,2,3};
        smallerNumbersThanCurrentOptimal1(arr);
    }

    public static int[] smallerNumbersThanCurrentOptimal1(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int[] sorted = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sorted[i] = nums[i];
        }

        Arrays.sort(sorted);

        int count = 1;
        map.put(sorted[0], 0);

        for(int i = 1; i < sorted.length; i++) {
            if(sorted[i] != sorted[i - 1]) {
                map.put(sorted[i], count);
            }
            count++;
        }

        for(int i = 0; i < sorted.length; i++) {
            sorted[i] = map.get(nums[i]);
        }

        return sorted;

    }

    public static int[] smallerNumbersThanCurrentOptimal2(int[] nums) {

        /*
            Dry run :
            ========

            Example Input  : [8,1,2,2,3]

            🧮 Step 1: Count frequency

            freq[8] = 1
            freq[1] = 1
            freq[2] = 2
            freq[3] = 1
            After step 1, freq (only showing relevant indices):

            freq[0] = 0
            freq[1] = 1
            freq[2] = 2
            freq[3] = 1
            freq[8] = 1


            🔗 Step 2: Prefix Sum
            Cumulative addition from 1 to 100:

            freq[1] = freq[1] + freq[0] = 1
            freq[2] = freq[2] + freq[1] = 2 + 1 = 3
            freq[3] = freq[3] + freq[2] = 1 + 3 = 4
            freq[4] = freq[4] + freq[3] = 0 + 4 = 4
            ...
            freq[8] = freq[8] + freq[7] = 1 + 4 = 5
            Now the important part of the prefix array looks like:

            freq[0] = 0
            freq[1] = 1
            freq[2] = 3
            freq[3] = 4
            freq[8] = 5
            This tells us:

            freq[1] = 1 → 1 number ≤ 1

            freq[2] = 3 → 3 numbers ≤ 2

            freq[3] = 4 → 4 numbers ≤ 3

            freq[nums[i]-1] → how many numbers < nums[i]

            🧾 Step 3: Construct the result
            i	nums[i]	nums[i]-1	result[i] = freq[nums[i]-1]
            0	8	7	freq[7] = 4
            1	1	0	freq[0] = 0
            2	2	1	freq[1] = 1
            3	2	1	freq[1] = 1
            4	3	2	freq[2] = 3

            Important Question :
            =====================

            You may ask me, we have for the freq[x], we are including the count x itself. Then, how can we get only the smaller elements count.
            If you see the solution, freq[nums[i] - 1], we are taking the count x - 1. which will always have count exclusive of x.
         */


        int[] freq = new int[101];

        // Step 1: Count frequency of each number
        for(int num : nums) {
            freq[num]++;
        }

        // Step 2: Build prefix sum array
        for(int i = 1; i < 101; i++) {
            freq[i] += freq[i - 1];
        }

        // Step 3: Build result using prefix sum
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                result[i] = 0;
            else
                result[i] = freq[nums[i] - 1];
        }

        return result;
    }
}
