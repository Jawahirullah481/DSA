package datastructure.graph.problems;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem18DetectCycleInGraphBFS {
    /*
        NOTE : General Rule

        In traversal algorithms (like BFS, DFS, or topological sort),
        you increment your "processed" count when you actually process a node (poll/visit/pop it)
         — not when you enqueue/push/add it to a queue/stack/visited list.
     */
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 1}
        };

        int numNodes = 3;

        boolean hasCycle = detectCycleBFS(numNodes, edges);
    }

    public static boolean detectCycleBFS(int numNodes, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numNodes; i++) {
            adjList.add(new ArrayList());
        }

        int[] indegree = new int[numNodes];
        for(int[] pair : edges) {
            adjList.get(pair[0]).add(pair[1]);
            indegree[pair[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numNodes; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int nodesTraversed = 0;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            nodesTraversed++;

            for(int neighbor : adjList.get(node)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if(nodesTraversed == numNodes) return false;

        return true;
    }
}
