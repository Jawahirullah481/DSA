package datastructure.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problem26DijkstraDirected {

    /*
        ✅ Why Dijkstra's Algorithm Uses a Priority Queue
        ==================================================
        In Dijkstra's algorithm, we use a PriorityQueue to always process the node with the smallest known distance from the source.

        This ensures that:

        # Each node is processed only once with its shortest path.
        # We avoid unnecessary reprocessing or updating of already finalized distances.


        🧠 Key Insight:
        ===============
        When multiple paths lead to the same node, processing the shortest one first avoids redundant work.

        ✅ When PriorityQueue Doesn’t Make Much Difference
        ===================================================
        * If the graph is like a binary tree or a forest, where:
        * Each path from the root leads to disjoint subtrees
        * There are no cycles or shared paths

        Then:

        Using a PriorityQueue or a normal Queue behaves similarly
        Because:
        Each node can only be reached by one unique path — there’s no competition or overlap.

        📘 Example Graph (with shared paths):
        =====================================

                    (4)
                A -------> B
                |          |
              (1)         (3)
                |          |
                v          v
                C -------> D ----> E
                    (1)       (1)

        🎯 Goal: Find shortest path from A to E

        🚫 If We Use a Normal Queue (FIFO): -

        1. Queue order (A → B → C).
        2. B is processed before C.
        3. Path A → B → E gives distance = 4 + 3 = 7
        4. Then C is processed → C → D → E gives distance = 1 + 1 + 1 = 3
        5. E is updated again, because a shorter path was found later.
        6. ❌ Duplicate work done for E.


        ✅ If We Use a PriorityQueue:

        1. A → C (1) and A → B (4) are both added to the queue.
        2. C is processed first (shorter distance).
        3. Then C → D (2), then D → E (3).
        4. E gets its shortest distance before B is ever processed.
        5. Later, when B → E is considered (distance = 7), it’s ignored since E already has a better path.
        6. ✅ No duplicate processing for E.

        | Feature                     | Toposort + Relaxation     | Dijkstra’s Algorithm           |
        | --------------------------- | ------------------------- | ------------------------------ |
        | Graph type                  | DAG only                  | Any graph (non-negative edges) |
        | Process node                | Once                      | Once (when popped from PQ)     |
        | Update distance of neighbor | May update multiple times | Only updates if shorter path   |
        | Distance update count       | Multiple                  | Usually once per node          |
        | Guarantees final distance?  | After all relaxations     | ✅ When popped from queue      |


     */

    public static void main(String[] args) {
        int[][] times = { {2, 1, 1}, {2, 3, 1}, {3, 4, 1} };
        int numberOfNodes = 4, source = 2;

        System.out.println(networkDelayTime(times, numberOfNodes, source));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        // 1.
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<Pair>());
        }

        for(int time[] : times) {
            adjList.get(time[0]).add(new Pair(time[1], time[2]));
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>((node1, node2) -> node1.distance - node2.distance);
        queue.add(new Pair(k, 0));

        while(!queue.isEmpty()) {
            Pair node = queue.poll();

            for(Pair neighbor : adjList.get(node.x)) {
                int oldDistance = distance[neighbor.x];
                int newDistance = distance[node.x] + neighbor.distance;

                if(newDistance < oldDistance) {
                    distance[neighbor.x] = newDistance;
                    queue.add(new Pair(neighbor.x, newDistance));
                }
            }
        }

        int minDistance = -1;

        for(int i = 1; i <= n; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                return -1;
            } else {
                minDistance = Math.max(minDistance, distance[i]);
            }
        }

        return minDistance;

    }

    static class Pair {
        int x;
        int distance;

        public Pair(int x, int distance) {
            this.x = x;
            this.distance = distance;
        }
    }

}
