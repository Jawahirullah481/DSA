package kunalsProblems.searching.medium;

import java.util.Arrays;

public class Problem4FindRightInterval {

    /*
        LeetCode No : 436, Problem Link : https://leetcode.com/problems/find-right-interval/description/

        Intuition :
        ============
        Key Observations :
        # What we really need is, for each interval’s end, the next closest start that is ≥ end.
        # That’s basically a lower bound search problem (like in binary search) if we had all the starts sorted.

        Why Sort Starts?
        If you sort all intervals by their start, then for any end you can do a binary search to find the first start that is ≥ that end.
        This avoids a brute force O(n²) scan.

        👉 Intuition Summary:
        Problem is asking for a "next closest start ≥ current end".
        Sorting starts gives order.
        Binary search (lower bound) finds the correct match efficiently.

     */

    public int[] findRightInterval(int[][] intervals) {

        int n = intervals.length;
        int[] res = new int[n];
        int[][] starts = new int[n][2];

        for(int i = 0; i < intervals.length; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }

        Arrays.sort(starts, (a, b) -> a[0] - b[0]);

        // find lower bound for each end element
        for(int i = 0; i < intervals.length; i++) {
            int idx = lowerBound(starts, intervals[i][1]);
            res[i] = idx;
        }

        return res;
    }

    public int lowerBound(int[][] starts, int target) {
        int st = 0, end = starts.length;

        while(st < end) {
            int mid = st + (end - st) / 2;

            if(starts[mid][0] >= target) {
                end = mid;
            } else {
                st = mid + 1;
            }
        }

        return st < starts.length ? starts[st][1] : -1;
    }

}
