package kunalsProblems.searching.medium;

public class Problem8FindPeakElement2 {

    /*
        LeetCode No : 1901, Problem Link : https://leetcode.com/problems/find-a-peak-element-ii/description/

        Why solution 1 correction and solution 2 is wrong ?

        🔴 Solution 2 approach (why it fails)

        # Pick a random mid-index from binary search inside a row (or column).
        # Compare only with its immediate neighbors (left/right if row, up/down if column).
        # Move toward the bigger neighbor.

        ⚠️ Problem: Rows/columns are not sorted or unimodal, so a bigger neighbor doesn’t guarantee that the peak lies in that direction. You can “walk past” the actual peak.


        ✅ Solution 2 approach (why it works)

        # In each iteration, pick the maximum element in the chosen row/column.
        # Only then compare with its vertical/horizontal neighbors.
        # If it’s bigger than both → peak found.
        # If not, move toward the neighbor direction (up/down or left/right).

        ✔️ Guarantee:
        Because you always start from the local maximum in that row/column, if a neighbor is larger, you’re forced to move in that direction — and eventually you must stop at a peak (since the grid is finite).

        NOTE :
        =====

        * Incorrect solution : Take the random mid from binary search and move based on neighbors.
        * Correct solution   : Take the element as mid if it is large in column or row and move based on neighbors.

     */

    // -- 1. Correction Solution
    public int[] findPeakGridRightProcess(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;

            // row index of max in this column
            int maxRow = 0;
            for (int r = 1; r < m; r++) {
                if (mat[r][mid] > mat[maxRow][mid]) maxRow = r;
            }

            int left  = (mid > 0)     ? mat[maxRow][mid - 1] : Integer.MIN_VALUE;
            int right = (mid < n - 1) ? mat[maxRow][mid + 1] : Integer.MIN_VALUE;

            if (mat[maxRow][mid] > left && mat[maxRow][mid] > right) {
                return new int[]{maxRow, mid};
            } else if (right > mat[maxRow][mid]) {
                lo = mid + 1;   // move right
            } else {
                hi = mid - 1;   // move left
            }
        }
        return new int[]{-1, -1};
    }

    // -- 2. Wrong Solution
    public int[] findPeakGridWrongProcess(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        for (int i = 0; i < m; i++) {
            int st = 0, end = n - 1;

            while (st <= end) {
                int mid = st + (end - st) / 2;
                int val = mat[i][mid];

                boolean up    = i > 0     && mat[i - 1][mid] > val;
                boolean down  = i < m - 1 && mat[i + 1][mid] > val;
                boolean left  = mid > 0   && mat[i][mid - 1] > val;
                boolean right = mid < n-1 && mat[i][mid + 1] > val;

                if (!up && !down && !left && !right) {
                    return new int[]{i, mid}; // peak found
                }

                // move inside row (binary search decision)
                if (right && mat[i][mid + 1] > val) {
                    st = mid + 1; // go right
                } else if (left && mat[i][mid - 1] > val) {
                    end = mid - 1; // go left
                } else {
                    // if blocked vertically, just break out
                    break;
                }
            }
        }
        return new int[]{-1, -1};
    }
}
