package datastructure.graph.problems;

import java.util.PriorityQueue;

public class Problem27ShortestPathInBinaryMaze {

    /*
        Leetcode Problem No 1091

        NOTE :
        ======

        Here, 2D grid itself is a graph. but there n x n nodes which are connected with each other in 8 direction in this problem,
        with unit edge weight between them.

     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        PriorityQueue<Node> queue = new PriorityQueue<>((node1, node2) -> {
            return node1.distance - node2.distance;
        });

        int[][] distances = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        if(grid[0][0] == 1) {
            return -1;
        } else if (grid.length == 1) {
            return 1;
        }

        queue.add(new Node(0, 0, 0));
        distances[0][0] = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int distance = node.distance;

            int[][] paths = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1} };
            for(int[] path : paths) {
                int nextX = x + path[0];
                int nextY = y + path[1];
                int nextDistance = distance + 1;

                if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < n && grid[nextX][nextY] == 0) {
                    if(nextX == n - 1 && nextY == n - 1) {
                        return nextDistance + 1;
                    } else if(nextDistance < distances[nextX][nextY]) {
                        queue.add(new Node(nextX, nextY, nextDistance));
                        distances[nextX][nextY] = nextDistance;
                    }
                }

            }

        }

        return -1;

    }

    class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
