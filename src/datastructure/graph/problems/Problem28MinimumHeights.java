package datastructure.graph.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem28MinimumHeights {

    /*
        LeetCode Problem : 1631

        NOTE :
        =====
        Why in the previous problem, we return immediately once we find the minimum distance ?
        But, in this problem, we return after the first pop of destination from the queue ?

        1. Shortest Path in Binary Maze : (Usually solved using BFS)
        ================================

        ✔️ Why do we return immediately when we reach the destination?
        BFS guarantees the shortest path in terms of number of steps (edges) in an unweighted graph.

        So, the first time you reach the destination, you’ve found the optimal path.
        There’s no point in continuing further.

        ➡️ BFS property:
        First time you visit a node, you are doing it via the shortest path.


        🧮 2. Minimum Effort Path (Leetcode 1631) : (Solved using Dijkstra’s Algorithm)
        ===========================================

        ❓ Why do we return only when the destination is popped from the queue?
        Here, "cost" is not number of steps, but the maximum effort (absolute height difference) on the path.

        You're not minimizing steps — you're minimizing the maximum weight on any edge of the path.

        Dijkstra guarantees:

        When a node is popped from the priority queue, we have found the minimum possible cost to reach it.
        So we must wait until the destination is dequeued from the min-heap, which means:
        All other paths to the destination have higher effort.
        The path we found is guaranteed to be minimal.

        VERY IMPORTANT NOTE : Dijkstra’s guarantee only holds when popping, not when enqueuing.

     */

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Node> queue = new PriorityQueue<>((node1, node2) -> {
            return node1.height - node2.height;
        });

        //Queue<Node> queue = new LinkedList<>();

        int[][] minHeights = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(minHeights[i], Integer.MAX_VALUE);
        }

        minHeights[0][0] = 0;
        queue.add(new Node(0, 0, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int height = node.height;

            if(x == n - 1 && y == m - 1) {
                return minHeights[n - 1][m - 1];
            }

            int[][] paths = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
            for(int[] path : paths) {
                int nextX = x + path[0];
                int nextY = y + path[1];

                if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    int nextHeight = Math.abs(heights[x][y] - heights[nextX][nextY]);
                    nextHeight = Math.max(nextHeight, height);

                    if(nextHeight < minHeights[nextX][nextY]) {
                        minHeights[nextX][nextY] = nextHeight;
                        queue.add(new Node(nextX, nextY, nextHeight));
                    }
                }
            }

        }

        return 0;

    }

    class Node {
        int x;
        int y;
        int height;

        public Node(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

}
