package datastructure.graph.problems;

import datastructure.array.problems.ArrayUtil;

import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.Queue;
import java.util.zip.DeflaterInputStream;

public class Problem9MinimumDistanceToReach0 {

    /*
        For this problem, always use BFS as it is efficient.
        Here, I solved DFS just for knowledge.
     */

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        updateMatrixBFS(mat);
        updateMatrixDFS(mat);
    }

    // -- 1. BFS Solution
    public static int[][] updateMatrixBFS(int[][] mat) {

        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[][] distance = new int[mat.length][mat[0].length];

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            distance[node.x][node.y] = node.dist;

            int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            for (int[] dir : directions) {
                int nextX = node.x + dir[0];
                int nextY = node.y + dir[1];

                if (nextX >= 0 && nextY >= 0 && nextX < mat.length && nextY < mat[0].length && !visited[nextX][nextY]) {
                    if (mat[nextX][nextY] == 1) {
                        queue.add(new Node(nextX, nextY, node.dist + 1));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }

        return distance;

    }

    // 2. DFS Solution
    public static int[][] updateMatrixDFS(int[][] mat) {
        int[][] distance = new int[mat.length][mat[0].length];

        for(int i = 0 ; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
               dfs(i, j, mat, distance);
            }
        }

        ArrayUtil.print2DArray(distance);
        return distance;
    }

    public static int dfs(int i, int j, int[][] mat, int[][] distance) {

        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) return Integer.MAX_VALUE;

        if(distance[i][j] != Integer.MAX_VALUE) return distance[i][j];

        if(mat[i][j] == 0) return 0;

        int up = dfs(i - 1, j, mat, distance);
        int right = dfs(i, j + 1, mat, distance);
        int bottom = dfs(i + 1, j, mat, distance);
        int left = dfs(i, j - 1, mat, distance);

        int minDistance = Math.min(Math.min(up, right), Math.min(bottom, left)) + 1;
        distance[i][j] = minDistance;

        return minDistance;
    }

    static class Node {
        int x;
        int y;
        int dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
