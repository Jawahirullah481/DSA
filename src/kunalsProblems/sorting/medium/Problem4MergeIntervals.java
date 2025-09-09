package kunalsProblems.sorting.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4MergeIntervals {

    /*
        LeetCode No : 56, Problem Link : https://leetcode.com/problems/merge-intervals/

        Follow up Question :
        ====================

        Commenting "line 1" works ? But, If We comment "line 1" and uncomment "line 2", it won't work. Why ?

        Good Question 👍
        ----------------

        The difference between your two solutions is **where you update `end`**.

        🔍 Solution 1 (Correct)
        -----------------------
        while (idx != intervals.length - 1 && end >= intervals[idx + 1][0]) {
            end = Math.max(end, intervals[idx + 1][1]);  // ✅ update `end`
            idx++;
        }
        list.add(new int[] { st, end });

        * At every overlap, you extend `end` to the maximum end seen so far.
        * That way, if multiple intervals overlap, `end` grows enough to cover all of them.

        Example:
        * intervals = [[1,3], [2,6], [5,10]]
        * Start: st = 1, end = 3
        * Overlap with [2,6]: end = max(3,6) = 6
        * Overlap with [5,10]: end = max(6,10) = 10
        * Final merged: [1,10] ✅

        🔍 Solution 2 (Wrong)
        ---------------------
        while (idx != intervals.length - 1 && end >= intervals[idx + 1][0]) {
            idx++;   // ❌ just moves forward, doesn’t update `end`
        }
        end = intervals[idx][1];
        list.add(new int[] { st, end });

        * You don’t expand `end` during the merge loop.
        * Instead, you just take the end of the last overlapping interval (`intervals[idx][1]`).
        * This fails when earlier intervals have a larger end than later ones.

        Example (same as above):
        * intervals = [[1,3], [2,6], [5,10]]
        * Works fine here…

        But test this:
        * intervals = [[1,10], [2,6], [3,5]]
        * Start: st = 1, end = 10
        * [2,6] overlaps → just move
        * [3,5] overlaps → just move
        * Final end = 5 ❌ (shrunk!)
        * Output = [1,5], but correct answer is [1,10].

        ✅ Conclusion
        -------------
        * **Solution 1 works** because it keeps track of the maximum `end` across all overlapping intervals.
        * **Solution 2 fails** because it only uses the last overlapping interval’s end, which can be smaller.

     */

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();

        int idx = 0;

        while(idx < intervals.length) {
            int st = intervals[idx][0];
            int end = intervals[idx][1];

            while(idx != intervals.length - 1 && end >= intervals[idx + 1][0]) {
                end = Math.max(end, intervals[idx + 1][1]); // ------> LINE 1
                idx++;
            }

            // end = intervals[idx][1]; // ----------> LINE 2
            list.add(new int[] { st, end });
            idx++;
        }

        return list.toArray(new int[list.size()][]);

    }
}
