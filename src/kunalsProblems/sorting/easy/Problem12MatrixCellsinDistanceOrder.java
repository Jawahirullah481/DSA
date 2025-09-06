package kunalsProblems.sorting.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Problem12MatrixCellsinDistanceOrder {

    /*
        LeetCode No : 1030, Problem Link : https://leetcode.com/problems/matrix-cells-in-distance-order/

        Intution :
        =========
        Arrange the coordinates based on the shortest distance from the center.
     */

    public int[][] allCellsDistOrderOptimal(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[rows * cols][2];
        boolean[][] visited = new boolean[rows][cols];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 4 directions

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{rCenter, cCenter});
        visited[rCenter][cCenter] = true;

        int idx = 0;
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            res[idx++] = new int[]{r, c};

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return res;
    }

    public int[][] allCellsDistOrderBetter(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[rows * cols][2];
        int idx = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[idx++] = new int[]{i, j};
            }
        }

        Arrays.sort(res, (i, j) -> {
            int dist1 = Math.abs(rCenter - i[0]) + Math.abs(cCenter - i[1]);
            int dist2 = Math.abs(rCenter - j[0]) + Math.abs(cCenter - j[1]);

            return dist1 - dist2;
        });

        return res;
    }
}
