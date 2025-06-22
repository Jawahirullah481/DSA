package datastructure.graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Problem4NumberOfIslands {

    /*
        In the previous problem (Problem 3), the input is matrix representation of nodes connectivity.
        So, we have converted into the adjacency list.

        But, in this question, each grid[x][y] is a node. There is no connectivity matrix provided.
     */

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of Islands : " + numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    Node node = new Node(i, j);
                    bfs(node, visited, grid, n, m);
                    // dfs(node, visited, grid, n, m);
                }
            }
        }
        return count;
    }

    // --1. BFS Solution
    public static void bfs(Node node, boolean[][] visited, char[][] grid, int n, int m) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited[node.x][node.y] = true;

        while (!queue.isEmpty()) {

            Node currentNode = queue.poll();

            int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            for (int[] direction : directions) {

                int nextX = currentNode.x + direction[0];
                int nextY = currentNode.y + direction[1];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    Node nextNode = new Node(nextX, nextY);
                    if (!visited[nextX][nextY] && grid[nextX][nextY] == '1') {
                        queue.add(nextNode);
                        visited[nextX][nextY] = true;
                    }
                }
            }

        }
    }

    // -- 2. DFS Solution
    public static void dfs(Node node, boolean[][] visited, char[][] grid, int n, int m) {
        visited[node.x][node.y] = true;

        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        for(int[] direction : directions) {
            int nextX = node.x + direction[0];
            int nextY = node.y + direction[1];

            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                if(!visited[nextX][nextY] && grid[nextX][nextY] == '1') {
                    dfs(new Node(nextX, nextY), visited, grid, n, m);
                }
            }
        }
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