package datastructure.graph.problems;

import java.util.*;

public class Problem12NumberOfDistinctIslands {
    /*
        Problem Statement :

        Given a 2D grid containing only 0s (water) and 1s (land), an island is a group of connected 1s (connected 4-directionally: up, down, left, right).
        Two islands are considered distinct if and only if one island's shape is different from another island's shape. (The shape is the relative position pattern of the land cells forming the island.)
        Write an algorithm to count the number of distinct islands in the grid.

     */

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };

        System.out.println("Number of Distinct Islands : " + solveBFS(grid));
        System.out.println("Number of Distinct Islands : " + solveDFS(grid));

    }

    // -- 1. BFS Solution
    public static int solveBFS(int[][] grid) {
        Set<List<String>> set = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    List<String> list = new ArrayList<>();
                    bfs(i, j, grid, visited, list, i, j);
                    set.add(list);
                }
            }
        }

        return set.size();
    }

    public static void bfs(int x, int y, int[][] grid, boolean[][] visited, List<String> list, int parentX, int parentY) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            list.add(toString(node.x - parentX, node.y - parentY));

            int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
            for(int[] dir : directions) {
                int nextX = node.x + dir[0];
                int nextY = node.y + dir[1];

                if(nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length
                   && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                    queue.add(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    // -- 2. DFS Solution
    public static int solveDFS(int[][] grid) {
        Set<List<String>> set = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    List<String> list = new ArrayList<>();
                    dfs(i, j, grid, visited, list, i, j);
                    set.add(list);
                }
            }
        }

        return set.size();
    }

    public static void dfs(int x, int y, int[][] grid, boolean[][] visited, List<String> list, int parentX, int parentY) {
        visited[x][y] = true;
        list.add(toString(x - parentX, y - parentY));

        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        for(int[] dir : directions) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if(nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length
                    && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                dfs(nextX, nextY, grid, visited, list, parentX, parentY);
            }
        }
    }

    public static String toString(int x, int y) {
        return Integer.toString(x) + " " + Integer.toString(y);
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
