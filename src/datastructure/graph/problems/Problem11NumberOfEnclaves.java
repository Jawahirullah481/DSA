package datastructure.graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Problem11NumberOfEnclaves {

    /*
        LeetCode : 1020
     */

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        int solution = 0;

        solution = solveBFS(grid);
        solution = solveDFS(grid);
    }

    // -- 1. BFS Solution
    public static int solveBFS(int[][] board) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        // Top Row
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == 1) {
                queue.add(new Node(0, col));
                visited[0][col] = true;
            }
        }

        // Bottom Row
        for (int col = 0; col < board[0].length; col++) {
            if (board[board.length - 1][col] == 1) {
                queue.add(new Node(board.length - 1, col));
                visited[board.length - 1][col] = true;
            }
        }

        // Left Col
        for (int row = 1; row < board.length - 1; row++) {
            if (board[row][0] == 1) {
                queue.add(new Node(row, 0));
                visited[row][0] = true;
            }
        }

        // Right Col
        for (int row = 1; row < board.length - 1; row++) {
            if (board[row][board[0].length - 1] == 1) {
                queue.add(new Node(row, board[0].length - 1));
                visited[row][board[0].length - 1] = true;
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

            for (int[] dir : directions) {
                int adjX = node.x + dir[0];
                int adjY = node.y + dir[1];

                if (adjX >= 0 && adjY >= 0 && adjX < board.length && adjY < board[0].length
                        && !visited[adjX][adjY] && board[adjX][adjY] == 1) {
                    queue.add(new Node(adjX, adjY));
                    visited[adjX][adjY] = true;
                }
            }
        }

        int numberOfLandCells = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    numberOfLandCells++;
                }
            }
        }

        return numberOfLandCells;

    }

    // 2. DFS Solution
    public static int solveDFS(int[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        // Top Row
        for (int col = 0; col < board[0].length; col++) {
            if (!visited[0][col] && board[0][col] == 1) {
                dfs(new Node(0, col), board, visited);
            }
        }

        // Bottom Row
        for (int col = 0; col < board[0].length; col++) {
            if (!visited[board.length - 1][col] && board[board.length - 1][col] == 1) {
                dfs(new Node(board.length - 1, col), board, visited);
            }
        }

        // Left Col
        for (int row = 1; row < board.length - 1; row++) {
            if (!visited[row][0] && board[row][0] == 1) {
                dfs(new Node(row, 0), board, visited);
            }
        }

        // Right Col
        for (int row = 1; row < board.length - 1; row++) {
            if (!visited[row][board[0].length - 1] && board[row][board[0].length - 1] == 1) {
                dfs(new Node(row, board[0].length - 1), board, visited);
            }
        }

        int numberOfEnclaves = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    numberOfEnclaves++;
                }
            }
        }

        return numberOfEnclaves;
    }

    public static void dfs(Node node, int[][] board, boolean[][] visited) {
        visited[node.x][node.y] = true;

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] dir : directions) {
            int adjX = node.x + dir[0];
            int adjY = node.y + dir[1];

            if (adjX >= 0 && adjY >= 0 && adjX < board.length && adjY < board[0].length
                    && !visited[adjX][adjY] && board[adjX][adjY] == 1) {
                dfs(new Node(adjX, adjY), board, visited);
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
