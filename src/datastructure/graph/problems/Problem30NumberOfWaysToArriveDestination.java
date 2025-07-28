package datastructure.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problem30NumberOfWaysToArriveDestination {

    /*
        Leetcode Problem : 1976

     */
    public int countPaths(int n, int[][] roads) {
        final int MOD = (int) 1e9 + 7;

        // Create adjacency list
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adjList.get(road[0]).add(new Node(road[1], road[2]));
            adjList.get(road[1]).add(new Node(road[0], road[2]));
        }

        // Dijkstra setup
        long[] distance = new long[n];
        int[] ways = new int[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;
        ways[0] = 1;

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int u = curr.n;
            long currTime = curr.time;

            // Skip if we already found a shorter path
            if (currTime > distance[u]) continue;

            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.n;
                long edgeTime = neighbor.time;
                long totalTime = currTime + edgeTime;

                if (totalTime < distance[v]) {
                    // If you have reached a shorter distance than you have so far,
                    // then, the number of ways the parent/incoming node have is you number of ways.
                    distance[v] = totalTime;
                    ways[v] = ways[u];
                    queue.add(new Node(v, totalTime));
                } else if (totalTime == distance[v]) {
                    // If you have reached the same shorter distance which you already have,
                    // then, this path's ways are also be included.
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }

    class Node {
        int n;
        long time;

        Node(int n, long time) {
            this.n = n;
            this.time = time;
        }
    }

}
