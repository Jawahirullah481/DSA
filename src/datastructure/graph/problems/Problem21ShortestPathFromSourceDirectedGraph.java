package datastructure.graph.problems;

import java.util.*;

public class Problem21ShortestPathFromSourceDirectedGraph {

    /*


        ---------------------------------------------------------------------------------
        | Feature                    | Dijkstra           | TopoSort + Relaxation        |
        | -------------------------- | ------------------ | ---------------------------  |
        | Works on Directed Graphs   | ✅ Yes             | ✅ Yes, if DAG               |
        | Works on Undirected Graphs | ✅ Yes             | ❌ No (no topological order) |
        | Handles Negative Weights   | ❌ No              | ❌ No                        |
        | Requires Priority Queue    | ✅ Yes             | ❌ No                        |
        | Time Complexity            | `O((V + E) log V)` | `O(V + E)`                   |
        | Optimal for DAGs           | 😐 Okay            | ✅ Best                      |
        ----------------------------------------------------------------------------------

        NOTE :
        =====

        1. In a Directed Acyclic Graph (DAG), you can solve the single-source shortest path problem without topological sorting.
           But,
           Topological sort helps you process each node after all its dependencies (predecessors) have been processed.
           This avoids repeated relaxations.


        2. In an Undirected Graph, you can solve the Single Source Shortest Path (SSSP) problem without a priority queue,
           But,
           using a priority queue (as in Dijkstra’s algorithm) helps process nodes in increasing order of their distance.
           This avoids repeated relaxations and improves efficiency.

        Reference : See /resources/images/topo_sort_uses.png for the use case of topo sort.

        in that reference,
        * you can visit the node 6 at first through the path 1->2->6. but it is longest
        * then you revisit the node 7 with path 1->4->5->8->6. it is smallest.
        * suppose, if n nodes are connected to 6, you have to revisit all of them again.
        * to prevent this, we do topo sort.
        * by doing topo sort, we ensure that the node 6 will never be visited until all its parent are visited.
        * this will prevent the duplicate visits.


        NOTE :
        ======

        The same problem can be solved using the DFS. But, In DFS, you have to try out all the possible paths and then get the shortest distance.
        so, BFS is efficient.

     */

    public int[] shortestPath(int V, int E, int[][] edges) {

        // 1.
        List<List<Node>> adjList = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        for(int [] edge : edges) {
            Node node = new Node(edge[1], edge[2]);
            adjList.get(edge[0]).add(node);
            indegree[node.x]++;
        }

        // 2.
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        // 3.
        Queue<Integer> sorted = new LinkedList<>();
        while(!queue.isEmpty()) {
            int node = queue.poll();
            sorted.add(node);

            for(Node neighbor : adjList.get(node)) {
                indegree[neighbor.x]--;
                if(indegree[neighbor.x] == 0) {
                    queue.add(neighbor.x);
                }
            }
        }

        // 4.
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 5.
        dist[0] = 0;

        while(!sorted.isEmpty()) {
            int node = sorted.poll();

            if (dist[node] != Integer.MAX_VALUE) {
                for(Node neighbor : adjList.get(node)) {
                    int wt = dist[node] + neighbor.dist;

                    if(dist[neighbor.x] > wt) {
                        dist[neighbor.x] = wt;
                    }
                }
            }
        }

        // 6.
        for(int i = 0; i < dist.length; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;

    }

    static class Node {
        int x;
        int dist;

        public Node(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }
}
