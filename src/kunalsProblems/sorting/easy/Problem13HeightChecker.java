package kunalsProblems.sorting.easy;

import java.util.Arrays;

public class Problem13HeightChecker {

    /*
        LeetCode No : 1051, Problem Link : https://leetcode.com/problems/height-checker/description/

        YouTube Link : https://youtu.be/7s7G42nWS1E?si=r79j6Id-6J_cKJeN

        Intuition :
        ==========

        Intuition Behind Counting Sort Approach
        ---------------------------------------

        Goal
        ----

        * We want to know how many students are not in their "expected" place (which is just the sorted order of heights).

        Naïve Way
        ---------

        * Copy the array → sort it (O(n log n)) → compare with original.
        * This works but sorting is extra cost.

        Key Observation
        ---------------

        * Heights are bounded: each height ∈ [1, 100].
        * Since the range is small and fixed, we don’t actually need to sort — we can just count frequencies and reconstruct the sorted order on the fly.

        Counting Sort Idea
        ------------------

        * Count how many times each height appears using a fixed array count[101].
        * This array now encodes the "sorted order" implicitly:
          * count[1] = k → means the first k elements in the heights should be in the height of 1.
          * count[2] = m → the next m elements should be in the height of 2.
          * and so on…

        Compare Directly Instead of Building New Array
        ----------------------------------------------

        * Instead of explicitly constructing the sorted array, we walk through the original heights.
        * For each heights[i], we figure out what the "expected" height should be by checking the smallest index idx such that count[idx] > 0.
        * If heights[i] != idx, that means the student is out of place → increment mismatch counter.
        * Reduce count[idx] since we "used" one occurrence of that height.

        Why It’s Efficient
        ------------------

        * We avoid sorting (O(n log n)) and instead do:
          * Count pass: O(n)
          * Comparison pass: O(n + 100) (at most 100 moves of idx).
        * Total: O(n) time, O(1) space.

     */

    public int heightCheckerOptimal(int[] heights) {

        int[] heightCount = new int[101];
        for(int height : heights) {
            heightCount[height]++;
        }

        int count = 0, idx = 1;
        for(int i = 0; i < heights.length; i++) {
            while(heightCount[idx] == 0) {
                idx++;
            }

            if(heights[i] != idx) {
                count++;
            }
            heightCount[idx]--;
        }

        return count;

    }

    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOfRange(heights, 0, heights.length);
        Arrays.sort(expected);

        int count = 0;

        for(int i = 0; i < heights.length; i++) {
            if(heights[i] != expected[i]) {
                count++;
            }
        }

        return count;
    }
}
