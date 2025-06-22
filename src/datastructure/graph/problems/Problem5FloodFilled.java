package datastructure.graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Problem5FloodFilled {

    /*
        In this problem, you need to start from single node. So, that's why outer loop is not required.
        Traversing all the connected nodes of starting node itself is enough.
     */
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;

        image = floodFill(image, sr, sc, color);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // 1. BFS Solution
        bfsChangeColor(image, sr, sc, color);

        // 2. DFS Solution
        dfsChangeColor(image, sr, sc, color);

        return image;
    }

    public static void bfsChangeColor(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<Node> queue = new LinkedList<>();

        Node node = new Node(sr, sc);
        queue.add(node);
        visited[sr][sc] = true;

        int sourceColor = image[sr][sc];
        if (sourceColor == color) {
            return;
        }

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            image[n.x][n.y] = color;

            int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            for (int[] dir : directions) {
                int adjX = n.x + dir[0];
                int adjY = n.y + dir[1];

                if (adjX >= 0 && adjY >= 0 && adjX < image.length && adjY < image[0].length
                        && !visited[adjX][adjY] && image[adjX][adjY] == sourceColor) {
                    queue.add(new Node(adjX, adjY));
                    visited[adjX][adjY] = true;
                }
            }
        }

    }

    public static void dfsChangeColor(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int sourceColor = image[sr][sc];
        Node node = new Node(sr, sc);

        dfs(image, visited, sourceColor, color, node);
    }

    public static void dfs(int[][] image, boolean[][] visited, int sourceColor, int targetColor, Node node) {
        image[node.x][node.y] = targetColor;
        visited[node.x][node.y] = true;

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int[] dir : directions) {
            int adjX = node.x + dir[0];
            int adjY = node.y + dir[1];

            if (adjX >= 0 && adjY >= 0 && adjX < image.length && adjY < image[0].length
                    && !visited[adjX][adjY] && image[adjX][adjY] == sourceColor) {
                dfs(image, visited, sourceColor, targetColor, new Node(adjX, adjY));
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
