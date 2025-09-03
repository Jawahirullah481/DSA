package kunalsProblems.searching.medium;

public class Problem11CountNegativeNumbers {

    /*
        LeetCode No : 1351, Problem Link : https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/

        Intuition for Optimal Solution :
        ===============================
        Youtube : https://youtu.be/NoLIX84wLVc?si=J-dRYOOkdwsuPKDu
     */

    public int countNegativesOptimal(int[][] grid) {

        int row = grid.length - 1, col = 0;

        int count = 0;

        while (row >= 0 && col < grid[0].length) {
            if (grid[row][col] < 0) {
                count += (grid[0].length - col);
                row--;
            } else {
                col++;
            }
        }

        return count;
    }

    public int countNegativesBetter(int[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            int st = 0, end = grid[0].length - 1;

            while (st <= end) {
                int mid = st + (end - st) / 2;

                if (grid[i][mid] < 0) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            }

            count += grid[0].length - st;
        }

        return count;

    }

}
